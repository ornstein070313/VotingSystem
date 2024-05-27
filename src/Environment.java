import java.time.Duration;
import java.time.Instant;

public class Environment
{
    private String name;
    private Duration duration;
    private Duration perVoter;
    private String key;

    public Duration getPerVoter()
    {
        return perVoter;
    }

    public void setPerVoter(Duration perVoter)
    {
        this.perVoter = perVoter;
    }

    public Duration getDuration()
    {
        return duration;
    }

    public void setDuration(Duration duration)
    {
        this.duration = duration;
    }

    public Environment(String name)
    {
        this.name = name;
        OptionManager optionManager = new OptionManager();
        VoterManager voterManager = new VoterManager();
    }

    public void addTotalDurationSeconds(int seconds)
    {
        duration = Duration.ofSeconds(seconds);
    }

    public void addTotalDurationMinutes(int minutes)
    {
        addTotalDurationSeconds(minutes * 60);
    }

    public void addTotalDurationHours(int hours)
    {
        addTotalDurationSeconds(hours * 60 * 60);
    }

    public void addVoterDurationSeconds(int seconds)
    {
        perVoter = Duration.ofSeconds(seconds);
    }

    public void addVoterDurationMinutes(int minutes)
    {
        perVoter = Duration.ofSeconds(minutes * 60);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public void start(String key)
    {
        if (!this.key.equals(key))
        {
            System.out.println("Invalid key. Cannot start the environment.");
            return;
        }

        Instant start = Instant.now();
        Instant perVoterStart = start;

        while (Duration.between(start, Instant.now()).toMillis() <= duration.toMillis())
        {
            perVoterStart = Instant.now();
            while (Duration.between(perVoterStart, Instant.now()).toMillis() <= perVoter.toMillis())
            {
            }
        }
    }
}
