package Class_folder;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;

import javax.print.attribute.standard.Destination;
import java.awt.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
public class Excursion {
    private SimpleStringProperty title;
    private SimpleStringProperty summary;
    private SimpleStringProperty destination;
    //private SimpleDateFormat date;
    private final ObjectProperty<LocalDate> date = new SimpleObjectProperty<>(this, "data",null);
    private double cost;
    private CheckBox check;

   // Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //String s = formatter.format(date);

    public Excursion(String title, String summary, String destination, LocalDate date, double cost) {
        this.title = new SimpleStringProperty(title);
        this.summary = new SimpleStringProperty(summary);
        //this.destination = new SimpleStringProperty(destination);
       // this.date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        this.date.set(date);
        this.cost = cost;
        this.check = new CheckBox();
    }


    public String getDestination(){
        return destination.get();
    }
    public void setDestination(String dest){
       destination.set(dest);
    }

    public String getTitle(){
        return title.get();
    }
    public void setTitle(String tit){
        destination.set(tit);
    }
    public CheckBox getCheck(){
        return check;
    }
    public void setCheck(CheckBox check){
       this.check = check;
    }
    public LocalDate getDate(){
        return date.get();
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
