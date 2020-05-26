package Class_folder;

import java.lang.reflect.Array;

public class Class {
    private String class_id;
    private String supervisor;

    public Class(String class_id) {
        this.class_id = class_id;
    }

    public Array getStudents(){

        return null;
    }

    public boolean createClass(){
        return true;
    }

    public boolean deleteClass(){
       return true;
    }

    public String[] getClasses() { //loads Class courses
        //search DB
        String[] c_courses = {"Μαθηματικά", "Ιστορία", "Πατάτες", "Γλώσσα", "Γυμναστική", "Γεωμετρία", "Κοινωνιολογία"};
        return c_courses;
    }
}
