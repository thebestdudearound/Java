/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: Represents a rectangle
 * Due Date: 11/02/2015
 * Name: Henry Goldman & Sebastian Kleinerman
 * File Name: Rectangle.java
 * Lab #9
 */

public class Rectangle extends Shape 
{
	private double length, width;
	
	public Rectangle(double l, double w)
	{
		super("Rectangle");
		length = l;
		width = w;
	}
	
	public double area()
	{
		double area = (length * width);
		return area;
	}
	
	public String toString()
	{
		return super.toString() + " of length " + length + " and width " + width;
	}

}
