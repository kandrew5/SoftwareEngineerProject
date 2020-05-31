package Class_folder;

import java.time.LocalDate;
import java.util.Date;

public class Calendar {
    private String cal_owner;
    private int cal_type; //notifications 0=>personal, 1=>public
    private String cal_creator; //username
    private LocalDate cal_date;
    private String cal_content;

    public Calendar(String cal_owner, int cal_type, String cal_creator, LocalDate cal_date, String cal_content) {
        this.cal_owner = cal_owner;
        this.cal_type = cal_type;
        this.cal_creator = cal_creator;
        this.cal_date = cal_date;
        this.cal_content = cal_content;
    }

    public boolean createNotification(String cal_creator){
        return true;
    }
    public boolean editNotification(String cal_creator){return true;}
    public boolean removeNotification(String cal_creator){return true;}
}
