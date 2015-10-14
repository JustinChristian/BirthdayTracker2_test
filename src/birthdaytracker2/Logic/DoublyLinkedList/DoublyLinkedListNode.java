//<editor-fold defaultstate="collapsed" desc="Package and Imports">
package birthdaytracker2.Logic.DoublyLinkedList;
//Package and Imports </editor-fold>

public class DoublyLinkedListNode <I>
{
    //<editor-fold defaultstate="collapsed" desc="Constructors">    
    public DoublyLinkedListNode(I item, DoublyLinkedListNode left, DoublyLinkedListNode right)
    {
        initialize(item, left, right);
    }
    //Constructors </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private I Item;
    public I getItem()
    {
        return this.Item;
    }
    public void setItem(I item)
    {
        this.Item = item;
    }
    
    private DoublyLinkedListNode Left;
    public DoublyLinkedListNode getLeft()
    {
        return this.Left;
    }
    public void setLeft(DoublyLinkedListNode left)
    {
        this.Left = left;
    }
    
    private DoublyLinkedListNode Right;
    public DoublyLinkedListNode getRight()
    {
        return this.Right;
    }
    public void setRight(DoublyLinkedListNode right)
    {
        this.Right = right;
    }
    //Properties </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methods">
    private void initialize(I item, DoublyLinkedListNode left, DoublyLinkedListNode right)
    {
       Item = item;
       Left = left;
       Right = right;
    }
    //Methods </editor-fold>
}