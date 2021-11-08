package sendnotification;

import command.CommandService;
import sender.SenderService;

import java.util.Arrays;
import java.util.List;

import static command.CommandService.getFieldsFromString;

public class Notifier {

    public static void main(String[] args) {

        String alex = CommandService.getUserById("1109266611");
//        System.out.println(CommandService.getUserById("430627864"));
        String usersId = String.valueOf(CommandService.getUsersByRole("user"));
        String [] userssplit = getFieldsFromString(usersId);
        System.out.println(userssplit[1]);
//        String [] splitter = getFieldsFromString(alex);
//        String textmessage = "User with ID: " + splitter[0] + " (Name: " + splitter[2] + " " + splitter[3] + ")" + " didnt send the report today!";
//        System.out.println("User with ID: " + splitter[0] +
//                " (Name: " + splitter[2] + " " + splitter[3] + ")" +
//                " didnt send the report today!");
//
//        SenderService.send(Long.valueOf(splitter[0]),textmessage);
    }
}


