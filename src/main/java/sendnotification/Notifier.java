package sendnotification;

import command.CommandService;

import java.util.List;

import static command.CommandService.getFieldsFromString;

public class Notifier {
    public static void sendMessage(Long chatID, String text) {
//        TimeTrackingSenderServiceImpl trackingSenderService =
//                new TimeTrackingSenderServiceImplService()
//                        .getPort(com.soapsendservice.TimeTrackingSenderServiceImpl.class);
//        trackingSenderService.sendMessage(chatID,  text);
//        trackingSenderService.sendMessage(430627864l, "Sashok_V", "lol");
    }
    public static void main(String[] args) {

        String alex = CommandService.getUserById("430627864");
        System.out.println(CommandService.getUserById("430627864"));
        String [] splitter = getFieldsFromString(alex);
        System.out.println("User with ID: " + splitter[0] + " (Name: " + splitter[2] + " " + splitter[3] + ")" + " didnt send the report today!");

        Notifier.sendMessage(336574141l,  "lollolol");




    }
}


