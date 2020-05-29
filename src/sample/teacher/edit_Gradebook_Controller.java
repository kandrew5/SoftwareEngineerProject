package sample.teacher;

import Class_folder.Class;
import Class_folder.Grade;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.*;

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
    protected int gradebook_id;
    Map<String, Integer> stGrades = new HashMap<String, Integer>();
    private String id;
    private String course;

    public void setClassID(int gradebook_id) {
        String title;
        this.gradebook_id = gradebook_id;
        //αναζήτηση στη βάση δεδομένων
        //dummy data εδώ
        if(this.gradebook_id == 1){
            System.out.println(this.gradebook_id);
            Grade grade1 = new Grade("A3","Μαθηματικά","τετραμήνου","Α3: Άλγεβρα Α'τετράμηνο",1);
            this.id = grade1.getGr_class_id();
            title = grade1.getGr_title();
            this.course = grade1.getGr_course();

        }
        else if(this.gradebook_id == 2){
            Grade grade2 = new Grade("A3","Μαθηματικά","τετραμήνου","Α3: Άλγεβρα Β'τετράμηνο",2);
            id = grade2.getGr_class_id();
            title = grade2.getGr_title();
            course = grade2.getGr_course();
        }
       else if(this.gradebook_id == 3){
            Grade grade3 = new Grade("A3","Μαθηματικά","τελικός","Α3: Άλγεβρα Τελικός",3);
            id = grade3.getGr_class_id();
            title = grade3.getGr_title();
            course = grade3.getGr_course();
        }
       else{
           Grade grade4 = new Grade("Β3","Μαθηματικά","τετραμήνου", "Β3.Γεωμετρία Α'τετράμηνο",4);
            id = grade4.getGr_class_id();
            title = grade4.getGr_title();
            course = grade4.getGr_course();
        }
        grade_title.setText(title);
        grade_course.setText(course);
        grade_class.setText(id);
        String[] keys = new String[stGrades.size()];
        Integer[] values = new Integer[stGrades.size()];
        int index = 0;
        for (Map.Entry<String, Integer> mapEntry : stGrades.entrySet()) {
            keys[index] = mapEntry.getKey();
            values[index] = mapEntry.getValue();
            index++;
        }
        //grade.setCellValueFactory(cd -> cd.getValue().items.get(key));
      //  stGrades = getGrades(this.gradebook_id);

    }

    String gr_classGrades[][] = {{"Apple", "Banana"}, {"Pork", "Beef"} };
    //private ArrayList<String> students =
   // Class s_class = new Class(gradebook_id);
    //String[] courses = s_class.getClasses();

    private final ObservableList<Grade> grade_list = FXCollections.observableArrayList(


    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //System.out.println(title);

    }
    @FXML
    public void selection(javafx.event.ActionEvent actionEvent) throws IOException {

    }
    @FXML
    public void click_Excursion(javafx.event.ActionEvent actionEvent) throws IOException { //create excursion button listener
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("excursion_create.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }
    public void click_Grades(javafx.event.ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gradebooks.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }
}
