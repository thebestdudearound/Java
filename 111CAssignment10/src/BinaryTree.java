import java.util.*;

/**
 * 
 * @author Sebastian Kleinerman
 * @class Java 111C
 *
 */

public class BinaryTree<T> implements BinaryTreeInterface<T> {
	private BinaryNode<T> root;

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(T rootData) {
		root = new BinaryNode<T>(rootData);
	}

	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		privateSetTree(rootData, leftTree, rightTree);
	}

	public void setTree(T rootData) {
		root = new BinaryNode<T>(rootData);
	}

	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		privateSetTree(rootData, (BinaryTree<T>) leftTree, (BinaryTree<T>) rightTree);
	}

	private void privateSetTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		root = new BinaryNode<T>(rootData);

		if ((leftTree != null) && !leftTree.isEmpty())
			root.setLeftChild(leftTree.root);

		if ((rightTree != null) && !rightTree.isEmpty()) {
			if (rightTree != leftTree)
				root.setRightChild(rightTree.root);
			else
				root.setRightChild(rightTree.root.copy());
		}

		if ((leftTree != null) && (leftTree != this))
			leftTree.clear();

		if ((rightTree != null) && (rightTree != this))
			rightTree.clear();
	}

	public T getRootData() {
		if (isEmpty())
			throw new IllegalStateException();
		else
			return root.getData();
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void clear() {
		root = null;
	}

	protected void setRootData(T rootData) {
		root.setData(rootData);
	}

	protected void setRootNode(BinaryNode<T> rootNode) {
		root = rootNode;
	}

	protected BinaryNode<T> getRootNode() {
		return root;
	}

	public int getHeight() {
		return root.getHeight();
	}

	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
	}

	public Iterator<T> getPreorderIterator() {
		return new PreorderIterator();
	}

	public Iterator<T> getInorderIterator() {
		return new InorderIterator();
	}

	public Iterator<T> getPostorderIterator() {
		return new PostorderIterator();
	}

	public Iterator<T> getLevelOrderIterator() {
		return new LevelOrderIterator();
	}

	public void iterativePreorderTraverse() {
		StackInterface<BinaryNode<T>> nodeStack = new LinkedStack<BinaryNode<T>>();
		if (root != null)
			nodeStack.push(root);
		BinaryNode<T> nextNode;
		while (!nodeStack.isEmpty()) {
			nextNode = nodeStack.pop();
			BinaryNode<T> leftChild = nextNode.getLeftChild();
			BinaryNode<T> rightChild = nextNode.getRightChild();

			// Push into stack in reverse order of recursive calls
			if (rightChild != null)
				nodeStack.push(rightChild);

			if (leftChild != null)
				nodeStack.push(leftChild);

			System.out.print(nextNode.getData() + " ");
		}
	}

	public void iterativeInorderTraverse() {
		StackInterface<BinaryNode<T>> nodeStack = new LinkedStack<BinaryNode<T>>();
		BinaryNode<T> currentNode = root;

		while (!nodeStack.isEmpty() || (currentNode != null)) {
			// Find leftmost node with no left child
			while (currentNode != null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.getLeftChild();
			} // end while

			// Visit leftmost node, then traverse its right subtree
			if (!nodeStack.isEmpty()) {
				BinaryNode<T> nextNode = nodeStack.pop();
				assert nextNode != null; // Since nodeStack was not empty
											// before the pop
				System.out.print(nextNode.getData() + " ");
				currentNode = nextNode.getRightChild();
			}
		}
	}
	
	
	private class PreorderIterator implements Iterator<T> {
		private StackInterface<BinaryNode<T>> nodeStack;

		public PreorderIterator() {
			nodeStack = new LinkedStack<BinaryNode<T>>();

			if (root != null)
				nodeStack.push(root);
		}

		public boolean hasNext() {
			return !nodeStack.isEmpty();
		}

		public T next() {
			BinaryNode<T> nextNode;

			if (hasNext()) {
				nextNode = nodeStack.pop();
				BinaryNode<T> leftChild = nextNode.getLeftChild();
				BinaryNode<T> rightChild = nextNode.getRightChild();

				// Push into stack in reverse order of recursive calls
				if (rightChild != null)
					nodeStack.push(rightChild);

				if (leftChild != null)
					nodeStack.push(leftChild);
				
			} else {
				throw new NoSuchElementException();
			}

			return nextNode.getData();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	} // end PreorderIterator
	
	private class InorderIterator implements Iterator<T> {
		private StackInterface<BinaryNode<T>> nodeStack;
		private BinaryNode<T> currentNode;

		public InorderIterator() {
			nodeStack = new LinkedStack<>();
			currentNode = root;
		} // end default constructor

		public boolean hasNext() {
			return !nodeStack.isEmpty() || (currentNode != null);
		} // end hasNext

		public T next() {	   
			BinaryNode<T> nextNode = null;

			// Find leftmost node with no left child
			while (currentNode != null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.getLeftChild();
			} // end while

			// Get leftmost node, then move to its right subtree
			if (!nodeStack.isEmpty()) {
				nextNode = nodeStack.pop();
				assert nextNode != null; // Since nodeStack was not empty
										 // before the pop
				currentNode = nextNode.getRightChild();
				
			} else {
				throw new NoSuchElementException();
			}
	      
			return nextNode.getData(); 
		} // end next

		public void remove() {
			throw new UnsupportedOperationException();
		} // end remove
	   
	} // end InorderIterator

	private class PostorderIterator implements Iterator<T> {	
		private StackInterface<BinaryNode<T>> nodeStack;
		private BinaryNode<T> currentNode;

		public PostorderIterator() {
			nodeStack = new LinkedStack<>();
			currentNode = root;
		} // end default constructor

		public boolean hasNext() {
			return !nodeStack.isEmpty() || (currentNode != null);
		} // end hasNext

		public T next() {	
		    BinaryNode<T> nextNode = null;
				
		    while (currentNode != null) {
			    nodeStack.push(currentNode);
			    BinaryNode<T> leftChild = currentNode.getLeftChild();
			    if (leftChild == null)	
			    	currentNode = currentNode.getRightChild();
			    else
			    	currentNode = leftChild;
			} // end while
				
		    if (!nodeStack.isEmpty()) {
			    nextNode = nodeStack.pop();
			    assert nextNode != null; // Since nodeStack was not empty
                						 // before the pop
			    BinaryNode<T> tempNode = nodeStack.peek();
					
			    if (tempNode != null && nextNode == tempNode.getLeftChild())
			    	currentNode = tempNode.getRightChild();	
			    else
			    	currentNode = null;
			    
			} else {
			    throw new NoSuchElementException();
			}
		    
		    return nextNode.getData();
		} // end next

		public void remove() {
			throw new UnsupportedOperationException();
		} // end remove
		
	} // end PostorderIterator

	private class LevelOrderIterator implements Iterator<T> {	
		private QueueInterface<BinaryNode<T>> nodeQueue;
		
		public LevelOrderIterator() {
			nodeQueue = new LinkedQueue();
			if (root != null)
				nodeQueue.enqueue(root);
	    }
		
		public boolean hasNext() {
			return !nodeQueue.isEmpty();
		}
		
		public T next() {
			BinaryNode<T> nextNode;
			
			if (hasNext()) {
				nextNode = nodeQueue.dequeue();
				BinaryNode<T> leftChild = nextNode.getLeftChild();
				BinaryNode<T> rightChild = nextNode.getRightChild();
				
				if (leftChild != null)
					nodeQueue.enqueue(leftChild);

				if (rightChild != null)
					nodeQueue.enqueue(rightChild);
				
			} else {
				throw new NoSuchElementException();
			}
		
			return nextNode.getData();
		}
	
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
    } // end LevelOrderIterator
	
	public static void main(String[] args) {
		BinaryTree<String> leafK = new BinaryTree<String>("K");
		BinaryTree<String> leafJ = new BinaryTree<String>("J");
		BinaryTree<String> leafI = new BinaryTree<String>("I");
		BinaryTree<String> leafH = new BinaryTree<String>("H");
		BinaryTree<String> leafG = new BinaryTree<String>("G");
		BinaryTree<String> leafF = new BinaryTree<String>("F");

		BinaryTree<String> nodeE = new BinaryTree<String>("E", leafJ, leafK);
		BinaryTree<String> nodeD = new BinaryTree<String>("D", leafH, leafI);
		BinaryTree<String> nodeC = new BinaryTree<String>("C", leafF, leafG);
		BinaryTree<String> nodeB = new BinaryTree<String>("B", nodeD, nodeE);
		BinaryTree<String> nodeA = new BinaryTree<String>("A", nodeB, nodeC);

		Iterator pre = nodeA.getPreorderIterator();
		Iterator in = nodeA.getInorderIterator();
		Iterator post = nodeA.getPostorderIterator();
		Iterator level = nodeA.getLevelOrderIterator();
		
		System.out.println("Pre Order");
		System.out.println(pre.next());
		System.out.println(pre.next());
		System.out.println(pre.next());
		System.out.println(pre.next());
		System.out.println(pre.next());
		System.out.println(pre.next());
		System.out.println(pre.next());
		System.out.println("In Order");
		System.out.println(in.next());
		System.out.println(in.next());
		System.out.println(in.next());
		System.out.println(in.next());
		System.out.println(in.next());
		System.out.println(in.next());
		System.out.println(in.next());
		System.out.println("Post Order");
		System.out.println(post.next());
		System.out.println(post.next());
		System.out.println(post.next());
		System.out.println(post.next());
		System.out.println(post.next());
		System.out.println(post.next());
		System.out.println(post.next());
		System.out.println("Level Order");
		System.out.println(level.next());
		System.out.println(level.next());
		System.out.println(level.next());
		System.out.println(level.next());
		System.out.println(level.next());
		System.out.println(level.next());
		System.out.println(level.next());
	}
	
}
