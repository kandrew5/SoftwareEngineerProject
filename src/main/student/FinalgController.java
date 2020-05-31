package main.student;

import Class_folder.Grade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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


public class FinalgController implements Initializable {

    @FXML
    private Button progress_id;
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

    public void click_Progress(MouseEvent mouseEvent) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) progress_id.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("student_grades_progress.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
