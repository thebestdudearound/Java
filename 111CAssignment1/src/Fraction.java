
public interface Fraction 
{

	public void setNumerator(int num);
	public int getNumerator();
	public void setDenominator(int den);
	public int getDenominator();
	
	public Fraction plus(Fraction fraction);
	public Fraction minus(Fraction fraction);
	public Fraction times(Fraction fraction);
	public Fraction dividedBy(Fraction fraction);
	public boolean equalsTo(Fraction fraction);
	public Fraction reciprocal();
	public String toString();
	
}
