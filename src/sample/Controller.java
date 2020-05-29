package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private TextField username_id;

    @FXML
    private PasswordField password_id;

    @FXML
    public void signIn(javafx.event.ActionEvent actionEvent) throws IOException {
        int u_type;
        String username = username_id.getText();
        String password = password_id.getText();
        if (username.isEmpty() && password.isEmpty()) {
            System.out.println("patates");
        }
        else if (!username.isEmpty() && password.isEmpty()) {
            System.out.println("patates1");
        }
        else if (username.isEmpty() && !password.isEmpty()) {
            System.out.println("patates2");
        }
        else {
            if(username.equals("st12") && password.equals("12345")) {
                Node node = (Node) actionEvent.getSource();
                Stage stage = (Stage) node.getScene().getWindow();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("student/student_home.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root, 1200, 800));
                stage.show();
            }
            else if(username.equals("tc12") && password.equals("12345")) {
                u_type = 1;
                if(u_type == 1) {
                    Node node = (Node) actionEvent.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();

                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("teacher/teacher_home.fxml"));
                    Parent root = (Parent) fxmlLoader.load();
                    stage.setScene(new Scene(root, 1200, 800));
                    stage.show();
                }
            }
            else if(username.equals("tc13") && password.equals("12345")) {
                u_type = 2;
                if(u_type == 2) {
                    Node node = (Node) actionEvent.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();

                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin/admin_home.fxml"));
                    Parent root = (Parent) fxmlLoader.load();
                    stage.setScene(new Scene(root, 1200, 800));
                    stage.show();
                }
            }
            else if (username.equals("pt12") && password.equals("12345")) {
                Node node = (Node) actionEvent.getSource();
                Stage stage = (Stage) node.getScene().getWindow();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("parent/parent_home.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root, 1200, 800));
                stage.show();
            }
        }
    }
}
