package Class_folder;
import java.lang.reflect.Array;
import java.util.Date;

public class Approval {
    private String approval_id;
    private String ap_student_id;
    private String ap_parent_id;
    private boolean ap_pending;
    private Date ap_expire_date;

    public Approval(String approval_id, String ap_student_id, String ap_parent_id, boolean ap_pending, Date ap_expire_date){
        this.approval_id = approval_id;
        this.ap_student_id = ap_student_id;
        this.ap_parent_id = ap_parent_id;
        this.ap_pending = ap_pending;
        this.ap_expire_date = ap_expire_date;
    }

    public boolean createApproval(){
        return true;
    }
    public boolean saveApproval(String approval_id){
        return true;
    }
    public Array getApprovals(){
        return null;
    }
    public boolean approveFile(String approval_id){
        return true;
    }
    public boolean removeApproval(String approval_id){
        return true;
    }
}


