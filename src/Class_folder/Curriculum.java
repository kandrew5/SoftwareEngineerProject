package Class_folder;

import java.time.LocalDate;

public class Curriculum {
    private String cur_id;
    private String cur_course; //maybe of type Course
    private LocalDate cur_date;
    private String cur_content;

    public Curriculum(String cur_id, String cur_course, LocalDate cur_date, String cur_content) {
        this.cur_id = cur_id;
        this.cur_course = cur_course;
        this.cur_date = cur_date;
        this.cur_content = cur_content;
    }

    public static boolean createCurriculum() {
        return true;
    }

    public static boolean editCurriculum(String cur_id) {
        return true;
    }
    public static String[] getCurriculum(String cur_id) {
        return null;
    }

    public static boolean saveCurriculum(String cur_id) {
        return true;
    }

    public String getCur_content()
    {
        return cur_content;
    }

    public LocalDate getCur_date()
    {
        return cur_date;
    }
}
