package Class_folder;

import java.util.Date;

public class Calendar {
    private String cal_owner;
    private int cal_type; //notifications 0=>personal, 1=>public
    private String cal_creator; //username
    private Date cal_date;
    private String cal_content;

    public Calendar(String cal_owner, int cal_type, String cal_creator, Date cal_date, String cal_content) {
        this.cal_owner = cal_owner;
        this.cal_type = cal_type;
        this.cal_creator = cal_creator;
        this.cal_date = cal_date;
        this.cal_content = cal_content;
    }

    public boolean createNotification(){
        return true;
    }
    public void editNotification(){

    }
    public boolean removeNotification(){

        return true;
    }
}
