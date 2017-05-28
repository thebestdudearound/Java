/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: This class stores an employee's ID number, gross pay, state tax, federal tax, and FICA holdings.
 * Due Date: 09/23/15
 * Name: Sebastian Kleinerman
 * File Name: Payroll.java
 * Assignment #3
*/

import java.util.*;
import java.text.NumberFormat;

public class Payroll 
{
	private String name;
	private String idNumber;
	private double grossPay;
	private double stateTax;
	private double fedTax;
	private double fica;

	//Constructor that accepts the employee's name and ID number as arguments as well as gross pay, state/federal tax and FICA
	public Payroll(String empName, String empNumber, double empGrossPay, 
			double empStateTax, double empFedTax, double empFICA)
	{
		name = empName;
		idNumber = empNumber;
		grossPay = empGrossPay;
		stateTax = empStateTax;
		fedTax = empFedTax;
		fica = empFICA;
		
	}
	
	//No-argument constructor.
	public Payroll(){ }
	
	//Method to return employee's name.
	public String getName()
	{
		return name; 
	}
	
	//Method to return employee's ID number.
	public String getEmployeeNumber()
	{ 
		return idNumber; 
	}
	
	//Method that calculates and returns employee's net pay.
	public double getNetPay()
	{
		double netPay;
		netPay = grossPay - (stateTax + fedTax + fica);
		return netPay;
	}
	
	//toString method to return well-formatted final values for gross pay, state/fed tax, FICA and net pay.
	public String toString ()
	{
		NumberFormat fmt = NumberFormat.getCurrencyInstance();

		return("\ngross pay: " + fmt.format(grossPay) + "\nstate tax: " + fmt.format(stateTax) + 
				"\nfederal tax: " + fmt.format(fedTax) + "\nFICA: " + fmt.format(fica) +
				"\nnet pay: " + fmt.format(getNetPay()));
		
	}
}
