import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class MemberTest {

	private Member colum;
	private Member jim;

	@Before
	public void setUp() throws Exception {
		colum = new Member("colum","july","waterford");
		jim = new Member("jim","june","waterford");
	}
	@Test
	public void testMember() {
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
	public void testCalculateMembershipFee()
	{
		
	}
	@Test
	public void testToString() {
		assertFalse(colum.toString().contains("&"));
	}
}
