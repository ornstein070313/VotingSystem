import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Participant candidate1 = new Participant("Candidate 1", "A", "Party 1");
        Participant candidate2 = new Participant("Candidate 2", "B", "Party 2");

        // Create OptionManager and add candidates
        OptionManager optionManager = new OptionManager();
        optionManager.addOption(candidate1);
        optionManager.addOption(candidate2);

        // Create VoterManager
        VoterManager voterManager = new VoterManager();

        // Simulate voters casting their votes
        long voter1ID = 1001;
        long voter2ID = 1002;

        voterManager.addVoter(voter1ID, candidate1); // Voter 1 votes for Candidate 1
        voterManager.addVoter(voter2ID, candidate2); // Voter 2 votes for Candidate 2

        // Show vote counts
        optionManager.showVotes();

        // Remove a voter
        voterManager.removeVoter(voter1ID);

        // Show updated vote counts
        optionManager.showVotes();
    }

//        VoterManager vm1 = new VoterManager();
//        OptionManager om1 = new OptionManager();
//
//        Participant p1 = new Participant("Rahul", "hand", "congress");
//        Participant p2 = new Participant("Modi", "star", "bjp");
//
//        om1.addOption(p1);
//        om1.addOption(p2);
//
//        long voterId;
//        int option;
//        int[] arr = new int[2];
//        int i = 0;
//        int numOptions = 2;
//        Instant start = Instant.now();
//        Duration duration = Duration.ofSeconds(50);
//        Vote[] votes = new Vote[100]; // Assuming a maximum of 100 votes
//
//        // Simulating the election process
//        while (Duration.between(start, Instant.now()).toMillis() <= duration.toMillis()) {
//            System.out.println("Hello! ");
//            System.out.println("Enter your voter id: ");
//            voterId = (long) (Math.random() * 100) + 1;
//
//            System.out.println("Enter option number: ");
//            option = (int) (Math.random() * 2) + 1;
//
//            votes[i] = new Vote(voterId, option);
//
//            System.out.println("Voter ID: " + voterId + "\n" + "Option: " + option);
//            System.out.println("Thank you for voting!");
//
//            i++;
//
//            try {
//                // Simulate a delay for each vote
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                return;
//            }
//        }
//
//        // Counting votes
//        for (int z = 0; z < i; z++) {
//            if (votes[z].getVoteOption() == 1) {
//                arr[0]++;
//            } else if (votes[z].getVoteOption() == 2) {
//                arr[1]++;
//            }
//        }
//
//        // Displaying total votes for each option
//        System.out.println("Total votes for option 1: " + arr[0]);
//        System.out.println("Total votes for option 2: " + arr[1]);
//
//        // Displaying individual votes
//        System.out.println("Individual votes:");
//        for (int z = 0; z < i; z++) {
//            System.out.println(votes[z]);
//        }
    }

