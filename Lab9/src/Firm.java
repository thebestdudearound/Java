/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: Demonstrates polymorphism via inheritance.
 * Due Date: 11/02/2015
 * Name: Henry Goldman & Sebastian Kleinerman
 * File Name: Firm.java
 * Lab #9
 */

public class Firm
{
   //-----------------------------------------------------------------
   //  Creates a staff of employees for a firm and pays them.
   //-----------------------------------------------------------------
   public static void main(String[] args)
   {
      Staff personnel = new Staff();

      personnel.payday();
   }
}
