import java.text.NumberFormat;

public class Child extends Ticket 
{
	private final double EVENING = 10.75;
	private final double MATINEE = 5.75;
	private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
	
	public Child(String mName, String mRating, int d, int t, String f){
		super(mName, mRating, d, t, f, "Child");
	}

	public double calculateTicketPrice()
	{
		double price=0;
		if(getTime()>17) price = EVENING;
		else price = MATINEE;
		
		switch(getFormat()){
		case IMAX: price += 2.0;
		break;
		case THREE_D: price += 1.5;
		break;
		case NONE:
		}
		
		price = price + price*TAX_AMT;
		
		setTicketPrice(price);
		
		return price;
	}
	public int getId() 
	{
		return -1;
		
	}
	
	public String toString()
	{
		String result = "CHILD ";
		if(getFormat()==Format.THREE_D)
			result+="3D ";
		else if(getFormat()==Format.IMAX)
			result+="IMAX ";

		result += super.toString();
		return result;
	}
}
