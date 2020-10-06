import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Junit {

	@Test
	public void areaTest() {
		Rectangle r = new Rectangle(2,2,2,2);
		double area = r.area();
		double expected = 4.0;
		assertEquals(expected, area);
	}

}
