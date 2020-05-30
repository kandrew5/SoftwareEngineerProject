package main.admin;

import Class_folder.Decisions_repo;
import Class_folder.Discussion;
import Class_folder.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.student.N_DiscussionController;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class AllDecisionsController implements Initializable {
    @FXML
    private TableView<Decisions_repo> decisionsTable;
    @FXML
    private TableColumn<Decisions_repo, String> dec_date;
    @FXML
    private TableColumn<Decisions_repo, String> dec_title;
    @FXML
    private TableColumn<Decisions_repo, Boolean> teachers;
    @FXML
    private TableColumn<Decisions_repo, Boolean> students;
    @FXML
    private TableColumn<Decisions_repo, Boolean> parents;
    @FXML
    CheckBox select;
    @FXML
    public void select_Decision(MouseEvent arg0) {
        System.out.println("clicked on " + decisionsTable.getSelectionModel().getSelectedItem());
    }

    private Decisions_repo added_Dec = new Decisions_repo();
    public Button new_dec;

    LocalDate date1 = LocalDate.of(2020, Month.MAY, 27);
    LocalDate date2 = LocalDate.of(2020, Month.MAY, 26);
    LocalDate date3 = LocalDate.of(2020, Month.APRIL, 29);
    LocalDate date4 = LocalDate.of(2020, Month.APRIL, 27);
    LocalDate date5 = LocalDate.of(2020, Month.MARCH, 4);

    protected final ObservableList<Decisions_repo> dec_list = FXCollections.observableArrayList(
            new Decisions_repo("58","Οδηγίες από ΕΟΔΥ","eody.pdf", 25478,1, "NAI", "NAI", "NAI", date5),
            new Decisions_repo("59","Επαναλειτουργία σχολείου","fek25May2020",187451, 1, "NAI", "OXI", "OXI", date4),
            new Decisions_repo("60","Νέο διαδικτυακό σεμινάριο","seminar2020May.pdf",896541,1, "OXI", "OXI", "NAI",  date3),
            new Decisions_repo("61","Λογαριασμοί στο webex","webex.pdf", 78364, 0, "NAI", "OXI", "NAI", date2),
            new Decisions_repo("62","Απόφαση συλλόγου διδασκόντων 1/3/20","τετραμήνου", 53147960, 0, "NAI", "NAI", "NAI", date1)
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dec_title.setCellValueFactory(new PropertyValueFactory<Decisions_repo,String>("dec_title"));
        dec_date.setCellValueFactory(new PropertyValueFactory<>("dec_Date"));
        teachers.setCellValueFactory(new PropertyValueFactory<>("teachers"));
        students.setCellValueFactory(new PropertyValueFactory<>("students"));
        parents.setCellValueFactory(new PropertyValueFactory<>("parents"));

        decisionsTable.setItems(dec_list);
    }

    public void click_allClasses(javafx.event.ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("export_data.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }

    public void click_newDecision(javafx.event.ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("new_decision.fxml"));

        Parent root = (Parent) fxmlLoader.load();
        scene.setRoot(root);
    }

    Decisions_repo getDec() {
        return added_Dec;
    }

    public void refreshList(Decisions_repo new_dec){
        dec_list.add(new_dec);
        decisionsTable.refresh();
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
