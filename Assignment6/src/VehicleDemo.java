/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: The VehicleDemo class demonstrates how the Person, Vehicle and Truck classes work.
 * Due Date: 10/23/2015
 * Name: Sebastian Kleinerman
 * File Name: VehicleDemo.java
 * Assignment #6
 */

public class VehicleDemo 
{
	public static void main(String[] args)
	{
		Person p1 = new Person("");
		
		System.out.println("p1:	 "  + p1);
		p1.setName("Bob");
		System.out.println("p1's name is: " + p1);
			
		Person p2 = new Person("Joe");
		System.out.println("p2: " + p2);
		
		Person p3 = p1;
		System.out.println("p3: " + p3);
		
		System.out.println("p3 equal to p1: " + p3.equals(p1));
		System.out.println("p2 equal to p1: " + p2.equals(p1));
		
		Person p4 = new Person("");
		Vehicle v1 = new Vehicle("None", 4, p4);
		System.out.println("v1: " + v1.toString());
		v1.setOwner(p2);
		v1.setManufacturerName("Ford");
		
		System.out.println("v1's manufacturer is: " + v1.getManufacturerName());
		System.out.println("v1's cylinders: " + v1.getCylinderNumber());
		System.out.println("v1's owner is: " + v1.getOwner());
		
		p4.setName("Betty");
		Vehicle v2 = new Vehicle("Chevy", 4, p4);
		Vehicle v3 = v1;
		System.out.println("v2: " + v2);
		System.out.println("v3: " + v3);
		
		System.out.println("v3 equal to v1: " + (v3.equals(v1)));
		System.out.println("v2 equal to v1: " + (v2.equals(v1)));
		
		Person p5 = new Person("");
		
		Truck truck1 = new Truck("None", 0, p5, 0.0, 0);
		System.out.println("t1: " + truck1.toString());
		truck1.setLoadCapacity(54.36);
		truck1.setTowingCapacity(10);
		System.out.println("t1's load capacity: " + truck1.getLoadCapacity());
		System.out.println("t1's towing capacity: " + truck1.getTowingCapacity());
		Truck truck2 = new Truck("Chevy", 4, p4, 34.5, 65);
		System.out.println("t2: " + truck2.toString());
		
		Truck truck3 = truck1;
		System.out.println("t3: " + truck3.toString());
		System.out.println("t3 equals t1: " + truck3.equals(truck1));
		System.out.println("t2 equals t1: " + truck2.equals(truck1));
	}
}