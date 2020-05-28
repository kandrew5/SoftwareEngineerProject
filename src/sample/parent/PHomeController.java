package sample.parent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.stage.Stage;

import java.io.IOException;

public class PHomeController {

    @FXML
    private SplitMenuButton pg_menu;
    @FXML
    private MenuItem pg_work;

    @FXML
    private SplitMenuButton approvalmenu;
    @FXML
    private MenuItem pendingapprovals;

    @FXML
    private void click_PG_Work(ActionEvent actionEvent) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("parent_PG_Work.fxml"));
        Stage stage = (Stage) pg_menu.getScene().getWindow();;
        Parent root = loader.load();
        Scene scene = new Scene(root);

        stage.setScene(scene);

        PGWorkController pgWorkController = loader.getController();
        stage.show();

    }

    public void click_PendingApprovals(ActionEvent actionEvent) throws IOException{

        FXMLLoader loader = new FXMLLoader((getClass().getResource("parent_pending_approvals.fxml")));
        Stage stage = (Stage) approvalmenu.getScene().getWindow();
        Parent root = loader.load();
        Scene scene = new Scene(root);

        stage.setScene(scene);

        PendingApprovalsController pendappController = loader.getController();
        stage.show();
    }
}
