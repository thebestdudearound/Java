/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: Represents a shopping cart as an array of items.
 * Due Date: 10/12/2015
 * Name: Henry Goldman & Sebastian Kleinerman
 * File Name: ShoppingCart.java
 * Lab #7 
 */

import java.text.NumberFormat;

public class ShoppingCart
{
    private int itemCount;      // total number of items in the cart
    private double totalPrice;  // total price of items in the cart
    private int capacity;    	// current cart capacity
    private Item[] cart;
    
    // -----------------------------------------------------------
    //  Creates an empty shopping cart with a capacity of 5 items.
    // -----------------------------------------------------------
    public ShoppingCart()
    {
	   capacity = 5;
	   itemCount = 0;
	   totalPrice = 0.0;
	   cart = new Item[capacity];
	}

    // -------------------------------------------------------
    //  Adds an item to the shopping cart.
    // -------------------------------------------------------
    public void addToCart(String itemName, double price, int quantity)
    {
    	if(itemCount == cart.length)
    		increaseSize();
    	cart[itemCount] = new Item(itemName, price, quantity);
    	itemCount++;
    	totalPrice += price*quantity;
    }

    // -------------------------------------------------------
    //  Returns the contents of the cart together with
    //  summary information.
    // -------------------------------------------------------
    public String toString()
    {
	   NumberFormat fmt = NumberFormat.getCurrencyInstance();

	   String contents = "\nShopping Cart\n";
	   contents += "\nItem\t\tUnit Price\tQuantity\tTotal\n";

	   for (int i = 0; i < itemCount; i++)
	       contents += cart[i].toString() + "\n";

	   contents += "\nTotal Price: " + fmt.format(totalPrice);
	   contents += "\nPlease pay..." + fmt.format(totalPrice);
	   contents += "\n";

	   return contents;
    }

    // ---------------------------------------------------------
    //  Increases the capacity of the shopping cart by 3
    // ---------------------------------------------------------
    private void increaseSize()
    {
    	capacity += 3;
    }

    // ---------------------------------------------------------
    //  Returns the total price of the items in the cart.
    // ---------------------------------------------------------
    public double getTotal()
    {
    	return totalPrice;
    }
}



