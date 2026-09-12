package bank.notification;

public class EmailNotificationService implements NotificationService {

    public void send(String message) {
        System.out.println("Email: " + message);
    }
}
