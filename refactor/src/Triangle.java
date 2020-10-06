
public class Triangle extends Shape {
	
	public double sideA, sideC, base, height;
	
	public Triangle (double sideA, double sideC, double base, double height, double xVal, double yVal) {
		super(xVal, yVal);
		this.sideA = sideA;
		this.sideC = sideC;
		this.base = base;
		this.height = height;
	}
	
	public double area() {
		return (base * height)/2;
	}
	
	public double circumference() {
		return sideA + sideC + base;
	}
	

}
