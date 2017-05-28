/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: Represents calculation of commission of employee created in Hourly.java
 * Due Date: 11/02/2015
 * Name: Henry Goldman & Sebastian Kleinerman
 * File Name: Commission.java
 * Lab #9
 */

public class Commission extends Hourly
{
	private double totalSales;
	private double commissionRate;
	
	public Commission(String name, String address, String phoneNumber, String socialSecurityNumber, double hourlyPay, double commission)
	{
		super(name, address, phoneNumber, socialSecurityNumber, hourlyPay);
		commissionRate = commission;
	}
	
	public void addSales(double sales)
	{
		totalSales += sales;
	}
	
	public double pay()
	{
		double payment = super.pay() + (totalSales * commissionRate);
		totalSales = 0;
	    return payment;
	}
	
	public String toString()
	{
		String result = super.toString() +"\nTotal Sales: " + totalSales;
		return result;
	}


}
