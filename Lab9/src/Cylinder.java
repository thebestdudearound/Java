/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: Represents a cylinder.
 * Due Date: 11/02/2015
 * Name: Henry Goldman & Sebastian Kleinerman
 * File Name: Cylinder.java
 * Lab #9
 */

public class Cylinder extends Shape 
{

	private double height, radius;
	
	public Cylinder(double r, double h) 
	{
		super("Cylinder");
		radius = r;
		height = h;
	}
	
	public double area()
	{
		double area = (Math.PI*radius*radius*height);
		return area;
	}
	
	public String toString()
	{
		return super.toString() + " of radius " + radius + " height " + height;
	}

}
