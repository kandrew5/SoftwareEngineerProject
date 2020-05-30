package main.teacher;

import Class_folder.Grade;
import Class_folder.Gradebook;
import Class_folder.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class edit_Gradebook_Controller implements Initializable {
    @FXML
    private TableView gradesTable;
    @FXML
    private TableColumn name;
    @FXML
    private TableColumn grade;
    @FXML
    private TableColumn surname;
    @FXML
    private TextField grade_title;
    @FXML
    private TextField grade_course;
    @FXML
    private TextField grade_class;
    @FXML
    private TextField grade_type;
    protected int gradebook_id;
    Map<String, Integer> stGrades = new HashMap<String, Integer>();
    private String id;
    private String course;

    public void setClassID(int gradebook_id) {
        String title;
        String type;
        System.out.println("mpoumpis");
        this.gradebook_id = gradebook_id;
        //αναζήτηση στη βάση δεδομένων
        //dummy data εδώ
        if(this.gradebook_id == 1){
            //System.out.println(this.gradebook_id);
            Gradebook grade1 = new Gradebook("A3","Μαθηματικά","τετραμήνου","Α3: Άλγεβρα Α'τετράμηνο",1);
            this.id = grade1.getGr_class_id();
            title = grade1.getGr_title();
            this.course = grade1.getGr_course();
            type = grade1.getGr_type();
        }
        else if(this.gradebook_id == 2){
            Gradebook grade2 = new Gradebook("A3","Μαθηματικά","τετραμήνου","Α3: Άλγεβρα Β'τετράμηνο",2);
            id = grade2.getGr_class_id();
            title = grade2.getGr_title();
            course = grade2.getGr_course();
            type = grade2.getGr_type();
        }
        else if(this.gradebook_id == 3){
            Gradebook grade3 = new Gradebook("A3","Μαθηματικά","τελικός","Α3: Άλγεβρα Τελικός",3);
            id = grade3.getGr_class_id();
            title = grade3.getGr_title();
            course = grade3.getGr_course();
            type = grade3.getGr_type();
        }
        else{
            Gradebook grade4 = new Gradebook("Β3","Μαθηματικά","τετραμήνου", "Β3.Γεωμετρία Α'τετράμηνο",4);
            id = grade4.getGr_class_id();
            title = grade4.getGr_title();
            course = grade4.getGr_course();
            type = grade4.getGr_type();
        }
        grade_title.setText(title);
        grade_course.setText(course);
        grade_class.setText(id);
        grade_type.setText(type);


        final ObservableList<Student> stlist = FXCollections.observableArrayList(
              new Student("st15","Αμπατζίδου" ,"Ζουμπουλία"),
              new Student("st16", "Αντωνοπούλου","Αμαλία"),
              new Student("st17","Βουλινός", "Φώτιος"),
              new Student("st18","Δελόγλου", "Σπυρίδων"),
              new Student("st19","Ιωακειμίδου", "Αγγελική"),
              new Student("st20","Κάλλιστρος","Ανδρέας"),
              new Student("st21","Καψάλης","Ρωμανός"),
              new Student("st22","Παυρινός", "Αριστομένης"),
              new Student("st23","Πολίτης", "Δημοσθένης"),
              new Student("st24","Στεργίου","Αλέξιος"),
              new Student("st25","Τζίνη", "Θεοπούλα" ),
              new Student("st26","Τριανταφυλλόπουλος","Παναγιώτης"),
              new Student("st27","Χατζηαλεξάνδρου","Ντάλια"),
              new Student("st28","Χατζόπουλος", "Θωμάς")
        );
        int ar[] = { 6,19,16,18,9,17,14,15,15,20,13,19,10,12 };
        ObservableList<Grade> gradelist = FXCollections.observableArrayList();
        int i = 0;
        for(Student student: stlist){
            String a = student.getFirst_name();
            String b = student.getLast_name();
            String c = a + " " + b;
            String d = student.getAm();
            gradelist.add(new Grade(d,b,a,ar[i]));
            i++;
        }

        name.setCellValueFactory(new PropertyValueFactory<Grade,String>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<Grade,String>("surname"));
        grade.setCellValueFactory(new PropertyValueFactory<>("grade_no"));
        gradesTable.setItems(gradelist);

    }



    private final ObservableList<Grade> grade_list = FXCollections.observableArrayList(


    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("patates");

    }
    @FXML
    public void selection(javafx.event.ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Επιτυχία");
        alert.setHeaderText("Επιτυχής αποθήκευση");
        alert.setContentText("Οι αλλαγές στο βαθμολόγιο αποθηκεύτηκαν επιτυχώς.");

        alert.showAndWait();
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

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("grades_main.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }
    public void  click_Cancel(javafx.event.ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gradebooks.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }
}
