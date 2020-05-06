import java.text.NumberFormat;

public class MoviePass extends Ticket {
	private final double MOVIEPASS_FEE = 9.99;
	private final double ADULT_EVENING = 13.5;
	private final double ADULT_MATINEE = 10.5;
	private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
	private int numberOfVisits;
	private int numTimesMovie;
	private int numMoviesToday;
	private int movieId;
	
	public MoviePass(String mName, String mRating, int d, int t,String f, int mId, int numV, int numTM, int numM){
		super(mName, mRating, d,t, f, "MoviePass");
		numberOfVisits = numV;
		numTimesMovie = numTM;
		numMoviesToday = numM;
		movieId=mId;
	}
	
	public int getId() {return movieId;}
	
	public double calculateTicketPrice(){
		double price =0;
	
		Format feature = getFormat();
		if(numTimesMovie>0 || numMoviesToday>0 || feature==Format.THREE_D || feature==Format.IMAX){
			if(getTime()>17) price = ADULT_EVENING;
			else price = ADULT_MATINEE;

			switch(getFormat()){
			case IMAX: price += 3.0;
			break;
			case THREE_D: price += 2.5;
			break;
			case NONE:
			}

			price = price + price*TAX_AMT;
		}
		else if(numberOfVisits>0) price = 0.0;
		else price = MOVIEPASS_FEE;

		setTicketPrice(price);

		return price;
	}
	public String toString(){
		String result = "MOVIEPASS-"+movieId+" ";
		if(getFormat()==Format.THREE_D)
			result+= "3D ";
		else if(getFormat()==Format.IMAX)
			result+= "IMAX ";

		result += super.toString();
		return result;
	}
}
