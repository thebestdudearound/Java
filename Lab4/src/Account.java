//*******************************************************
// Account.java
//
// A bank account class with methods to deposit to, withdraw from,
// change the name on, charge a fee to, and return a string
// representation of the account.
//*******************************************************

public class Account
{
  private double balance;
  private String name;
  private long acctNum;
  private int numberTransactions;

  //----------------------------------------------
  //Constructor -- initializes balance, owner, and account number
  //----------------------------------------------
  public Account(double initBal, String owner, long number)
  {
	  balance = initBal;
	  name = owner;
	  acctNum = number;
	  numberTransactions = 0;
  }

  //----------------------------------------------
  // Checks to see if balance is sufficient for withdrawal.
  // If so, decrements balance by amount; if not, prints message.
  //----------------------------------------------
  public void withdraw(double amount)
  {
	  if(balance >= amount)
	  {	  
		  balance -= amount;
	  	  numberTransactions++;
	  }	  
	  else
		  System.out.println("Insufficient funds.");
   }

  //----------------------------------------------
  // Adds deposit amount to balance.
  //----------------------------------------------
  public void deposit(double amount)
  {
	  if(amount > 0)
	  {
		  balance += amount;
		  numberTransactions++;
	  }	  
	  else
		  System.out.println("Amount should be positive");
  }

  //----------------------------------------------
  // Returns balance.
  //----------------------------------------------
  public double getBalance()
  {
	  return balance;
  }


  //----------------------------------------------
  // Returns a string containing the name, account number, and balance
  //----------------------------------------------
  public String toString()
  {
	  return "Name: " + name + "\nAccount Number: " + acctNum + 
			 "\nBalance: " + balance + "\nNumber of Transactions: " + numberTransactions;
  }


  //----------------------------------------------------
  // *** ADD CODE in the body of the chargeFee method
  // *** DELETE these instructions and add appropriate
  // documentation for the  method.
  //  Deducts $10 service fee 
  //----------------------------------------------------
  public double chargeFee()
  {
	  balance -= 10;
	  return balance;
  }

   //----------------------------------------------------
   // *** ADD CODE in the body of the changeName method
   // *** DELETE these instructions and add appropriate
   // documentation for the  method.
   //----------------------------------------------------


  public void changeName(String newName)
  {    
	  name = newName;
  }
  
  //Method to return number of transactions
  public int getTransactions()
  {
	  return numberTransactions;
  }

}

