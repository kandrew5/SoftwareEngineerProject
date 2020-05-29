package main.student;

import Class_folder.Discussion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class N_DiscussionController {


    public TextArea descr_id;
    public TextField title_id;
    @FXML
    private Button ndisc_id;

    Discussion new_disc = new Discussion();
    public void create_Discussion(MouseEvent mouseEvent) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) ndisc_id.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("student_discussion.fxml"));
        root = loader.load();
        if (descr_id.getText().equals("") || title_id.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error message");
            alert.setHeaderText(null);
            alert.setContentText("You didn't fill all the fields!");

            alert.showAndWait();
        } else {
            String descr = descr_id.getText();
            String title = title_id.getText();
            //save to DB
            LocalDate mDate = LocalDate.now();

            new_disc = new Discussion("d4", title, "Αρκετό κείμενο", mDate, "Ανδρέας");

            descr_id.clear();
            title_id.clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success message");
            alert.setHeaderText(null);
            alert.setContentText("Your question has been successfully committed!");

            alert.showAndWait();
            stage.close();
        }
    }
    public Discussion getDisc() {
        return new_disc;
    }
}
