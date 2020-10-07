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
	
	@Test
	public void testSquareArea() {
		Square s = new Square(6, 6, 0, 0);
		
		double expectedArea = 36;
		
		assertEquals(expectedArea, s.area());
	}
	
	@Test
	public void testRectangleArea() {
		Rectangle r = new Rectangle(9, 9, 0, 0);
		
		double expectedArea = 81;
		
		assertEquals(expectedArea, r.area());
	}
	
	@Test
	public void testCircleArea() {
		Circle c = new Circle(10, 0, 0);
		
		double expectedArea = 314.16;
		
		assertEquals(expectedArea, c.area(), 1);
	}
	
	@Test
	public void testPointDistance() {
		Point p1 = new Point(0, 0);
		Point p2 = new Point(10, 0);
		
		double expecetedDistance = 10;
		
		assertEquals(expecetedDistance, p1.distance(p2));
	}
	
	@Test
	public void testRectangleDistance() {
		Rectangle r1 = new Rectangle(10, 10, 0, 0);
		Rectangle r2 = new Rectangle(10, 10, 25, 0);
		
		double expectedDistance = 25;
		
		assertEquals(expectedDistance, r1.distance(r2));
	}
	
	@Test
	public void testShapeDistance() {
		Rectangle r = new Rectangle(50, 50, 0, 0);
		Square s = new Square(5, 5, 0, 100);
		
		double expectedDistance = 100;
		
		assertEquals(expectedDistance, r.distance(s));
	}


}
