//<editor-fold defaultstate="collapsed" desc="Package and Imports">
package birthdaytracker2;
import birthdaytracker2.Logic.BinaryTree.BinaryTree;
import birthdaytracker2.Logic.Common;
import birthdaytracker2.Logic.Data;
import birthdaytracker2.Logic.DoublyLinkedList.DoublyLinkedList;
import birthdaytracker2.Logic.FileIO;
import birthdaytracker2.Models.Birthday;
import birthdaytracker2.UI.FrameMain;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
//Package and Imports </editor-fold>

//<editor-fold defaultstate="collapsed" desc="Information">
    /*
        Justin Christian - 8100093415
        TAFE Brisbane - Loganlea Campus
        Diploma of Sofware Development

        This application is an updated version of an earlier version of "Birthday Tracker".
        Both applications are assessment in the course.
    */
//Information </editor-fold>

public class Main
{
    public static void main(String[] args)
    {        
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                FrameMain mainWindow = new FrameMain();
                mainWindow.setVisible(true);
            }
        });
    }
    
    public static Data data = new Data();
    public static List<JFrame> windows = new ArrayList<>();
    
    public static void endProgram()
    {
        for (JFrame jframe : windows)
        {
            jframe.dispose();
        }
        
        System.exit(0);
    }
}