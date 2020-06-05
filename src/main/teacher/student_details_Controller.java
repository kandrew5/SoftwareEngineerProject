package main.teacher;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class student_details_Controller {
    @FXML
    private TextField class_field;
    @FXML
    private TextField mname_field;
    @FXML
    private TextField fname_field;
    @FXML
    private TextField amka_field;
    @FXML
    private TextField tel_field;
    @FXML
    private TextField am_field;
    @FXML
    private TextField fn_field;
    @FXML
    private TextField sn_field;

    @FXML
    public void click_Excursion(javafx.event.ActionEvent actionEvent) throws IOException { //create excursion button listener
        var node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("excursions.fxml"));
        var root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }

    public void click_Grades(javafx.event.ActionEvent actionEvent) throws IOException {
        var node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("grades_main.fxml"));
        var root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }


    public void click_showAnnounc(javafx.event.ActionEvent actionEvent) throws IOException {
        var node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("teacher_announcement.fxml"));
        var root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }
    public void setStudentData(String id, String fn,String mn,String cid,String tel,String AMKA, String first, String last){
        class_field.setText(cid);
        mname_field.setText(mn);
        fname_field.setText(fn);
        amka_field.setText(AMKA);
        tel_field.setText(tel);
        am_field.setText(id);
        fn_field.setText(first);
        sn_field.setText(last);
    }

}
