import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.NumberFormat;

public interface MovieTicketManagerInterface {
	

	public int numVisits(int id);

	public int numThisMovie(int id, String movie);

	public int numMoviesToday(int id, int date);
	

	public double addTicket(String movieN, String rating, int d, int t, String f, String type, int id);
	
	
	
	public double totalSalesMonth();
	
	public String monthlySalesReport();
	
	
	public ArrayList<String> get3DTickets();

	public ArrayList<String> getAllTickets();


	public ArrayList<String> getMoviePassTickets();
	

	public void readFile(File file) throws FileNotFoundException;
}