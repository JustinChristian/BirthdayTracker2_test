//<editor-fold defaultstate="collapsed" desc="Package and Imports">
package birthdaytracker2.Logic.DoublyLinkedList;
//Package and Imports </editor-fold>

public class DoublyLinkedList <I>
{
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public DoublyLinkedList()
    {
        initialize();
    }
    //Constructors </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private int Size;
    public int getSize()
    {
        return this.Size;
    }
    public void setSize(int size)
    {
        this.Size = size;
    }
    
    private DoublyLinkedListNode Start;
    public DoublyLinkedListNode getStart()
    {
        return this.Start;
    }
    public void setStart(DoublyLinkedListNode start)
    {
        this.Start = start;
    }
    
    private DoublyLinkedListNode End;
    public DoublyLinkedListNode getEnd()
    {
        return this.End;
    }
    public void setEnd(DoublyLinkedListNode end)
    {
        this.End = end;
    }
    //Properties </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methods">
    public void addNode(I item)
    {
        newNodeBefore(getEnd(), item);
        incrementSize();
    }
    
    public void insertNode(int afterNode, I newItem)
    {
        DoublyLinkedListNode focusNode = findNode(afterNode);
        
        if (focusNode != null)
        {
            newNodeAfter(focusNode, newItem);
            incrementSize();
        }
        else
        {
            // TODO: Not enough nodes.
        }
    }
    
    public void insertNode(I afterItem, I newItem)
    {
        DoublyLinkedListNode focusNode = findNode(afterItem);
        
        if (focusNode != null)
        {
            newNodeAfter(focusNode, newItem);
            incrementSize();
        }
        else
        {
            // TODO: Node not found.
        }
    }
    
    public void deleteNode(int node)
    {
        removeNode(findNode(node));
        decrementSize();
    }
    
    public void deleteNode(I item)
    {
        removeNode(findNode(item));
        decrementSize();
    }
    
    public void deleteNodes(I item)
    {
        DoublyLinkedListNode focusNode;
        
        while ((focusNode = findNode(item)) != null)
        {
            deleteNode(item);
            decrementSize();
        }
    }
    
    public DoublyLinkedListNode findNode(int node)
    {
        if (getSize() > 0 && node < getSize() && node >= 0)
        {
            DoublyLinkedListNode focusNode = getStart().getRight();
            
            while (node != 0)
            {
                node -= 1;
                focusNode = focusNode.getRight();
            }
            
            return focusNode;
        }
        else
        {
            return null;
        }
    }
    
    public DoublyLinkedListNode findNode(I item)
    {
        if (getSize() > 0)
        {
            DoublyLinkedListNode focusNode = getStart().getRight();
            
            while (focusNode.getItem() != item)
            {
                if (focusNode.getRight() == getEnd())
                {
                    focusNode = null;
                    break;
                }
                
                focusNode = focusNode.getRight();
            }
            
            return focusNode;
        }
        else
        {
            return null;
        }
    }
    
    private void initialize()
    {
        setStart(new DoublyLinkedListNode(null, null, null));
        setEnd(new DoublyLinkedListNode(null, null, null));
        getStart().setRight(getEnd());
        getEnd().setLeft(getStart());
        setSize(0);
    }
    
    private void newNodeAfter(DoublyLinkedListNode target, I item)
    {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(item, target, target.getRight());
        target.getRight().setLeft(newNode);
        target.setRight(newNode);
    }
    
    private void newNodeBefore(DoublyLinkedListNode target, I item)
    {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(item, target.getLeft(), target);
        target.getLeft().setRight(newNode);
        target.setLeft(newNode);
    }
    
    private void removeNode(DoublyLinkedListNode target)
    {
        target.getLeft().setRight(target.getRight());
        target.getRight().setLeft(target.getLeft());
    }
    
    public void previousNode(DoublyLinkedListNode node)
    {
        node = node.getLeft();
    }
    
    public void nextNode(DoublyLinkedListNode node)
    {
        node = node.getRight();
    }
    
    private void incrementSize()
    {
        setSize(getSize() + 1);
    }
    private void decrementSize()
    {
        setSize(getSize() - 1);
    }
    //Methods </editor-fold>
}