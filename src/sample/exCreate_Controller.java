package sample;

import Class_folder.Excursion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class exCreate_Controller {
    @FXML
    private TableView<Excursion> table;
    @FXML
    private TableColumn<Excursion, String> ex_name;
    @FXML
    private TableColumn<Excursion, String> ex_date;
    private Date exc_date = new Date();
    public ObservableList<Excursion> list = FXCollections.observableArrayList(
            new Excursion("��������� ������� ���� �����", "�������� ��� ������� ��� ��������� ��� ��� �����", "�����", exc_date, 30)
    );
    public void initialize(URL location, ResourceBundle resources){
        ex_name.setCellValueFactory(new PropertyValueFactory<>("destination"));
        table.setItems(list);
    }
}
