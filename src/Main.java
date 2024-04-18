import java.io.File;
import java.util.Scanner;

// necessary imports for using classes Instant and Duration.
import java.time.Instant;
import java.time.Duration;

// ...

// start time point of your code execution.

public class Main
{
    public static void main(String[] args)
    {
        int capacity = 100;
        String s;

        int numOptions = 2;

        int i = 0;

        Vote[] votes = new Vote[capacity];
        int[] arr = new int[numOptions];

        Scanner sc = new Scanner(System.in);

        int option;

        long voterId;

        Instant start = Instant.now();
        Duration duration = Duration.ofSeconds(10);

        FileHandler myFileHandler = new FileHandler();

        myFileHandler.createFile();

        while (Duration.between(start, Instant.now()).toMillis() <= duration.toMillis())
        {
            System.out.println("Hello! ");

            votes[i] = new Vote();

            System.out.println("Enter your voter id: ");
            voterId = (long)(Math.random()*11212412)+1;
            votes[i].setVoterID(voterId);

            System.out.println("Enter option number: ");
            option = (int)(Math.random()*2) + 1;

            votes[i].setVoteOption(option);

            System.out.println("Voter ID: " + voterId + "\n"+ "Option: " + option);
            System.out.println("Thank you for voting!");

            String detail = Long.toString(voterId);
            detail += " " + option;

            myFileHandler.writeToFile(detail);

            i++;

            try {
                // to sleep 10 seconds
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // recommended because catching InterruptedException clears interrupt flag
                Thread.currentThread().interrupt();
                // you probably want to quit if the thread is interrupted
                return;
            }


        }

        for(int z = 0; z<i; z++)
        {
            if(votes[z].getVoteOption() == 1)
            {
                arr[0]++;
            }
            else if(votes[z].getVoteOption() == 2)
            {
                arr[1]++;
            }
        }

        System.out.println("Total votes for option 1: "+ arr[0]);

        System.out.println("Total votes for option 2: "+ arr[1]);

        System.out.println("Individual votes:");
        for (int z = 0; z < i; z++) {
            System.out.println(votes[z]);
        }

        myFileHandler.readFromFile();
    }
}
