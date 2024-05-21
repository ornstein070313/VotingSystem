import java.io.*;

public class FileHandler
{
    private String fileName;
    private String filePath;

    public void createFile(String name)
    {
        File myFile = new File(name);

        try
        {
            if(myFile.createNewFile())
            {
                System.out.println("File created successfully");
            }

        }
        catch(IOException e)
        {
            System.err.println(e.getMessage());
            System.out.println("Please try again with a different file name");
        }

    }

    public void writeToFile(String s)
    {
        try (FileWriter myWriter = new FileWriter(fileName, true);
             BufferedWriter bufferedWriter = new BufferedWriter(myWriter))
        {
            bufferedWriter.write(s);
        } catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void readFromFile()
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }
        } catch (IOException e)
        {
            System.out.println("error");
            e.printStackTrace();
        }
    }
}
