package dto;

import command.User;
import lombok.Getter;
import lombok.Setter;
import model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class NotificationDto {
    private Map<User, List<Task>> students;
    private List<User> leads;
    private List<User> admins;

    public NotificationDto() {
        this.students = new HashMap<>();
        this.leads = new ArrayList<>();
        this.admins = new ArrayList<>();
    }
}
