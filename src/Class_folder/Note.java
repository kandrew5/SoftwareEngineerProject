package Class_folder;

import java.time.LocalDate;

public class Note {
    private String note_id;
    private String note_course_id;
    private String note_name;
    private LocalDate note_date;
    private int note_type; //remember

    public static boolean createNote() {
        return true;
    }

    public static boolean create_Nfolder() {
        return true;
    }

    public static void select_Nfolder() {}

    public static boolean uploadFile() {
        return true;
    }

    public static boolean saveNote(String note_id) {
        return true;
    }

    public static String[] getNote(String note_id) {
        return null;
    }

    public static boolean removeNote(String note_id) {
        return true;
    }
}
