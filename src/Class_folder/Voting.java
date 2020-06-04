package Class_folder;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Date;

public class Voting {
    private String voting_id;
    private String vote_title;          // vote title
    private String vote_description;    // vote description
    private LocalDate vote_expire_date;
    private int vote_options;
    private String[] results;

    private LocalDate vote_creation_date;
    private String result;
    private int percentage;

    public Voting(String voting_id, String vote_title, String result, int percentage, LocalDate vote_creation_date, LocalDate vote_expire_date){
        this.voting_id = voting_id;
        this.vote_title = vote_title;
        this.result = result;
        this.percentage = percentage;
        this.vote_creation_date = vote_creation_date;
        this.vote_expire_date = vote_expire_date;
    }

    public boolean createVoting(){
        return true;
    }
    public boolean newVotingFile(String voting_id){
        return true;
    }
    public boolean saveVoting(String voting_id){
        return true;
    }
    public String[] getVotings(String voting_id){return null;}
    public boolean removeVoting(String voting_id){
        return true;
    }

    public String getVote_title() {
        return vote_title;
    }

    public void setVote_title(String vote_title) {
        this.vote_title = vote_title;
    }

    public String getVote_description() {
        return vote_description;
    }

    public void setVote_description(String vote_description) {
        this.vote_description = vote_description;
    }

    public LocalDate getVote_expire_date() {
        return vote_expire_date;
    }

    public void setVote_expire_date(LocalDate vote_expire_date) {
        this.vote_expire_date = vote_expire_date;
    }

    public int getVote_options() {
        return vote_options;
    }

    public void setVote_options(int vote_options) {
        this.vote_options = vote_options;
    }

    public String getVoting_id() {
        return voting_id;
    }

    public void setVoting_id(String voting_id) {
        this.voting_id = voting_id;
    }

    public String[] getResults() {
        return results;
    }

    public void setResults(String[] results) {
        this.results = results;
    }

    public LocalDate getVote_creation_date() {
        return vote_creation_date;
    }

    public void setVote_creation_date(LocalDate vote_creation_date) {
        this.vote_creation_date = vote_creation_date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}


