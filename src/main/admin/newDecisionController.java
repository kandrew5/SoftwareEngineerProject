package main.admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class newDecisionController {
    @FXML
    private Button fileUploadButton;
    @FXML
    private Text textFile;
    @FXML
    private TextField decTitle;
    @FXML
    private CheckBox cbT;
    @FXML
    private CheckBox cbS;
    @FXML
    private CheckBox cbP;
    @FXML
    private ComboBox<String> cmbPrior;

    boolean newFileName = false;
    ObservableList<String> priorityList = FXCollections.observableArrayList("Υψηλή", "Κανονική");

    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbPrior.setItems(priorityList);
    }

    public void onFileButton(javafx.event.ActionEvent actionEvent) {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);

        if(selectedFile != null){
            textFile.setText(selectedFile.getName());
            newFileName = true;
        }
    }

    @FXML
    public void forwordingDec(javafx.event.ActionEvent actionEvent) throws IOException {
        if(decTitle.getText().equals("") || !newFileName || decTitle.getText().equals("") || cmbPrior.getSelectionModel() == null || ((!(cbT.isSelected()))&&(!(cbS.isSelected()))&&(!(cbP.isSelected())))){ //check for empty fields
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Μη συμπληρωμένα πεδία");
            alert.setContentText("Παρακαλώ συμπληρώστε όλα τα πεδία.");

            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Επιτυχία");
            alert.setHeaderText("Επιτυχής προώθηση");
            alert.setContentText("Η απόφαση προωθήθηκε με επιτυχία.");

            alert.showAndWait();
        }
    }

    public void click_communication(MouseEvent mouseEvent) throws IOException {
        Node node = (Node) mouseEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("recent_messages.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }

    public void click_calendar(MouseEvent mouseEvent) throws IOException {
        Node node = (Node) mouseEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("calendar.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }

    public void click_Timetable(MouseEvent mouseEvent) throws IOException {
        Node node = (Node) mouseEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("timetable.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }

    public void click_decisions(MouseEvent mouseEvent) throws IOException {
        Node node = (Node) mouseEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("all_decisions.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }

    public void click_Votings(MouseEvent mouseEvent) throws IOException {
        Node node = (Node) mouseEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newVoting.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }
}
