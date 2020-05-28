package sample.student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private Button grade_id;
    @FXML
    private SplitMenuButton menu_id;
    @FXML
    private MenuItem mycourses_id;

    String user_id = "45";
    @FXML
    private void click_Classes(ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) menu_id.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("student_courses.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        CoursesController courseControl = loader.getController();
        courseControl.setUser(user_id);
        stage.show();
    }

    public void click_Grades(MouseEvent mouseEvent) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) grade_id.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("student_grades.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        HGradeController gradeControl = loader.getController();
        gradeControl.setUser(user_id);
        stage.show();
    }
}
