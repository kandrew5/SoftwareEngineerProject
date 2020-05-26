package sample.student;

import Class_folder.Curriculum;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DiscussionController implements Initializable {

    public TableView disc_table_id;
    public TableColumn dtitle_id;
    public TableColumn dcreator_id;
    public Button new_disc;
    String course_title;

    public void setCourse(String course_title) {
        this.course_title = course_title;
    }

    private final ObservableList<Discussion> list = FXCollections.observableArrayList(
            new Discussion("d1", "Δεν καταλαβαίνω", "Λίγο κείμενο", "19-01-2020", "Πάνος"),
            new Discussion("d2", "Πονάει το αυτί μου", "Λίγο κείμενο", "17-01-2020", "Ρωμανός"),
            new Discussion("d3", "Τι είναι αυτά ρε", "Λίγο κείμενο", "10-10-2019", "Θωμάς")
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dtitle_id.setCellValueFactory(new PropertyValueFactory<Curriculum, String>("disc_title"));
        dcreator_id.setCellValueFactory(new PropertyValueFactory<Curriculum, String>("disc_sender"));

        disc_table_id.setItems(list);
    }

    public void newDiscussion(MouseEvent mouseEvent) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) new_disc.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("student_discussion.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        DiscussionController discControl = loader.getController();
        discControl.setCourse(course_title);
        stage.show();
    }
}
