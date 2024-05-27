import java.util.HashMap;
import java.util.Map;

public class EnvironmentManager
{
    private Map<String, Environment> environments;

    public EnvironmentManager()
    {
        environments = new HashMap<>();
    }

    public void addEnvironment(Environment environment)
    {
        environments.put(environment.getName(), environment);
    }

    public void removeEnvironment(String name)
    {
        if (environments.containsKey(name))
        {
            environments.remove(name);
            System.out.println("Environment " + name + " removed.");
        }
        else
        {
            System.out.println("Environment " + name + " not found.");
        }
    }

    public Environment getEnvironment(String name)
    {
        return environments.get(name);
    }

    public void startEnvironment(String name, String key)
    {
        Environment environment = environments.get(name);
        if (environment != null)
        {
            environment.start(key);
        }
        else
        {
            System.out.println("Environment " + name + " not found.");
        }
    }

    public void printAllEnvironments()
    {
        for (String name : environments.keySet())
        {
            System.out.println("Environment Name: " + name);
        }
    }
}
