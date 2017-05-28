/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: A simple program to test the numAccts method of the Account class.
 * Due Date: 10/05/2015
 * Name: Henry Goldman & Sebastian Kleinerman
 * File Name: Account.java
 * Lab #6
 */
import java.util.Scanner;

public class TestAccounts1
{
    public static void main(String[] args)
    {
    	Account testAcct;

    	Scanner scan = new Scanner(System.in);

    	System.out.println("How many accounts would you like to create?");
    	int num = scan.nextInt();

    	for (int i=1; i<=num; i++)
	    {
    		testAcct = new Account(100, "Name" + i);
    		System.out.println("\nCreated account " + testAcct);
	    }
    	System.out.println("\nCreated " + Account.getNumAccounts() + " accounts." );
    }
}

