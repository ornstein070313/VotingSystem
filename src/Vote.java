public class Vote
{
    private long voterID;

    public Vote()
    {
        voterID = 0;
    }

    public void setVoterID(long voterID)
    {
        this.voterID = voterID;
    }

    public Vote(long voterID)
    {
        this.voterID = voterID;
    }

    public long getVoterID()
    {
        return voterID;
    }


    @Override
    public String toString()
    {
        return "Vote{" + "voterID=" + voterID + '}';
    }
}
