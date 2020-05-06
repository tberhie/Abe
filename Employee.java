import java.text.NumberFormat;

public class Employee extends Ticket {
	private final double ADULT_EVENING = 13.5;
	private final double ADULT_MATINEE = 10.5;
	private NumberFormat format = NumberFormat.getCurrencyInstance();
	private int numVisits;
	private int empId;
	
	public Employee(String mName, String mRating, int day, int time,String ff, int EmId, int nV)
	{
		super(mName, mRating, day,time, ff, "Employee");
		numVisits = nV;
		empId = EmId;
	}
	@Override
	public double calculateTicketPrice()
	{
		double PRICE = 0;
		if(numVisits >= 2)
		{
			if(getTime()>17) PRICE = ADULT_EVENING;
			else PRICE = ADULT_MATINEE;

			switch(getFormat())
		{
			case IMAX: PRICE += 3.0;
			break;
			case THREE_D: PRICE += 2.5;
			break;
			case NONE:
	    }

			PRICE = PRICE / 2;
			PRICE = PRICE + PRICE*TAX_AMT;
		}

		setTicketPrice(PRICE);

		return PRICE;
	}

	public int getId() {return empId;}
	
	public String toString()
	{
		String result = "EMPLOYEE-"+empId+" ";
		if(getFormat()==Format.THREE_D)
			result+= "3D ";
		else if(getFormat()==Format.IMAX)
			result+= "IMAX ";

		result += super.toString();
		return result;
	}
}
