package main.teacher;

import Class_folder.Student;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class students_data_Controller implements Initializable {
   @FXML
   private TableView stData;
   @FXML
   private TableColumn<Student,String> st_name;
   @FXML
   private TableColumn<Student,String> st_surname;
   @FXML
   private TableColumn<Student,String> st_am;

   @FXML
   public void click_Excursion(javafx.event.ActionEvent actionEvent) throws IOException { //create excursion button listener
        var node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("excursions.fxml"));
        var root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }

    public void click_Grades(javafx.event.ActionEvent actionEvent) throws IOException {
        var node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("grades_main.fxml"));
        var root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }


    public void click_showAnnounc(javafx.event.ActionEvent actionEvent) throws IOException {
        var node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("teacher_announcement.fxml"));
        var root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }
    final ObservableList<Student> stlist = FXCollections.observableArrayList(
            new Student("st15","Ζουμπουλία","Αμπατζίδου","Β2","Γεώργιος","Χρυσούλα","123456","1234567"),
            new Student("st16", "Αμαλία","Αντωνοπούλου","Β2","Δημήτριος","Καλλιόπη","123456","123456"),
            new Student("st17", "Φώτιος","Βουλινός","Β2","Θωμάς","Ελένη","123456","123456"),
            new Student("st18", "Σπυρίδων","Δελόγλου","Β2","Αντώνιος","Ιωάννα","123456","123456"),
            new Student("st19","Αγγελική","Ιωακειμίδου","Β2","Γεράσιμος","Γεωργία","123456","123456"),
            new Student("st20","Ανδρέας","Κάλλιστρος","Β2","Ιορδάνης","Μαρία","123456","123456"),
            new Student("st21","Ρωμανός","Καψάλης","B2","Μιλτιάδης","Χρυσούλα","123456","1234567"),
            new Student("st22", "Αριστομένης","Παυρινός","Β2","Αθανάσιος","Ευτέρπη","123456","123456"),
            new Student("st23", "Δημοσθένης","Πολίτης","Β2","Γεώργιος","Αθανασία","12345","123456"),
            new Student("st24","Αλέξιος","Στεργίου","Β2","Κυριάκος","Άννα","12345","123456"),
            new Student("st25", "Θεοπούλα","Τζίνη","Β2","Παναγιώτης","Αριστέα","123456","123456" ),
            new Student("st26","Παναγιώτης","Τριανταφυλλόπουλος","Β2","Ανδρέας","Παναγιώτα","123456","12345"),
            new Student("st27","Ντάλια","Χατζηαλεξάνδρου","Β2","Στέφανος","Αικατερίνη","12345","123456"),
            new Student("st28", "Θωμάς","Χατζόπουλος","Β2","Παντελής", "Φωτεινή","123456","123456")
    );
    public void select_Student(MouseEvent arg0) throws IOException {
        Student st = (Student) stData.getSelectionModel().getSelectedItem();

        System.out.println("clicked on " + st.getAm());
        Stage stage;
        Parent root;
        stage = (Stage) stData.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("student_details.fxml"));
        root = loader.load();


        String id = st.getAm();
        String fn = st.getFather_name();
        String mn = st.getMother_name();
        String cid = st.getClass_id();
        String tel = st.getTel();
        String AMKA = st.getAMKA();
        String first = st.getFirst_name();
        String last = st.getLast_name();
        student_details_Controller editController = loader.getController();
        editController.setStudentData(id,fn,mn,cid,tel,AMKA,first,last);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        st_name.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        st_surname.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        st_am.setCellValueFactory(new PropertyValueFactory<>("am"));
        stData.setItems(stlist);
    }

}
