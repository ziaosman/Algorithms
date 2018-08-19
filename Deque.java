/*Zia Osman
*/
import java.util.Iterator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item>
{
	
	private Node first, last; 
	private int size; 
	// construct an empty deque
   public Deque()
   {
   	first = null; 
   	last = null;
   	size = 0; 

   } 
    private class Node
   {
   	Item item; 
   	Node next;
      Node prev; //make sure to implement throughout
   }
   // is the deque empty?
   public boolean isEmpty()
   {
   	return (first == null || last == null);
   }
    // return the number of items on the deque
   public int size()
   {
   		return size;
   }

   // add the item to the front                      
   public void addFirst(Item item)  
   {
   	Node oldFirst = first;
   	first = new Node();
   	first.item = item;
   	first.next = oldFirst;
      first.prev = null;
      if (oldFirst == null)
      {
         last = first;
      }
      else
      {
      oldFirst.prev = first;
      }
   	size++;
   }
   // add the item to the end        
   public void addLast(Item item)  
   {
   	Node oldLast = last;
   	last = new Node();
   	last.item = item;
   	last.prev = oldLast;
      last.next = null;
   	if (oldLast ==null)
   	{
   		first = last; 
   	}
   	else
   	{
   		oldLast.next = last;
   	}
   	size++; 
   }
   // remove and return the item from the front      
   public Item removeFirst()
   {
   	if (isEmpty())
   	{
   		throw new java.util.NoSuchElementException("The deque is already empty");
   	}
   	else
   	{
   		Item item = first.item;
   		first = first.next;
         first.prev = null;
   		size--;
   		return item;
   	}
   }
   // remove and return the item from the end              
   public Item removeLast()
   {
   	if (isEmpty())
   	{
   		throw new java.util.NoSuchElementException("The deque is already empty");
   	}
   	else
   	{
   		Item item = last.item;
   		last = last.prev;
         last.next = null;
   		size--;
   		return item;
   	}
   }

   // return an iterator over items in order from front to end                 
   public Iterator<Item> iterator() 
   {
   	return new dequeIterator();
   }

   private class dequeIterator implements Iterator<Item>
   {
   	private Node current = first;

   	public boolean hasNext()
   	{
   		return current != null;
   	}
   	public Item next()
   	{
   		Item item = current.item;
   		current = current.next;
   		return item; 
   	}
   }   
}