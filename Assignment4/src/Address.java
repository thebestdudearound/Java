/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: The Address class allows the user to create instances of addresses with specified data, as well as display each address instance with the toString() method.
 * Due Date: 10/07/2015
 * Name: Sebastian Kleinerman
 * File Name: Address.java
 * Assignment #4
 */

public class Address
{
   private String streetAddress, city, state;
   private long zipCode;

   //-----------------------------------------------------------------
   //  Constructor: Sets up this address with the specified data.
   //-----------------------------------------------------------------
   public Address(String street, String town, String st, long zip)
   {
      streetAddress = street;
      city = town;
      state = st;
      zipCode = zip;
   }

   //-----------------------------------------------------------------
   //  Returns a description of this Address object.
   //-----------------------------------------------------------------
   public String toString()
   {
      String result;

      result = streetAddress + "\n";
      result += city + ", " + state + "  " + zipCode;

      return result;
   }
}
