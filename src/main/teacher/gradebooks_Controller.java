package main.teacher;


import Class_folder.Gradebook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class gradebooks_Controller<gradeList> implements Initializable {
    @FXML
    private TableView<Gradebook> gradeList;
    @FXML
    private TableColumn<Gradebook,String> title_col;
    @FXML
    private TableColumn id_col;

    @FXML
    public void select_Gradebook(MouseEvent arg0) throws IOException {
        Gradebook grade = (Gradebook) gradeList.getSelectionModel().getSelectedItem();

       //System.out.println("clicked on " + grade.getGr_id());
        Stage stage;
        Parent root;
        stage = (Stage) gradeList.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("edit_Gradebook.fxml"));
        root = loader.load();


        int id = grade.getGr_id();
        edit_Gradebook_Controller editController = loader.getController();
        editController.setClassID(id);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
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
    //getGradebook() αναζήτηση στη βάση
    //dummy data εδώ
    private final ObservableList<Gradebook> list = FXCollections.observableArrayList(
            new Gradebook("A3","Μαθηματικά","τετραμήνου","Α3: Άλγεβρα Α'τετράμηνο",1),
            new Gradebook("A3","Μαθηματικά","τετραμήνου","Α3: Άλγεβρα Β'τετράμηνο",2),
            new Gradebook("A3","Μαθηματικά","τελικός","Α3: Άλγεβρα Τελικός",3),
            new Gradebook("Β3","Μαθηματικά","τετραμήνου", "Β3: Γεωμετρία Α'τετράμηνο",4)
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) { //showGradebooks()
        title_col.setCellValueFactory(new PropertyValueFactory<>("gr_title"));
        id_col.setCellValueFactory(new PropertyValueFactory<>("gr_id"));

        gradeList.setItems(list);

    }
    @FXML
    public void click_showAnnounc(javafx.event.ActionEvent actionEvent) throws IOException {
        var node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("teacher_announcement.fxml"));
        var root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }
}
