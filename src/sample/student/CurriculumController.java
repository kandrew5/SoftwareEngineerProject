package sample.student;

import Class_folder.Curriculum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CurriculumController implements Initializable {
    public TableView<Curriculum> table_id;
    public TableColumn<Curriculum, String> date_id;
    public TableColumn<Curriculum, String> cur_data_id;

    String course_title;

    public void setCourse(String course_title) {
        this.course_title = course_title;
    }

    private final ObservableList<Curriculum> list = FXCollections.observableArrayList(
            new Curriculum("cur1", "Μαθηματικά", "2019-01-12", "Πατάτες"),
            new Curriculum("cur2", "Μαθηματικά", "2019-01-11", "Πατάτες1"),
            new Curriculum("cur3", "Μαθηματικά", "2019-01-10", "Πατάτες2")
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        date_id.setCellValueFactory(new PropertyValueFactory<Curriculum, String>("cur_date"));
        cur_data_id.setCellValueFactory(new PropertyValueFactory<Curriculum, String>("cur_content"));

        table_id.setItems(list);
    }
}
