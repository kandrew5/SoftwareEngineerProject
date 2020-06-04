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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class students_data_Controller implements Initializable {

    @FXML
    public void click_Excursion(javafx.event.ActionEvent actionEvent) throws IOException { //create excursion button listener
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("excursions.fxml"));
        var root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }
    public void click_Grades(javafx.event.ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("grades_main.fxml"));
        var root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
