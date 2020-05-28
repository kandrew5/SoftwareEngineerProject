package sample.teacher;

import Class_folder.Grade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.student.HCourseController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class gradebooks_Controller<gradeList> implements Initializable {
    @FXML
    private TableView<Grade> gradeList;
    @FXML
    private TableColumn title_col;
    @FXML
    private TableColumn id_col;

    @FXML
    public void select_Gradebook(MouseEvent arg0) throws IOException {
        Grade grade = (Grade) gradeList.getSelectionModel().getSelectedItem();
        System.out.println("clicked on " + grade.getGr_title());
        System.out.println("clicked on " + grade.getGr_id());
        Stage stage;
        Parent root;
        stage = (Stage) gradeList.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("edit_Gradebook.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        String id = String.valueOf(grade.getGr_id());
        edit_Gradebook_Controller editController = loader.getController();
       // editController.setCoursetitle(grade.getGr_title());
        editController.setClassID(id);
        stage.show();

    }
    private final ObservableList<Grade> list = FXCollections.observableArrayList(
            new Grade("A3","Μαθηματικά","τετραμήνου","Α3: Άλγεβρα Α'τετράμηνο",01),
            new Grade("A3","Μαθηματικά","τετραμήνου","Α3: Άλγεβρα Β'τετράμηνο",02),
            new Grade("A3","Μαθηματικά","τελικός","Α3: Άλγεβρα Τελικός",03),
            new Grade("Β3","Μαθηματικά","τετραμήνου", "Β3.Γεωμετρία Α'τετράμηνο",04)
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        title_col.setCellValueFactory(new PropertyValueFactory<Grade,String>("gr_title"));
        id_col.setCellValueFactory(new PropertyValueFactory<>("gr_id"));
//        gradeList.setRowFactory(tv -> {
////            TableRow<Object> row = new TableRow<>();
////            row.setOnMouseClicked(event -> {
////                if (! row.isEmpty() && event.getButton()== MouseButton.PRIMARY
////                        && event.getClickCount() == 2) {
////
////                    Object clickedRow = row.getItem();
////                   // String convertedToString = String.valueOf(clickedRow);
////                    System.out.println(clickedRow);
////                }
////            });
////            return 1 ;
////        });
        gradeList.setItems(list);

    }
}
