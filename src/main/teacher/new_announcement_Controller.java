package main.teacher;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class new_announcement_Controller {
    @FXML
    private TextField an_title;
    @FXML
    private TextArea an_content;

    @FXML
    public void click_Excursion(javafx.event.ActionEvent actionEvent) throws IOException { //create excursion button listener
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("excursions.fxml"));
        var root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }

    public void click_Grades(javafx.event.ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("grades_main.fxml"));
        var root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }

    public void publish_Announc(javafx.event.ActionEvent actionEvent) throws IOException {
      if(an_title.getText().equals("") || an_content.getText().equals("") ) { //check for empty fields
          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("Warning Dialog");
          alert.setHeaderText("Μη συμπληρωμένα πεδία"); //μήνυμα αποτυχίας
          alert.setContentText("Παρακαλώ συμπληρώστε όλα τα πεδία.");

          alert.showAndWait();
      }
      else {
          List<String> choices = new ArrayList<>();
          choices.add("Όλους");
          choices.add("Διεύθυνση");
          choices.add("Μαθητές");
          choices.add("Γονείς");

          ChoiceDialog<String> dialog = new ChoiceDialog<>("Όλους", choices);
          dialog.setTitle("Επιλογή παραληπτών");
          dialog.setHeaderText("Παρακαλώ επιλέξτε σε ποιους θέλετε \nνα δημοσιεύσετε την ανακοίνωση");
          dialog.setContentText("Δημοσίευση σε:");

          // Traditional way to get the response value.
          Optional<String> result = dialog.showAndWait();
          if (result.isPresent()) {
              System.out.println("Your choice: " + result.get());
          }

          // The Java 8 way to get the response value (with lambda expression).
          result.ifPresent(letter -> System.out.println("Your choice: " + letter));
      }
    }
}
