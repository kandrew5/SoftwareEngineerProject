package Class_folder;
import java.lang.reflect.Array;
import java.util.Date;

public class Voting {
    private String vote_title;          // vote title
    private String vote_description;    // vote description
    private Date vote_expire_date;      //
    private int vote_options;

    public Voting(){
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
