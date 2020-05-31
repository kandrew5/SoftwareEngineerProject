package main.student;

import Class_folder.Curriculum;
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
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class CurriculumController implements Initializable {
    public TableView<Curriculum> table_id;
    public TableColumn<Curriculum, String> date_id;
    public TableColumn<Curriculum, String> cur_data_id;
    public Button disc_id;

    String course_title;

    public void setCourse(String course_title) {
        this.course_title = course_title;
    }

    LocalDate fDate = LocalDate.of(2020, Month.JANUARY, 19);
    LocalDate sDate = LocalDate.of(2020, Month.JANUARY, 17);
    LocalDate tDate = LocalDate.of(2019, Month.NOVEMBER, 10);

    private final ObservableList<Curriculum> list = FXCollections.observableArrayList(
            new Curriculum("cur1", "Μαθηματικά", fDate, "Βιβλίο: Παραδόθηκαν οι σελίδες 20-25 και λύθηκαν στον πίνακα οι ασκήσεις 1-5 της σελίδας 27"),
            new Curriculum("cur2", "Ιστορία", sDate, "Βιβλίο: Παραδόθηκαν οι σελίδες 12-19"),
            new Curriculum("cur3", "Γεωμετρία", tDate, "Βιβλίο: Ασκήσεις τριγωνομετρίας απο φωτοτυπίες")
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        date_id.setCellValueFactory(new PropertyValueFactory<Curriculum, String>("cur_date"));
        cur_data_id.setCellValueFactory(new PropertyValueFactory<Curriculum, String>("cur_content"));

        table_id.setItems(list);
    }

    public void click_Discussions(MouseEvent mouseEvent) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) disc_id.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("student_discussion.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        DiscussionController discControl = loader.getController();
        discControl.setCourse(course_title);
        stage.show();
    }
}
