import java.util.*;

/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: This class includes constant values for a short-term loan, a medium-term loan, and a long-term loan as well as company name and maximum loan amount.
 * Due Date: 11/04/2015
 * Name: Sebastian Kleinerman
 * File Name: LoanConstants.java
 * Assignment #7
 */

public interface LoanConstants 
{
	Scanner scan = new Scanner(System.in);
	
	final double maxLoanAmount = 100000;
	final int shortTerm = 1;
	final int medTerm = 3;
	final int longTerm = 5;
	final String companyName = scan.next();
	
}