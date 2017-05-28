/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: This program creates 3 Account objects, closes the first and attempts to consolidate the second and third.
 * Due Date: 10/05/2015
 * Name: Henry Goldman & Sebastian Kleinerman
 * File Name: Account.java
 * Lab #6
 */

import java.util.Scanner;
import java.text.NumberFormat;

public class TestAccounts2
{
    public static void main(String[] args)
    {
    	Account acct1, acct2, acct3, acctCons = null;
    	String name1, name2, name3;
    	NumberFormat fmt = NumberFormat.getIntegerInstance();

    	Scanner scan = new Scanner(System.in);
	
    	
    	System.out.print("Enter name for first account: ");
    	name1 = scan.nextLine();
    	acct1 = new Account(100, name1);
    	System.out.println("Created account for " + name1 + " with balance $" + fmt.format(acct1.getBalance()) + ".");
    	
    	System.out.println("");
    	System.out.print("Enter name for second account: ");
    	name2 = scan.nextLine();
    	acct2 = new Account(100, name2);
    	System.out.println("Created account for " + name2 + " with balance $" + fmt.format(acct2.getBalance()) + ".");
    	
    	System.out.println("");
    	System.out.print("Enter name for third account: ");
    	name3 = scan.nextLine();
    	acct3 = new Account(100, name3);
    	System.out.println("Created account for " + name3 + " with balance $" + fmt.format(acct3.getBalance()) + ".");
    	
    	System.out.println("\nClosing first account.");
    	acct1.close();
    	System.out.println("Trying to consolidate second and third accounts.");
		acctCons.consolidate(acct2, acct3);
		System.out.println("Result account is " + acctCons);
    	System.out.println("Number of accounts is now " + acctCons.getNumAccounts());
    }
}
