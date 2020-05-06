import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.NumberFormat;

public class MovieTicketManager implements MovieTicketManagerInterface{
	private ArrayList<Ticket> List;
	private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
	

	public MovieTicketManager(){
	    List = new ArrayList<Ticket>();
	}
	

	public int numVisits(int id){
		int numberOfVisits =0;
		for(Ticket m : List)
			if(m.getId()==id)
				numberOfVisits++;
		return numberOfVisits;
	}
	

	public int numThisMovie(int id, String movie){
		int numTimes = 0;
		for(Ticket m : List)
			if(m.getId() == id)
				if(m.getMovieName().equals(movie))
					numTimes++;
		return numTimes;
	}
	

	public int numMoviesToday(int id, int date){
		int numMovies = 0;
		for(Ticket m : List)
			if(m.getId()==id)
				if(m.getDate()==date)
					numMovies++;
		return numMovies;
		
	}
	

	public double addTicket(String movieN, String rating, int d, int t, String f, String type, int id){
		Ticket newPatron;
		if(type.equals("Adult")) {
			newPatron = new Adult(movieN,rating, d, t, f);
			List.add(newPatron);
			return newPatron.calculateTicketPrice();
		}
		else if(type.equals("Child")) {
			newPatron = new Child(movieN,rating, d, t, f);
			List.add(newPatron);
			return newPatron.calculateTicketPrice();
		}
		else if(type.equals("Employee")) {
			
			int numV = numVisits(id);
			newPatron = new Employee(movieN,rating, d, t, f,id,numV);
			List.add(newPatron);
			return newPatron.calculateTicketPrice();
		}
		else if(type.equals("MoviePass")) {
			
				int numV = numVisits(id);
				int numTM = numThisMovie(id,movieN);
				int numM = numMoviesToday(id,d);
				newPatron = new MoviePass(movieN,rating, d, t, f,id, numV,numTM, numM);
				List.add(newPatron);
				return newPatron.calculateTicketPrice();
		}
		return -1;
	}
	
	

	public double totalSalesMonth(){
		double totalSales = 0;
		for(Ticket m : List)
				totalSales+=m.calculateTicketPrice();
		return totalSales;
	}
	
	public String monthlySalesReport(){
		String result = "";
		double totalSalesAdult=0,totalSalesChild = 0,totalSalesEmployee=0,totalSalesMoviePass=0;
		int numAdult=0,numChild=0,numEmployee=0,numMoviePass=0;
		for(Ticket m : List)
		{
			switch (m.getType()){
			case "Adult":numAdult++; totalSalesAdult+=m.calculateTicketPrice();
			break;
			case "Child":numChild++;totalSalesChild+=m.calculateTicketPrice();
			break;
			case "Employee":numEmployee++;totalSalesEmployee+=m.calculateTicketPrice();
			break;
			case "MoviePass":numMoviePass++;totalSalesMoviePass+=m.calculateTicketPrice();
			}
		}
			result += "\tMonthly Sales Report\n\n";
			result += "\t\t\tSales\tNumber\n";
			result +="ADULT\t\t"+currencyFormat.format(totalSalesAdult)+"\t"+numAdult+"\n";
			result +="CHILD\t\t"+currencyFormat.format(totalSalesChild)+"\t"+numChild+"\n";
			result +="EMPLOYEE\t"+currencyFormat.format(totalSalesEmployee)+"\t"+numEmployee+"\n";
			result +="MOVIEPASS\t"+currencyFormat.format(totalSalesMoviePass)+"\t"+numMoviePass+"\n";
			result +="\n"+"Total Monthly Sales: "+currencyFormat.format(totalSalesMonth());
	return result;
	}
	

	public ArrayList<String> get3DTickets(){
		ArrayList<String> result = new ArrayList<String>();

		sortByDay();
		for(Ticket m : List)
			if(m.getFormat()==Format.THREE_D){
				result.add(m.toString());
			}
		return result;
	}

	public ArrayList<String> getAllTickets(){
		ArrayList<String> result = new ArrayList<String>();
	
		sortByDay();

		for(Ticket m : List)
				result.add(m.toString());		return result;
	}

	
	public ArrayList<String> getMoviePassTickets() {
		ArrayList<String> result = new ArrayList<String>();
		
		sortById();
		for(Ticket m : List)
			if(m.getType().equals("MoviePass")){
				result.add(m.toString());
			}
		return result;
	}
	

	public void readFile(File file) throws FileNotFoundException {
		Scanner input=null;;
		input = new Scanner(file);

		String line;
		String[] fields;
		String name, movieName, movieRating, dayString, timeString, feature, type, idString;
		int day, time, numV, numTM, numM, id=0;
		while(input.hasNextLine())
		{
			line = input.nextLine();
			fields = line.split(":");
			movieName = fields[0];
			movieRating = fields[1];
			dayString = fields[2];
			timeString = fields[3];
			feature = fields[4];
			type = fields[5];
			if(type.equals("Employee")|| type.equals("MoviePass"))
			{
				idString = fields[6];
				id = Integer.parseInt(idString);
			}

			day = Integer.parseInt(dayString);
			time = Integer.parseInt(timeString);

			switch(type)
			{
			case "Adult": List.add(new Adult(movieName, movieRating, day, time, feature));
					break;
			case "Child": List.add(new Child(movieName, movieRating, day, time, feature));	
					break;
			case "Employee": 
			
					numV = numVisits(id);
					List.add(new Employee(movieName, movieRating, day, time, feature, id,numV));
					break;
			case "MoviePass": 
				
					numV = numVisits(id);
					numTM = numThisMovie(id,movieName);
					numM = numMoviesToday(id,day);
					List.add(new MoviePass(movieName, movieRating, day, time, feature,id, numV,numTM,numM));
					break;
			}

		}
		input.close();
	}
	

	private void sortByDay(){
		Ticket temp;
		for(int x =1;x < List.size();x++)
		{
			for(int y = x ;y > 0; y--){
				if(List.get(y).getDate() < List.get( y - 1 ).getDate()){
					temp = List.get(y);
					List.set(y, List.get(y-1));
					List.set( y - 1, temp);
				}
			}
		}
		
	}
	

	private void sortById() 
	{
		Ticket temp;
		for(int i=1;i< List.size();i++)
		{
			for(int j=i;j>0;j--){
				if(List.get(j).getId() < List.get(j-1).getId()){
					temp = List.get(j);
					List.set(j, List.get(j-1));
					List.set(j-1, temp);
				}
			}
		}
		
	}
}