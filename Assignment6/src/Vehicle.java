/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: The Vehicle class creates a Vehicle object with the manufacturer's name, number of cylinders, and who the owner is
 * Due Date: 10/23/2015
 * Name: Sebastian Kleinerman
 * File Name: Vehicle.java
 * Assignment #6
 */

public class Vehicle 
{
	private String manufName;
	private int cylNumber;
	private Person owner = new Person();

	public Vehicle(String manufacturer, int cylinders, Person driver)
	{
		manufName = manufacturer;
		cylNumber = cylinders;
		owner = driver;
	}
	
	public Vehicle(double towCapacity, int cylinders)
	{
		cylNumber = cylinders;
	}
	
	public void setManufacturerName(String manufacturer)
	{
		manufName = manufacturer;
	}
	public String getManufacturerName()
	{
		return manufName;
	}
	
	public void setCylinderNumber(int cylinders)
	{
		cylNumber = cylinders;
	}
	public int getCylinderNumber()
	{
		return cylNumber;
	}
	
	public void setOwner(Person driver)
	{
		owner = driver;
	}
	public Person getOwner()
	{
		return owner;
	}
	public String toString()
	{
		String vehicle = getManufacturerName() + ", " + getCylinderNumber() + " cylinders" + ", owned by " + getOwner();
		return vehicle;
	}
}
