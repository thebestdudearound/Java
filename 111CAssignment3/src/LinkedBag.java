/**
 * @author Sebastian Kleinerman
 * @class Java 111C
 * @title LinkedBag.java
 */

public final class LinkedBag<T> implements BagInterface<T> {
	
	private Node firstNode;       
	private int numberOfEntries;
	private boolean initialized = false;

	public LinkedBag()
	{
	    firstNode = null;
        numberOfEntries = 0;
	}

	/** Adds a new entry to this bag.
	    @param newEntry  The object to be added as a new entry.
	    @return  True. 
	*/
	public boolean add(T newEntry)
	{
	  Node newNode = new Node(newEntry);
	  newNode.next = firstNode;
      firstNode = newNode;
      numberOfEntries++;
      
	  return true;
	}

	/** Retrieves all entries that are in this bag.
       @return  A newly allocated array of all the entries in this bag. 
    */
	public T[] toArray()
	{
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries];
      
      int index = 0;
      Node currentNode = firstNode;
      while ((index < numberOfEntries) && (currentNode != null))
      {
         result[index] = currentNode.data;
         index++;
         currentNode = currentNode.next;
      }
      
      return result;
      // Note: The body of this method could consist of one return statement,
      // if you call Arrays.copyOf
	}
   
	/** Sees whether this bag is empty.
       @return  True if the bag is empty, or false if not.
    */
	public boolean isEmpty()
	{
		return numberOfEntries == 0;
	}
   
	/** Gets the number of entries currently in this bag.
       @return  The integer number of entries currently in the bag. 
    */
	public int getCurrentSize()
	{
		return numberOfEntries;
	}

	/** Removes one unspecified entry from this bag, if possible.
       @return  Either the removed entry, if the removal
                was successful, or null. 
    */
	public T remove()
	{
	  T result = null;
      if (!isEmpty())
      {
         result = firstNode.data; 
         firstNode = firstNode.next;
         numberOfEntries--;
      }
		return result;
	}
   
	/** Removes one occurrence of a given entry from this bag.
       @param anEntry  The entry to be removed.
       @return  True if the removal was successful, or false otherwise. 
    */
    public boolean remove(T anEntry) 
    {
	  boolean result = false;
      Node nodeN = getReferenceTo(anEntry);
      
      if (nodeN != null)
      {
         nodeN.data = firstNode.data; 
         firstNode = firstNode.next; 
         numberOfEntries--;
         result = true;
      }    
		return result;
	}
	
	// Removes all entries from this bag. 
	public void clear() 
	{
		while (!isEmpty()) 
         remove();
	}
	
	/** Counts the number of times a given entry appears in this bag.
		 @param anEntry  The entry to be counted.
		 @return  The number of times anEntry appears in the bag.
    */
	public int getFrequencyOf(T anEntry) 
	{
		int frequency = 0;
      int loopCounter = 0;
      Node currentNode = firstNode;

      while ((loopCounter < numberOfEntries) && (currentNode != null))
      {
         if (anEntry.equals(currentNode.data))
         {
            frequency++;
         }
         
         loopCounter++;
         currentNode = currentNode.next;
      }

		return frequency;
	}
	
	/** Tests whether this bag contains a given entry.
		 @param anEntry  The entry to locate.
		 @return  True if the bag contains anEntry, or false otherwise. 
    */
	public boolean contains(T anEntry)
	{
      boolean found = false;
      Node currentNode = firstNode;
      
      while (!found && (currentNode != null))
      {
         if (anEntry.equals(currentNode.data))
            found = true;
         else
            currentNode = currentNode.next;
      }	
      return found;
    }
	
	public boolean equals(Object aBag)
	{
		boolean equal = true;
		@SuppressWarnings("unchecked")
		LinkedBag<T> newBag = (LinkedBag<T>)aBag;
		int loopCounter = 0;
		Node currentNode = firstNode;
		Node newNode = newBag.firstNode;
		
		if (numberOfEntries == newBag.getCurrentSize())
		{
			while (loopCounter < numberOfEntries && equal)
			{
				if (currentNode.data.equals(newNode.data) && 
				   (getFrequencyOf(currentNode.data) == getFrequencyOf(newNode.data)))
				{
					currentNode = currentNode.next;
					newNode = newNode.next;
				}
				else
					equal = false;
				loopCounter++;			
			}
		}	
		return equal;
	}
	
	public BagInterface<T> union(BagInterface<T> aBag) 
	{ 
		LinkedBag<T> newBag = (LinkedBag<T>)aBag;
		BagInterface<T> unionBag = new LinkedBag<T>(); 
		Node currentNode = firstNode;
		while (currentNode != null) 
		{ 
			unionBag.add(currentNode.data); 
			currentNode = currentNode.next; 
		}
		currentNode = newBag.firstNode; 
		while (currentNode != null) 
		{ 
			unionBag.add(currentNode.data); 
			currentNode = currentNode.next; 
		} 
		return unionBag; 
	}
	
	// Throws an exception if receiving object is not initialized.
	private void checkInitialization()
	{
	   if (!initialized)
	      throw new SecurityException ("Uninitialized object used " +
	                                      "to call an ArrayBag method.");
	}  
   
    private Node getReferenceTo(T anEntry)
    {
		boolean found = false;
		Node currentNode = firstNode;
		
		while (!found && (currentNode != null))
		{
			if (anEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.next;
		}
     
		return currentNode;
	}
   
	private class Node
	{
	  private T    data; 
	  private Node next;

		private Node(T dataPortion)
		{
			this(dataPortion, null);	
		}
		
		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;	
		}
	}	
}