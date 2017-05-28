/**
 * @author Sebastian Kleinerman
 * @class Java 111C
 * @title Tester.java
 */

public class Tester 
{
	public static void main(String[] args)
	{
		BagInterface<String> aBag = new ResizableArrayBag<String>(3);
		System.out.println("Testing to see if aBag is empty: " + aBag.isEmpty());
		System.out.println("The current size of the bag is: " + aBag.getCurrentSize());
		
		System.out.println();
		System.out.println("Adding to the bag more strings than its initial capacity.");
	    String[] contentsOfBag = {"A", "D", "B", "A", "C", "A", "D", "1"};
	    for(int i = 0; i < contentsOfBag.length; i++)
	    {
	    	aBag.add(contentsOfBag[i]);
	    }
	    System.out.print("Current contents of the bag: ");
	    for (int index = 0; index < contentsOfBag.length; index++)
		{
         System.out.print(contentsOfBag[index] + " ");
		}
	    System.out.println();
	    System.out.println("The current size of the bag is: " + aBag.getCurrentSize());
	    
	    System.out.println();
	    System.out.println("Does the bag contain 'A'?: " + aBag.contains("A"));
	    System.out.println("How many times does 'A' appear in the bag?: " + aBag.getFrequencyOf("A"));
	    System.out.println("Removing the strings 'A', 'D', 'C'");
	    aBag.remove("A"); aBag.remove("D"); aBag.remove("C");
	    System.out.println("The current size of the bag is: " + aBag.getCurrentSize());
	    System.out.println("How many times does 'A' appear in the bag?: " + aBag.getFrequencyOf("A"));
	    System.out.println("How many times does 'D' appear in the bag?: " + aBag.getFrequencyOf("D"));
	}

}
