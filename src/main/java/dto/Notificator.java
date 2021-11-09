package dto;

import command.CommandService;
import command.User;
import model.Report;
import model.Task;
import tracker.TrackerService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Notificator {

    private TrackerService trackerService;
    private NotificationDto notificationDto;

    public Notificator() {
        this.trackerService = new TrackerService();
    }

    public NotificationDto createNotification() throws IOException {
        notificationDto = new NotificationDto();

        List<User> allUsers = CommandService.getAllUsers();
        TrackerService trackerService = new TrackerService();
        List<Report> timingReport = trackerService.getTimingReport();

        notificationDto.setLeads(leadUsers(allUsers));

        HashMap<User, List<Task>> userList = studentUsers(allUsers);
        addNotificationToLead(userList, timingReport);
        notificationDto.setStudents(userList);

        return notificationDto;
    }

    private void addNotificationToLead(HashMap<User, List<Task>> students, List<Report> timingReport) {
        Map<Long, List<Report>> collect = timingReport.stream().
                collect(Collectors.groupingBy(Report::getUserId, Collectors.toList()));

        for (Map.Entry<User, List<Task>> UserTaskEntry : students.entrySet()) {
            for (Map.Entry<User, List<Task>> userTaskEntry : students.entrySet()) {

                int id = userTaskEntry.getKey().getId();
                List<Report> reports = collect.get((long) id);

                if (reports != null) {
                    Report report = reports.get(0);
                    List<Task> tasks = report.getTasks();
                    userTaskEntry.setValue(tasks);
                }
            }
        }
    }


    private HashMap<User, List<Task>> studentUsers(List<User> allUsers) {
        List<User> list = new ArrayList<>();
        for (User u : allUsers) {
            if (u.getRole().equals("user")) {
                list.add(u);
            }
        }
        List<User> students = list;
        HashMap<User, List<Task>> studentMap = new HashMap<>();
        for (User s : students) {
            studentMap.put(s, new ArrayList<>());
        }

        return studentMap;
    }

    private List<User> leadUsers(List<User> allUsers) {
        List<User> list = new ArrayList<>();
        for (User u : allUsers) {
            if (u.getRole().equals("lead"))
                list.add(u);
        }
        return list;
    }


    private List<User> adminUsers(List<User> allUsers) {
        List<User> list = new ArrayList<>();
        for (User u : allUsers) {
            if (u.getRole().equals("admin"))
                list.add(u);
        }
        return list;
    }
}
