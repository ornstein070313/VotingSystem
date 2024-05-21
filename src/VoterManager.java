import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class VoterManager
{
    //private HashMap<Long, Integer> voterIds;

    public VoterManager()
    {

    }


    public HashMap<Long, Integer> getVoterIds()
    {
        return Constants.voterIds;
    }

    public boolean hasVoted(Long voterId) // TODO implement logic to handle those who cannot vote(dead/banned). using enums
    {
        if (Constants.voterIds.containsKey(voterId))
        {
            return Constants.voterIds.get(voterId) == 1;
        }
        else
            return false;
    }

    public void addVoter(Long voterId, VoteOption option) //TODO implement logic to handle array options not objects. Also join csv with it.
    {
        if (hasVoted(voterId))
        {
            System.out.println("Sorry you have already voted.");
        }
        else
        {
            if(addVote(option))
            {
                Constants.voterIds.put(voterId, 1);
                System.out.println("Successfully added.");
            }
        }
    }

    private boolean addVote(VoteOption option)
    {
        if (Constants.voteCount.containsKey(option))
        {
            BigInteger a = Constants.voteCount.get(option);
            Constants.voteCount.replace(option, a, a.add(BigInteger.ONE));
            return true;
        }
        else
            return false;
    }

    public void removeVoter(Long voterId)
    {
        if (!hasVoted(voterId))
        {
            System.out.println("Sorry voter doesn't exist.");
        }
        else
        {
            Constants.voterIds.remove(voterId);
            System.out.println("Successfully removed.");
        }
    }

    public void printVoters()
    {
        Constants.voterIds.forEach((key, value) -> System.out.println(key + " + " + value));
    }

    public void writeVoters(String filepath) //TODO add writevoters functions
    {
        File f = new File(filepath);
        String s = f.getName();
        String s1 = s.replace(".","-voterResult.");
        String s2 = filepath.replace(s,s1);
        long voterId;
        try (FileWriter writer = new FileWriter(s2))
        {
            // Write header
            writer.append("VoterID, HasVoted\n");

            // Write each participant's information along with their selected vote option
            if (!Constants.voteCount.isEmpty())
            {
                for (Map.Entry<Long, Integer> entry : Constants.voterIds.entrySet())
                {
                    voterId = entry.getKey();
                    writer.append(String.valueOf(voterId)).append(',')
                            .append(String.valueOf(entry.getValue()))
                            .append("\n");
                }
            }

            writer.flush();
            System.out.println("Results written successfully to " + s2);
        } catch (IOException e)
        {
            System.err.println("Error writing results to " + s2 + ": " + e.getMessage());
        }
    }
    public void readVoters(String filePath)
    {
        BufferedReader reader = null;
        String line;

        try
        {
            reader = new BufferedReader(new FileReader(filePath));
            Vote v = null;
            while((line = reader.readLine()) != null)
            {
                 //// TODO implement logic to handle those who cannot vote(dead/banned). using enums
                Constants.voterIds.put(Long.parseLong(line), 1);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                reader.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }

        }
    }

    @Override
    public String toString()
    {
        return "VoterManager{" + "voterIds=" + Constants.voterIds + '}';
    }
}
