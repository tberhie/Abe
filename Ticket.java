import java.text.NumberFormat;

public abstract class Ticket 
{
	private String movName;
	private String movRating;
	private int date;
	private int time;
	private String type;
	private Format format;
	private double ticketPrice;
	
	public final double TAX_AMT = .096;
	private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
	
	public abstract double calculateTicketPrice();
	public abstract int getId();
	
	public Ticket(String mName, String mRating, int day, int t, String f, String type){
		movName = mName;
		movRating = mRating;
		date = day;
		time = t;
		switch(f){
		case "IMAX": format = Format.IMAX;
				break;
		case "3D": format = Format.THREE_D;
				break;
		case "NONE": format = Format.NONE;
		}
		this.type = type;
	}
	
	public int getTime()
	{
		return time;
		
	}
	
	public Format getFormat() 
	{
		return format;
		
	}
	
	public String getMovieName() 
	{
		return movName;
		
	}
	
	public int getDate()
	{
		return date;
		
	}
	
	public double getTicketPrice() 
	{
		return ticketPrice;
		
	}
	
	public void setTicketPrice(double price)
	{
		ticketPrice = price;
		
	}
	
	public String getType() 
	{
		return type;
		
	}
	
	public String getRating() 
	{
		return movRating;
		
	}
	
	public String toString()
	{
		return  " Movie: "+getMovieName()+" Rating: "+getRating()+" Day: "+getDate()+
				" Time: "+getTime()+
				" Price: "+currencyFormat.format(calculateTicketPrice());
	}

}