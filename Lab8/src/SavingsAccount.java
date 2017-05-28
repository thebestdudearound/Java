/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: The SavingsAccount class is a class that extends the BankAccount class and calculates interest gained.
 * Due Date: 10/19/2015
 * Name: Henry Goldman & Sebastian Kleinerman
 * File Name: SavingsAccount.java
 * Lab #8
 */

public class SavingsAccount extends BankAccount
{
	private final double RATE = .025;
	private int savingsNumber = 0;
	private String accountNumber;
	
	public SavingsAccount(String name, double amount)
	{
		super(name, amount);
		accountNumber = "";
	}
			
	
	public SavingsAccount(SavingsAccount oldAccount, double amount)
	{   	
		super(oldAccount,amount); 
		savingsNumber+=1;
	}

	public void postInterest()
	{
		double balance = getBalance();
		balance = (balance * (RATE/12));
		deposit(balance);	 
	}   
	
	public String getAccountNumber()
	{
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
		
		return accountNumber;
	}
	
}
