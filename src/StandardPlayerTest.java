import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class StandardPlayerTest {
	private StandardPlayer colum;
	private StandardPlayer jim;
	private Competition comp;
	private Competition comp2;

	@Before
	public void setUp() throws Exception {
		colum = new StandardPlayer("colum","july","waterford");
		jim = new StandardPlayer("jim","june","waterford");
		comp = new Competition("comp");
		comp2= new Competition("comp2");
		colum.addCompetiton(comp);
	}

	@Test
	public void testStandardPlayer() {
		assertEquals(colum.getName(), "colum");
		assertEquals(colum.getDob(), "july");
		assertEquals(colum.getAddress(), "waterford");
		assertEquals(jim.getName(), "jim");
		assertEquals(jim.getDob(), "june");
		assertEquals(jim.getAddress(), "waterford");
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
		assertEquals("comp2",colum.getEligibleComps().get(1).getName());
	} 

	@Test
	public void testToString() {
		assertFalse(colum.toString().contains("&"));
	}

}
