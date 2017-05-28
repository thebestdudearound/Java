import java.util.*;
/*
 * An array implement of the ListInterface<T>
 * @author Sebastian Kleinerman
 */

public class ArrayBasedList<T> implements ListInterface<T> {

	private T[] list;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 100;
   
	public ArrayBasedList() {
		
		this(DEFAULT_CAPACITY);
	} // end default constructor
   
	public ArrayBasedList(int initialCapacity) {
		
		if (initialCapacity < DEFAULT_CAPACITY)
			initialCapacity = DEFAULT_CAPACITY;
      
		@SuppressWarnings("unchecked")
		T[] tempList = (T[])new Object[initialCapacity + 1];
		list = tempList;
		numberOfEntries = 0;
	} // end constructor
   
	public void add(T newEntry) {
		
		list[numberOfEntries + 1] = newEntry;
		numberOfEntries++;
		ensureCapacity();
	} // end add

	public void add(int newPosition, T newEntry) {
		
		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
			
			if (newPosition <= numberOfEntries)
				makeRoom(newPosition);
			list[newPosition] = newEntry;
			numberOfEntries++;
			ensureCapacity();
		}
		else
			throw new IndexOutOfBoundsException("Illegal Position");
	} // end add

	private void makeRoom(int newPosition) {
		
		int newIndex = newPosition;
		int lastIndex = numberOfEntries;
		
		for (int index = lastIndex; index >= newIndex; index--)
			list[index + 1] = list[index];
	}  // end makeRoom

	public T remove(int givenPosition) {
		
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			T result = list[givenPosition];
			if (givenPosition < numberOfEntries)
				removeGap(givenPosition);
			
			numberOfEntries--;
			return result;
		}
		else
			throw new IndexOutOfBoundsException("Illegal Position");
	} // end remove
	
	private void removeGap(int givenPosition) {
		
		assert (givenPosition >= 1) && (givenPosition < numberOfEntries);
		
		int removedIndex = givenPosition;
		int lastIndex = numberOfEntries;
		
		for (int index = removedIndex; index < lastIndex; index++)
			list[index] = list[index + 1];
	}
	public void clear() {

		numberOfEntries = 0;
	}

	public T replace(int givenPosition, T newEntry) {
		
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			T originalEntry = list[givenPosition];
			list[givenPosition] = newEntry;
			return originalEntry;
		}
		else
			throw new IndexOutOfBoundsException("Illegal Position");
	} // end replace

	public T getEntry(int givenPosition) {
		
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			return list[givenPosition];
		}
		else
			throw new IndexOutOfBoundsException("Illegal Position");
	} // end getEntry

    public T[] toArray() {
    	
    	@SuppressWarnings("unchecked")
    	T[] result = (T[])new Object[numberOfEntries];
    	
    	for (int index = 0; index < numberOfEntries; index++)
    		result[index] = list[index + 1];
      
    	return result;
    } // end toArray
    
	public boolean contains(T anEntry) {
		boolean found = false;

		int i = 1;
		while (!found && i < numberOfEntries) {
			if (anEntry.equals(list[i])) {
				found = true;
			}
			i++;
		}

		return found;
	}

	/*
	 * gets length of this list
	 * @return number of entries currently in list
	*/
	public int getLength() {
		return numberOfEntries;
	}

	/*
	 * sees whether list is empty
	 * @return true if list is empty, false if not
	*/
	public boolean isEmpty() {
		return numberOfEntries==0;
	}
	
private void ensureCapacity() {
		
		int capacity = list.length - 1;
		
		if (numberOfEntries >= capacity) {
			int newCapacity = 2 * capacity;
			list = Arrays.copyOf(list, newCapacity + 1);
		}
	}

}