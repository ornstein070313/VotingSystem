import java.io.*;

public class FileHandler
{
    private String fileName;
    private String filePath;

    public FileHandler(String fileName, String filePath)
    {
        this.fileName = fileName;
        this.filePath = filePath;
    }


    public FileHandler(String fileName)
    {
        this.fileName = fileName;

    }

    public void createFile(String fileName)
    {
        File myFile = new File(fileName);

        try
        {
            if (myFile.createNewFile())
            {
                System.out.println("File created successfully");
            }

        } catch (IOException e)
        {
            System.err.println(e.getMessage());
            System.out.println("Please try again with a different file name");
        }
    }

    public void createFile()
    {
        File myFile = new File(filePath, fileName);

        try
        {
            if (myFile.createNewFile())
            {
                System.out.println("File created successfully");
            }

        } catch (IOException e)
        {
            System.err.println(e.getMessage());
            System.out.println("Please try again with a different file name");
        }
    }

    public void writeToFile(String data)
    {
        try (FileWriter writer = new FileWriter(new File(filePath, fileName), true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer))
        {
            bufferedWriter.write(data);
            bufferedWriter.newLine();
        } catch (IOException e)
        {
            System.out.println("An error occurred while writing to file.");
            e.printStackTrace();
        }
    }

    public boolean checkCredentials(String username, String password)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filePath, fileName))))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password))
                {
                    return true;
                }
            }
        } catch (IOException e)
        {
            System.out.println("An error occurred while reading from file.");
            e.printStackTrace();
        }
        return false;
    }
}
