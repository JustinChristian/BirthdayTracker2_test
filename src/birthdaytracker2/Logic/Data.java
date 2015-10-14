//<editor-fold defaultstate="collapsed" desc="Package and Imports">
package birthdaytracker2.Logic;
import birthdaytracker2.Logic.BinaryTree.BinaryTree;
import birthdaytracker2.Logic.BinaryTree.BinaryTreeNode;
import birthdaytracker2.Logic.DoublyLinkedList.DoublyLinkedList;
import birthdaytracker2.Logic.DoublyLinkedList.DoublyLinkedListNode;
import birthdaytracker2.Models.Birthday;
import java.util.ArrayList;
import java.util.List;
//Package and Imports </editor-fold>

public class Data
{
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Data()
    {
        loadBirthdays();
    }
    //Constructors </editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Fields">
    public DoublyLinkedList allBirthdays; // Contains ALL birthdays.
    public BinaryTree currentBirthdays; // Contains the current working set of birthdays.
    String file = System.getProperty("user.dir") + "\\dist\\" + "Birthdays.dsv";
    //Fields </editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Methods">
    public String[][] getData()
    {
        return birthdaysToRows(currentBirthdays);
    }
    
    private void loadBirthdays()
    {
        allBirthdays = new DoublyLinkedList();
        FileIO fileIO = new FileIO(file);
        
        for (List<String> line : fileIO.load_dsv(","))
        {
            String name = line.get(0);
            int day = Integer.parseInt(line.get(1));
            int month = Integer.parseInt(line.get(2));
            List<String> likes = new Common().stringToStringList(line.get(3), ",");
            List<String> dislikes = new Common().stringToStringList(line.get(4), ",");
            
            allBirthdays.addNode(new Birthday(name, day, month, likes, dislikes));
        }
        
        updateCurrentBirthdays();
    }
    
    public void updateCurrentBirthdays()
    {
        currentBirthdays = convertDoublyLinkedListToBinaryTree(allBirthdays);
    }
        
    public void saveBirthdays()
    {
        List<String> birthdayLines = new ArrayList<>();
        DoublyLinkedListNode focusNode = allBirthdays.getStart().getRight();
        
        for (int index = 0; index < allBirthdays.getSize() - 1; index += 1)
        {
            if (focusNode == allBirthdays.getEnd())
            {
                break;
            }
            else
            {
                birthdayLines.add(((Birthday)focusNode.getItem()).toString());
                focusNode = focusNode.getRight();
            }
        }
        
        FileIO fileIO = new FileIO(file);
        fileIO.save_text(birthdayLines);
    }
    
    public void deleteBirthday()
    {
        
    }
    
    private DoublyLinkedList convertBinaryTreeToDoublyLinkedList(BinaryTree input)
    {
        DoublyLinkedList output = new DoublyLinkedList();
        
        for (Object object : input.traverse())
        {
            output.addNode(object);
        }
        
        return output;
    }
    
    private BinaryTree convertDoublyLinkedListToBinaryTree(DoublyLinkedList input)
    {
        DoublyLinkedListNode focusNode = input.getStart().getRight();
        BinaryTree output = null;
            
        while (focusNode != input.getEnd())
        {
            Birthday birthday = (Birthday) focusNode.getItem();
            
            if (output == null)
            {
                output = new BinaryTree(new BinaryTreeNode(birthday.getName(), birthday, null, null, null));
            }
            else
            {
                output.addNode(birthday.getName(), birthday);
            }
            
            focusNode = focusNode.getRight();
        }
        
        return output;
    }
    
    private List<Birthday> getListFromDoublyLinkedList(DoublyLinkedList input)
    {
        List<Birthday> output = new ArrayList<>();
        
        DoublyLinkedListNode focusNode = input.getStart().getRight();
        
        while (focusNode != input.getEnd())
        {
            output.add((Birthday) focusNode.getItem());
        }
        
        return output;
    }
    
    private List<Birthday> getListFromBinaryTree(BinaryTree input)
    {
        List<Birthday> output = new ArrayList<>();
        
        for (BinaryTreeNode node : (List<BinaryTreeNode>) input.traverse())
        {
            for (Birthday birthday : (List<Birthday>) node.getItems())
            {
                output.add(birthday);
            }
        }
        
        return output;
    }
    
    private BinaryTree nameTree(List<Birthday> input)
    {
        BinaryTree output = null;
        
        for (Birthday birthday : input)
        {
            String birthdayKey = birthday.getName();
            
            if (output == null)
            {
                output = new BinaryTree(new BinaryTreeNode(birthdayKey, birthday, null, null, null));
            }
            else
            {
                output.addNode(birthdayKey, birthday);
            }
        }
        
        return output;
    }
    
    private BinaryTree dateTree(List<Birthday> input)
    {
        BinaryTree output = null;
        
        for (Birthday birthday : input)
        {
            String birthdayKey = Integer.toString(birthday.getMonth() + birthday.getDay());
            
            if (output == null)
            {
                output = new BinaryTree(new BinaryTreeNode(birthdayKey, birthday, null, null, null));
            }
            else
            {
                output.addNode(birthdayKey, birthday);
            }
        }
        
        return output;
    }
    
    private String[] birthdayToRow(Birthday birthday)
    {
        return new String[] {birthday.getName(), (birthday.getDay() + "/" + birthday.getMonth())};
    }
    
    private String[][] birthdaysToRows(BinaryTree birthdayTree)
    {
        if (birthdayTree == null)
        {
            return new String[0][0];
        }
        
        int index = 0;
        int rowCount = birthdayTree.getSize();
        String[] row = new String[2];
        String[][] rows = new String[rowCount][row.length];

        
        for (BinaryTreeNode birthdayNode : (List<BinaryTreeNode>) birthdayTree.traverse())
        {
            for (Birthday birthday : (List<Birthday>) birthdayNode.getItems())
            {
                row = birthdayToRow(birthday);
                rows[index] = row;
                index += 1;
            }
        }
        
        return rows;
    }
    //Methods </editor-fold>
}