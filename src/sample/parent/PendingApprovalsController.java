package sample.parent;

import Class_folder.Approval;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.stage.Stage;


import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

public class PendingApprovalsController {

    Approval file1 = new Approval("singleday","st12", "pt12" , true , LocalDate.of(2020, Month.MAY, 5));
    Approval file2 = new Approval("fiveday","st12", "pt12" , true , LocalDate.of(2020, Month.FEBRUARY, 2));
    Approval file3 = new Approval("educational","st12", "pt12" , true , LocalDate.of(2019, Month.DECEMBER, 11));
    Approval file4 = new Approval("schoolmatches","st12", "pt12" , true , LocalDate.of(2020, Month.MARCH, 10));



    public void click_FileToApprove(ActionEvent actionEvent) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("parent_approval.fxml"));
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        Parent root = loader.load();
        Scene scene = stage.getScene();

        ApprovalController appcont = loader.getController();

        String id = source.getId();
        if(id.equals("singleday11_5")){
            appcont.setTitle("Μονοήμερη εκδρομή");
        }else if (id.equals("fiveday12_2")){
            appcont.setTitle("Πενθήμερη εκδρομή");
        }else if (id.equals("educational11_12")){
            appcont.setTitle("Εκπαιδευτική εκδρομή");
        }else if (id.equals("schoolmatches")){
            appcont.setTitle("Σχολικοί αγώνες");
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText(String.valueOf(id.equals("asda")));
            alert.setContentText(id);
            alert.showAndWait();
        }

        scene.setRoot(root);
    }
}
