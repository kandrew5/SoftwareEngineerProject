package main.parent;

import Class_folder.Announcement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.stage.Stage;
import jfxtras.scene.control.agenda.Agenda;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class PHomeController implements Initializable {

    @FXML
    private SplitMenuButton pg_menu;
    @FXML
    private SplitMenuButton approvalmenu;
    @FXML
    private ListView parent_announcements;

    @FXML
    private void click_PG_Work(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("parent_PG_Work.fxml"));
        Stage stage = (Stage) pg_menu.getScene().getWindow();;
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void click_PendingApprovals(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader((getClass().getResource("parent_pending_approvals.fxml")));
        Stage stage = (Stage) approvalmenu.getScene().getWindow();
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private final ObservableList<Announcement> anns = FXCollections.observableArrayList(
            new Announcement("Επαναλειτουργία των σχολείων", "cont1", LocalDate.of(2020, Month.MAY, 20), "rec1", "sen1"),
            new Announcement("Απόφαση ΕΟΔΥ", "cont1", LocalDate.of(2020, Month.MAY, 20), "rec1", "sen1"),
            new Announcement("Διαδικυτακή λειτουργία σχολείων", "cont1", LocalDate.of(2020, Month.MAY, 20), "rec1", "sen1"),
            new Announcement("Κοπή Βασιλόπιτας", "cont1", LocalDate.of(2020, Month.JANUARY, 17), "rec1", "sen1")
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Announcement ann : anns) {
            parent_announcements.getItems().add(ann.get_an_title());
        }
    }
}
