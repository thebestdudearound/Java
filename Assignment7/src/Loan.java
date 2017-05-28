import javax.swing.JOptionPane;

/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: This class creates a Loan which includes a loan number, customer last name, amount of loan, interest rate and term.
 * Due Date: 11/04/2015
 * Name: Sebastian Kleinerman
 * File Name: Loan.java
 * Assignment #7
 */

public abstract class Loan implements LoanConstants
{
	private int loanNumber;
	private String lastName;
	private double loanAmount;
	private int loanTerm;
	public double interestRate = 0;
	
	//Constructor accepts loan number, name of customer, loan amount and the term.
	public Loan(int number, String name, double amount, int term)
	{
		loanNumber = number;
		lastName = name;
		loanAmount = amount;
		loanTerm = term;
		
		//Makes sure loan amount is not greater than the max amount.
		if(amount > maxLoanAmount)
		{
			JOptionPane.showMessageDialog(null, "loan amount cannot be over $100,000");
			loanAmount = 0.0;
		}
		
		//Checks to see if it is a short term, medium term or long term. If it's not either, then it automatically makes it a short term.
		if(loanTerm != shortTerm && loanTerm != medTerm && loanTerm != longTerm)
		{
			loanTerm = shortTerm;
		}
	}
	
	//Mutator method to set account number.
	public void setAccountNumber(int accountNumber)
	{
		loanNumber = accountNumber;
	}
	
	//Mutator method to set customer's name.
	public void setAccountName(String name)
	{
		lastName = name;
	}
	
	//Mutator method to set loan amount.
	public void setLoanAmount(double amount)
	{
		loanAmount = amount;
	}
	
	//Mutator method to set interest rate.
	public void setInterestRate(double rate)
	{
		interestRate = rate;
	}
	
	//Mutator method to set term.
	public void setTerm(int term)
	{
		loanTerm = term;
	}
	
	//Accessor method to return term.
	public int getTerm()
	{
		return loanTerm;
	}
	
	//toString method to display all information in a Loan object.
	public String toString()
	{
		String account = "Loan #" + loanNumber + " Name:" + lastName + loanAmount + "\n for " + loanTerm + "year(s) at " + interestRate + " interest";
		return account;
	}
}