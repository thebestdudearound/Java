import javax.swing.JOptionPane;

/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: This class creates an array of five loans. It asks the user for the prime interest rate. 
 * Then, it asks for loan type and all information needed for the loan. The loans are stored in the array and then all loans are displayed.
 * Due Date: 11/04/2015
 * Name: Sebastian Kleinerman
 * File Name: CreateLoans.java
 * Assignment #7
 */

public class CreateLoans 
{
	public static void main(String[] args)
	{
		Loan[] list = new Loan[5];
		
		//Prompts user for prime interest rate.
		String interestRate = JOptionPane.showInputDialog(" Welcome to Sanchez Construction\n Enter the current prime interest rate\n as a decimal number, for example, .05"); 
		double rate = Double.parseDouble(interestRate) * 100;
		
		//for loop to create 5 Loan objects and store them into the array.
		for(int i = 0; i < 5; i++)
		{	
			//Asks user for type of loan.
			String loanType = JOptionPane.showInputDialog(" Is this a (1) Business loan\n or a (2) Personal loan?");
			int type = Integer.parseInt(loanType);
			
			//If loan is business type then the interest is calculated accordingly.
			if(type == 1)
			{	
				String accountNumber = JOptionPane.showInputDialog(" Enter account number");
				int accountNum = Integer.parseInt(accountNumber);
		
		
				String name = JOptionPane.showInputDialog("Enter Name");
			
	
				String amount = JOptionPane.showInputDialog("Enter loan amount");
				double loanAmount = Double.parseDouble(amount);
			
		
				String term = JOptionPane.showInputDialog("Enter term");
				int loanTerm = Integer.parseInt(term);
				
				Loan loan1 = new BusinessLoan(accountNum, name, loanAmount, loanTerm);
				
				loan1.setInterestRate(rate);
				
				list[i] = loan1;
			 }
			 else if(type == 2) //If loan is personal type then the interest is calculated accordingly.
			 {	
				 String accountNumber = JOptionPane.showInputDialog(" Enter account number");
				 int accountNum = Integer.parseInt(accountNumber);
		
		
				 String name = JOptionPane.showInputDialog("Enter Name");
			
	
				 String amount = JOptionPane.showInputDialog("Enter loan amount");
				 double loanAmount = Double.parseDouble(amount);
			
		
				 String term = JOptionPane.showInputDialog("Enter term");
				 int loanTerm = Integer.parseInt(term);
				
				 Loan loan1 = new PersonalLoan(accountNum, name, loanAmount, loanTerm);
				
				 loan1.setInterestRate(rate);
				
				 list[i] = loan1;
			 }
			 else //Makes sure loan type is either business or personal.
			 {
				 loanType = JOptionPane.showInputDialog("Invalid loan type, enter 1 for Business loan and 2 for Personal loan");
				 type = Integer.parseInt(loanType);
			 }		
			
		}				
		
		//Displays all Loan objects in the array.
		JOptionPane.showMessageDialog(null, list);	
	}
}
