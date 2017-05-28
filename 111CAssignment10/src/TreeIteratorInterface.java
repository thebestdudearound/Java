import java.util.Iterator;

/**
 * 
 * @author Sebastian Kleinerman
 * @class Java 111C
 *
 */

public interface TreeIteratorInterface<T>
{
   public Iterator<T> getPreorderIterator();
   public Iterator<T> getPostorderIterator();
   public Iterator<T> getInorderIterator();
   public Iterator<T> getLevelOrderIterator();
} // end TreeIteratorInterface
