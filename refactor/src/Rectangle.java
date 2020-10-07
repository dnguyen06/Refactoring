
public class Rectangle extends Shape {

	private double length;
	private double width;


	public Rectangle(double lengthVal, double widthVal, double xVal, double yVal) {
		super(xVal, yVal);
		length = lengthVal;
		width = widthVal;
	}

	public void setLength(double lengthVal) {
		length = lengthVal;
	}


	public void setWidth(double widthVal) {
		width = widthVal;
	}

	public double getLength() {
		return length;
	}

	public double getWidth() {
		return width;
	}

	public double area() {
		return super.area(length, width);
	}

	public double circumference() {
		return (2 * length) + (2 * width);
	}
	
	public double distance(Rectangle r) {
		Point p1 = super.getOrigin();
		Point p2 = r.getOrigin();
		return p1.distance(p2);
	}	

}
