/**
 * @author Sebastian Kleinerman
 * @class Java 111C
 * @title ResizableArrayBag.java
 */

import java.util.*;

public final class ResizableArrayBag<T> implements BagInterface<T>
{
	private T[] bag;
	private int entries;
    private boolean value = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	
	//No-argument constructor.
	public ResizableArrayBag() 
	{
		this(DEFAULT_CAPACITY);
	}
	
	//Constructor with an integer as a parameter.
	public ResizableArrayBag(int initialCapacity)
	{
      checkCapacity(initialCapacity);

      @SuppressWarnings("unchecked")
      T[] tempBag = (T[])new Object[initialCapacity];
      bag = tempBag;
      entries = 0;
      value = true;
	} 

	//Constructor with array of some object of type <T>.
    public ResizableArrayBag(T[] contents) 
    {
       checkCapacity(contents.length);
       bag = Arrays.copyOf(contents, contents.length);
       entries = contents.length;
       value = true;
    }
   
    //add method for some object of type <T>.
	public boolean add(T newEntry)
	{
		checkInitialization();
        if (isTooBig())
        {
           doubleCapacity();
        }
        
      bag[entries] = newEntry;
      entries++;
      return true;
	} 
	
	//toArray method which returns array of type <T> objects.
	public T[] toArray() 
	{
		checkInitialization();
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[entries];
		for (int index = 0; index < entries; index++)
		{
			result[index] = bag[index];
		} 
      
		return result;
	}
   
	//isEmpty method to check whether bag is empty.
	public boolean isEmpty()
	{
      return entries == 0;
	}
   
	//getCurrentSize method to get size of bag.
	public int getCurrentSize()
	{
      return entries;
	}
   
	//getFrequencyOf method to get the amount of times a certain object of type <T> is in the array.
	public int getFrequencyOf(T anEntry)
	{
		checkInitialization();
		int counter = 0;
      
		for (int index = 0; index < entries; index++)
		{
			if (anEntry.equals(bag[index]))
			{
				counter++;
			}
		}
		return counter;
	}
	
	//contains method which checks whether an object of type <T> is in the bag.
    public boolean contains(T anEntry)
	{
	   checkInitialization();
       return getIndexOf(anEntry) >= 0;
	}
   
    //clear method to empty the bag.
	public void clear()
	{
      while (!isEmpty())
         remove();
	}

	//remove method to remove an object of type <T> from the bag if there are too many objects that wont fit in the array.
	public T remove()
	{
		checkInitialization();
		if(this.isTooBig())
		{
			reduceArray();
		}
		T result = removeEntry(entries - 1);
		return result;
	}
	
	//remove method to remove an object of type <T> from the bag.
	public boolean remove(T anEntry)
	{
		checkInitialization();
	
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
	}

	//getIndexOf method to check where a certain object of type <T> is.
	private int getIndexOf(T anEntry)
	{
		int where = -1;
		boolean found = false;
		int index = 0;
      
        while (!found && (index < entries))
		{
			if (anEntry.equals(bag[index]))
			{
				found = true;
				where = index;
			}
			
            index++;
		}
      
		return where;
	} 
	
	//removeEntry method to remove whatever object is at a certain index.
	private T removeEntry(int givenIndex)
	{
		T result = null;
      
		if (!isEmpty() && (givenIndex >= 0))
		{
         result = bag[givenIndex];          
         int lastIndex = entries - 1;
         bag[givenIndex] = bag[lastIndex];  
         bag[lastIndex] = null;             
         entries--;
		}
      
      return result;
	}
   
	//isTooBig method to check whether there are too many objects to be added to the bag.
	private boolean isTooBig()
	{
		if((bag.length > 20) && (entries >= (bag.length)/2));
			{
				return true;
			}
	}
   
	//doubleCapacity method to increase the size of the array if there are too many objects to be added.
	private void doubleCapacity()
	{
      int newLength = 2 * bag.length;
      checkCapacity(newLength);
      bag = Arrays.copyOf(bag, newLength);
	}
	
	//reduceArray method to decrease the size of the array.
	private void reduceArray()
	{
		if(bag.length >= 4)
		{
			int newLength = (3/4) * bag.length;
			bag = Arrays.copyOf(bag, newLength);
		}
	}
   
	//checkCapacity method to check how many spots are available in the bag.
    private void checkCapacity(int capacity)
    {
       if (capacity > MAX_CAPACITY)
          throw new IllegalStateException("Attempt to create a bag whose capacity exceeds " +
                                          "allowed maximum of " + MAX_CAPACITY);
    }

    //checkInitialization method to check whether an object got initialized.
    private void checkInitialization()
    {
       if (!value)
          throw new SecurityException ("Uninitialized object used " +
                                       "to call an ArrayBag method.");
    }
}
