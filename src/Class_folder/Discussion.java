package Class_folder;

import java.lang.reflect.Array;
import java.time.LocalDate;

public class Discussion {
    private String disc_id;
    private String disc_title;
    private String disc_content;
    private LocalDate disc_date;
    private String disc_sender;  //maybe of type User

    public Discussion (String disc_id, String disc_title, String disc_content,LocalDate disc_date, String disc_sender){
        this.disc_id = disc_id;
        this.disc_title = disc_title;
        this.disc_content = disc_content;
        this.disc_date = disc_date;
        this.disc_sender = disc_sender;
    }

    public Discussion(){
        
    }

    public static void newTopic() {

    }

    public static void replyDiscussion() {

    }

    public static boolean saveDiscussion() {
        return true;
    }

    public static Array getDiscussion() {
        return null;
    }

    public static boolean removeDiscussion() {
        return true;
    }

    public String getDisc_title(){
        return disc_title;
    }

    public String getDisc_sender(){
        return disc_sender;
    }
}
