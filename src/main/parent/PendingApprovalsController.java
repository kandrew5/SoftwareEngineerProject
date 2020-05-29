package main.parent;

import Class_folder.Approval;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class PendingApprovalsController implements Initializable {

    private final ObservableList<Approval> pendapprovals = FXCollections.observableArrayList(
            new Approval("a1","st12", "pt12" , true , LocalDate.of(2020, Month.MAY, 5), "Μονοήμερη εκδρομή στην Αθήνα"),
            new Approval("a2","st12", "pt12" , true , LocalDate.of(2020, Month.FEBRUARY, 2), "Πενθήμερη εκδρομή στο Ναύπλιο"),
            new Approval("a3","st12", "pt12" , true , LocalDate.of(2019, Month.DECEMBER, 11), "Εκπαιδευτική εκδρομή στη Βουλή"),
            new Approval("a4","st12", "pt12" , true , LocalDate.of(2020, Month.MARCH, 10) , "Συμμετοχή στους σχολικούς αγώνες")
    );


    @FXML
    private TableView pendingapprovalstable;
    @FXML
    private TableColumn pa_title_col;
    @FXML
    private TableColumn pa_date_col;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pa_title_col.setCellValueFactory(new PropertyValueFactory<Approval, String>("ap_title"));
        pa_date_col.setCellValueFactory(new PropertyValueFactory<Approval, LocalDate>("ap_expire_date"));

        pendingapprovalstable.setItems(pendapprovals);
    }

    public void click_FileToApprove(MouseEvent click) throws IOException{


        if(click.getClickCount()==2){

            Approval temp = (Approval) pendingapprovalstable.getSelectionModel().getSelectedItem();
            String appTitle = (String) temp.getAp_title();
            Stage stage = (Stage) pendingapprovalstable.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("parent_approval.fxml"));

            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);

            ApprovalController appcont = loader.getController();


            if(appTitle.equals(pendapprovals.get(0).getAp_title())){
                appcont.setTitle("Μονοήμερη εκδρομή");
            }else if(appTitle.equals(pendapprovals.get(1).getAp_title())){
                appcont.setTitle("Πενθήμερη εκδρομή");
            }else if (appTitle.equals(pendapprovals.get(2).getAp_title())){
                appcont.setTitle("Εκπαιδευτική εκδρομή");
            }else if (appTitle.equals(pendapprovals.get(3).getAp_title())){
                appcont.setTitle("Συμμετοχή στους σχολικούς αγώνες");
            }
            scene.setRoot(root);
            stage.show();
        }


    }



}
