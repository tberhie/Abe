import java.text.NumberFormat;

public class Adult extends Ticket {
	private final double EVENING = 13.5;
	private final double MATINEE = 10.5;
	private NumberFormat format = NumberFormat.getCurrencyInstance();
	
	public Adult(String mName, String mRating, int d, int t,String f){
		super(mName, mRating, d, t, f, "Adult");
	}
	
	public int getId() 
	{
		return -1;
	
	}
	
	public double calculateTicketPrice()
	{
		double price=0;
		if(getTime() > 18) price = EVENING;
		else price = MATINEE;
		
		switch(getFormat())
		{
		case IMAX: price += 3.0;
		break;
		case THREE_D: price += 2.5;
		break;
		case NONE:
		}
		
		price = price + price*TAX_AMT;
		
		setTicketPrice(price);
		
		return price;
	}
	
	public String toString()
	{
		String result = "ADULT ";
		if(getFormat()==Format.THREE_D)
			result+="3D ";
		else if(getFormat()==Format.IMAX)
			result+="IMAX ";

		result += super.toString();
		return result;
	}

}
