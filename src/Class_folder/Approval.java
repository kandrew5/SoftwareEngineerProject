package Class_folder;
import java.lang.reflect.Array;
import java.util.Date;

public class Approval {
    private String approval_id;
    private String ap_student_id;
    private String ap_parent_id;
    private boolean ap_pending;
    private Date ap_expire_date;

    public Approval(){
    }

    public boolean createApproval(){
        return true;
    }
    public boolean saveApproval(){
        return true;
    }
    public Array getApprovals(){
        return null;
    }
    public boolean approveFile(){
        return true;
    }
    public boolean removeApproval(){
        return true;
    }
}
