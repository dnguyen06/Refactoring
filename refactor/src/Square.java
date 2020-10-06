
public class Square extends Shape {

	private double length;
	private double width;


	public Square(double lengthVal, double widthVal, double xVal, double yVal) {
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
		return length * width;
	}

	public double circumference() {
		return (2 * length) + (2 * width);
	}


}