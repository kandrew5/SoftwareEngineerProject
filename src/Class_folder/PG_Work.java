package Class_folder;

import java.util.Date;

public class PG_Work {

    private String work_title;
    private String work_content;
    private Date work_date;
    private String work_author;

    public PG_Work(String work_title, String work_content, Date work_date, String work_author) {
        this.work_title = work_title;
        this.work_content = work_content;
        this.work_date = work_date;
        this.work_author = work_author;
    }

    public boolean newPG_Entry(){
        return true;
    }

    public boolean removePG_Entry(){
        return true;
    }

    public boolean editPG_Entry(){
        return true;
    }
}
