/**
 * @author Sebastian Kleinerman
 * @class Java 111C
 * @title EmptyStackException.java
 */

public class EmptyQueueException extends RuntimeException 
{
	public EmptyQueueException()
	{
		this(null);
	}
	
	public EmptyQueueException(String message)
	{
		super(message);
	}

}
