import command.CommandService;

import java.util.List;

public class Notifier {

    public static void main(String[] args) {

        List<String> allUsers = CommandService.getAllUsers();

        for (String s : allUsers
        ) {
            System.out.println(s);
        }



    }
}
