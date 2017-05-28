/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: Represents an item in a shopping cart.
 * Due Date: 10/12/2015
 * Name: Henry Goldman & Sebastian Kleinerman
 * File Name: Item.java
 * Lab #7 
 */

import java.text.NumberFormat;

public class Item
{
    private String name;
    private double price;
    private int quantity;

    // -------------------------------------------------------
    //  Create a new item with the given attributes.
    // -------------------------------------------------------
    public Item(String itemName, double itemPrice, int numPurchased)
    {
    	name = itemName;
    	price = itemPrice;
    	quantity = numPurchased;
    }

    // -------------------------------------------------------
    //   Return a string with the information about the item
    // -------------------------------------------------------
    public String toString()
    {
    	NumberFormat fmt = NumberFormat.getCurrencyInstance();
    	String item;
    	if (name.length() >= 8)
    		item = name + "\t";
    	else
    		item = name + "\t\t";
    	return (item + "   " + fmt.format(price) + "\t    " + quantity 
    			+ "\t\t" + fmt.format(price*quantity));
    }

    // -------------------------------------------------
    //   Returns the unit price of the item
    // -------------------------------------------------
    public double getPrice()
    {
    	return price;
    }

    // -------------------------------------------------
    //   Returns the name of the item
    // -------------------------------------------------
    public String getName()
    {
    	return name;
    }

    // -------------------------------------------------
    //   Returns the quantity of the item
    // -------------------------------------------------
    public int getQuantity()
    {
    	return quantity;
    }
}  

