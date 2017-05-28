/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: Creates shape according to type chosen by user
 * Due Date: 11/02/2015
 * Name: Henry Goldman & Sebastian Kleinerman
 * File Name: Shape.java
 * Lab #9
 */

public abstract class Shape 
{
	private String shapeName;
	
	abstract public double area();
	
	public Shape(String shapeType)
	{
		shapeName = shapeType;
	}
	
	public String toString(String shape)
	{
		shapeName = shape;
		return shape;
	}
}
