package Class_folder;

import java.time.LocalDate;

public class Absence {
    private String student_id;
    private int period; // 1-7 timetable hour
    private LocalDate dates;
    int status;

    public static boolean createAbsence() {
        return true;
    }

    public static boolean editAbsence(String student_id) { return true;}

    public static boolean sendAbsence(String student_id) {
        return true;
    }

    public static boolean saveAbsence(String student_id) {
        return true;
    }

    public static String[] getAbsence(String student_id) {
        return null;
    }
}
