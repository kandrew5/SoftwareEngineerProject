package main.admin;

import Class_folder.Student;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ExportDataController implements Initializable {
    @FXML
    public TableView<Student> studentDatatable;
    @FXML
    public TableColumn<Student, String> am;
    @FXML
    public TableColumn<Student, String> last_name;
    @FXML
    public TableColumn<Student, String> first_name;
    @FXML
    public TableColumn<Student, String> class_id;
    @FXML
    public TableColumn<Student, String> father_name;
    @FXML
    public TableColumn<Student, String> mother_name;
    @FXML
    public TableColumn<Student, Long> tel;
    @FXML
    public TableColumn<Student, String> AMKA;
    @FXML
    public ComboBox<String> cmbClass;

    ObservableList<String> classList = FXCollections.observableArrayList("A","B","Γ","Δ","Ε","ΣΤ");
    private static String[] columns = {"Αριθμός Μητρώου", "Επίθετο", "Όνομα", "Τάξη", "Όνομα πατέρα", "Όνομα μητέρας", "Τηλέφωνο", "ΑΜΚΑ"};

    private final ObservableList<Student> list = FXCollections.observableArrayList(
            new Student("st01","Βαϊόπουλος","Θεοφάνης","A","Κωνσταντίνος","Μαρκέλα","6912345678","02151412345"),
            new Student("st02","Χατζηαποστόλου","Έλενα ","A","Ευάγγελος","Φωτεινή","6912345678","14041412345"),
            new Student("st03","Παναγιώτου","Χρήστος","B","Χάρης","Σοφία","6912345678","01121312345"),
            new Student("st04","Βαλαζιώτης","Αυγουστίνος","B","Εμμανουήλ","Σταυρούλα","6912345678","22121312345"),
            new Student("st05","Παπαδοπούλου","Μαρία","Γ","Ανδρέας","Γλυκερία","6912345678","26071112345"),
            new Student("st06","Γεωργάκης","Βασίλειος","Γ","Φώτιος","Εμμανουέλα","6912345678","09111212345"),
            new Student("st07","Τριποδάκη","Έλλη","Δ","Αθανάσιος","Αικατερίνη","6912345678","30091112345"),
            new Student("st08","Δατζής","Κυριάκος","Δ","Ευάγγελος","Φωτεινή ","6912345678","05051112345"),
            new Student("st09","Μυλονόπουλος","Παναγιώτης","Ε","Γεώργιος","Δήμητρα","6912345678","27101012345"),
            new Student("st10","Ζωιτσάκου","Αθανασία","Ε","Παντελής","Μαρία","6912345678","03071012345"),
            new Student("st11","Κώτσαινας","Παναγιώτης","ΣΤ","Μελέτιος","Νεκταρία","6912345678","16030912345"),
            new Student("st12","Τζανακάκη","Ευσταθία","ΣΤ","Νικόλαος","Ελένη","6912345678","05050912345")
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        last_name.setCellValueFactory(new PropertyValueFactory<Student, String>("last_name"));
        first_name.setCellValueFactory(new PropertyValueFactory<Student, String>("first_name"));
        class_id.setCellValueFactory(new PropertyValueFactory<Student, String>("class_id"));
        father_name.setCellValueFactory(new PropertyValueFactory<Student, String>("father_name"));
        mother_name.setCellValueFactory(new PropertyValueFactory<Student, String>("mother_name"));
        tel.setCellValueFactory(new PropertyValueFactory<Student, Long>("tel"));
        AMKA.setCellValueFactory(new PropertyValueFactory<Student, String>("AMKA"));
        studentDatatable.setItems(list);

        cmbClass.setItems(classList);
    }

    public void export_Button() throws IOException {

        TableColumn<Student,String> nameCol_1 = new TableColumn<Student,String>("Αριθμός Μητρώου");
        nameCol_1.setCellValueFactory(new PropertyValueFactory<Student, String>("am"));
        TableColumn<Student,String> nameCol_2 = new TableColumn<Student,String>("Όνομα");
        nameCol_2.setCellValueFactory(new PropertyValueFactory<Student, String>("first_name"));
//        TableColumn<Student,String> nameCol_3 = new TableColumn<Student,String>("Όνομα");
//        nameCol_3.setCellValueFactory(new PropertyValueFactory<Student, String>("first_name"));
//        TableColumn<Student,String> nameCol_4 = new TableColumn<Student,String>("Όνομα");
//        nameCol_4.setCellValueFactory(new PropertyValueFactory<Student, String>("first_name"));
//        TableColumn<Student,String> nameCol_5 = new TableColumn<Student,String>("Όνομα");
//        nameCol_5.setCellValueFactory(new PropertyValueFactory<Student, String>("first_name"));
//        TableColumn<Student,String> nameCol_6 = new TableColumn<Student,String>("Όνομα");
//        nameCol_6.setCellValueFactory(new PropertyValueFactory<Student, String>("first_name"));

        ObservableList<TableColumn<Student, ?>> columns = studentDatatable.getColumns();
        columns.add(nameCol_1);
        columns.add(nameCol_2);

        Workbook workbook = new HSSFWorkbook();
        Sheet spreadsheet = workbook.createSheet("sample");

        Row row = spreadsheet.createRow(0);

        for (int j = 0; j < studentDatatable.getColumns().size(); j++) {
            row.createCell(j).setCellValue(studentDatatable.getColumns().get(j).getText());
        }

        for (int i = 0; i < studentDatatable.getItems().size(); i++) {
            row = spreadsheet.createRow(i + 1);
            for (int j = 0; j < studentDatatable.getColumns().size(); j++) {
                if(studentDatatable.getColumns().get(j).getCellData(i) != null) {
                    row.createCell(j).setCellValue(studentDatatable.getColumns().get(j).getCellData(i).toString());
                }
                else {
                    row.createCell(j).setCellValue("");
                }
            }
        }

        FileOutputStream fileOut = new FileOutputStream("workbook.xls");
        workbook.write(fileOut);
        fileOut.close();

        Platform.exit();



//        XSSFWorkbook wb = new XSSFWorkbook();
//        XSSFSheet sheet = wb.createSheet("userData");
//        XSSFFont headerFont = wb.createFont();
//        headerFont.setBold(true);
//        CellStyle hcStyle = wb.createCellStyle();
//        hcStyle.setFont(headerFont);
//
//        Row headerRow = sheet.createRow(0);
//        for(int i=0; i<columns.length;i++){
//            Cell cell = headerRow.createCell(i);
//            cell.setCellValue(columns[i]);
//            cell.setCellStyle(hcStyle);
//        }
//
//        int rowNum = 1;
//
//        for(Student student: list){
//            Row row = sheet.createRow(rowNum++);
//            row.createCell(0).setCellValue(student.getAm());
//            row.createCell(1).setCellValue(student.getFirst_name());
//            row.createCell(2).setCellValue(student.getLast_name());
//            row.createCell(3).setCellValue(student.getClass_id());
//            row.createCell(4).setCellValue(student.getFather_name());
//            row.createCell(5).setCellValue(student.getMother_name());
//            row.createCell(6).setCellValue(student.getTel());
//            row.createCell(7).setCellValue(student.getAMKA());
//        }
//
//        for (int i=0; i<columns.length; i++){
//            sheet.autoSizeColumn(i);
//        }
//
//        FileOutputStream fileOut = new FileOutputStream("studentData.xlsx");
//        wb.write(fileOut);
//        fileOut.close();

//        XSSFRow header = sheet.createRow(0);
//        header.createCell(0).setCellValue("Αριθμός Μητρώου");
//        header.createCell(1).setCellValue("Επίθετο");
//        header.createCell(2).setCellValue("Όνομα");
//        header.createCell(3).setCellValue("Τάξη");
//        header.createCell(4).setCellValue("Όνομα πατέρα");
//        header.createCell(5).setCellValue("Όνομα μητέρας");
//        header.createCell(6).setCellValue("Τηλέφωνο");
//        header.createCell(7).setCellValue("ΑΜΚΑ");
    }

    public void click_communication(javafx.event.ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("recent_messages.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }

    public void click_calendar(javafx.event.ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("calendar.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }

    public void click_Timetable(javafx.event.ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("timetable.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }

    public void click_decisions(javafx.event.ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("all_decisions.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }
    public void click_Votings(javafx.event.ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newVoting.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }
}