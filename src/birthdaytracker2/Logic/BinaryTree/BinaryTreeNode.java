//<editor-fold defaultstate="collapsed" desc="Package and Imports">
package birthdaytracker2.Logic.BinaryTree;
import java.util.ArrayList;
import java.util.List;
//Package and Imports </editor-fold>

public class BinaryTreeNode <I>
{
    //<editor-fold defaultstate="collapsed" desc="Constructors">    
    public BinaryTreeNode (String key, I item, BinaryTreeNode parent, BinaryTreeNode left, BinaryTreeNode right)
    {
       if (item instanceof List<?>)
       {
           initialize(key, (List<I>) item, parent, left, right);
       }
       else
       {
            List<I> items  = new ArrayList<>();
            items.add(item);
            initialize(key, items, parent, left, right);  
       }
    }
    //Constructors </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Fields">
    private String Key;
    private List<I> Items;
    private BinaryTreeNode Parent;
    private BinaryTreeNode Left;
    private BinaryTreeNode Right;

    // Fields </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methods">
    public String getKey()
    {
        return Key;
    }
    
    public void setKey(String key)
    {
        Key = key;
    }
    
     public List<I> getItems()
    {
        return Items;
    }

    public void setItems(List<I> items)
    {
        Items = items;
    }
    
    public I getItem(int index)
    {
        return Items.get(index);
    }
    
    public BinaryTreeNode getParent()
    {
        return Parent;
    }
    
    public void setParent(BinaryTreeNode parent)
    {
        Parent = parent;
    }
    
    public BinaryTreeNode getLeft()
    {
        return Left;
    }
    
    public void setLeft(BinaryTreeNode left)
    {
        Left = left;
    }
    
    public BinaryTreeNode getRight()
    {
        return Right;
    }
    
    public void setRight(BinaryTreeNode right)
    {
        Right = right;
    }
    
    public void addItem(I item)
    {
       Items.add(item);
    }
    
    public void insertItem(int afterItem, I newItem)
    {
        Items.add(afterItem, newItem);
    }
    
    public void insertItem(I afterItem, I newItem)
    {
        Items.add(getItems().indexOf(afterItem), newItem);
    }
    
    public void removeItem(int index)
    {
        Items.remove(index);
    }
    
    public void removeItem(I item)
    {
        Items.remove(item);
    }
    
    public int countChildren()
    {
        if (Left == null && Right == null)
        {
            return 0;
        }
        else if((Left == null && Right != null) || (Left != null && Right == null))
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }
    
    public boolean noChildren()
    {
        return (Left == null && Right == null);
    }
    
    public boolean oneChild()
    {
        return ((getLeft() == null && getRight() != null) || (getLeft() != null && getRight() == null));
    }
    
    public boolean twoChildren()
    {
        return (getLeft() != null && getRight() != null);
    }
    
    private void initialize(String key, List<I> items, BinaryTreeNode parent, BinaryTreeNode left, BinaryTreeNode right)
    {
        Key = key;
        Items = items;
        Parent = parent;
        Left = left;
        Right = right;
    }
    //Methods </editor-fold>
}