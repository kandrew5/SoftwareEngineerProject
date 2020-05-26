package Class_folder;

import java.lang.reflect.Array;

public class Parent extends User {

    private boolean pg_member;  //true -> is a member of PG, false -> is not a member of PG
    private String pg_role;     //role of member in the PG Association
    private int nu_kids;

    public Parent(boolean pg_member, String pg_role, int nu_kids){
        this.pg_member = pg_member;
        this.pg_role = pg_role;
        this.nu_kids = nu_kids;
    }

    public Array getChild(){
        return null;
    }

    public Array getParentData(){
        return null;
    }

    public void setParentData(){}

}
