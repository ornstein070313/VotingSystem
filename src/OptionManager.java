import java.util.HashMap;
import java.math.BigInteger;
import java.util.Map;

public class OptionManager
{
    //private HashSet<VoteOption> Constants.voteCount;
    //private HashMap<VoteOption, BigInteger> Constants.voteCount;
    public OptionManager()
    {

    }

//    public void populateVoteCount()
//    {
//        if (!Constants.voteCount.isEmpty())
//        {
//            Iterator<VoteOption> iter = Constants.voteCount.iterator();
//
//            while (iter.hasNext())
//            {
//                VoteOption obj = iter.next();
//
//                Constants.voteCount.put(obj.getOptionID(), BigInteger.valueOf(0));
//            }
//        }
//        else
//        {
//            System.out.println("Error. No options exist in the set.");
//        }
//    }


    public HashMap<VoteOption, BigInteger> getVoteCount()
    {
        return Constants.voteCount;
    }

    public boolean hasOption(VoteOption optionId)
    {
        return Constants.voteCount.containsKey(optionId);
    }

    public void addOption(VoteOption optionId)
    {
        if (hasOption(optionId))
        {
            System.out.println("Sorry this option already exists..");
        }
        else
        {
            Constants.voteCount.put(optionId, BigInteger.ZERO);
            System.out.println("Successfully added.");
        }
    }

    public void removeOption(VoteOption optionId)
    {
        if (!hasOption(optionId))
        {
            System.out.println("Sorry option doesn't exist.");
        }
        else
        {
            Constants.voteCount.remove(optionId);
            System.out.println("Successfully removed.");
        }
    }

    public void showVotes()
    {
        if (!Constants.voteCount.isEmpty())
        {
            for (Map.Entry<VoteOption, BigInteger> entry : Constants.voteCount.entrySet())
            {
                System.out.println(entry.getKey() + "/" + entry.getValue());
            }
        }
        else
            System.out.println("The hashmap is empty.");
    }

    @Override
    public String toString()
    {
        return "OptionManager{" +
                "Constants.voteCount=" + Constants.voteCount +
                ", Constants.voteCount=" + Constants.voteCount +
                '}';
    }
}
