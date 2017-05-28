import java.util.*;
/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: The Course class creates instances of courses that include an array list of students in the course. 
 * There are methods to add a student, drop a student, and find the class's overall test average, 
 * and it will also display each address instance with the toString() method.
 * Due Date: 10/07/2015
 * Name: Sebastian Kleinerman
 * File Name: Course.java
 * Assignment #4
 */

public class Course 
{
	private String courseName;
	private int test1, test2, test3;
	
	Student stud = new Student(test1, test2, test3);
	public ArrayList<Student> list = new ArrayList<Student>();

	
	public Course(String course)
	{
		courseName = course;
	}
	
	public void addStudent(Student student1)
	{
		stud = student1;
		list.add(stud);
	}
	
	public void dropStudent(Student student1)
	{
		stud = student1;
		list.remove(stud);
	}
	
	public double average()
	{
		double average = 0.0;
		double sum = 0.0;
		for(Student stud : list)
		{
			sum += stud.average();
		}
		average = (sum / (double)list.size());
		return average;
	}
	
	public void roll()
	{
		System.out.println(courseName + " Class Roll");
		
		for(Student stud : list)
		{
			System.out.println(stud.toString());
		}
	}
	
}