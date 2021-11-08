import command.CommandService;
import command.User;

import java.util.List;

public class Notifier {

    public static void main(String[] args) {



        

//         CommandService.getAll();
//        CommandService.getByGroup("green");
       CommandService.getByRole("admin");
       System.out.print("User with ID " + CommandService.getByRole("user").get(0).getId() +
                "(" + CommandService.getByRole("user").get(0).getFirstName() + " " + CommandService.getByRole("user").get(0).getLastName() + ")" + " didn't send the report");
//        CommandService.getByRoleAndGroup("lead", "green");


    }
}
