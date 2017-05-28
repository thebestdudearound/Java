/*
 * A Linked List implementation of ListInterface<T>
 * @author Sebastian Kleinerman
 */

public class LinkedListBasedList<T> implements ListInterface<T> {
	
	private Node firstNode;
	private Node lastNode;
	private int  numberOfEntries;

   
	public LinkedListBasedList() {
		
		initializeDataFields();
	} // end default constructor
	
	public void clear() {	
		initializeDataFields();
	} // end clear
   
  
	public void add(T newEntry) {
		
		Node newNode = new Node(newEntry);

		if (isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
	   
		lastNode = newNode;
		numberOfEntries++;
	}  // end add

	public void add(int newPosition, T newEntry) {
		
		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
			
			Node newNode = new Node(newEntry);
			if (isEmpty()) {
				firstNode = newNode;
				lastNode = newNode;
			} else if (newPosition == 1) {
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			} else if (newPosition == numberOfEntries + 1) {
				lastNode.setNextNode(newNode);
				lastNode = newNode;
			} else {
				Node nodeBefore = getNodeAt(newPosition - 1);
				Node nodeAfter = nodeBefore.getNextNode();
				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
			} // end if
			
			numberOfEntries++;
		}
		else
			throw new IndexOutOfBoundsException("Illegal Position");
	} // end add


	public boolean isEmpty() {
		
		boolean result;
	      
		if (numberOfEntries == 0) {
			assert firstNode == null;
			result = true;
		} else {
			assert firstNode != null;
			result = false;
		} // end if
	      
		return result;
	} // end isEmpty

	public T[] toArray() {
		
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		int index = 0;
		Node currentNode = firstNode;
		
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			index++;
		} // end while
	   
		return result;
	} // end toArray

	public T remove(int givenPosition) {
		
		T result = null;  
		
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			if (givenPosition == 1) {
				result = firstNode.getData();
				firstNode = firstNode.getNextNode();
				if (numberOfEntries == 1)
					lastNode = null;
			} else {
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeToRemove = nodeBefore.getNextNode();
				Node nodeAfter = nodeToRemove.getNextNode();
				nodeBefore.setNextNode(nodeAfter);
				result = nodeToRemove.getData();
				if (givenPosition == numberOfEntries)
					lastNode = nodeBefore;
			} // end if
			
			numberOfEntries--;
		}
		else
			throw new IndexOutOfBoundsException("Illegal Position");
		
		return result;
	} // end remove

	public T replace(int givenPosition, T newEntry) {
		
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			Node desiredNode = getNodeAt(givenPosition);
			T originalEntry = desiredNode.getData();
			desiredNode.setData(newEntry);
			return originalEntry;
		}
		else
			throw new IndexOutOfBoundsException("Illegal Position");
	} // end replace

	public T getEntry(int givenPosition) {
		
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			return getNodeAt(givenPosition).getData();
		}
		else
			throw new IndexOutOfBoundsException("Illegal Position");
	} // end getEntry

	public int getLength() {
		
		return numberOfEntries;
	} // end getLength
	
	public boolean contains(T anEntry) {
		boolean found = false;
		Node current = firstNode;

		while(!found && current != null) {
			if(anEntry.equals(current.getData())) {
				found = true;
			}
			else
				current = current.getNextNode();
		}

		return found;
	}
	
	private void initializeDataFields() {
		
		firstNode = null;
		lastNode = null;
		numberOfEntries = 0;
	} // end initializeDataFields

	private Node getNodeAt(int givenPosition) {
		
		assert !isEmpty() && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
		Node currentNode = firstNode;
		
		for (int counter = 1; counter < givenPosition; counter++)
			currentNode = currentNode.getNextNode();
		
		assert currentNode != null;
		return currentNode;
	} // end getNodeAt
  
	private class Node {
		
		private T    data;
		private Node next;
      
		private Node(T dataPortion) {
			
			data = dataPortion;
			next = null;
		} // end constructor
      
		private Node(T dataPortion, Node nextNode) {
			
			data = dataPortion;
			next = nextNode;
		} // end constructor
      
		private T getData() {
			
			return data;
		} // end getData
      
		private void setData(T newData) {
			
			data = newData;
		} // end setData
      
		private Node getNextNode() {
			
			return next;
		} // end getNextNode
      
		private void setNextNode(Node nextNode) {
			
			next = nextNode;
		} // end setNextNode
		
	} // end Node
	
} // end LinkedListBasedList