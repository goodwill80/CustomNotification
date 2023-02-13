package sg.edu.ntu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import sg.edu.ntu.Exception.InvalidInputException;
import sg.edu.ntu.notification.CustomNotification;
import sg.edu.ntu.notification.EmailNotification;
import sg.edu.ntu.notification.NotificationFactory;
import sg.edu.ntu.notification.SMSNotification;

/**
 * Hello world!
 *
 */
public class App 
{
    // This is the initialization of the logger
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main( String[] args )
    {   
        try {
            CustomNotification n1 = new SMSNotification("+65 9123 4567", "Good morning!");
            n1.send();
            System.out.println("=========================================================");
            CustomNotification n2 = new EmailNotification("edison@mail.com", "Good afternoon!");
            n2.send();
            System.out.println("=========================================================");
        } catch(InvalidInputException ex) {
            ex.printStackTrace();
            logger.error("Error");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
            System.out.println("Finally from original code");
            System.out.println("=========================================================");
        }
        
        // Factory design pattern
      
        CustomNotification email = NotificationFactory.createNotification("email", "oliver@gmail.com", "Good Bye from Oliver!");
        CustomNotification sms = NotificationFactory.createNotification("sms", "97311980", "Good Evening");
        try {
            email.send();
            System.out.println("=========================================================");
            sms.send();
            System.out.println("=========================================================");
        } catch(InvalidInputException ex) {
            ex.printStackTrace();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("Finally from factory code");
            System.out.println("=========================================================");
        }

        // testLogger();
    }

    public static void testLogger(){
        logger.debug("Debug message");
        logger.info("Info message");
        logger.warn("Warning message");
        logger.error("Error message");
        logger.fatal("Fatal message");
    }
}
