public class Vote
{
    private final long voterID;
    private int voteOption;

    public Vote()
    {
        voterID = 0;
    }

    public Vote(long voterID, int voteOption)
    {
        this.voterID = voterID;
        this.voteOption = voteOption;
    }

    public long getVoterID()
    {
        return voterID;
    }

    public int getVoteOption()
    {
        return voteOption;
    }

    public void setVoteOption(int voteOption)
    {
        this.voteOption = voteOption;
    }


    @Override
    public String toString()
    {
        return "Vote{" + "voterID=" + voterID + ", voteOption='" + voteOption + '}';
    }
}
