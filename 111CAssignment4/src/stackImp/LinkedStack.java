package stackImp;
import java.util.EmptyStackException;

/**
 * @author Sebastian Kleinerman
 * @class Java 111C
 * @title LinkedStack.java
 */

public class LinkedStack<T> implements StackInterface<T>
{
	private Node topNode; // References the first node in the chain
  
   public LinkedStack()
   {
      topNode = null;
   }
  
   public void push(T newEntry)
   {
      Node newNode = new Node(newEntry, topNode);
      topNode = newNode;
   }

   public void pushAll(T[] a) 
   {
	   T[] array = a;
	   for (int i = 0; i < array.length; i++) 
	   {
		   this.push(array[i]);
	   }
   }
   
   public T peek()
   {
      if (isEmpty())
         throw new EmptyStackException();
      else
         return topNode.getData();
   }
   
   public T peek2()
   {
      if (topNode.getNextNode() == null)
         throw new EmptyStackException();
      else
    	 return topNode.getNextNode().getData();	 
   }
   
   public T pop()
   {
      T top = peek();  // Might throw EmptyStackException

      assert (topNode != null);
      topNode = topNode.getNextNode();

      return top;
   }
   
   public String toString()
   {
	   //Node current = topNode;
	   assert (topNode != null);
	   String s = topNode.getData() + " ";
	   Node current = topNode.getNextNode();
	   
	   while (current != null) 
	   {
		   s += current.getData() + " ";
		   current = current.getNextNode();
	   }
	   
	   return s;
   }
   
   public void remove(int n) 
   {
	   int count = n;
	   
	   while ((count != 0) || isEmpty() ) 
	   {
		   this.pop();
		   count --;
	   }
   }
   
   public boolean isEmpty()
   {
      return topNode == null;
   }

   public void clear()
   {
      topNode = null;
   }

   private class Node
   {
      private T    data; // Entry in stack
      private Node next; // Link to next node
      
      private Node(T dataPortion)
      {
         this(dataPortion, null);
      }
      
      private Node(T dataPortion, Node linkPortion)
      {
         data = dataPortion;
         next = linkPortion;
      }
      
      private T getData()
      {
         return data;
      }
      
      private void setData(T newData)
      {
         data = newData;
      }
      
      private Node getNextNode()
      {
         return next;
      }
      
      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      }
	}
	
}
