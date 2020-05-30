package Class_folder;

import java.lang.reflect.Array;
import java.time.LocalDate;

public class Announcement {

    private String an_title;
    private String an_content;
    private LocalDate an_date;
    private String an_receiver;
    private String an_sender;

    public Announcement( String an_title, String an_content, LocalDate an_date, String an_receiver, String an_sender){
        this.an_title = an_title;
        this.an_content = an_content;
        this.an_date = an_date;
        this.an_receiver = an_receiver;
        this.an_sender = an_sender;
    }

    public boolean newAnnounc(){
        return true;
    }

    public boolean publish_Announc(){
        return true;
    }

    public boolean saveAnnounc(){
        return true;
    }

    public Array getAnnouncement(){
        return null;
    }


    public String get_an_title(){
        return this.an_title;
    }

}
