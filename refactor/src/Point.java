
public class Point {
	// Instance variables 
	private double x;
	private double y;
	private int objectID;
	
	// Class variables 
	private static int currentID = 1;
	private static int activeObjects = 0;

	/**
	 * Sets up x and y coordinates and assigns an objectID
	 * 
	 * @param xVal
	 *            the x coordinate
	 * @param yVal
	 *            the y coordinate
	 */
	public Point(double xVal, double yVal) {
		x = xVal;
		y = yVal;
		objectID = currentID++;
		activeObjects++;
	}

	/**
	 * Initializes coordinates to (0.0,0.0)
	 */
	public Point() {
		this(0.0, 0.0);
	}

	/**
	 * Gets the number of active objects
	 * 
	 * @return the number of active objects
	 */
	public static int activeObjects() {
		return activeObjects;
	}

	/**
	 * Gets the objectID
	 * 
	 * @return the objectID number
	 */
	public int objectID() {
		return objectID;
	}

	/**
	 * Sets x and y coordinates
	 * 
	 * @param xVal
	 *            x coordinate
	 * @param yVal
	 *            y coordinate
	 */
	public void setXY(double xVal, double yVal) {
		x = xVal;
		y = yVal;
	}

	/**
	 * Sets x coordinate
	 * 
	 * @param xVal
	 *            x coordinate
	 */
	public void setX(double xVal) {
		x = xVal;
	}

	/**
	 * Sets y coordinate
	 * 
	 * @param yVal
	 *            y coordinate
	 */
	public void setY(double yVal) {
		y = yVal;
	}

	/**
	 * Gets the x coordinate
	 * 
	 * @return x coordinate
	 */
	public double getX() {
		return x;
	}

	/**
	 * Gets the y coordinate
	 * 
	 * @return y coordinate
	 */
	public double getY() {
		return y;
	}

	/**
	 * Moves the position of the point
	 * 
	 * @param deltaX
	 *            the change in x
	 * @param deltaY
	 *            the change in y
	 */
	public void move(double deltaX, double deltaY) {
		x = x + deltaX;
		y = y + deltaY;
	}

	/**
	 * Calculates the distance between two points
	 * 
	 * @param point
	 *            the point that is being compared
	 * @return the distance between the points
	 */
	public double distance(Point point) {
		double xDisplacement = point.x - x;
		double yDisplacement = point.y - y;
		xDisplacement *= xDisplacement;
		yDisplacement *= yDisplacement;
		double distance = Math.sqrt(xDisplacement + yDisplacement);
		return distance;
	}
	

	protected void finalize() throws Throwable {
		//super.finalize();
		activeObjects--;
	}

	/**
	 * Calculates the distance between two points
	 * 
	 * @param pointOne
	 *            the first point
	 * @param pointTwo
	 *            the second point
	 * @return the distance between the points
	 */
	public static double distance(Point pointOne, Point pointTwo) {
		return pointOne.distance(pointTwo);
	}
	
	public String toString() {
		String aString = "ID: "+ objectID + ", " + "Coordinates" + "(" + x + ", " + y + ")";
		return aString;
		
	}

}
