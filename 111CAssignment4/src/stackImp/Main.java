package stackImp;

/**
 * @author Sebastian Kleinerman
 * @class Java 111C
 * @title Main.java
 */

public class Main 
{	
	public static void main(String[] args) 
	{

		StackInterface<String> stack = new ArrayStack<>();
		StackInterface<String> stack1 = new LinkedStack<>();
		
		//Test for ArrayStack
		System.out.println("ArrayStack: ");
		stack.push("S");
		stack.push("K");
		stack.push("V");	
		System.out.println(stack.peek2() + " is second in the stack.");
		System.out.println(stack.toString());
		
		stack.remove(2);
		System.out.println(stack.toString());
		
		String[] s = {"0", "3", "1", "8"};
		stack.pushAll(s);
		System.out.println(stack.toString());
		
		System.out.println();
		
		//Test for LinkedStack
		System.out.println("LinkedStack: ");
		stack1.push("I");
		stack1.push("D");
		stack1.push("K");
		System.out.println(stack1.peek2() + " is second in the stack.");
		System.out.println(stack1.toString());
		
		stack1.remove(2);
		System.out.println(stack1.toString());
		
		String[] s1 = {"1", "9", "9", "6"};
		stack1.pushAll(s1);
		System.out.println(stack1.toString());
		
	}

}
