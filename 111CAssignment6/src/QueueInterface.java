/**
 * @author Sebastian Kleinerman
 * @class Java 111C
 * @title QueueInterface.java
 */

public interface QueueInterface<T> 
{

	//Adds a new entry to the back of this queue.
	public void enQueue(T newEntry);

	//Removes and returns the entry at the front of this queue.
	public T deQueue();

	//Retrieves the entry at the front of this queue.
	public T getFront();

	//Detects whether this queue is empty.
	public boolean isEmpty();

	// Removes all entries from this queue
	public void clear();	
	
}
