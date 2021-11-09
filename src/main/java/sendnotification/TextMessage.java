package sendnotification;

import command.User;
import dto.NotificationDto;
import model.Task;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class TextMessage {
    String text;

    public TextMessage(NotificationDto notificationDto) {
        StringBuilder message = new StringBuilder();
        for (Map.Entry<User, List<Task>> userListEntry : notificationDto.getStudents().entrySet()) {
            User user = userListEntry.getKey();
            message.append("On date " + LocalDate.now() + "\n");
            message.append("User with ID " + user.getId() + "\n");
            message.append(user.getFirstName() + " " + user.getLastName() + "\n");
            message.append("from " + user.getGroup() + " team"+ "\n");
            message.append("didn't send the report" + "\n");
        }
        this.text = message.toString();
    }
}
