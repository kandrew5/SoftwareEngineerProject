package sample.parent;

import Class_folder.Decisions_repo;
import Class_folder.PG_Work;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.Month;
import java.util.ResourceBundle;


public class PGWorkController implements Initializable {

    @FXML
    private TextArea entryshown;
    @FXML
    private ChoiceBox filters;
    @FXML
    private TableView entriestable;
    @FXML
    private TableColumn wtitle_col;
    @FXML
    private TableColumn wdate_col;
    @FXML
    private TableColumn wauthor_col;

    ObservableList<String> filtersList = FXCollections.observableArrayList("Πρόσφατα", "Δημοφιλή", "Σχολικά");

    private String cont1 = "Ο Σύλλογος γονέων και κηδεμόνων στα πλαίσια του\n" +
            "νέου κορωνοϊού COVID-19 παρέχει ενημέρωση όσον \n" +
            "αφορά τα μέτρα που χρειάζεται να πάρει ο καθένας\n" +
            "για την προστασία από τον ιό αλλά και για τον \n" +
            "περιορισμό της εξάπλωσης του. Είναι σημαντικό\n" +
            "όσοι μπορούν να προσέλθουν καθώς ο ιός αυτός \n" +
            "απειλεί και τη χώρα μας.Η ενημέρωση θα γίνει\n" +
            "στις 17-2-2020.";
    private LocalDate wdate1 = LocalDate.of(2020, Month.FEBRUARY, 17);

    private String cont2 = "Με χαρά σας ενημερώνουμε πώς ο Σύλλογος γονέων \n" +
            "και κηδεμόνων θα πραγματοποιήσει κοπή \n" +
            "βασιλόπιτας για το σχολικό έτος 2019-2020. \n" +
            "Η κοπή θα λάβει χώρα στην αίθουσα εκδηλώσεων\n" +
            "του σχολείου τη Δευτέρα 20/01/2020 την τελευταία\n" +
            "ώρα της σχολικής χρονιάς.";
    private LocalDate wdate2 = LocalDate.of( 2020, Month.JANUARY, 17);

    private String cont3 = "Στις 14 Ιανουαρίου θα πραγματοποιηθεί γενική \n" +
            "συνέλευση του Συλλόγου γονέων και κηδεμόνων κατά \n" +
            "την οποία θα συζητηθούν θέματα που αφορούν το \n" +
            "σχολικό περιβάλλον καθώς και αρκετά ζητήματα που \n" +
            "προέκυψαν κατά την οργάνωση του συλλόγου.";
    private LocalDate wdate3 = LocalDate.of(2020, Month.JANUARY, 17);

    private String cont4 = "Στις 12 Δεκεμβρίου 2019 θα πραγματοποιηθεί η πρώτη \n" +
            "φάση του πανελλήνιου διαγωνισμού μαθηματικών για\n" +
            "μαθητές γυμνασίου και λυκείου. Όποιος μαθητής \n" +
            "επιθυμεί να συμμετάσχει μπορεί να δηλώσει συμμετοχή \n" +
            "στον υπεύθυνο καθηγητή του τμήματος του.";
    private LocalDate wdate4 = LocalDate.of(2019, Month.DECEMBER, 12);

    private final ObservableList<PG_Work> entries = FXCollections.observableArrayList(
            new PG_Work("Ενημέρωση για το νέο κορωνοϊό COVID-19", cont1, wdate1, "Πάνος"),
            new PG_Work("Κοπή βασιλόπιτας για το σχολικό έτος 2019-2020", cont2, wdate2, "Ανδρέας"),
            new PG_Work("Γενική συνέλευση του Συλλόγου Γονέων και Κηδεμόνων", cont3, wdate3, "Ρωμανός"),
            new PG_Work("Πανελλήνιος διαγωνισμός μαθηματικών", cont4, wdate4, "Θωμάς")
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        filters.setValue("Πρόσφατα");
        filters.setItems(filtersList);

        wtitle_col.setCellValueFactory(new PropertyValueFactory<PG_Work, String>("work_title"));
        wauthor_col.setCellValueFactory(new PropertyValueFactory<PG_Work, String>("work_author"));
        wdate_col.setCellValueFactory(new PropertyValueFactory<PG_Work, LocalDate>("work_date"));

        entriestable.setItems(entries);

    }

    @FXML
    private void click_Filter(){
        String value = filters.getValue().toString();

        System.out.println(value);

    }

    public void clickPG_Entry(MouseEvent click) {
        if(click.getClickCount() == 2){ //if doubleclick
            PG_Work selectedentry = (PG_Work) entriestable.getSelectionModel().getSelectedItem();

            if(selectedentry.getWork_title().equals(entries.get(0).getWork_title())){
                entryshown.setText(selectedentry.getWork_content());
            }else if (selectedentry.getWork_title().equals(entries.get(1).getWork_title())){
                entryshown.setText(selectedentry.getWork_content());
            }else if (selectedentry.getWork_title().equals(entries.get(2).getWork_title())) {
                entryshown.setText(selectedentry.getWork_content());
            }else if (selectedentry.getWork_title().equals(entries.get(3).getWork_title())) {
                entryshown.setText(selectedentry.getWork_content());
            }
        }
    }
}
