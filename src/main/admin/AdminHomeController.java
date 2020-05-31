package main.admin;

import Class_folder.Decisions_repo;
import Class_folder.Message;
import Class_folder.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import java.util.ResourceBundle;

public class AdminHomeController implements Initializable {

    @FXML
    private TableView<Decisions_repo> decisionsTable;
    @FXML
    private TableColumn<Decisions_repo, String> dec_title;
    @FXML
    private TableView<Message> messageTable;
    @FXML
    private TableColumn<Message, String> mess_sender;
    @FXML
    private TableColumn<Message, String> mess_content;

    public MenuItem menu_id;
    public SplitMenuButton menuB_id;

    private final ObservableList<Decisions_repo> ministryList = FXCollections.observableArrayList(
            new Decisions_repo("Ανακοίνωση από την DPO"),
            new Decisions_repo("Πρόσκληση συμμετοχής στον εορτασμό της Ευρωπαϊκής Ημέρας Γλωσσών για το 2020"),
            new Decisions_repo("Οδηγίες για την επαναλειτουργία των σχολικών μονάδων"),
            new Decisions_repo("Μεταθέσεις εκπαιδευτικών Δευτεροβάθμιας Εκπαίδευσης"),
            new Decisions_repo("Δράση: «Μένουμε Σπίτι με το eTwinning»  - ΝΕΑ ΜΑΘΗΜΑΤΑ"),
            new Decisions_repo("Διαβίβαση ενημερωτικού υλικού σχετικά με την ασφαλή πλοήγηση στο διαδίκτυο"),
            new Decisions_repo("Ενημέρωση για τις εξετάσεις των Ελλήνων του εξωτερικού"),
            new Decisions_repo("Περιορισμένη Λειτουργία Υπηρεσιών του Υπουργείου Παιδείας και Θρησκευμάτων"),
            new Decisions_repo("Παρουσίαση στο Υπουργικό Συμβούλιο μεταρρυθμίσεων στην Παιδεία"),
            new Decisions_repo("Διενέργεια εξετάσεων Πιστοποίησης Αρχικής Επαγγελματικής Κατάρτισης Αποφοίτων ΙΕΚ και ΣΕΚ"),
            new Decisions_repo("Αναστολή των εκδρομών-μετακινήσεων μαθητών/τριών και εκπαιδευτικών στην Ιταλία"),
            new Decisions_repo("Εγκύκλιος ενημέρωσης για τις πανελλαδικές εξετάσεις ΓΕΛ 2020 με το ΠΑΛΑΙΟ σύστημα"),
            new Decisions_repo("Ενημέρωση αποτελεσμάτων αιτήσεων μετεγγραφών")
    );

    private final ObservableList<Message> messageList = FXCollections.observableArrayList(
            new Message("Χατζόπουλος", "Χατζηαλεξάνδρου", "Απορία μαθήματος"),
            new Message("Χατζόπουλος","Κάλλιστρος","Αίτηση για ψηφορία"),
            new Message("Χατζόπουλος","Καψάλης","Θέμα θεατρικού γιορτής 25ης Μαρτίου"),
            new Message("Χατζόπουλος","Τριανταφυλλόπουλος","Ενημέρωση μαθητών για το COVID-19"),
            new Message("Χατζόπουλος","Ραμπαούνης","Λίστα δεκαπενταμελών τμημάτων"),
            new Message("Χατζόπουλος","Παπαδόπουλος","Άρρωστος - αδυναμία προσέλευσης στο σχολείο")
    );
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dec_title.setCellValueFactory(new PropertyValueFactory<Decisions_repo,String>("dec_title"));
        decisionsTable.setItems(ministryList);

        mess_sender.setCellValueFactory(new PropertyValueFactory<Message,String>("mess_sender"));
        mess_content.setCellValueFactory(new PropertyValueFactory<Message,String>("mess_content"));
        messageTable.setItems(messageList);
    }

    @FXML
    private void click_allClasses(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) menuB_id.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("export_data.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
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
