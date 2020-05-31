package Class_folder;

import java.lang.reflect.Array;
import java.time.LocalDate;

public class Message {

    private String mess_receiver;
    private String mess_sender;
    private String mess_content;
    private String mess_file_name;
    private LocalDate mess_date;
    private String mess_id;

    public Message(){

    }

    public Message(String mess_receiver, String mess_sender, String mess_content) {
        this.mess_receiver = mess_receiver;
        this.mess_sender = mess_sender;
        this.mess_content = mess_content;
    }

    public String getMess_sender() {
        return mess_sender;
    }

    public void setMess_sender(String mess_sender) {
        this.mess_sender = mess_sender;
    }

    public String getMess_content() {
        return mess_content;
    }

    public void setMess_content(String mess_content) {
        this.mess_content = mess_content;
    }

    public String[] getMessage(String mess_id){
        return null;
    }

    public boolean send_Message(String mess_id){
        return true;
    }

    public boolean replyMessage(String mess_id){
        return true;
    }

    public boolean save_Message(String mess_id){
        return true;
    }

    public void filter_message(){}

    public boolean deleteMessage(String mess_id){
        return true;
    }
}
