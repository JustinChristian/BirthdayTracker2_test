//<editor-fold defaultstate="collapsed" desc="Package and Imports">
package birthdaytracker2.Logic.BinaryTree;
import birthdaytracker2.Logic.Common;
import java.util.ArrayList;
import java.util.List;
//Package and Imports </editor-fold>

public class BinaryTree <I>
{
    //<editor-fold defaultstate="collapsed" desc="Constructors">    
    public BinaryTree(BinaryTreeNode node)
    {
        if (node != null)
        {
            initialize(node);
        }
    }
    //Constructors </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Fields">
    private BinaryTreeNode Root;
    private int Size; 
    private List<BinaryTreeNode> Nodes;
    //Fields </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methods">
    public BinaryTreeNode getRoot()
    {
        return Root;
    }
    
    public int getSize()
    {
        int output;
        
        try
        {
            output = Size;    
        }
        catch (Exception exception)
        {
            output = 0;
        }
        
        return output;
    }
    
    public void addNode(String newKey, I newItem)
    {
        if (Root == null)
        {            
            Root = new BinaryTreeNode(newKey, newItem, null, null, null);
        }
        else
        {
            BinaryTreeNode focusNode = findNode(Root, newKey);
            int comparison = newKey.compareToIgnoreCase(focusNode.getKey());

            if (comparison < 0)
            {
                focusNode.setLeft(new BinaryTreeNode(newKey, newItem, focusNode, null, null));
            }
            else if (comparison > 0)
            {
                focusNode.setRight(new BinaryTreeNode(newKey, newItem, focusNode, null, null));  
            }
            else
            {
                focusNode.addItem(newItem);
            }
        }
        
        Size += 1;
    }
    
    public void removeNode(BinaryTreeNode targetNode)
    {
        switch(targetNode.countChildren())
        {
            case (0):
                if (targetNode.getParent().getLeft() == targetNode)
                {
                    targetNode.getParent().setLeft(null);
                }
                else
                {
                    targetNode.getParent().setRight(null);
                }
                break;
            case (1):
                if (targetNode.getParent().getLeft() == targetNode)
                {
                    if (targetNode.getLeft() == null)
                    {
                        targetNode.getParent().setLeft(targetNode.getLeft());
                    }
                    else
                    {
                        targetNode.getParent().setLeft(targetNode.getRight());
                    }
                }
                else
                {
                     if (targetNode.getLeft() == null)
                    {
                        targetNode.getParent().setRight(targetNode.getLeft());
                    }
                    else
                    {
                        targetNode.getParent().setRight(targetNode.getRight());
                    }
                }
                break;
            case (2):
            {
                if (targetNode.getParent().getLeft() == targetNode)
                {
                    
                }
                else
                {
                
                }
                break;
            }
            default:
                break;
        }
        
        Size -= 1;
    }
    
    public BinaryTreeNode findNode(BinaryTreeNode focusNode, String targetKey)
    {
        int comparison;
                    
        try 
        {
            comparison = targetKey.compareToIgnoreCase(focusNode.getKey());
        }
        catch (NullPointerException exception)
        {
            return null;
        }
        
        if (comparison < 0)
        {
            if (focusNode.getLeft() != null)
            {
                focusNode = findNode(focusNode.getLeft(), targetKey);  
            }
        }
        else if (comparison > 0)
        {
            if (focusNode.getRight() != null)
            {
                focusNode = findNode(focusNode.getRight(), targetKey);
            }
        }
        
        return focusNode;
    }
    
    public BinaryTreeNode findNode(I targetItem)
    {
        BinaryTreeNode output = null;
        boolean found = false;
        
        for (BinaryTreeNode focusNode : traverse())
        {            
            if (found)
            {
                break;
            }
            else
            {
                for (I focusItem : (ArrayList<I>) focusNode.getItems())
                {  
                    if (focusItem == targetItem)
                    {
                        output = focusNode;
                        found = true;
                        break;
                    }
                }
            }
        }
        
        return output;
    }
    
    public List<BinaryTreeNode> traverse()
    {
        Nodes = new ArrayList<>();
        inOrder(Root);
        return Nodes;
    }
    
    private void initialize(BinaryTreeNode root)
    {
        Root = root;
        
        if (root != null)
        {
            Size = 1;
        }
        else
        {
            Size = 0;
        }
    }
    
    private void inOrder(BinaryTreeNode parent)
    {
        BinaryTreeNode left = parent.getLeft();
        BinaryTreeNode right = parent.getRight();
        
        if (left != null)
        {
            inOrder(left);
        }
        
        Nodes.add(parent);
        
        if (right != null)
        {
            inOrder(right);
        }
    }
    //Methods </editor-fold>
}