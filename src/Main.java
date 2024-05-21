import java.time.Duration;
import java.time.Instant;

public class Main
{
    public static void main(String[] args)
    {
        VoterManager vm1 = new VoterManager();
        OptionManager om1 = new OptionManager();

        Participant[] list = om1.readOptions("D:\\VoteDemo\\src\\Detail.csv");

        long voterId;
        int option;

        int numOptions = list.length;
        Instant start = Instant.now();
        Duration duration = Duration.ofSeconds(10);

        // Simulating the election process
        while (Duration.between(start, Instant.now()).toMillis() <= duration.toMillis())
        {
            System.out.println("Hello! ");
            System.out.println("Enter your voter id: ");
            voterId = (int) (Math.random() * 100) + 1;

            System.out.println("Enter option number: ");
            option = (int) (Math.random() * numOptions);

            vm1.addVoter(voterId, list[option]);

            System.out.println("Voter ID: " + voterId + "\n");
            System.out.println("Thank you for voting!");

            try
            {
                // Simulate a delay for each vote
                Thread.sleep(200);
            } catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
                return;
            }
        }

        vm1.printVoters();
        om1.showVotes();
        om1.writeResults("D:\\VoteDemo\\src\\Detail.csv");
        vm1.writeVoters("D:\\VoteDemo\\src\\Voters.csv");
    }
}