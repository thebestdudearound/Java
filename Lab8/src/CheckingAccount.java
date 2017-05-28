/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: The CheckingAccount class is a class that extends the BankAccount class. 
 * Due Date: 10/19/2015
 * Name: Henry Goldman & Sebastian Kleinerman
 * File Name: CheckingAccount.java
 * Lab #8
 */

public class CheckingAccount extends BankAccount
{
	private static final double FEE = 0.15;
	private String accountNumber;
	
	public CheckingAccount(String name, double amount)
	{
		super(name, amount);
		
		accountNumber = getAccountNumber().concat("-10");
		setAccountNumber(accountNumber);
	}

	 public boolean withdraw(double amount)
	   {
		  boolean completed = true;
	      double checkedAmount = amount + FEE;
	      
	      super.withdraw(checkedAmount);
	      
	      return completed;
	   }
}

