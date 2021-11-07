package command;

import java.util.List;

public class CommandService {
    public static void main(String[] args) {
        UserService userService = new UserServiceImplementationService()
                .getPort(UserService.class);



        List <User> users= userService.findAll();
        System.out.println(users.get(0).getUsername());




    }





}
