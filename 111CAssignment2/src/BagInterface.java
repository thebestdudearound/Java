/**
 * @author Sebastian Kleinerman
 * @class Java 111C
 * @title BagInterface.java
 */

public interface BagInterface<T> 
{
	T[] toArray();
	T remove();
	
	boolean add(T value);
	boolean contains(T value);
	boolean isEmpty();
	boolean remove(T value);
	
	int getCurrentSize();
	int getFrequencyOf(T value);
	
	void clear();
	
}