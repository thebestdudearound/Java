import java.util.*;

/**
 * @author Sebastian Kleinerman
 * @class Java 111C
 * @title ArrayQueue.java
 */

public final class ArrayQueue<T> implements QueueInterface<T> 
{
	private T[] queue;
	private int frontIndex;
	private int backIndex;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	public ArrayQueue() 
	{
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayQueue(int initialCapacity) 
	{	
		checkCapacity(initialCapacity);
		
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[initialCapacity + 1];
		queue = tempQueue;
		frontIndex = 0;
		backIndex = initialCapacity;
		initialized = true;
	}

	public void enQueue(T newEntry) 
	{
		checkInitialization();
		ensureCapacity();
		
		backIndex = (backIndex + 1) % queue.length;
		queue[backIndex] = newEntry;
	}

	public T getFront() 
	{
		checkInitialization();
		
		if(isEmpty())
			throw new EmptyQueueException();
		else
			return queue[frontIndex];
		
	}
	
	public T deQueue()
	{
		checkInitialization();
		
		if(isEmpty())
			throw new EmptyQueueException();
		else
		{
			T front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
			return front;
		}
	}

	public boolean isEmpty() 
	{
		return frontIndex == ((backIndex + 1) % queue.length);
	}

	public void clear() 
	{
		queue = null;
	} 
	
	public void splice(QueueInterface<T> q)
	{
		QueueInterface<T> tempQueue = new ArrayQueue<T>();
		
		while(!q.isEmpty())
		{
			enQueue(q.getFront());
			tempQueue.enQueue(q.deQueue());
		}
		
		while(!tempQueue.isEmpty())
		{
			q.enQueue(tempQueue.deQueue());
		}
		
	}
	
	private void ensureCapacity()
	{
		if(frontIndex == ((backIndex + 2) % queue.length))
		{
			T[] oldQueue = queue;
			int oldSize = oldQueue.length;
			int newSize = 2 * oldSize;
			checkCapacity(newSize);
			
			@SuppressWarnings("unchecked")
			T[] tempQueue = (T[]) new Object[newSize];
			queue = tempQueue;
			for(int i = 0; i < oldSize - 1;i++)
			{
				queue[i] = oldQueue[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
			}
			
			frontIndex = 0;
			backIndex = oldSize - 2;
		}
	}

	// Throws an exception if the client requests a capacity that is too large.
	private void checkCapacity(int capacity)
	{
	   if (capacity > MAX_CAPACITY)
	      throw new IllegalStateException("Attempt to create a queue whose capacity exceeds " +
	                                      "allowed maximum of " + MAX_CAPACITY);
	}
	   
	// Throws an exception if receiving object is not initialized.
	private void checkInitialization()
	{
	   if(!initialized)
	      throw new SecurityException("Uninitialized object used " +
	                                   "to call an ArrayQueue method.");
	}
	
}
