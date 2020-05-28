package Class_folder;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Class {
    private String class_id;
    private String supervisor;
    private ArrayList<String> students;

    public Class(String class_id) {
        this.class_id = class_id;
    }

    public Class(String class_id, ArrayList students) {
        this.class_id = class_id;
        this.students = students;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public void setStudents(ArrayList students) {
        this.students = students;
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
