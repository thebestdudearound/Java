import java.text.DecimalFormat;
/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: The School class creates an instance of courses, several students, and addresses with specified data, as well as display the course roll with the toString() method.
 * Due Date: 10/07/2015
 * Name: Sebastian Kleinerman
 * File Name: School.java
 * Assignment #4
 */

public class School 
{
	public static void main(String[] args)
	{
		DecimalFormat twoDec = new DecimalFormat("##.##");
		Course java = new Course("Java");
		
		Address school = new Address("50 Phelan ave.", "San Francisco", "California,", 94115);
		
		Address home1 = new Address("1 Seward st.", "San Francisco", "California", 94114);
		Student stud1 = new Student("Sebastian", "Kleinerman", home1, school, 100, 99, 97);
		
		Address home2 = new Address("4200 Post st.", "San Francisco", "California", 94123);
		Student stud2 = new Student("John", "Smith", home2, school, 75, 88, 78);
		
		Address home3 = new Address("366 Corona dr.", "San Francisco", "California", 94114);
		Student stud3 = new Student("Marsha", "Jones", home3, school, 100, 98, 94);
		
		Address home4 = new Address("3609 Banks cir.", "San Francisco", "California", 94113);
		Student stud4 = new Student("Jose", "Garcia", home4, school, 79, 85, 96);
		
		Address home5 = new Address("666 Mission st.", "San Francisco", "California", 94115);
		Student stud5 = new Student("Kayla", "Lewis", home5, school, 96, 98, 94);
		
		Address home6 = new Address("2011 Vallejo st.", "San Francisco", "California", 94123);
		Student stud6 = new Student("Tanya", "Dubinski", home6, school, 89, 86, 95);
		
		java.addStudent(stud1);
		java.addStudent(stud2);
		java.addStudent(stud3);
		java.addStudent(stud4);
		java.addStudent(stud5);
		java.addStudent(stud6);
		
		java.roll();
		System.out.println("Average test score for all tests: " + twoDec.format(java.average()));
		
	}
}
