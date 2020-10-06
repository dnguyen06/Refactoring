
public class Circle extends Shape {

	private double radius;

	public Circle(double radiusVal, double xVal, double yVal) {
		super(xVal, yVal);
		radius = radiusVal;
	}

	public void setRadius(double radiusVal) {
		radius = radiusVal;
	}

	public double getRadius() {
		return radius;
	}

	public double area() {
		return Math.PI * radius * radius;
	}
	
	public double circumference() {
		return Math.PI * 2 * radius;
	}

}
