import java.math.BigInteger;
import java.util.HashMap;

public class VoterManager
{
    private HashMap<Long, Integer> voterIds;

    public VoterManager()
    {
        voterIds = Constants.voterIds;
    }

    public VoterManager(HashMap<Long, Integer> voterIds)
    {
        this.voterIds = voterIds;
    }

    public HashMap<Long, Integer> getVoterIds()
    {
        return voterIds;
    }

    public void setVoterIds(HashMap<Long, Integer> voterIds)
    {
        this.voterIds = voterIds;
    }

    public boolean hasVoted(Long voterId) // TODO implement logic to handle those who cannot vote(dead/banned).
    {
        if (voterIds.containsKey(voterId))
        {
            return voterIds.get(voterId) == 1;
        }
        else
            return false;
    }

    public void addVoter(Long voterId, VoteOption option)
    {
        if (hasVoted(voterId))
        {
            System.out.println("Sorry you have already voted.");
        }
        else
        {
            voterIds.put(voterId, 1);
            addVote(option);
            System.out.println("Successfully added.");
        }
    }

    public void addVote(VoteOption option)
    {
        if (Constants.voteCount.containsKey(option))
        {
            BigInteger a = Constants.voteCount.get(option);
            Constants.voteCount.replace(option, a, a.add(BigInteger.ONE));
        }
    }

    public void removeVoter(Long voterId)
    {
        if (!hasVoted(voterId))
        {
            System.out.println("Sorry voter doesn't exist.");
        }
        else
        {
            voterIds.remove(voterId);
            System.out.println("Successfully removed.");
        }
    }

    @Override
    public String toString()
    {
        return "VoterManager{" + "voterIds=" + voterIds + '}';
    }
}
