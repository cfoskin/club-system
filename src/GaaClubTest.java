import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GaaClubTest {
private GaaClub club;

	@Before
	public void setUp() throws Exception {
		club = new GaaClub();
	}

	@Test
	public void testSetandGetClubName() {
		assertNull(club.getClubName());
	}
	@Test
	public void testSetandGetClubAddress() {
		assertNull(club.getClubAddress());
	}
	
	@Test
	public void testToString() {
		assertFalse(club.toString().contains("&"));
	}
}
