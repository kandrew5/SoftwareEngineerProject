package Class_folder;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Date;

public class Decisions_repo {
    private String dec_id;          // decision id
    private String dec_title;       // title of decision
    private String dec_file_name;   // name of decision file
    private int priority;           // 0: for normal & 1: for high priority
    private int dec_type;           // 0: ministry decision, 1: municipal decision, 2: teachers decision
    private long dec_file_size;     // file size of decision
    private LocalDate dec_Date;     // date of publication
    private int receivers;          //receivers

    private String teachers;        // if teachers are receivers
    private String students;        // if students are receivers
    private String parents;         // if parents are receivers

    public Decisions_repo() {
    }

    public Decisions_repo(String dec_id, String dec_title, String dec_file_name, long dec_file_size, int priority, String teachers, String students, String parents, LocalDate dec_Date) {
        this.dec_id = dec_id;
        this.dec_title = dec_title;
        this.dec_file_name = dec_file_name;
        this.dec_file_size = dec_file_size;
        this.priority = priority;
        this.teachers = teachers;
        this.students = students;
        this.parents = parents;
        this.dec_Date = dec_Date;
    }

    public Decisions_repo(String dec_id, String dec_title, String dec_file_name, int priority, int dec_type, long dec_file_size, LocalDate dec_Date){
        this.dec_id = dec_id;
        this.dec_title = dec_title;
        this.dec_file_name = dec_file_name;
        this.priority = priority;
        this.dec_type = dec_type;
        this.dec_file_size = dec_file_size;
        this.dec_Date = dec_Date;
    }

    public Decisions_repo(String dec_title) {
        this.dec_title=dec_title;
    }

    public boolean createDecision() {
        return true;
    }

    public boolean saveDecision(String dec_id) {
        return true;
    }

    public boolean forwardDecision(String dec_id) {
        return true;
    }

    public String[] getForwardedDecisions() {
        return null;
    }

    public boolean removeDecision(String dec_id) {
        return true;
    }

    public boolean editDecision(String dec_id) {
        return true;
    }

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

    public String getDec_id() {
        return dec_id;
    }

    public void setDec_id(String dec_id) {
        this.dec_id = dec_id;
    }

    public String getDec_file_name() {
        return dec_file_name;
    }

    public void setDec_file_name(String dec_file_name) {
        this.dec_file_name = dec_file_name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getDec_type() {
        return dec_type;
    }

    public void setDec_type(int dec_type) {
        this.dec_type = dec_type;
    }

    public long getDec_file_size() {
        return dec_file_size;
    }

    public void setDec_file_size(long dec_file_size) {
        this.dec_file_size = dec_file_size;
    }

    public String getTeachers() {
        return teachers;
    }

    public void setTeachers(String teachers) {
        this.teachers = teachers;
    }

    public String getStudents() {
        return students;
    }

    public void setStudents(String students) {
        this.students = students;
    }

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }
}