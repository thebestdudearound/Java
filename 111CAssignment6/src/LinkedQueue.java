import java.util.*;

/**
 * @author Sebastian Kleinerman
 * @class Java 111C
 * @title LinkedQueue.java
 */

public final class LinkedQueue<T> implements QueueInterface<T> 
{
	private Node queueNode; 
	private Node freeNode;

	public LinkedQueue() 
	{
		freeNode = new Node(null, null);
		freeNode.setNextNode(freeNode);
		queueNode = freeNode;
	}

	public void enQueue(T newEntry) 
	{
		freeNode.setData(newEntry);

		if (isChainFull())
		{
			Node newNode = new Node(null, freeNode.getNextNode());
			freeNode.setNextNode(newNode);
		}	
		
		freeNode = freeNode.getNextNode();
	} // end enqueue


	public T getFront() 
	{
		if (isEmpty())
			throw new EmptyQueueException();
		else
			return queueNode.getData();
	} // end getFront

	public T deQueue()
	{
		T front = getFront(); // Might throw EmptyQueueException
		assert !isEmpty();
		queueNode.setData(null);
		queueNode = queueNode.getNextNode();

		return front;
	}

	public boolean isEmpty() 
	{
		return queueNode == freeNode;
	}

	public void clear() 
	{
		queueNode = null;
		freeNode = null;
	} 
	
	public void splice(QueueInterface<T> q)
	{
		QueueInterface<T> tempQueue = new LinkedQueue<T>();
		
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

	private class Node 
	{
		private T data; // Entry in queue
		private Node next; // Link to next node

		private Node(T dataPortion) 
		{
			data = dataPortion;
			next = null;
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
	
	private boolean isChainFull() 
	{
		return queueNode == freeNode.getNextNode();
	}
	
}
