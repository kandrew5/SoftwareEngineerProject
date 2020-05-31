package Class_folder;



public class Teacher extends User{
    private long afm;
    private String class_sv; //class supervisor
    private String[] course;

    public Teacher(long afm, String class_sv) {
        this.afm = afm;
        this.class_sv = class_sv;
    }

    public String[] getTeacherData(Long afm){

        return null;
    }
    public boolean setTeacherData(Long afm){
         return true;
    }
}
