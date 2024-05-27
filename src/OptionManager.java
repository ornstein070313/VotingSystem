import java.io.*;
import java.util.HashMap;
import java.math.BigInteger;
import java.util.Map;

public class OptionManager
{
    Participant[] list = null;

    public OptionManager()
    {

    }

    public Participant[] readOptions(String filePath)
    {
        BufferedReader reader = null;
        String line;
        int count = 0;
        int index = 0;
        Participant[] arr = null;

        try
        {
            reader = new BufferedReader(new FileReader(filePath));
            Participant p = null;

            while ((line = reader.readLine()) != null)
            {
                count++;
            }

            reader.close();
            arr = new Participant[count];

            reader = new BufferedReader(new FileReader(filePath));

            while ((line = reader.readLine()) != null)
            {
                p = new Participant();
                String[] property = line.split(",");
                p.setName(property[0]);
                p.setParty(property[1]);
                p.setSign(property[2]);

                addOption(p);
                arr[index] = p;
                index++;
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                reader.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }

        }
        this.list = arr;
        return arr;
    }

    public void writeResults(String filepath)
    {
        File f = new File(filepath);
        String s = f.getName();
        String s1 = s.replace(".", "-result.");
        String s2 = filepath.replace(s, s1);

        Participant participant = null;
        try (FileWriter writer = new FileWriter(s2))
        {
            writer.append("Participant Name,Sign,Party,Vote Option\n");

            if (!Constants.voteCount.isEmpty())
            {
                for (Map.Entry<VoteOption, BigInteger> entry : Constants.voteCount.entrySet())
                {
                    participant = (Participant) entry.getKey();
                    writer.append(participant.getName()).append(',')
                            .append(participant.getSign()).append(',')
                            .append(participant.getParty()).append(',')
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
