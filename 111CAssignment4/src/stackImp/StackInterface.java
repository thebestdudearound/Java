package stackImp;

/**
 * @author Sebastian Kleinerman
 * @class Java 111C
 * @title StackInterface.java
 */

public interface StackInterface<T>
{
   //Adds a new entry to the top of this stack.
   //@param newEntry An object to be added to the stack. 
   public void push(T newEntry);
  
   // Removes and returns this stack's top entry.
   // @return The object at the top of the stack. 
   // @throws EmptyStackException if the stack is empty before the operation. 
   public T pop();
  
   // Retrieves this stack's top entry.
   // @return The object at the top of the stack.
   // @throws EmptyStackException if the stack is empty. 
   public T peek();
   
   public T peek2();
   
   public String toString();
   
   public void remove(int n);
   
   public void pushAll(T[] a);
  
   // Detects whether this stack is empty.
   // @return True if the stack is empty. 
   public boolean isEmpty();
  
   // Removes all entries from this stack. 
   public void clear();
}
