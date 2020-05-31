package main.student;

import Class_folder.Grade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProgressController implements Initializable {
    public Button final_id;
    @FXML
    private TableColumn grade_no_id;
    @FXML
    private TableColumn grade_title_id;
    @FXML
    private TableView grade_table_id;
    @FXML
    private ChoiceBox course_box_id;
    String[] courses_array;

    private final ObservableList<Grade> list = FXCollections.observableArrayList(
            new Grade(13, "Διαγώνισμα τετραμήνου"),
            new Grade(17, "Πρόχειρο διαγώνισμα απροειδοποίητο"),
            new Grade(20, "Προφορική εξέταση 24/5"),
            new Grade(15, "Διαγώνισμα τετραμήνου"),
            new Grade(17, "Άσκήσεις 22/2"),
            new Grade(20, "Προφορική εξέταση 15/1")
    );
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //search db for students
        courses_array = new String[]{"Μαθηματικά", "Ιστορία", "Γεωμετρία", "Γλώσσα", "Κείμενα"};
        for (int i = 0; i<courses_array.length; i++) {
            course_box_id.getItems().add(courses_array[i]);
        }
    }

    public void select_Course(ActionEvent mouseEvent) {
        String course =(String) course_box_id.getValue();
        //getGrades() for the selected course
        grade_title_id.setCellValueFactory(new PropertyValueFactory<Grade, String>("grade_title"));
        grade_no_id.setCellValueFactory(new PropertyValueFactory<Grade, Integer>("grade_no"));

        grade_table_id.setItems(list);
    }

    public void click_FinalGrades(MouseEvent mouseEvent) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) final_id.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("student_grades_final.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
