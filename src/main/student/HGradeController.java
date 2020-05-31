package main.student;

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

public class HGradeController {
    public MenuItem mycourses_id;
    public SplitMenuButton menu_id;
    @FXML
    private Button progress_id;

    @FXML
    private Button final_id;
    String user;
    String user_id = "45";

    public void setUser(String user){
        this.user=user;
    }

    public String getUser(){
        return user;
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

    public void click_Classes(ActionEvent actionEvent) throws IOException {
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
}
