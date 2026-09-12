public class SMSNotificationService implements NotificationService {

    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}
