/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: This class sets the interest rate to 1 percent over the current prime interest rate.
 * Due Date: 11/04/2015
 * Name: Sebastian Kleinerman
 * File Name: BusinessLoan.java
 * Assignment #7
 */

public class BusinessLoan extends Loan
{
	//Constructor accepts loan number, name of customer, loan amount and the term and adds .01 to the current prime interest rate.
	public BusinessLoan(int number, String name, double amount, int term)
	{
		super(number, name, amount, term);
		super.interestRate = super.interestRate + .01;
	}
	
	//Mutator method to set the interest rate.
	public void setInterest(double interest)
	{
		super.interestRate = interest + .01;
	}
	
	//Accessor method to return interest rate.
	public double getInterest()
	{
		return super.interestRate;
	}
}
