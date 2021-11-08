package sendnotification;

import command.CommandService;
import comparator.CompareService;
import model.Report;
import sender.SenderService;
import tracker.TimeTrackerService;

import java.util.ArrayList;
import java.util.List;

import static command.CommandService.getFieldsFromString;

public class Notifier {

    public static void main(String[] args) {

       List<String> comm = CommandService.getNotAdminUsers();
       List<Report> acc = TimeTrackerService.trackUsersId();
//        System.out.println(comm);
        List<String> Ids = new ArrayList<>();
        for (int i = 0; i < acc.size(); i++) {
            Ids.add(String.valueOf(acc.get(i).getUserId()));
        }
//        System.out.println(Ids);
        List<String> difference = CompareService.compare(Ids ,comm);
//        System.out.println(difference);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < difference.size(); i++) {
            result.add(difference.get(i));
        }
        for (int i = 0; i < result.size(); i++) {
            String userInfo = CommandService.getUserById(result.get(i));
            String [] splitter = getFieldsFromString(userInfo);
            List<String> leads = CommandService.getUsersByRoleAndGroup("lead", splitter[5]);
            String [] leadsplitter = getFieldsFromString(leads.get(0));
            SenderService.send(Long.valueOf(leadsplitter[0]),"User with ID: " + result.get(i) +
               " (Name: " + splitter[2] + " " + splitter[3] + ")" +
                   " didnt send the report today!");
        }


//        for (int i = 0; i < result.size(); i++) {
//            SenderService.send(430627864l,"User with ID: " + result.get(i) +
//                    " didnt send the report today!");
//        }
//






//        String textmessage = "User with ID: " + splitter[0] +
//                " (Name: " + splitter[2] + " " + splitter[3] +
//                ")" + " didnt send the report today!";






//        System.out.println(CommandService.getUserById("430627864"));
//        String usersId = String.valueOf(CommandService.getUsersByRole("user"));
//        String [] userssplit = getFieldsFromString(usersId);
//        System.out.println(userssplit[1]);
//        TimeTrackerService.track()
//        String [] splitter = getFieldsFromString(alex2);
//        String textmessage = "User with ID: " + splitter[0] + " (Name: " + splitter[2] + " " + splitter[3] + ")" + " didnt send the report today!";
//        System.out.println("User with ID: " + splitter[0] +
//                " (Name: " + splitter[2] + " " + splitter[3] + ")" +
//                " didnt send the report today!");
//
//        SenderService.send(Long.valueOf(splitter[0]),textmessage);
    }
}


