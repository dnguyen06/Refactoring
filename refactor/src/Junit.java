import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Junit {
	
	@Test
	public void testTriangleGetters() {
		Triangle t = new Triangle(1, 2, 3, 4, 0, 0);
		
		double expectedsideA = 1;
		double expectedsideC = 2;
		double expectedBase = 3;
		double expectedHeight = 4;
		
		assertEquals(expectedsideA, t.getsideA());
		assertEquals(expectedsideC, t.getsideC());
		assertEquals(expectedBase, t.getBase());
		assertEquals(expectedHeight, t.getHeight());
		
	}
	
	@Test
	public void testTriangleSetters() {
		Triangle t = new Triangle(5, 5, 10, 20, 0, 0);
		
		double expectedArea = 100;
		double expectedPerimeter = 20;
		
		assertEquals(expectedArea, t.area());
		assertEquals(expectedPerimeter, t.circumference());
	}

}
