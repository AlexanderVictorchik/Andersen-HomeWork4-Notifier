package command;

import java.util.List;

public class CommandService {

    private static UserService getService() {
        UserService userService = new UserServiceImplementationService()
                .getPort(UserService.class);
        return userService;
    }

    public static List<User> getAll() {
        List<User> users = getService().findAll();
        for (User u : users) {
            System.out.println(
                    u.getId() + ":"
                            + u.getUsername() + ":"
                            + u.getFirstName() + ":"
                            + u.getLastName() + ":"
                            + u.getRole() + ":"
                            + u.getGroup()
            );
        }
        return users;
    }


    public static List<User> getByGroup(String group) {
        List<User> users = getService().findByGroup(group);
        for (User u : users) {
            System.out.println(u.getGroup());
        }
        return users;
    }

    public static List<User> getByRole(String role) {
        List<User> users = getService().findByRole(role);
        for (User u : users) {
            System.out.println(u.getRole());
        }
        return users;
    }

    public static List<User> getByRoleAndGroup(String role, String group) {
        List<User> users = getService().findByRoleAndGroup(role, group);
        for (User u : users) {
            System.out.println(u.getRole() + ":"
                            + u.getGroup()
            );
        }
        return users;
    }

}
