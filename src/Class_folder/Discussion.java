package Class_folder;

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

    public static boolean newTopic() {return true;}

    public static boolean replyDiscussion(String disc_id) {return true;}

    public static boolean saveDiscussion(String disc_id) {
        return true;
    }

    public static String[] getDiscussion(String disc_id) {
        return null;
    }

    public static boolean removeDiscussion(String disc_id) {
        return true;
    }

    public String getDisc_title(){
        return disc_title;
    }

    public String getDisc_sender(){
        return disc_sender;
    }
}
