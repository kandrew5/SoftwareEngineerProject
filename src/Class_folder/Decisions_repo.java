package Class_folder;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Date;

public class Decisions_repo {
    private String dec_id;          // decision id
    private String dec_title;       // title of decision
    private String dec_file_name;   // name of decision file
    private int priority;           // 0: for normal & 1: for high priority
    private int dec_type;           // 0: for ministry decision, 1: for municipal decision, 2: for teachers decision
    private int dec_file_size;      // file size of decision
    private LocalDate dec_Date;          // date of publication

    public LocalDate getDec_Date() {
        return dec_Date;
    }

    public void setDec_Date(LocalDate dec_Date) {
        this.dec_Date = dec_Date;
    }

    public String getDec_title() {
        return dec_title;
    }

    public void setDec_title(String dec_title) {
        this.dec_title = dec_title;
    }

    public Decisions_repo(String dec_id, String dec_title, String dec_file_name, int priority, int dec_type, int dec_file_size, LocalDate dec_Date){
        this.dec_id = dec_id;
        this.dec_title = dec_title;
        this.dec_file_name = dec_file_name;
        this.priority = priority;
        this.dec_type = dec_type;
        this.dec_file_size = dec_file_size;
        this.dec_Date = dec_Date;
    }

    public boolean createDecision(String dec_id) {
        return true;
    }

    public boolean editDecision(String dec_id) {
        return true;
    }

    public boolean saveDecision(String dec_id) {
        return true;
    }

    public boolean forwardDecision(String dec_id) {
        return true;
    }

    public Array getForwardedDecisions() {
        return null;
    }

    public boolean removeDecision(String dec_id) {
        return true;
    }
}
