package sg.edu.ntu.notification;

public class NotificationFactory {
    
    public NotificationFactory() {

    }

    public static CustomNotification createNotification(String type, String contact, String content) {
        if(type == null || type.equals("")) {
            throw new IllegalArgumentException("Type cannot be null or  blank");
        }
        if(type.equals("sms")) {
            return new SMSNotification(contact, content);
        }
        if(type.equals("email")) {
            return new EmailNotification(contact, content);
        }
        return null;
    }
}
