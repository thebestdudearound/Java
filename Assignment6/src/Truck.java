/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: The Truck class creates a Vehicle object that can accept its load capacity, tow capacity, brancd, number of cylinders, and the Person driving it.
 * Due Date: 10/23/2015
 * Name: Sebastian Kleinerman
 * File Name: Truck.java
 * Assignment #6
 */

public class Truck extends Vehicle
{
	private double loadCapacity;
	private int towCapacity;
	
	public Truck(double load, int towing)
	{
		super(load, towing);
		
		loadCapacity = load;
		towCapacity = towing;
	}
	
	public Truck(String brand, int cylinders, Person p1) 
	{
		super(brand, cylinders, p1);
	}
	public Truck(String brand, int cylinders, Person p1, double load, int towing)
	{
		super(brand, cylinders, p1);
		loadCapacity = load;
		towCapacity = towing;
	}

	public double getLoadCapacity()
	{
		return loadCapacity;
	}
	public void setLoadCapacity(double load)
	{
		loadCapacity = load;
	}
	
	public int getTowingCapacity()
	{
		return towCapacity;
	}
	public void setTowingCapacity(int towing)
	{
		towCapacity = towing;
	}
	
	public String toString()
	{
		String truck = getManufacturerName() + ", " + getCylinderNumber() + " cylinders" + ", owned by " + getOwner() + ", load capacity " + getLoadCapacity() + ", towing capacity " + getTowingCapacity();
		return truck;
	}
}
