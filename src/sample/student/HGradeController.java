package sample.student;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HGradeController {
    @FXML
    private Button progress_id;

    @FXML
    private Button final_id;
    String user;


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

//        HGradeController gradeControl = loader.getController();
//        gradeControl.setUser(user_id);
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

//        HGradeController gradeControl = loader.getController();
//        gradeControl.setUser(user_id);
        stage.show();
    }
}
