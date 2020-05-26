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
}


