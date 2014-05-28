import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ElitePlayerTest 
{
	private ElitePlayer colum;
	private ElitePlayer jim;
	private Competition comp;
	private Competition comp2;

	@Before
	public void setUp() throws Exception {
		colum = new ElitePlayer("colum","july","waterford", 5, 6.0);
		jim = new ElitePlayer("jim","june","waterford", 4, 6.0);
		comp = new Competition("comp");
		comp2= new Competition("comp2");
		colum.addCompetiton(comp);
	}
	@Test
	public void testElitePlayer() {
		assertEquals(colum.getName(), "colum");
		assertEquals(colum.getDob(), "july");
		assertEquals(colum.getAddress(), "waterford");
		assertEquals(colum.getBmi(), 5);
		assertEquals(colum.getHeight(),5.9, 6.1);
		assertEquals(colum.getMembershipSoFar(),0.0, 0.001);
		assertEquals(jim.getName(), "jim");
		assertEquals(jim.getDob(), "june");
		assertEquals(jim.getAddress(), "waterford");
		assertEquals(jim.getBmi(), 4);
		assertEquals(jim.getHeight(),5.9, 6.1);
		assertEquals(jim.getMembershipSoFar(),0.0, 0.001);

	}


	@Test
	public void testSetandGetName() {
		assertEquals(colum.getName(), "colum");
		colum.setName("john");
		assertEquals(colum.getName(), "john");
	}

	@Test
	public void testSetandGetDob() {
		assertEquals(colum.getDob(), "july");
		colum.setDob("august");
		assertEquals(colum.getDob(), "august");
	}

	@Test
	public void testSetandGetAddress() {
		assertEquals(colum.getAddress(), "waterford");
		colum.setAddress("kilkenny");
		assertEquals(colum.getAddress(), "kilkenny");
	}

	@Test
	public void testSetandGetMembershipSoFar()
	{
		assertEquals(colum.getMembershipSoFar(), 0.0, 0.001);
		colum.setMembershipSoFar(100.00);
		assertEquals(colum.getMembershipSoFar(), 99.99, 100.01);
	}

	@Test
	public void testAddCompetition()
	{
		colum.addCompetiton(comp2);
		assertEquals(comp2, colum.getEligibleComps().get(1));
	} 

	@Test
	public void testToString() {
		assertFalse(colum.toString().contains("&"));
	}

}
