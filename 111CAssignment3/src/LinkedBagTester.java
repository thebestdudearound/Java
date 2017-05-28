/**
 * @author Sebastian Kleinerman
 * @class Java 111C
 * @title LinkedBagTester.java
 */

public class LinkedBagTester {

	public static void main(String[] args) 
	{
      System.out.println("Creating an empty bag.");
      BagInterface<String> aBag = new LinkedBag<>();
      BagInterface<String> anotherBag = new LinkedBag<>();
      testIsEmpty(aBag, true);
		displayBag(aBag);
      
      String[] contentsOfBag = {"A", "D", "B", "A", "C", "A", "Z"};
		testAdd(aBag, contentsOfBag);
		testIsEmpty(aBag, false);
		
	  String[] contentsOfBag2 = {"A", "D", "B", "A", "C", "A", "E", "X"};
	    testAdd(anotherBag, contentsOfBag2);
	  
	  System.out.println("\nTest 1: equals method: " + aBag.equals(anotherBag));
	  System.out.println("Should output: true");
	  displayBag(aBag);
	  displayBag(anotherBag);
	  System.out.println("The bag's current size: " + aBag.getCurrentSize());
	  System.out.println("The bag's current size: " + anotherBag.getCurrentSize());
	}
   
   // Tests the method isEmpty.
   // Precondition: If the bag is empty, the parameter empty should be true;
   // otherwise, it should be false.
	private static void testIsEmpty(BagInterface<String> bag, boolean empty)
   {
      System.out.print("\nTesting isEmpty with ");
      if (empty)
         System.out.println("an empty bag:");
      else
         System.out.println("a bag that is not empty:");
      
      System.out.print("isEmpty finds the bag ");
      if (empty && bag.isEmpty())
			System.out.println("empty: OK.");
		else if (empty)
			System.out.println("not empty, but it is: ERROR.");
		else if (!empty && bag.isEmpty())
			System.out.println("empty, but it is not empty: ERROR.");
		else
			System.out.println("not empty: OK.");      
	}
	
	private static void testAdd(BagInterface<String> aBag, String[] content)
	{
		System.out.print("Adding the following " + content.length +
                       " strings to the bag: ");
		for (int index = 0; index < content.length; index++)
		{
			if (aBag.add(content[index]))
            System.out.print(content[index] + " ");
         else
            System.out.print("\nUnable to add " + content[index] +
                             " to the bag.");
		}
		System.out.println();
		displayBag(aBag);
	}
   
   // Tests the method toArray while displaying the bag.
	private static void displayBag(BagInterface<String> aBag)
	{
		System.out.println("The bag contains the following string(s):");
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++)
		{
			System.out.print(bagArray[index] + " ");
		}
		
		System.out.println();
	}	
}