// ***************************************************************
//   Shop.java
//
//   Uses the Item class to create items and add them to a shopping
//   cart stored in an ArrayList.
// ***************************************************************

import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Scanner;

public class Shop
{
	public static void main (String[] args)
    {
		// *** Declare and instantiate a variable cart to be an empty ArrayList.
		ArrayList<Item> cart = new ArrayList<Item>();
	
		Item item;
		String itemName;
		double itemPrice;
		int quantity;
		double totalPrice = 0.0;
		double price = 0.0;

		Scanner scan = new Scanner (System.in);
		NumberFormat fmt = NumberFormat.getCurrencyInstance();

		String keepShopping = "y";
		// *** Fill in the statements in the loop to add an item to the cart and to print the cart contents 
		do 
	    {
			System.out.print("Enter the name of the item: ");
			itemName = scan.next();
			
			System.out.print("Enter the unit price: ");
			itemPrice = scan.nextDouble();
			
			System.out.print("Enter the quantity: ");
			quantity = scan.nextInt();
      
			// *** create a new item and add it to the cart
			item = new Item(itemName, itemPrice, quantity);
			cart.add(item);
			System.out.println("\nCurrent Cart");

			// *** print the contents of the cart object
			for(int i = 0; i < cart.size(); i++)
			{
				Item item1 = cart.get(i);
				System.out.println(item1.toString());
				price = item1.getPrice() * item1.getQuantity();
			}
			totalPrice += price;
			
			System.out.println("The total price is: " + fmt.format(totalPrice));
			System.out.println();
			
			System.out.print("Continue shopping?(y/n) ");
			Scanner keyboard = new Scanner(System.in);
			keepShopping = keyboard.nextLine();
			
	    } while (keepShopping.equals("y"));

    }
}

