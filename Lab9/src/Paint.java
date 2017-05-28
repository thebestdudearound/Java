/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: Represents a type of paint that has a fixed area
 * covered by a gallon. All measurements are in feet.
 * Due Date: 11/02/2015
 * Name: Henry Goldman & Sebastian Kleinerman
 * File Name: Paint.java
 * Lab #9
 */

public class Paint
{
    private double coverage;  //number of square feet per gallon

    //-----------------------------------------
    //  Constructor:  Sets up the paint object.
    //-----------------------------------------
    public Paint(double c)
    {
	coverage = c;
    }

    //---------------------------------------------------
    //  Returns the amount of paint (number of gallons)
    //  needed to paint the shape given as the parameter.
    //---------------------------------------------------
    public double amount(Shape s)
    {
   	System.out.println ("Computing amount for " + s);
	   double amount = s.area()/coverage;
	   return amount;
    }

}
