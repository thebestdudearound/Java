/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: The Person class creates a Person object and keeps track of how many people are created.
 * Due Date: 10/23/2015
 * Name: Sebastian Kleinerman
 * File Name: Person.java
 * Assignment #6
 */

public class Person
{
	private String name;
	private static int numberOfPeople = 0;
	
	
    public Person()
    {
    	numberOfPeople++;
    }
    public Person(String theName)
    {
    	name = theName;
    	numberOfPeople++;
    }
    public Person(Person theObject)
    {
    	Person person = theObject;
    	numberOfPeople++;
    }
    public String getName()
    {
    	return name;
    }
    public void setName(String theName)
    {
    	name = theName;
    }
    public String toString()
    {
    	String pers = getName();
    	return pers;
    }
    public boolean equals(Person person, Person person2)
    {   		
    	if(person.getName().equalsIgnoreCase(person2.getName()))
    	{	
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    } 
}