package sample.student;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class ProgressController implements Initializable {
    @FXML
    private TableColumn grade_no_id;
    @FXML
    private TableColumn grade_title_id;
    @FXML
    private TableView grade_table_id;
    @FXML
    private ChoiceBox course_box_id;
    String[] courses_array;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //search db for students
        courses_array = new String[]{"Μαθηματικά", "Ιστορία", "Γεωμετρία", "Γλώσσα", "Κείμενα"};
        for (int i = 0; i<courses_array.length; i++) {
            course_box_id.getItems().add(courses_array[i]);
        }
    }
}
