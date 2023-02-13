package sg.edu.ntu.notification;

import sg.edu.ntu.Exception.InvalidInputException;
import sg.edu.ntu.api.Connectable;

public class EmailNotification extends CustomNotification implements Connectable{
    public EmailNotification(String to, String content){
        super(to, content);
        this.init();
    }

    public boolean isValidFormat(String email) {
        return false;
    }

    @Override
    public void send() throws Exception{
        // if(!isValidFormat(this.to)) throw new InvalidInputException("Email format is incorrect!");
        if(checkHasNetworkConnection())
            System.out.println("Sending email to "+this.to+" with message: "+this.content);
        else {
            throw new Exception("Network cannot be connected");
        }
            // System.out.println("Unable to send Email due to network error");
    }

    @Override
    public void init() {
        System.out.println("Initialize all properties needed to connect to email server.");
        
    }

    @Override
    public boolean checkHasNetworkConnection() {
        System.out.println("Check whether has network connection");
        boolean isSuccess = true;
        if(isSuccess){
            CustomNotification.isOperating = true;
        }
        return isSuccess;
    }
}
