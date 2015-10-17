//<editor-fold defaultstate="collapsed" desc="Package and Imports">
package birthdaytracker2.Logic;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
//Package and Imports </editor-fold>

public class FileIO
{
    //<editor-fold defaultstate="collapsed" desc="Constructors">    
    public FileIO (String filepath)
    {
        if(validate(filepath))
        FilePath = filepath;
    }
    //Constructors </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private String FilePath;
    
    public String getFilepath()
    {
        return FilePath;
    }
    //Properties </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methods">
    public void save_text(List<String> lines)
    {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(FilePath)))
        {
            for (String line : lines)
            {
                printWriter.println(line);
            }

            printWriter.close();
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }
    }
    
    public void save_dsv(List<List<String>> splitLines, String seperator)
    {        
        save_text(new Common().stringGridToStringList(splitLines, seperator));
    }
    
    public List<String> load_text()
    {
        List<String> result = new ArrayList<>();
        
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FilePath)))
        {
            String line;

            while ((line = bufferedReader.readLine()) != null)
            {
                result.add(line);
//                new Common().print(line);
            }
            
            bufferedReader.close();
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }   
        
        return result;
    }
    
    public List<List<String>> load_dsv(String seperator)
    {
        return new Common().stringListToStringGrid(load_text(), seperator);
    }
    
    private boolean validate(String filepath)
    {
        File file = new File(filepath);
        
        while (!file.exists())
        {
            try
            {
                file.createNewFile();
            }
            catch(Exception exception)
            {
                System.out.println(exception);
                return false;
            }
        }
        
        return true;
    }
    //Methods </editor-fold>
}