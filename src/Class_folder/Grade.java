package Class_folder;

public class Grade {
    private String gr_class_id;
    private String gr_course;
    private String gr_type; //final, semester grades
    private String gr_title;

    public Grade(String gr_class_id, String gr_course, String gr_type, String gr_title) {
        this.gr_class_id = gr_class_id;
        this.gr_course = gr_course;
        this.gr_type = gr_type;
        this.gr_title = gr_title;
    }

    public void getGrade(){

    }
    public void editGrade(){

    }
    public boolean createGrade(){
        return true;
    }
    public boolean saveGrade(){
       return true;
    }
    public boolean sendGrade(){
        return true;
    }

    public void setGr_title(String gr_title) {
        this.gr_title = gr_title;
    }

    public String getGr_title() {
        return gr_title;
    }
}
