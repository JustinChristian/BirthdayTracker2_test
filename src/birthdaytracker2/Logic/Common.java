//<editor-fold defaultstate="collapsed" desc="Package and Imports">
package birthdaytracker2.Logic;
import java.util.ArrayList;
import java.util.List;
//Package and Imports </editor-fold>

public class Common
{
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Common()
    {
        
    }
    //Constructors </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methods">
    public void print(Object line)
    // Simplified line print.
    {
        System.out.println(line.toString());
    }
    
    public String stringListToString(List<String> input, String separator)
    // Concatenates a list of strings into a delimiter seperated value string.
    {
        String output = "";
        
        for (String string : input)
        {
            if (output.equals(""))
            {
                output = string;
            }
            else
            {
                output = (separator + string);
            }
        }
        
        return output;
    }
    
    public List<String> stringToStringList(String input, String separator)
    // Splits a dsv string into a list of strings at the seperators.
    {
        List<String> output = new ArrayList<>();
        new Common().print(input);
        
        for (String string : input.split(separator))
        {
            output.add(string);
            new Common().print(string);
        }
        
        return output;
    }
    
    public List<String> stringGridToStringList(List<List<String>> input, String separator)
    // Converts a 2-dimensional string list into list of dsv strings.
    {
        List<String> output = new ArrayList<>();
        
        for (List<String> row : input)
        {            
            output.add(stringListToString(row, separator));
        }
        
        return output;
    }
    
    public List<List<String>> stringListToStringGrid(List<String> input, String separator)
    // Converts a list of dsv strings into a 2-dimensional string list.
    {
        List<List<String>> output = new ArrayList<>();
        
        for (String row : input)
        {            
            output.add(stringToStringList(row, separator));
        }
        
        return output;
    }
    //Methods </editor-fold>
}