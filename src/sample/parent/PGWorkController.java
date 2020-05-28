package sample.parent;

import Class_folder.PG_Work;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.net.URL;
import java.time.Month;
import java.util.ResourceBundle;


public class PGWorkController implements Initializable {

    ObservableList<String> filtersList = FXCollections.observableArrayList("Πρόσφατα", "Δημοφιλή", "Σχολικά");

    @FXML
    private Button show1;
    @FXML
    private Button show2;
    @FXML
    private Button show3;
    @FXML
    private Button show4;
    @FXML
    private TextArea entryshown;
    @FXML
    private ChoiceBox filters;
    @FXML
    private Text entry1date;
    @FXML
    private Text entry1text;
    @FXML
    private Text entry2date;
    @FXML
    private Text entry2text;
    @FXML
    private Text entry3date;
    @FXML
    private Text entry3text;
    @FXML
    private Text entry4date;
    @FXML
    private Text entry4text;
    @FXML
    private Text entry1auth;
    @FXML
    private Text entry2auth;
    @FXML
    private Text entry3auth;
    @FXML
    private Text entry4auth;

    private String title1 = "Ενημέρωση για το νέο κορωνοϊό COVID-19";
    private String cont1 = "Ο Σύλλογος γονέων και κηδεμόνων στα πλαίσια του νέου κορωνοϊού \n" +
            "COVID-19 παρέχει ενημέρωση όσον αφορά τα μέτρα που χρειάζεται \n" +
            "να πάρει ο καθένας για την προστασία από τον ιό αλλά και για τον \n" +
            "περιορισμό της εξάπλωσης του. Είναι σημαντικό όσοι μπορούν \n" +
            "να προσέλθουν καθώς ο ιός αυτός απειλεί και τη χώρα μας.\n" +
            "Η ενημέρωση θα γίνει στις 17-2-2020.";
    private LocalDate date1 = LocalDate.of(2020, Month.FEBRUARY, 17);
    private String auth1 = "Παναγιώτης Τριανταφυλλόπουλος";
    private PG_Work pgwork1 = new PG_Work(title1 , cont1, date1, auth1);

    private String title2 = "Κοπή βασιλόπιτας για το σχολικό έτος 2019-2020";
    private String cont2 = "Με χαρά σας ενημερώνουμε πώς ο Σύλλογος γονέων και κηδεμόνων θα \n" +
            "πραγματοποιήσει κοπή βασιλόπιτας για το σχολικό έτος 2019-2020. \n" +
            "Η κοπή θα λάβει χώρα στην αίθουσα εκδηλώσεων του σχολείου τη \n" +
            "Δευτέρα 20/01/2020 την τελευταία ώρα της σχολικής χρονιάς.";
    private LocalDate date2 = LocalDate.of( 2020, Month.JANUARY, 17);
    private String auth2 = "Νίκος Παπαδόπουλος";
    private PG_Work pgwork2 = new PG_Work(title2 , cont2, date2, auth2);

    private String title3 = "Γενική συνέλευση του Συλλόγου Γονέων και Κηδεμόνων";
    private String cont3 = "Στις 14 Ιανουαρίου θα πραγματοποιηθεί γενική συνέλευση του Συλλόγου\n" +
            "γονέων και κηδεμόνων κατά την οποία θα συζητηθούν θέματα που \n" +
            "αφορούν το σχολικό περιβάλλον καθώς και αρκετά ζητήματα που \n" +
            "προέκυψαν κατά την οργάνωση του συλλόγου.";
    private LocalDate date3 = LocalDate.of(2020, Month.JANUARY, 17);
    private String auth3 = "Παναγιώτης Τριανταφυλλόπουλος";
    private PG_Work pgwork3 = new PG_Work(title3, cont3, date3, auth3);

    private String title4 = "Πανελλήνιος διαγωνισμός μαθηματικών";
    private String cont4 = "Στις 12 Δεκεμβρίου 2019 θα πραγματοποιηθεί η πρώτη φάση του\n" +
            "πανελλήνιου διαγωνισμού μαθηματικών για τους μαθητές \n" +
            "γυμνασίου και λυκείου. Όποιος μαθητής επιθυμεί να συμμετάσχει\n" +
            "μπορεί να δηλώσει συμμετοχή στον υπεύθυνο καθηγητή του \n" +
            "τμήματος του.";
    private LocalDate date4 = LocalDate.of(2019, Month.DECEMBER, 12);
    private String auth4 = "Μαρία Αναστασοπούλου";
    private PG_Work pgwork4 = new PG_Work(title4, cont4, date4, auth4);

    private final ObservableList<PG_Work> entries =  FXCollections.observableArrayList(pgwork1, pgwork2, pgwork3, pgwork4); //τα δεδομένα θα μπαίνουν εδώ δυναμικά θέλει φτιάξιμο

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        filters.setValue("Πρόσφατα");
        filters.setItems(filtersList);

        entry1text.setText(pgwork1.getWork_title());
        entry1date.setText(pgwork1.getWork_date().toString());
        entry1auth.setText(pgwork1.getWork_author());

        entry2text.setText(pgwork2.getWork_title());
        entry2date.setText(pgwork2.getWork_date().toString());
        entry2auth.setText(pgwork2.getWork_author());

        entry3text.setText(pgwork3.getWork_title());
        entry3date.setText(pgwork3.getWork_date().toString());
        entry3auth.setText(pgwork3.getWork_author());

        entry4text.setText(pgwork4.getWork_title());
        entry4date.setText(pgwork4.getWork_date().toString());
        entry4auth.setText(pgwork4.getWork_author());
    }


    @FXML
    private void clickPG_Entry(ActionEvent actionEvent) {
        Node actionEventSource = (Node) actionEvent.getSource();
        String id = actionEventSource.getId();

        if(id.equals("show1"))
        {
            entryshown.setText(pgwork1.getWork_content());
        }
        else if(id.equals("show2"))
        {
            entryshown.setText(pgwork2.getWork_content());
        }
        else if(id.equals("show3"))
        {
            entryshown.setText(pgwork3.getWork_content());
        }
        else if(id.equals("show4"))
        {
            entryshown.setText(pgwork4.getWork_content());
        }
        else //πιθανότατα δε θα φτάνει εδώ
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText(String.valueOf(id.equals("show1")));
            alert.setContentText(id);
            alert.showAndWait();
        }


    }

    @FXML
    private void click_Filter(){
        String value = filters.getValue().toString();

        System.out.println(value);

    }

}
