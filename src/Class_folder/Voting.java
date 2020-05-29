package Class_folder;
import java.lang.reflect.Array;
import java.util.Date;

public class Voting {
    private String vote_title;          // vote title
    private String vote_description;    // vote description
    private Date vote_expire_date;      //
    private int vote_options;

    public Voting(    String vote_title, String vote_description, Date vote_expire_date, int vote_options){
        this.vote_title = vote_title;
        this.vote_description = vote_description;
        this.vote_expire_date = vote_expire_date;
        this.vote_options = vote_options;
    }

    public boolean createVoting(){
        return true;
    }
    public int newVotingFile(){
        return 0;
    }
    public boolean saveVoting(){
        return true;
    }
    public Array getVotings(){
        return null;
    }
    public boolean removeVoting(){
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

    public Date getVote_expire_date() {
        return vote_expire_date;
    }

    public void setVote_expire_date(Date vote_expire_date) {
        this.vote_expire_date = vote_expire_date;
    }

    public int getVote_options() {
        return vote_options;
    }

    public void setVote_options(int vote_options) {
        this.vote_options = vote_options;
    }
}


