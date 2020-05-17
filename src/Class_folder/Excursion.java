package Class_folder;

import java.lang.reflect.Array;
import java.util.Date;

public class Excursion {
    private String title;
    private String summary;
    private String destination;
    private Date date;
    private double cost;

    public Excursion(String title, String summary, String destination, Date date, double cost) {
        this.title = title;
        this.summary = summary;
        this.destination = destination;
        this.date = date;
        this.cost = cost;
    }

    public boolean createExursion(){
        return true;
    }
    public void editExursion(){

    }
    public boolean saveExursion(){
         return true;
    }
    public Array getExursion(){
        return null;
    }
    public boolean removeExursion(){
       return true;
    }
}
