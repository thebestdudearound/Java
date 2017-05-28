/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: This class asks for the employee's ID number, gross pay, state tax, federal tax and FICA.
 * However, it doesnt accept any value less than zero and if the state tax, federal tax or FICA are greater
 * than the gross pay it'll display an error message and ask the user to enter a value again. Then, at the end,
 * once all values are accepted, it displays final values with correct decimals and dollar signs.
 * Due Date: 09/23/15
 * Name: Sebastian Kleinerman
 * File Name: PayrollReport.java
 * Assignment #3
*/

import java.util.*;

public class PayrollReport 
{
	public static void main(String[] args)
	{
		String name = null;
		String idNumber = new String();
		double empGrossPay = 0;
		double empStateTax = 0;
		double empFedTax = 0;
		double empFICA = 0;
		
		//Creates Scanner object
		Scanner scan = new Scanner(System.in);
		
		//Asks employee for ID number
		System.out.print("Enter the employee ID number: ");
		idNumber = scan.nextLine();
		
		//Asks user for employee's gross pay and makes sure it's not less than zero.
		System.out.print("Enter employee " + idNumber + "'s gross pay: ");
		empGrossPay = scan.nextDouble();
		if(empGrossPay < 0)
		{	
			System.out.println("Error - gross pay cannot be less than zero.");
			System.out.print("Re-enter gross pay: ");
			empGrossPay = scan.nextDouble();
		}	
		
		//Asks user for state tax and makes sure it's not greater than gross pay or less than zero.
		System.out.print("Enter employee " + idNumber + "'s state tax: ");
		empStateTax = scan.nextDouble();
		if(empStateTax > empGrossPay)
		{
			System.out.println("Error - state tax cannot be greater than gross pay.");
			System.out.print("Re-enter state tax: ");
			empStateTax = scan.nextDouble();
			if(empStateTax < 0)
			{	
				System.out.println("Error - state tax cannot be less than zero.");
				System.out.print("Re-enter state tax: ");
				empStateTax = scan.nextDouble();
			}	
		}
		else if(empStateTax < 0)
		{
			System.out.println("Error - state tax cannot be less than zero.");
			System.out.print("Re-enter state tax: ");
			empStateTax = scan.nextDouble();
			if(empStateTax > empGrossPay)
			{
				System.out.println("Error - state tax cannot be greater than gross pay.");
				System.out.print("Re-enter state tax: ");
				empStateTax = scan.nextDouble();
			}
		}
		
		//Asks user for federal tax and makes sure it's not greater than gross pay or less than zero.
		System.out.print("Enter employee " + idNumber + "'s federal tax: ");
		empFedTax = scan.nextDouble();
		if(empFedTax > empGrossPay)
		{
			System.out.println("Error - federal tax cannot be greater than gross pay.");
			System.out.print("Re-enter federal tax: ");
			empFedTax = scan.nextDouble();
			if(empFedTax < 0)
			{	
				System.out.println("Error - federal tax cannot be less than zero.");
				System.out.print("Re-enter federal tax: ");
				empFedTax = scan.nextDouble();
			}	
		}
		else if(empFedTax < 0)
		{
			System.out.println("Error - federal tax cannot be less than zero.");
			System.out.print("Re-enter federal tax: ");
			empFedTax = scan.nextDouble();
			if(empFedTax > empGrossPay)
			{
				System.out.println("Error - federal tax cannot be greater than gross pay.");
				System.out.print("Re-enter federal tax: ");
				empFedTax = scan.nextDouble();
			}
		}
		
		//Asks user for FICA and makes sure it's not greater than gross pay or less than zero.
		System.out.print("Enter employee " + idNumber + "'s FICA: ");
		empFICA = scan.nextDouble();
		if(empFICA > empGrossPay)
		{
			System.out.println("Error - FICA cannot be greater than gross pay.");
			System.out.print("Re-enter FICA: ");
			empFICA= scan.nextDouble();
			if(empFICA < 0)
			{	
				System.out.println("Error - FICA cannot be less than zero.");
				System.out.print("Re-enter FICA: ");
				empFICA = scan.nextDouble();
			}
		}
		else if(empFICA < 0)
		{
			System.out.println("Error - FICA cannot be less than zero.");
			System.out.print("Re-enter FICA: ");
			empFICA = scan.nextDouble();
			if(empFICA > empGrossPay)
			{
				System.out.println("Error - FICA cannot be greater than gross pay.");
				System.out.print("Re-enter FICA: ");
				empFICA = scan.nextDouble();
		    }
		}
		
		//Uses toString method to display employee's Payroll info.
		Payroll employee = new Payroll(name, idNumber, empGrossPay, empStateTax, empFedTax, empFICA);
		
		System.out.println(employee.toString());
		
	}

}
