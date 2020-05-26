package Class_folder;

import java.lang.reflect.Array;

public class Curriculum {
    private String cur_id;
    private String cur_course; //maybe of type Course
    private String cur_date;
    private String cur_content;

    public Curriculum(String cur_id, String cur_course, String cur_date, String cur_content) {
        this.cur_id = cur_id;
        this.cur_course = cur_course;
        this.cur_date = cur_date;
        this.cur_content = cur_content;
    }

    public static boolean createCurriculum() {
        return true;
    }

    public static void editCurriculum() {

    }
    public static Array getCurriculum() {
        return null;
    }

    public static boolean saveCurriculum() {
        return true;
    }

    public String getCur_content()
    {
        return cur_content;
    }

    public String getCur_date()
    {
        return cur_date;
    }
}
