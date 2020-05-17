package Class_folder;
import java.lang.reflect.Array;
import java.util.Date;

public class Decisions_repo {
    private String dec_id;             // decision id
    private String dec_title;       // title of decision
    private String dec_file_name;   // name of decision file
    private int priority;           // 0: for normal & 1: for high priority
    private int dec_type;           // 0: for ministry decision, 1: for municipal decision, 2: for teachers decision
    private int dec_file_size;      // file size of decision
    private Date dec_Date;          // date of publication

    public Decisions_repo(){
    }

    public boolean createDecision() {
        return true;
    }

    public boolean editDecision() {
        return true;
    }

    public boolean saveDecision() {
        return true;
    }

    public boolean forwardDecision() {
        return true;
    }

    public Array getForwardedDecisions() {
        return null;
    }

    public boolean removeDecision() {
        return true;
    }
}