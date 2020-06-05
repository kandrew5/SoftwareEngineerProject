package Class_folder;

public class Student extends User{
    private String class_id;
    private String  am;
    private String AMKA;
    private String father_name;
    private String mother_name;

    private String first_name;
    private String last_name;

    @Override
    public String getFirst_name() {
        return first_name;
    }

    @Override
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @Override
    public String getLast_name() {
        return last_name;
    }

    @Override
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Student(String am, String first_name, String last_name, String class_id, String father_name, String mother_name, String tel, String AMKA) {
        this.am = am;
        this.first_name = first_name;
        this.last_name = last_name;
        this.class_id = class_id;
        this.father_name = father_name;
        this.mother_name = mother_name;
        this.tel = tel;
        this.AMKA = AMKA;
    }
    public Student(String am, String last_name, String first_name ) {
        this.am = am;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public static String[] getStudentData(String  am) {
        return null;
    }

    public static boolean setStudentData(String  am) {
        return true;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getAm() {
        return am;
    }

    public void setAm(String am) {
        this.am = am;
    }

    public String getAMKA() {
        return AMKA;
    }

    public void setAMKA(String AMKA) {
        this.AMKA = AMKA;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }
}
