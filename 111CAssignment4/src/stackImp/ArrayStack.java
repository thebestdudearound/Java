package stackImp;
import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author Sebastian Kleinerman
 * @class Java 111C
 * @title ArrayStack.java
 */

public class ArrayStack<T> implements StackInterface<T>
{
	private T[] stack;    // Array of stack entries
	private int topIndex; // Index of top entry
    private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
  
   public ArrayStack()
   {
      this(DEFAULT_CAPACITY);
   }
  
   public ArrayStack(int initialCapacity)
   {
      checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempStack = (T[])new Object[initialCapacity];
      stack = tempStack;
		topIndex = -1;
      initialized = true;
   } 
  
   public void push(T newEntry)
   {
      checkInitialization();
      ensureCapacity();
      
      stack[topIndex + 1] = newEntry;
      topIndex++;
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
      checkInitialization();
      
      if (isEmpty())
         throw new EmptyStackException();
      else
         return stack[topIndex];
   }
   
   public T peek2()
   {
      checkInitialization();
      
      if (topIndex < 1)
         throw new EmptyStackException();
      else
         return stack[topIndex - 1];
   }

   public T pop()
   {
      checkInitialization();
      
      if (isEmpty())
         throw new EmptyStackException();
      else
      {
         T top = stack[topIndex];
         stack[topIndex] = null;
         topIndex--;
         return top;
      }
   }

   public String toString()
   {
	   checkInitialization();
	   
	   int count = topIndex;
	   String s = stack[count] + " ";
	   count--;
	   
	   while (count > -1) 
	   {
		   s += stack[count] + " ";
		   count--;
	   }
	   
	   return s;
   }
   
   public void remove(int n) 
   {
	   int count = n;
	   
	   while ((count != 0) || isEmpty() ) 
	   {
		   this.pop();
		   count--;
	   }
   }
   
   public boolean isEmpty()
   {
      return topIndex < 0;
   }

   public void clear()
   {
    
   }
   
   // Throws an exception if the client requests a capacity that is too large.
   private void checkCapacity(int capacity)
   {
      if (capacity > MAX_CAPACITY)
         throw new IllegalStateException("Attempt to create a bag whose capacity exceeds " +
                                         "allowed maximum of " + MAX_CAPACITY);
   }
   
   // Throws an exception if receiving object is not initialized.
   private void checkInitialization()
   {
      if (!initialized)
         throw new SecurityException ("Uninitialized object used " +
                                      "to call an ArrayBag method.");
   }
   
   private void ensureCapacity()
   {
      if (topIndex >= stack.length - 1) // If array is full, double its size
      {
         int newLength = 2 * stack.length;
         checkCapacity(newLength);
         stack = Arrays.copyOf(stack, newLength);
      }
   }

}
