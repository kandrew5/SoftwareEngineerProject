package main.parent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ApprovalController implements Initializable {

    @FXML
    private Canvas canvas;
    @FXML
    private CheckBox clearBox;
    @FXML
    private TextField fullnameText;
    @FXML
    private TextField parentText;
    @FXML
    private Text approvaltitle;
    @FXML
    private Text approvaltitleblue;

    private boolean canvasclear = true;

    public void setTitle(String title){
        this.approvaltitle.setText(title);
        this.approvaltitleblue.setText(title);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) throws NullPointerException{
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.WHITE);
        g.fillRect(0,0, canvas.getWidth(), canvas.getHeight());
        canvas.setOnMouseDragged(e -> {
            double size = 3;
            double x = e.getX() - size/2;
            double y = e.getY() - size/2;

            g.setFill(Color.BLACK);
            g.fillRect(x,y,size,size);

            if (canvasclear) canvasclear=false;
        });
    }

    public void clearCanvas(ActionEvent actionEvent) {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.WHITE);
        g.fillRect(0,0, canvas.getWidth(), canvas.getHeight());
        canvasclear = true;
        clearBox.setSelected(false);
    }

    public void validateFields(TextField tf1, TextField tf2, Canvas cv){

        if (tf1.getText().equals("") || tf2.getText().equals("") || canvasclear){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Μη συμπληρωμένα πεδία");
            alert.setContentText("Παρακαλώ συμπληρώστε όλα τα πεδία");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Επιτυχία");
            alert.setHeaderText("Επιτυχής έγκριση");
            alert.setContentText("Το έγγραφο έχει πλέον εγκριθεί");

            alert.showAndWait();
        }

    }

    public void approveFile(ActionEvent actionEvent) {
        validateFields(fullnameText, parentText, canvas);
    }

    public void displayFail(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Ακύρωση έκγρισης");
        alert.setHeaderText("Ή έγκριση του εγγράφου ακυρώθηκε");
        alert.setContentText("Επιστροφή στις εκκρεμείς εγκρίσεις");

        alert.showAndWait();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("parent_pending_approvals.fxml"));
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = loader.load();
        Scene scene = stage.getScene();

        scene.setRoot(root);
    }
}
