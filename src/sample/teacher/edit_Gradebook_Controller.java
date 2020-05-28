package sample.teacher;

import Class_folder.Class;
import Class_folder.Decisions_repo;
import Class_folder.Grade;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class edit_Gradebook_Controller implements Initializable {
    @FXML
    private TableView gradesTable;
    @FXML
    private TableColumn fullname;
    @FXML
    private TableColumn grade;
    @FXML
    private TextField grade_title;
    @FXML
    private TextField grade_course;
    @FXML
    private TextField grade_class;
    protected String class_id;

    public void setClassID(String class_id) {
        this.class_id = class_id;
    }
    public String getClassID(){
        return class_id;
    }
    String gr_classGrades[][] = {{"Apple", "Banana"}, {"Pork", "Beef"} };

    //private Grade grade1 = new Grade("Α3", "Άλγεβρα","Τελικός","Α3: Άλγεβρα Τελικός",01);
//    private String id = grade1.getGr_class_id();
//    private String type = grade1.getGr_type();
//    private String course = grade1.getGr_course();
//    private SimpleStringProperty title = grade1.getGr_title();

    //private ArrayList<String> students =
    Class s_class = new Class(class_id);
    String[] courses = s_class.getClasses();

    private final ObservableList<Grade> grade_list = FXCollections.observableArrayList(


    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //grade_title.setText(title);
//        grade_course.setText(course);
//        grade_class.setText(id);
    }
    @FXML
    public void selection(javafx.event.ActionEvent actionEvent) throws IOException {

    }

}
