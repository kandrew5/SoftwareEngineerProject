package sample.teacher;

import Class_folder.Excursion;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class excursions_Controller implements Initializable {
    @FXML
    private TableView<Excursion> table;
    @FXML
    private TableColumn<Excursion, String> ex_name;
    @FXML
    private TableColumn<Excursion, String> ex_date;
    @FXML
    private TableColumn<Excursion, Boolean> select;

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

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gradebooks.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }
    LocalDate date1 = LocalDate.of(2021, Month.MAY, 27);
    LocalDate date2 = LocalDate.of(2021, Month.MAY, 26);
    LocalDate date3 = LocalDate.of(2021, Month.APRIL, 29);
    LocalDate date4 = LocalDate.of(2020, Month.APRIL, 27);
    LocalDate date5 = LocalDate.of(2020, Month.MARCH, 4);

    private final ObservableList<Excursion> list = FXCollections.observableArrayList(
            //αναζήτηση στη βάση δεδομένων
            new Excursion("Τριήμερη εκδρομή στην Αρχαία Ολυμπία", "Επίσκεψη στον αρχαιολογικό χώρο της Αρχαίας Ολυμπίας"," Αρχαία Ολυμπία",date1,70),
            new Excursion("Μονοήμερη εκδρομή στην Αθήνα", "Επίσκεψη στο μουσειο της Ακρόπολης και στη Βουλή", "Αθήνα", date2, 30),
            new Excursion("Τριήμερη εκδρομή στο Βόλο", "Επίσκεψη στο Βόλο και στο Πήλιο", "Βόλος", date3, 60),
            new Excursion("Πενθήμερη εκδρομή στο Ναύπλιο", "Επίσκεψη στο Ναύπλιο και στο αρχαίο θέατρο της Επιδαύρου", "Ναύπλιο", date4, 90),
            new Excursion("Τριήμερη εκδρομή στη Θεσσαλονίκη","Επίσκεψη στο μετρό της Θεσαλονίκης", "Θεσσαλονίκη", date5, 64)
    );
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ex_name.setCellValueFactory(new PropertyValueFactory<Excursion, String>("title"));
        ex_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        select.setCellValueFactory(new PropertyValueFactory<>("check"));

        //ex_title.setCellValueFactory(new PropertyValueFactory<Excursion, String>("destination"));
        //ex_name.setCellValueFactory(cellData -> cellData.getValue().getDestination());
        table.setItems(list);
        //table.getColumns().addAll(ex_name);

    }


}
