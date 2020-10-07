
public class Triangle extends Shape {
	
	private double sideA, sideC, base, height;
	
	public Triangle (double sideA, double sideC, double base, double height, double xVal, double yVal) {
		super(xVal, yVal);
		this.sideA = sideA;
		this.sideC = sideC;
		this.base = base;
		this.height = height;
	}
	
	public double area() {
		return super.area(base, height)/2;
	}
	
	public double perimeter() {
		return sideA + sideC + base;
	}
	
	public void setsideA (double length) {
		this.sideA = length;
	}
	
	public void setsideC (double length) {
		this.sideC = length;
	}
	
	public void setBase (double length) {
		this.base = length;
	}
	
	public void setHeight (double length) {
		this.height = length;
	}
	
	public double getsideA () {
		return this.sideA;
	}
	
	public double getsideC () {
		return this.sideC;
	}
	
	public double getBase () {
		return this.base;
	}
	
	public double getHeight () {
		return this.height;
	}
	

}
