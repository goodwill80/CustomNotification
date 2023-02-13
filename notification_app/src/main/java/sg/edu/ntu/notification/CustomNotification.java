package sg.edu.ntu.notification;

import java.util.ArrayList;
import java.util.List;

import sg.edu.ntu.api.Connectable;

public abstract class CustomNotification implements Connectable {
 
    public static boolean isOperating = false;

    // By default, private.
    String to;
    String content;
    
    // with values initialization
    public CustomNotification(String to, String content){
        this.to = to;
        this.content = content;
    }

    // this will enforce child class to implement send() method
    public abstract void send() throws Exception;

    // accessor methods
    public String getTo() {
        return to;
    }
    public void setTo(String to) {        
        this.to = to;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
