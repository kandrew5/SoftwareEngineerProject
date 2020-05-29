package main.student;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


public class HCourseController {
    @FXML
    private Button curric_id;

    @FXML
    public Button disc_id;

    String course_title;
    @FXML
    private Text course_text_id;

    public void setCoursetitle(String course_title) {
        this.course_title = course_title;
    }

    public void setcText(String course_title){
        course_text_id.setText(course_title);
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
