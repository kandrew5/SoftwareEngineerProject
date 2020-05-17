package Class_folder;

import java.lang.reflect.Array;
import java.util.Date;

public class Message {

    private String mess_receiver;
    private String mess_sender;
    private String mess_content;
    private String mess_file_name;
    private Date mess_date;

    public Message(){

    }

    public Array getMessage(){
        return null;
    }

    public boolean send_Message(){
        return true;
    }

    public boolean replyMessage(){
        return true;
    }

    public boolean save_Message(){
        return true;
    }

    public void filter_message(){}

    public boolean deleteMessage(){
        return true;
    }
}
