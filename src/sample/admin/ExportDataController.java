package sample.admin;

import Class_folder.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ExportDataController implements Initializable {
    @FXML
    public Label label;
    @FXML
    public TableView<Student> studentDatatable;
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
    public TableColumn<Student, Long> tel;
    @FXML
    public TableColumn<Student, String> AMKA;

    private final ObservableList<Student> list = FXCollections.observableArrayList(
            new Student("Βαϊόπουλος","Θεοφάνης","A","Κωνσταντίνος","Μαρκέλα","6912345678","02151412345"),
            new Student("Χατζηαποστόλου","Έλενα ","A","Ευάγγελος","Φωτεινή","6912345678","14041412345"),
            new Student("Παναγιώτου","Χρήστος","B","Χάρης","Σοφία","6912345678","01121312345"),
            new Student("Βαλαζιώτης","Αυγουστίνος","B","Εμμανουήλ","Σταυρούλα","6912345678","22121312345"),
            new Student("Παπαδοπούλου","Μαρία","Γ","Ανδρέας","Γλυκερία","6912345678","260711212345"),
            new Student("Γεωργάκης","Βασίλειος","Γ","Φώτιος","Εμμανουέλα","691234567","09111212345"),
            new Student("Τριποδάκη","Έλλη","Δ","Αθανάσιος","Αικατερίνη","6912345678","30091112345"),
            new Student("Δατζής","Κυριάκος","Δ","Ευάγγελος","Φωτεινή ","6912345678","05051112345"),
            new Student("Μυλονόπουλος","Παναγιώτης","Ε","Γεώργιος","Δήμητρα","6912345678","27101012345"),
            new Student("Ζωιτσάκου","Αθανασία","Ε","Παντελής","Μαρία","6912345678","03071012345"),
            new Student("Κώτσαινας","Παναγιώτης","ΣΤ","Μελέτιος","Νεκταρία","6912345678","16030912345"),
            new Student("Τζανακάκη","Ευσταθία","ΣΤ","Νικόλαος","Ελένη","69123456789","05050912345")
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        last_name.setCellValueFactory(new PropertyValueFactory<Student, String>("last_name"));
        first_name.setCellValueFactory(new PropertyValueFactory<Student, String>("first_name"));
        class_id.setCellValueFactory(new PropertyValueFactory<Student, String>("class_id"));
        father_name.setCellValueFactory(new PropertyValueFactory<Student, String>("father_name"));
        mother_name.setCellValueFactory(new PropertyValueFactory<Student, String>("mother_name"));
        tel.setCellValueFactory(new PropertyValueFactory<Student, Long>("tel"));
        AMKA.setCellValueFactory(new PropertyValueFactory<Student, String>("AMKA"));

        studentDatatable.setItems(list);
    }

    public void click_Votings(MouseEvent mouseEvent) throws IOException {
        Node node = (Node) mouseEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin_voting.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }

    public void click_Timetable(MouseEvent mouseEvent) throws IOException {
        Node node = (Node) mouseEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin_timetable.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }

    public void click_decisions(MouseEvent mouseEvent) throws IOException {
        Node node = (Node) mouseEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin_all_decisions.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }
}
