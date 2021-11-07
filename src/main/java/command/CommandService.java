package command;

import java.util.List;

public class CommandService {
        public static List<User>getAll() {
            UserService userService = new UserServiceImplementationService()
                    .getPort(UserService.class);


            List<User> users = userService.findAll();
            System.out.println(users.get(0).getId());
            System.out.println(users.get(0).getUsername());
            System.out.println(users.get(0).getFirstName());
            System.out.println(users.get(0).getLastName());
            System.out.println(users.get(0).getRole());
            System.out.println(users.get(0).getGroup());
return users;
        }

}
