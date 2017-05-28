/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: This class sets the interest rate to 2 percent over the current prime interest rate.
 * Due Date: 11/04/2015
 * Name: Sebastian Kleinerman
 * File Name: PersonalLoan.java
 * Assignment #7
 */

public class PersonalLoan extends Loan 
{
	//Constructor accepts loan number, name of customer, loan amount and the term and adds .02 to the current prime interest rate.
	public PersonalLoan(int number, String name, double amount, int term)
	{
		super(number, name, amount, term);
		super.interestRate = super.interestRate + .02;
	}
	
	//Mutator method to set interest rate.
	public void setInterest(double interest)
	{
		super.interestRate = interest + .02;
	}
	
	//Accessor method to get interest rate.
	public double getInterest()
	{
		return super.interestRate;
	}
}
