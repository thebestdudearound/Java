import java.text.DecimalFormat;

/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: The Student class creates instances of students with specified names, addresses, and three test scores. 
 * The average() method calculates a specific student's average from the three scores, 
 * and then it will display each address instance with the toString() method.
 * Due Date: 10/07/2015
 * Name: Sebastian Kleinerman
 * File Name: Student.java
 * Assignment #4
 */

public class Student
{
   private String firstName, lastName;
   private Address homeAddress, schoolAddress;
   private int test1, test2, test3;
   private double examAverage;
   private final int num1 = 1;
   private final int num2 = 2;
   private final int num3 = 3;
   
   DecimalFormat twoD = new DecimalFormat("##.##");
   //-----------------------------------------------------------------
   //  Constructor: Sets up this student with the specified values.
   //-----------------------------------------------------------------
   public Student(String first, String last, Address home,
                  Address school, int test1Score, int test2Score, int test3Score)
   {
      firstName = first;
      lastName = last;
      homeAddress = home;
      schoolAddress = school;
      test1 = test1Score;
      test2 = test2Score;
      test3 = test3Score;
   }
   
   public Student(int test1Score, int test2Score, int test3Score)
   {
	  test1 = test1Score = 0;
	  test2 = test2Score = 0;
	  test3 = test3Score = 0;
   }
   
   public void setTestScore(int testNumber, int testScore)
   {
	   switch(testNumber)
	   {
	   		case num1:
	   		   test1 = testScore;
	   		   break;
	   		case num2:
	 		   test2 = testScore;
	 		   break;
	   		case num3:
	 		   test3 = testScore;
	 		   break;
	 		default:
	   }
   }
   
   public int getTestScore(int testNumber)
   {
	   switch(testNumber)
	   {
	   		case num1:
	   		   return test1;
	   		case num2:
	 		   return test2;
	   		case num3:
	 		   return test3;
	 		default:
	   }
	   return 0;
   }
   
   public double average()
   {
	   double testAverage = (test1 + test2 + test3)/3.0;
	   return testAverage;
   }
   
   //-----------------------------------------------------------------
   //  Returns a string description of this Student object.
   //-----------------------------------------------------------------
   public String toString()
   {
      String result;

      result = "----------------------------\n" + firstName + " " + lastName + "\n----------------------------";
      result += "\nHome Address:\n" + homeAddress + "\n";
      result += "\nSchool Address:\n" + schoolAddress + "\n";
      result += "\nTest 1 Score: " + test1 + "\n";
      result += "Test 2 Score: " + test2 + "\n";
      result += "Test 3 Score: " + test3 + "\n";
      result += "Average test score: " + twoD.format(average()) + "\n";
      
      return result;
   }
}
