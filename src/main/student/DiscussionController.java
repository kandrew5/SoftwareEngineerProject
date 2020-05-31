package main.student;

import Class_folder.Discussion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class DiscussionController implements Initializable {

    public TableView disc_table_id;
    public TableColumn dtitle_id;
    public TableColumn dcreator_id;
    public Button new_disc;
    public Button curric_id;
    String course_title;
    private Discussion added_Disc = new Discussion();

    public void setCourse(String course_title) {
        this.course_title = course_title;
    }
    LocalDate fDate = LocalDate.of(2020, Month.JANUARY, 19);
    LocalDate sDate = LocalDate.of(2020, Month.JANUARY, 17);
    LocalDate tDate = LocalDate.of(2019, Month.NOVEMBER, 10);

    private final ObservableList<Discussion> list = FXCollections.observableArrayList(
            new Discussion("d1", "Δεν καταλαβαίνω τίποτα", "Λίγο κείμενο", fDate, "Πάνος"),
            new Discussion("d2", "Απορία στην επίλυση της άσκησης 3", "Λίγο κείμενο", sDate, "Ρωμανός"),
            new Discussion("d3", "Ερώτηση σχετικά με την επίλυση εξίσσωσης", "Λίγο κείμενο", tDate, "Θωμάς")
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dtitle_id.setCellValueFactory(new PropertyValueFactory<Discussion, String>("disc_title"));
        dcreator_id.setCellValueFactory(new PropertyValueFactory<Discussion, String>("disc_sender"));

        disc_table_id.setItems(list);
    }

    public Discussion getDisc(){
        return added_Disc;
    }

    public void newDiscussion(MouseEvent mouseEvent) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) new_disc.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("student_new_discussion.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        Stage stage2 = new Stage();
        stage2.setScene(scene);
        stage2.initModality(Modality.WINDOW_MODAL);
        stage2.initOwner(stage);
        stage2.showAndWait();
        N_DiscussionController pd = loader.getController();
        added_Disc=pd.getDisc();
        list.add(getDisc());
        disc_table_id.refresh();

    }

    public void click_Curriculum(MouseEvent mouseEvent) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) curric_id.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("student_curriculum.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        CurriculumController currControl = loader.getController();
        currControl.setCourse(course_title);
        stage.show();
    }
}
