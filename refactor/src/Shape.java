
public class Shape {

	private Point origin;


	public Shape(double x, double y) {
		origin = new Point(x, y);
	}


	public Shape() {
		this(0.0, 0.0);
	}


	public void setOrigin(double x, double y) {
		origin.setXY(x, y);
	}


	public Point getOrigin() {
		return origin;
	}


	public void move(double x, double y) {
		origin.move(x, y);
	}


}
