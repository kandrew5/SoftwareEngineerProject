package main.admin;

import Class_folder.Student;
import Class_folder.Voting;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class AllVotesController implements Initializable {
    @FXML
    public Button new_dec;
    @FXML
    public TableView<Voting> VotingsTable;
    @FXML
    public TableColumn<Voting,String> vote_title;
    @FXML
    public TableColumn<Voting,String> result;
    @FXML
    public TableColumn<Voting,Integer> percentage;
    @FXML
    public TableColumn<Voting,LocalDate> vote_creation_date;
    @FXML
    public TableColumn<Voting,LocalDate> vote_expire_date;

    LocalDate date1s = LocalDate.of(2020, Month.MARCH, 27);
    LocalDate date1e = LocalDate.of(2020, Month.MARCH, 28);
    LocalDate date2s = LocalDate.of(2020, Month.MARCH, 26);
    LocalDate date2e = LocalDate.of(2020, Month.MARCH, 27);
    LocalDate date3s = LocalDate.of(2020, Month.MARCH, 1);
    LocalDate date3e = LocalDate.of(2020, Month.MARCH, 2);
    LocalDate date4s = LocalDate.of(2020, Month.FEBRUARY, 25);
    LocalDate date4e = LocalDate.of(2020, Month.FEBRUARY, 27);
    LocalDate date5s = LocalDate.of(2020, Month.FEBRUARY, 4);
    LocalDate date5e = LocalDate.of(2020, Month.FEBRUARY, 4);

    private final ObservableList<Voting> votingsList = FXCollections.observableArrayList(
            new Voting("vt5","Ακύρωση εκδρομής Ε' τάξης", "Ναι", 60, date1s, date1e),
            new Voting("vt4", "Επιλογή καθηγητή για ενημέρωση μαθητών για τον COVID-19", "κ.Χαλδούπης", 54, date2s, date2e),
            new Voting("vt3", "Γιορτή 25ς Μαρτίου", "Μακρυγιάννης", 40, date3s, date3e),
            new Voting("vt2", "Ημερησια αποβολή", "Ναι", 100, date4s, date4e),
            new Voting("vt1","Περίπατος","Ναι",68,date1s,date1e)

    );
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vote_title.setCellValueFactory(new PropertyValueFactory<>("vote_title"));
        result.setCellValueFactory(new PropertyValueFactory<>("result"));
        percentage.setCellValueFactory(new PropertyValueFactory<>("percentage"));
        vote_creation_date.setCellValueFactory(new PropertyValueFactory<>("vote_creation_date"));
        vote_expire_date.setCellValueFactory(new PropertyValueFactory<>("vote_expire_date"));

        VotingsTable.setItems(votingsList);
    }

    public void click_newVoting(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newVoting.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
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
