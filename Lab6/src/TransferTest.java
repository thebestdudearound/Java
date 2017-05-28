/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: This Program creates two Account objects and prompts the user to transfer from one to the other using 
 * the overloaded transfer method in the Account class.
 * Due Date: 10/05/2015
 * Name: Henry Goldman & Sebastian Kleinerman
 * File Name: Account.java
 * Lab #6
 */
import java.util.*;
public class TransferTest 
{
	public static void main(String[] args)
	{
		Account account1, account2;
		int choice;
		int transferAmt;
		
		Scanner scan = new Scanner(System.in);
		
		account1 = new Account(100.0, "Joe");
		account2 = new Account(100.0, "Mary");
		
		System.out.println("Account1 Summary");
		System.out.println("----------------");
		System.out.println(account1.toString());
		System.out.println("Account2 Summary");
		System.out.println("----------------");
		System.out.println(account2.toString());
		System.out.println("");
		
		do
		{	
			System.out.println("Menu");
			System.out.println("----");
			System.out.println("1: Transfer from Account1 to Account2");
			System.out.println("2: Transfer from Account2 to Account1");
			System.out.println("3: Quit");
			System.out.println("Enter your choice: ");
			choice = scan.nextInt();
			if(choice == 1 || choice == 2)
			{
				System.out.println("Enter amount to transfer: ");
				transferAmt = scan.nextInt();
				if (transferAmt > account1.getBalance() || transferAmt > account2.getBalance())
				{
					System.out.println("Insufficient funds for transfer\n");
				}
				
				System.out.println("New Account1 balance:" + account1.getBalance());
				System.out.println("New Account2 balance:" + account2.getBalance());	
				System.out.println();
			}
		}
		while(choice != 3);
	}
}
