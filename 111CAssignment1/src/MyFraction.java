/**
 * 
 * @author Sebastian Kleinerman
 * @class Java 111C
 *
 */

public class MyFraction implements Fraction
{
	
	private int num, den;
	
	
	public MyFraction(int numer, int denom)
	{
		num = numer;
		den = denom;
	}
	
	public int getNumerator() 
	{
		return num;
	}

	public void setNumerator(int numer) 
	{
		num = numer;
	}

	public int getDenominator() 
	{
		return den;
	}
	
	public void setDenominator(int denom) 
	{
		den = denom;
	}
	
	
	public Fraction plus(Fraction fraction)
	{
		if ((den == 0) || (fraction.getDenominator() == 0))
	         throw new IllegalArgumentException("invalid denominator");
		
		MyFraction fraction1 = new MyFraction((num *(fraction).getDenominator()) +
	               (den *(fraction).getNumerator()),
	               den * (fraction).getDenominator());
		
		fraction1.reduce();
		
		return fraction1;
	}
	
	public Fraction minus(Fraction fraction)
	{
		if ((den == 0) || (fraction.getDenominator() == 0))
	         throw new IllegalArgumentException("invalid denominator");
		
		MyFraction fraction1 = new MyFraction((num *(fraction).getDenominator()) -
	               (den *(fraction).getNumerator()),
	               den * (fraction).getDenominator());
		
		fraction1.reduce();
		
		return fraction1;
	}
	
	public Fraction times(Fraction fraction)
	{
		int num1 = num * fraction.getNumerator();
		int num2 = den * fraction.getDenominator();
		
		MyFraction multipliedFraction = new MyFraction(num1, num2);
		multipliedFraction.reduce();
		
		return multipliedFraction;
	}
	
	public Fraction dividedBy(Fraction fraction)
	{
		if ((den == 0) || (fraction.getNumerator() == 0))
		      throw new IllegalArgumentException("invalid denominator");		
		    
		MyFraction dividedFraction = new MyFraction((num * fraction.getDenominator()), (den * fraction.getNumerator()));
		dividedFraction.reduce();
		
	    return dividedFraction;
	}
	
	public Fraction reciprocal()
	{
		if ((den == 0) || (num == 0))
		      throw new IllegalArgumentException("invalid denominator");
		
		int tempNum = num;
		num = den;
		den = tempNum;
		Fraction reciprocal = new MyFraction(num, den);
		
		return reciprocal;
	}
	
	public boolean equalsTo(Fraction fraction)
	{
		if(fraction.getNumerator() == num && fraction.getDenominator() == den)
		{
			return true;
		}
		else
			return false;
	}
	
	public String toString()
	{
		String string = num + "/" + den;
		
	    return string;
	}
	
	
	private void reduce()
	{
		int n = num, d = den, largest;
		
	    if (num < 0) 
	    {
	    	n = -num;
	    }
	    
	    if (n > d) 
	    {
	    	largest = n;
	    }
	    else 
	    {
	    	largest = d;
	    }
	    
	    int gcd = 0;
	    
	    for (int i = largest; i >= 2; i--) 
	    {
	    	if (num % i == 0 && den % i == 0) 
	        {
	            gcd = i;
	            break;
	        }
	    }
	    
	    if (gcd != 0) 
	    {
	    	num /= gcd;
	        den /= gcd;
	    }
	}

	public static void main(String[] args)
	{
		Fraction fraction1 = new MyFraction(1, 3);
		Fraction fraction2 = new MyFraction(1, 4);
		
		Fraction fraction4 = new MyFraction(5, 6);
		Fraction fraction3 = new MyFraction(7, 8);
		
		System.out.println(fraction1.toString() + " equal to " + fraction2.toString() + "?: " + fraction1.equals(fraction2));
		System.out.println(fraction1.toString() + " + " + fraction2.toString() + " = " + fraction1.plus(fraction2));
		System.out.println(fraction1.toString() + " - " + fraction2.toString() + " = " + fraction1.minus(fraction2));
		System.out.println(fraction1.toString() + " * " + fraction2.toString() + " = " + fraction1.times(fraction2));
		System.out.println(fraction1.toString() + " / " + fraction2.toString() + " = " + fraction1.dividedBy(fraction2));
		System.out.println(fraction1.toString() + " reciprocal: " + fraction1.reciprocal().toString());
		
		System.out.println(fraction4.toString() + " equal to " + fraction3.toString() + "?: " + fraction4.equals(fraction3));
		System.out.println(fraction4.toString() + " + " + fraction3.toString() + " = " + fraction4.plus(fraction3));
		System.out.println(fraction4.toString() + " - " + fraction3.toString() + " = " + fraction4.minus(fraction3));
		System.out.println(fraction4.toString() + " * " + fraction3.toString() + " = " + fraction4.times(fraction3));
		System.out.println(fraction4.toString() + " / " + fraction3.toString() + " = " + fraction4.dividedBy(fraction3));
		System.out.println(fraction4.toString() + " reciprocal: " + fraction4.reciprocal().toString());
		
	}
}

