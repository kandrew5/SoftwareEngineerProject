package main.admin;

import Class_folder.Decisions_repo;
import Class_folder.Student;
import com.gembox.spreadsheet.ExcelFile;
import com.gembox.spreadsheet.ExcelWorksheet;
import com.gembox.spreadsheet.SpreadsheetInfo;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Parent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ExportDataController implements Initializable {
    @FXML
    public TableView<Student> studentDatatable;
    @FXML
    public TableColumn<Student, String> am;
    @FXML
    public TableColumn<Student, String> last_name;
    @FXML
    public TableColumn<Student, String> first_name;
    @FXML
    public TableColumn<Student, String> class_id;
    @FXML
    public TableColumn<Student, String> father_name;
    @FXML
    public TableColumn<Student, String> mother_name;
    @FXML
    public TableColumn<Student, String> tel;
    @FXML
    public TableColumn<Student, String> AMKA;

    @FXML
    private ChoiceBox<String> filter;

    public Button exportButton;

    private Stage savedStage;


    private static String[] columns = {"Αριθμός Μητρώου", "Επίθετο", "Όνομα", "Τάξη", "Όνομα πατέρα", "Όνομα μητέρας", "Τηλέφωνο", "ΑΜΚΑ"};

    private final ObservableList<Student> list = FXCollections.observableArrayList(
            new Student("st01","Βαϊόπουλος","Θεοφάνης","Α","Κωνσταντίνος","Μαρκέλα","6912345678","02151412345"),
            new Student("st02","Χατζηαποστόλου","Έλενα ","Α","Ευάγγελος","Φωτεινή","6912345678","14041412345"),
            new Student("st03","Παναγιώτου","Χρήστος","Β","Χάρης","Σοφία","6912345678","01121312345"),
            new Student("st04","Βαλαζιώτης","Αυγουστίνος","Β","Εμμανουήλ","Σταυρούλα","6912345678","22121312345"),
            new Student("st05","Παπαδοπούλου","Μαρία","Γ","Ανδρέας","Γλυκερία","6912345678","26071112345"),
            new Student("st06","Γεωργάκης","Βασίλειος","Γ","Φώτιος","Εμμανουέλα","6912345678","09111212345"),
            new Student("st07","Τριποδάκη","Έλλη","Δ","Αθανάσιος","Αικατερίνη","6912345678","30091112345"),
            new Student("st08","Δατζής","Κυριάκος","Δ","Ευάγγελος","Φωτεινή ","6912345678","05051112345"),
            new Student("st09","Μυλονόπουλος","Παναγιώτης","Ε","Γεώργιος","Δήμητρα","6912345678","27101012345"),
            new Student("st10","Ζωιτσάκου","Αθανασία","Ε","Παντελής","Μαρία","6912345678","03071012345"),
            new Student("st11","Κώτσαινας","Παναγιώτης","ΣΤ","Μελέτιος","Νεκταρία","6912345678","16030912345"),
            new Student("st12","Τζανακάκη","Ευσταθία","ΣΤ","Νικόλαος","Ελένη","6912345678","05050912345")
    );

    private final FilteredList<Student> filteredData = new FilteredList<>(list);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        filter.getItems().addAll("Α","Β","Γ","Δ","Ε","ΣΤ");
        am.setCellValueFactory(new PropertyValueFactory<Student, String>("am"));
        last_name.setCellValueFactory(new PropertyValueFactory<Student, String>("last_name"));
        first_name.setCellValueFactory(new PropertyValueFactory<Student, String>("first_name"));
        class_id.setCellValueFactory(new PropertyValueFactory<Student, String>("class_id"));
        father_name.setCellValueFactory(new PropertyValueFactory<Student, String>("father_name"));
        mother_name.setCellValueFactory(new PropertyValueFactory<Student, String>("mother_name"));
        tel.setCellValueFactory(new PropertyValueFactory<Student, String>("tel"));
        AMKA.setCellValueFactory(new PropertyValueFactory<Student, String>("AMKA"));

         filter.valueProperty().addListener(new ChangeListener<String>(){

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                filteredData.setPredicate(newValue == null ? null : (Student e) -> newValue.equals(e.getClass_id())); //βαζεις την αντιστοιχη get για το τμημα
            }
        });

        studentDatatable.setItems(filteredData);

//        cmbClass.setItems(classList);
    }
    String s;
    public void export_Button() throws IOException {
        SpreadsheetInfo.setLicense("FREE-LIMITED-KEY");
        ExcelFile file = new ExcelFile();
        ExcelWorksheet worksheet = file.addWorksheet("sheet");
        for (int row = 0; row < studentDatatable.getItems().size(); row++) {
            studentDatatable.getItems().get(row);
            for (int column = 0; column < list.size(); column++) {
                if (list.get(column) != null)
                    worksheet.getCell(row, column).setValue(list.get(column).toString());
            }
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("XLSX files (*.xlsx)", "*.xlsx"),
                new FileChooser.ExtensionFilter("XLS files (*.xls)", "*.xls"),
                new FileChooser.ExtensionFilter("ODS files (*.ods)", "*.ods"),
                new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv"),
                new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html")
        );
        File saveFile = fileChooser.showSaveDialog(studentDatatable.getScene().getWindow());

        file.save(saveFile.getAbsolutePath());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Επιτυχία");
        alert.setHeaderText("Επιτυχής εξαγωγή");
        alert.setContentText("Το αρχείο αποθηκεύτηκε στον φάκελο: "+ saveFile.getAbsolutePath());
        alert.showAndWait();
    }


    public void click_communication(javafx.event.ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("recent_messages.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }

    public void click_calendar(javafx.event.ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("calendar.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }

    public void click_Timetable(javafx.event.ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("timetable.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }

    public void click_decisions(javafx.event.ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("all_decisions.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }
    public void click_Votings(javafx.event.ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newVoting.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }
}