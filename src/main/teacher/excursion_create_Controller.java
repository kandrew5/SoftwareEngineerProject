package main.teacher;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class excursion_create_Controller implements Initializable {
    @FXML
    TextField loc;
    @FXML
    TextField cost;
    @FXML
    TextField clas;
    @FXML
    TextArea desc;
    @FXML
    DatePicker date;
    @FXML
    DatePicker dp2;
    @FXML
    DatePicker dp3;
    @FXML
    Label start_date;
    @FXML
    Label end_date;
    @FXML
    Label days_l;
    @FXML
    TextField num_days;
    @FXML
    CheckBox select;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //show multi day excursion options if checkbox is selected
        dp2.visibleProperty().bind(select.selectedProperty());
        dp3.visibleProperty().bind(select.selectedProperty());
        start_date.visibleProperty().bind(select.selectedProperty());
        end_date.visibleProperty().bind(select.selectedProperty());
        days_l.visibleProperty().bind(select.selectedProperty());
        num_days.visibleProperty().bind(select.selectedProperty());
    }
    @FXML
    public void create(javafx.event.ActionEvent actionEvent) throws IOException {
        if(loc.getText().equals("") || cost.getText().equals("") || clas.getText().equals("") || desc.getText().equals("") || date == null){ //check for empty fields
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Μη συμπληρωμένα πεδία");
            alert.setContentText("Παρακαλώ συμπληρώστε όλα τα πεδία.");

            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Επιτυχία");
            alert.setHeaderText("Επιτυχής δημιουργία");
            alert.setContentText("Η εκδρομή δημιουργήθηκε με επιτυχία.");

            alert.showAndWait();
        }

    }
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
}
