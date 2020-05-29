package sample.student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController  implements Initializable {
    @FXML
    private NumberAxis y_axis_id;
    @FXML
    private NumberAxis x_axis_id;
    @FXML
    private ListView notif_id;
    @FXML
    private AreaChart areachart_id;
    @FXML
    private Button grade_id;
    @FXML
    private SplitMenuButton menu_id;
    @FXML
    private MenuItem mycourses_id;

    String user_id = "45";
    @FXML
    private void click_Classes(ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) menu_id.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("student_courses.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        CoursesController courseControl = loader.getController();
        courseControl.setUser(user_id);
        stage.show();
    }

    public void click_Grades(MouseEvent mouseEvent) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) grade_id.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("student_grades.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        HGradeController gradeControl = loader.getController();
        gradeControl.setUser(user_id);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] notification_titles = {"Ενημέρωση υπουργείου για το COVID-19", "Αναλυτικός βοηθός για την χρήση Webex",
                "Γραμμή ψυχολογικής στήριξης μαθητών", "Ασύγχρονή εκπαίδευση μέσω της εφαρμογής",
                "Δημοσίευση ΦΕΚ για την διακοπή των μαθημάτων"};
        for (String notification_title : notification_titles) {
            notif_id.getItems().add(notification_title);
        }
        notif_id.setPrefHeight(notification_titles.length*40);

        x_axis_id.setAutoRanging(false);
        x_axis_id.setLowerBound(1);
        x_axis_id.setUpperBound(31);
        x_axis_id.setTickUnit(1);

        y_axis_id.setAutoRanging(false);
        y_axis_id.setLowerBound(0);
        y_axis_id.setUpperBound(70);
        y_axis_id.setTickUnit(5);

        areachart_id.setTitle("Ωρές ενασχόλησης μηνιαία");

        XYChart.Series seriesCurrentMonth= new XYChart.Series();
        seriesCurrentMonth.setName("May");
        seriesCurrentMonth.getData().add(new XYChart.Data(1, 4));
        seriesCurrentMonth.getData().add(new XYChart.Data(3, 10));
        seriesCurrentMonth.getData().add(new XYChart.Data(6, 12));
        seriesCurrentMonth.getData().add(new XYChart.Data(9, 15));
        seriesCurrentMonth.getData().add(new XYChart.Data(12, 16));
        seriesCurrentMonth.getData().add(new XYChart.Data(15, 17));
        seriesCurrentMonth.getData().add(new XYChart.Data(18, 23));
        seriesCurrentMonth.getData().add(new XYChart.Data(21, 25));
        seriesCurrentMonth.getData().add(new XYChart.Data(24, 35));
        seriesCurrentMonth.getData().add(new XYChart.Data(27, 40));
        seriesCurrentMonth.getData().add(new XYChart.Data(30, 54));

        areachart_id.getData().addAll(seriesCurrentMonth);
    }
}
