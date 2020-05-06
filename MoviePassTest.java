import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MoviePassTest {
	MoviePass m1,m2,m3,m4,m5,m6;

	@Before
	public void setUp() throws Exception {
		//seen 1 movie this month, not seen this movie, not seen any other movies today
		//should be no charge
		m1 = new MoviePass("Deadpool", "NR", 5,19,"NONE",22222,1,0,0);
		//seen 0 movies this month, not seen this movie, not seen any other movies today
		//charge of 9.99
		m2 = new MoviePass("Solo", "PG13", 2,12,"NONE",33333,0,0,0);
		//seen 4 movies this month, has seen this movie, not seen any other movies today
		//charged full price
		m3 = new MoviePass("Overboard", "PG13", 3,20,"NONE",44444,4,1,0);
		//seen 2 movies this month, has not seen this movie, has seen another movie today
		//charged full price
		m4 = new MoviePass("Deadpool", "G", 1,13,"IMAX",55555,2,0,1);
		//seen 3 movies this month, has not seen this movie, has not seen another movie today
		//should be no charge
		m5 = new MoviePass("Infinity Wars", "PG", 3,21,"NONE",66666,3,0,0);
		////seen 3 movies this month, has not seen this movie, has not seen another movie today
		//charged full price because 3D
		m6 = new MoviePass("Infinity Wars", "PG", 2,14,"3D",77777,3,0,0);
	}

	@After
	public void tearDown() throws Exception {
		m1=m2=m3=m4=m5=m6=null;
	}

	@Test
	public void test() {
		assertEquals(0.0,m1.calculateTicketPrice(),.01);
		assertEquals(9.99,m2.calculateTicketPrice(),.01);
		assertEquals(14.80,m3.calculateTicketPrice(),.01);
		assertEquals(14.80,m4.calculateTicketPrice(),.01);
		assertEquals(0.0,m5.calculateTicketPrice(),.01);
		assertEquals(14.25,m6.calculateTicketPrice(),.01);
	}

}
