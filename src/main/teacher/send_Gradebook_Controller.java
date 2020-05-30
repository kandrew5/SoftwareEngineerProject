package main.teacher;

import Class_folder.Gradebook;
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
import java.util.ResourceBundle;

public class send_Gradebook_Controller implements Initializable {
    @FXML
    private TableView sndGradebooks;
    @FXML
    private TableColumn grName;
    @FXML
    private TableColumn classCol;
    @FXML
    private TableColumn courseCol;
    @FXML
    private TextField search;

    @FXML
    public void click_Excursion(javafx.event.ActionEvent actionEvent) throws IOException { //create excursion button listener
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("excursions.fxml"));
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
    public void sendGrades(javafx.event.ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Επιτυχία");
        alert.setHeaderText("Επιτυχής αποστολή");
        alert.setContentText("Το βαθμολόγιο απεστάλη επιτυχώς.");

        alert.showAndWait();
    }
    private final ObservableList<Gradebook> Sendlist = FXCollections.observableArrayList(
            new Gradebook("A3","Άλγεβρα","τετραμήνου","Α3: Άλγεβρα Α'τετράμηνο",1),
            new Gradebook("A3","Άλγεβρα","τετραμήνου","Α3: Άλγεβρα Β'τετράμηνο",2),
            new Gradebook("A3","Άλγεβρα","τελικός","Α3: Άλγεβρα Τελικός",3),
            new Gradebook("Β3","Γεωμετρία","τετραμήνου", "Β3.Γεωμετρία Α'τετράμηνο",4)
    );
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        classCol.setCellValueFactory(new PropertyValueFactory<>("gr_class_id"));
        courseCol.setCellValueFactory(new PropertyValueFactory<>("gr_course"));
        grName.setCellValueFactory(new PropertyValueFactory<>("gr_title"));
        sndGradebooks.setItems(Sendlist);
    }
}
