//<editor-fold defaultstate="collapsed" desc="Package and Imports">
package birthdaytracker2.Models;
import java.util.ArrayList;
import java.util.List;
//Package and Imports </editor-fold>

public class Birthday
{
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Birthday ()
    {
        Name = "";
        Month = 0;
        Day = 0;
        Likes = new ArrayList<>();
        Dislikes = new ArrayList<>();
    }
    
    public Birthday (String name, int day, int month, List<String> likes, List<String> dislikes)
    {
        Name = name;
        Day = day;
        Month = month;
        Likes = likes;
        Dislikes = dislikes;
    }
    //Constructors </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private String Name;
    private int Month;
    private int Day;
    private List<String> Likes;
    private List<String> Dislikes;
    
    //<editor-fold defaultstate="collapsed" desc="Getters">
    public String getName()
    {
        return Name;
    }
    
    public int getMonth()
    {
        return Month;
    }
    
    public int getDay()
    {
        return Day;
    }
    
    public List<String> getLikes ()
    {
        return Likes;
    }
    
    public List<String> getDislikes()
    {
        return Dislikes;
    }
    //Getters </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Setters">
    public void setName(String name)
    {
        Name = name;
    }
    
    public void setMonth(int month)
    {
        Month = month;
    }
    
    public void setDay(int day)
    {
        Day = day;
    }
    
    public void setLikes(List<String> likes)
    {
        Likes = likes;
    }
    
    public void setDislikes(List<String> dislikes)
    {
        Dislikes = dislikes;
    }
    //Setters </editor-fold>
    //Properties </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methods">
    @Override
    public String toString()
    {
        return Name + "," + Day + "," + Month + "," + getlikesString() + "," + getDislikesString();
    }
    
    private String getlikesString()
    {
        String likes = "";
        
        for (String like : Likes)
        {
            if (likes.equals(""))
            {
                likes = like;
            } 
            else
            {
                likes += "|" + like;
            }
        }
        
        return likes;
    }
    
    private String getDislikesString()
    {
        String dislikes = "";
        
        for (String dislike : Dislikes)
        {
            if (dislikes.equals(""))
            {
                dislikes = dislike;
            }
            else
            {
                dislikes += "|" + dislike;
            }
        }
        
        return dislikes;
    }
    //Methods </editor-fold>
}
