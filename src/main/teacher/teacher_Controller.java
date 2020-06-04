package main.teacher;

import Class_folder.Decisions_repo;
import Class_folder.Message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;


public class teacher_Controller implements Initializable {
   @FXML
   private TableView forwarded;
   @FXML
   private TableColumn dec_date;
   @FXML
   private TableColumn dec_title;
   @FXML
   private TableView recent_messages;
   @FXML
   private TableColumn message;
   @FXML
   private TableColumn sender;

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
    @FXML
    public void click_showAnnounc(javafx.event.ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("teacher_announcement.fxml"));
        var root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }
    @FXML
    public void select_Decision(MouseEvent arg0) {
        System.out.println("clicked on " + forwarded.getSelectionModel().getSelectedItem());
    }
    LocalDate date1 = LocalDate.of(2020, Month.MAY, 27);
    LocalDate date2 = LocalDate.of(2020, Month.MAY, 26);
    LocalDate date3 = LocalDate.of(2020, Month.APRIL, 29);
    LocalDate date4 = LocalDate.of(2020, Month.APRIL, 27);
    LocalDate date5 = LocalDate.of(2020, Month.MARCH, 4);

    private final ObservableList<Decisions_repo> dec_list = FXCollections.observableArrayList(
              //dummy data
              new Decisions_repo("58","Οδηγίες από ΕΟΔΥ","eody.pdf",1,0,123856,date1),
              new Decisions_repo("59","Επαναλειτουργία σχολείου","fek25May2020",1,0, 234567, date2),
              new Decisions_repo("60","Νέο διαδικτυακό σεμινάριο","seminar2020May.pdf",0,0, 456781, date3),
              new Decisions_repo("61","Λογαριασμοί στο webex","webex.pdf", 1, 0,1023478, date4),
              new Decisions_repo("62","Απόφαση συλλόγου διδασκόντων 1/3/20","τετραμήνου", 1, 2, 123456, date5)
    );
    private final ObservableList<Message> message_list = FXCollections.observableArrayList(
            //dummy data
             new Message("Ρωμανός Καψάλης", "Γιωργάκης", "Απορία σε άσκηση"),
             new Message("Ρωμανός Καψάλης", "κ.Χατζόπουλος", "Σχετικά με βαθμούς"),
             new Message("Ρωμανός Καψάλης", "Κωστάκης", "Αυριανός περίπατος"),
             new Message("Ρωμανός Καψάλης", "Ελενίτσα", "Ο Θανάσης με πειράζει"),
             new Message("Ρωμανός Καψάλης", "Θανασάκης", "Η Ελένη λέει ψέμματα")
    );
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dec_title.setCellValueFactory(new PropertyValueFactory<Decisions_repo,String>("dec_title"));
        dec_date.setCellValueFactory(new PropertyValueFactory<>("dec_Date"));
        forwarded.setItems(dec_list);

        sender.setCellValueFactory(new PropertyValueFactory<Message, String>("mess_sender"));
        message.setCellValueFactory(new PropertyValueFactory<Message, String>("mess_content"));
        recent_messages.setItems(message_list);
    }


}
