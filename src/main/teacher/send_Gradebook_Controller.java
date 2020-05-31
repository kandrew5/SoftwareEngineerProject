package main.teacher;

import Class_folder.Gradebook;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
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
    private ChoiceBox<String> filter;

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
    public void sendGrades(javafx.event.ActionEvent actionEvent) throws IOException {
        //pop-up επιβεβαίωσης
        //requestConfirmation
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Επιβεβαίωση");
        alert.setHeaderText("Παρακαλώ επιβεβαιώστε");
        alert.setContentText("Είστε βέβαιος ότι επιθυμείτε αποστολή του παρόντος βαθμολογίου στη Διεύθυνση;");

        Optional<ButtonType> result = alert.showAndWait();
        //returnConfirmation
        if (result.get() == ButtonType.OK){ //displaysuccess
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Επιτυχία");
            alert.setHeaderText("Επιτυχής αποστολή");
            alert.setContentText("Το βαθμολόγιο απεστάλη επιτυχώς.");

            alert.showAndWait();
            // ... user chose OK
        } else {
            // ... user chose CANCEL or closed the dialog
        }

    }
    private final ObservableList<Gradebook> Sendlist = FXCollections.observableArrayList(
            //dummy data again
            new Gradebook("A3","Άλγεβρα","τετραμήνου","Α3: Άλγεβρα Α'τετράμηνο",1),
            new Gradebook("A3","Άλγεβρα","τετραμήνου","Α3: Άλγεβρα Β'τετράμηνο",2),
            new Gradebook("A3","Άλγεβρα","τελικός","Α3: Άλγεβρα Τελικός",3),
            new Gradebook("Β3","Γεωμετρία","τετραμήνου", "Β3.Γεωμετρία Α'τετράμηνο",4),
            new Gradebook("Γ3","Γεωμετρία","τετραμήνου", "Γ3.Γεωμετρία Α'τετράμηνο",5)
    );
    private final FilteredList<Gradebook> filteredData = new FilteredList<>(Sendlist);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //αναζήτηση στη βάση δεδομένων
        filter.getItems().addAll("A3","Β3","Γ3");
        //filter.setValue("A3");
        classCol.setCellValueFactory(new PropertyValueFactory<Gradebook,String>("gr_class_id"));
        courseCol.setCellValueFactory(new PropertyValueFactory<Gradebook,String>("gr_course"));
        grName.setCellValueFactory(new PropertyValueFactory<Gradebook,String>("gr_title"));

        filter.valueProperty().addListener(new ChangeListener<String>(){ //selectClass

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                filteredData.setPredicate(newValue == null ? null : (Gradebook e) -> newValue.equals(e.getGr_class_id()));
            }

        });

        sndGradebooks.setItems(filteredData);
    }
}
