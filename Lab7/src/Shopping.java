/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: Creates a cart object from the ShoppingCart class and allows the user to input several items with their prices and quantites.
 * Due Date: 10/12/2015
 * Name: Henry Goldman & Sebastian Kleinerman
 * File Name: Shopping.java
 * Lab #7 
 */
import java.util.Scanner;

public class Shopping 
{
	public static void main(String[] args)
	{
		String itemName;
		double itemPrice;
		int quantity;
		String response;
		
		ShoppingCart cart = new ShoppingCart();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the name of the first item: ");
		itemName = scan.nextLine();
		do
		{	
			System.out.print("Enter the quantity: ");
			quantity = scan.nextInt();
			
			System.out.print("Enter the price: ");
			itemPrice = scan.nextDouble();
			
			cart.addToCart(itemName, itemPrice, quantity);
			
			System.out.print("Enter the name of the next Item or Q to quit: ");
			response = itemName = scan.next(); 
		
		}
		while(!response.equalsIgnoreCase("Q"));
		
		System.out.println(cart.toString());
	}	
}