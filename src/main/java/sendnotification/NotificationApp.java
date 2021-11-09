package sendnotification;

import command.CommandService;
import command.User;
import dto.NotificationDto;
import dto.Notificator;
import model.Task;
import sender.SenderService;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationApp {

    public static void main(String[] args) throws IOException {
        LocalTime sendTime = LocalTime.of(19, 15, 00);

        while (true) {
            if (LocalTime.now().equals(sendTime)) {
                sendNotification();
            }
        }
    }

    private static void sendNotification() throws IOException {
        Notificator notificator = new Notificator();
        NotificationDto notification = notificator.createNotification();
        TextMessage msg = new TextMessage(notification);
        HashMap<User, Integer> longIntegerHashMap = new HashMap<>();
        for (Map.Entry<User, Integer> longIntegerEntry : longIntegerHashMap.entrySet()) {
            Integer counter = longIntegerEntry.getValue();
            if (counter == 1) {
                String group = longIntegerEntry.getKey().getGroup();
                for (User lead : notification.getLeads()) {
                    SenderService.send((long) lead.getId(), msg.text);
                }
            }
            if (counter == 3) {
                for (User admin : notification.getAdmins()) {
                    SenderService.send((long) admin.getId(), msg.text);
                }
            }

        }
    }
}
