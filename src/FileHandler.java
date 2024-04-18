import java.io.*;

public class FileHandler
{
    private String name = "Data.txt";

    public void createFile()
    {
        try
        {
            File myFile = new File(name);
            if(myFile.createNewFile())
            {
                System.out.println("File is successfully created." + myFile.getName());
            }
            else
            {
                System.out.println("File already exists.");
            }

        }
        catch(IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeToFile(String s)
    {
        try(FileWriter myWriter = new FileWriter(name, true);
            BufferedWriter bufferedWriter = new BufferedWriter(myWriter))
        {
            bufferedWriter.write(s);
        }
        catch(IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void readFromFile()
    {
        try(BufferedReader reader = new BufferedReader(new FileReader(name)))
        {
            String line;
            while((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }
        }

        catch(IOException e)
        {
            System.out.println("error");
            e.printStackTrace();
        }
    }
}
