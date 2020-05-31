package Class_folder;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;


import java.time.LocalDate;

public class Excursion {
    private String ex_id;
    private SimpleStringProperty ex_title;
    private SimpleStringProperty ex_summary;
    private SimpleStringProperty ex_destination;
    private final ObjectProperty<LocalDate> ex_date = new SimpleObjectProperty<>(this, "data",null);
    private double ex_cost;
    private CheckBox check;

   // Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //String s = formatter.format(date);

    public Excursion(String title, String summary, String destination, LocalDate date, double cost) {
        this.ex_title = new SimpleStringProperty(title);
        this.ex_summary = new SimpleStringProperty(summary);
        this.ex_date.set(date);
        this.ex_cost = cost;
        this.check = new CheckBox();
    }


    public String getDestination(){
        return ex_destination.get();
    }
    public void setDestination(String dest){
       ex_destination.set(dest);
    }

    public String getTitle(){
        return ex_title.get();
    }
    public void setTitle(String tit){
        ex_destination.set(tit);
    }
    public CheckBox getCheck(){
        return check;
    }
    public void setCheck(CheckBox check){
       this.check = check;
    }
    public LocalDate getDate(){
        return ex_date.get();
    }
    public boolean createExcursion(){
        return true;
    }
    public boolean editExcursion(String ex_id){
        return true;
    }
    public boolean saveExcursion(String ex_id){
         return true;
    }
    public String[] getExcursion(String ex_id){
        return null;
    }
    public boolean removeExcursion(String ex_id){
       return true;
    }
}
