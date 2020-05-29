package sample.student;

import Class_folder.Grade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class FinalgController implements Initializable {

    @FXML
    private TableColumn gr_course_title;
    @FXML
    private TableColumn gr_grade_no;
    @FXML
    private TableColumn gr_grade_no2;
    @FXML
    private TableColumn gr_grade_mean;
    @FXML
    private TableView table_gr_id;


    private final ObservableList<Grade> list = FXCollections.observableArrayList(
            new Grade("Μαθηματικά", 13, 14, 10),
            new Grade("Ιστορία", 18, 19, 19),
            new Grade("Γεωμετρία", 17, 17, 16),
            new Grade("Αρχαία", 13, 12, 16),
            new Grade("Φιλοσοφία", 19, 20, 19),
            new Grade("Κοινωνιολογία", 20, 20, 20),
            new Grade("Φυσική", 17, 17, 15),
            new Grade("Χημεία", 18, 20, 19)
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gr_course_title.setCellValueFactory(new PropertyValueFactory<Grade, String>("gr_course"));
        gr_grade_no.setCellValueFactory(new PropertyValueFactory<Grade, Integer>("grade_no"));
        gr_grade_no2.setCellValueFactory(new PropertyValueFactory<Grade, Integer>("grade_no2"));
        gr_grade_mean.setCellValueFactory(new PropertyValueFactory<Grade, Integer>("grade_mean"));

        table_gr_id.setItems(list);
    }
}
