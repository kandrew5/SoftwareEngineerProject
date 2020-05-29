package Class_folder;

public class Grade {
    private String gr_class_id;

    private String gr_course;//!!!!!!!!!
    private int grade_no;//!!!!!!!!!!!!!
    private int grade_no2;//!!!!!!!!!!!!!
    private int grade_mean;//!!!!!!!!!!!!!
    private String grade_title; //!!!!!!!!!!!!
    private int gr_id;
    private String student_am; //!!!!!!!

    //=--------------------------------------------------------=
    public Grade(int grade_no, String grade_title) {
        this.grade_title = grade_title;
        this.grade_no = grade_no;
    }

    public Grade(String gr_course, int grade_no, int grade_no2, int grade_mean) {
        this.gr_course = gr_course;
        this.grade_no = grade_no;
        this.grade_no2 = grade_no2;
        this.grade_mean = grade_mean;
    }

    public int getGrade_no() {
        return grade_no;
    }

    public String getGrade_title() {
        return grade_title;
    }

    public int getGrade_no2() {
        return grade_no2;
    }

    public int getGrade_mean() {
        return grade_mean;
    }

    //=------------------------------------------------------------------=


    public int getGr_id() {
        return gr_id;
    }

    public String getGr_course() {
        return gr_course;
    }

}


