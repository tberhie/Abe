import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AdultTest {
	Adult a1,a2,a3, a4, a5,a6;

	@Before
	public void setUp() throws Exception 
	{
		//Evening movie (after 6 pm)
		a1 = new Adult("Infinity Wars", "PG13", 5,19,"NONE");
		//Matinee (before 6 pm)
		a2 = new Adult("A Quiet Place", "PG13", 2,12,"NONE");
		//Evening IMAX movie
		a3 = new Adult("Solo", "PG13", 3,20,"IMAX");
		//Matinee IMAX
		a4 = new Adult("Solo", "PG13", 1,13,"IMAX");
		//Evening 3D
		a5 = new Adult("Black Panther", "PG13", 3,21,"3D");
		//Matinee 3D
		a6 = new Adult("Black Panther", "PG13", 2,14,"3D");
	}

	@After
	public void tearDown() throws Exception {
		a1=a2=a3=a4=a5=a6=null;
	}

	@Test
	public void test()
	{
		assertEquals(14.80,a1.calculateTicketPrice(),.01);
		assertEquals(11.51,a2.calculateTicketPrice(),.01);
		assertEquals(18.08,a3.calculateTicketPrice(),.01);
		assertEquals(14.80,a4.calculateTicketPrice(),.01);
		assertEquals(17.54,a5.calculateTicketPrice(),.01);
		assertEquals(14.25,a6.calculateTicketPrice(),.01);
	}

}
