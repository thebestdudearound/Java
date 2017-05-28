/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: A bank account class with methods to deposit, withdraw, and check the balance.
 * Due Date: 10/05/2015
 * Name: Henry Goldman & Sebastian Kleinerman
 * File Name: Account.java
 * Lab #6
 */

import java.util.*;

public class Account
{
	private double balance;
    private String name;
    private long acctNum;
	private static int numAccounts;
	
	Random generator = new Random();
    
  //----------------------------------------------
  //Constructor -- initializes balance and owner; generates random
  //account number
  //----------------------------------------------
  public Account(double initBal, String owner, long number)
  {
    balance = initBal;
    name = owner;
    acctNum = number;
    numAccounts++;
  }
  
  public Account(double initBal, String owner)
  {
	 balance = initBal;
	 name = owner;
	 acctNum = Math.abs(generator.nextLong());
	 numAccounts++;
  }
  
  public Account(String owner)
  {
	 balance = 0;
	 name = owner;
	 acctNum = Math.abs(generator.nextLong());
	 numAccounts++;
  }

  //----------------------------------------------
  // Checks to see if balance is sufficient for withdrawal.
  // If so, decrements balance by amount; if not, prints message.
  //----------------------------------------------
  public void withdraw(double amount)
  {
    if (balance >= amount)
       balance -= amount;
    else
       System.out.println("Insufficient funds");

  }

  //----------------------------------------------
  // Checks to see if balance is sufficient for withdrawal.
  // If so, decrements balance by amount; if not, prints message.
  // Also deducts fee from account.
  //----------------------------------------------
  public void withdraw(double amount, double fee)
  {
    if (balance >= amount)
	{
	    balance -= amount;
	    balance -= fee;
	}
    else
       System.out.println("Insufficient funds");

  }

  //----------------------------------------------
  // Adds deposit amount to balance.
  //----------------------------------------------
  public void deposit(double amount)
  {
    balance += amount;
  }
  
  //----------------------------------------------
  // Returns balance.
  //----------------------------------------------
  public double getBalance()
  {
    return balance;
  }

  //----------------------------------------------
  // Returns account number
  //----------------------------------------------
  public double getAcctNumber()
  {
    return acctNum;
  }

  //----------------------------------------------
  // Returns a string containing the name, acct number, and balance.
  //----------------------------------------------

  public String toString()
  {
	return "Name: " + name + 
	    "\nAcct #: " + acctNum + 
	    "\nBalance: " + balance;
  }
  
  public String getName()
  {
	  return name;
  }
  
  public void close()
  {
	  name = " CLOSED";
	  balance = 0;
	  numAccounts--;
  }
  
  public static Account consolidate(Account acct1, Account acct2)
  {  
	  Account acctCons = null;
	  if (acct1.getName() == (acct2.getName()))
	  {
		  acctCons = new Account(acct1.getBalance() + acct2.getBalance(), acct1.getName());
		  acct1.close();
		  acct2.close();
		  numAccounts -= 2;
		  return acctCons;
	  }
	  else if (acct1.getAcctNumber() == acct2.getAcctNumber())
	  {
		  System.out.println("These account numbers are the same, cannot consolidate.");
		  acctCons = null;
	  } 
	  else if (acct1.getName() != acct2.getName())
	  {
		  System.out.println("Sorry, accounts with different names cannot be consolidated.");
		  acctCons = null;
	  }
	  return acctCons;
  }
  
  public static int getNumAccounts()
  {
	return numAccounts;
  }
  
  public void transfer(Account acct1, double amount)
  {
	  if(balance >= amount)
	  {
		  this.withdraw(amount);
		  acct1.deposit(amount);
	  }
	  else
		  System.out.println("Insufficient funds for transfer.");
  }
  
  public static void transfer(Account acct1, Account acct2, double amount)
  { 
	  if(acct1.balance >= amount)
	  {
		  acct1.withdraw(amount);
		  acct2.deposit(amount);
	  }
	  else
		System.out.println("Insufficient funds for transfer.");  
  }
}