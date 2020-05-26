package sample.student;

import Class_folder.Class;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CoursesController implements Initializable {
    String user;
    @FXML
    private ListView list_id;

    public String getUser(){
        return user;
    }

    public void setUser(String user){
        this.user=user;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //search DB for students class
        String class_id = "c123";
        Class s_class = new Class(class_id);
        String[] courses = s_class.getClasses();
        for(int i=0; i<courses.length;i++) {
        list_id.getItems().add(courses[i]);
        }
        list_id.setPrefHeight(courses.length*41);
    }

    public void select_Course(MouseEvent mouseEvent) throws IOException {
        String course_title = (String) list_id.getSelectionModel().getSelectedItem();
        Stage stage;
        Parent root;
        stage = (Stage) list_id.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("student_courses_home.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        HCourseController hcourseController = loader.getController();
        hcourseController.setCoursetitle(course_title);
        hcourseController.setcText(course_title);
        stage.show();
    }
}
