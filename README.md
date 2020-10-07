# CPSC 501 - A1

## First Refactor
***Code to be altered***

    public class Triangle extends Shape {
  
	    public double sideA, sideC, base, height;

     ... }

The field variables in the Triangle class needs to be improved because they are public. The code smell is non-encapsulation. I used Encapsulating Fields to refactor, which involved privatizing the variables and implementing setters and getters in the Triangle class.

***Code result***

    public class Triangle extends Shape {
  
		private double sideA, sideC, base, height;
	    ...
		public void setsideA (double length) { this.sideA = length;}
		public void setsideC (double length) { this.sideC = length;}
	    public void setBase (double length) { this.base = length;}
		public void setHeight (double length) { this.height = length;}
		public double getsideA () { return this.sideA;}
		public double getsideC () { return this.sideC;}
		public double getBase () { return this.base;}
		public double getHeight () { return this.height;}
	}

To test the getters I created a Triangle object with specified dimensions and checked against those.

***Testing code for getters***

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
  To test the setters I created a Triangle object with dimensions of 0, then I set them to different values using the setter method that was created and checked the calculations for the area and perimeter.

***Testing code for setters***

    @Test
    public void testTriangleSetters() {
	    Triangle t = new Triangle(0, 0, 0, 0, 0, 0);
      
	    t.setsideA(5);
	    t.setsideC(5);
	    t.setBase(10);
	    t.setHeight(20);
      
	    double expectedArea = 100;
	    double expectedPerimeter = 20;
      
	    assertEquals(expectedArea, t.area());
	    assertEquals(expectedPerimeter, t.perimeter());
    }

This code is now better structured after refactoring because the variables are now private which means no one can access it directly, but only through the setters and getters. It doesn't seem like the result of this refactoring suggests any further refactoring. 

***SHA: df57d2fcb30237bd589a38799e0c583b2fe6ad40***
***SHA: 5ca8d0d326b536f8ad44932f71923ae72f88b564*** (*this SHA represents the modified Junit test to better test the setters*)

#

## Second Refactor (larger)
***Code to be altered***

    public class Square extends Shape {
		...
		public double area() { return length * width;}
		...
	}
    
    public class Rectangle extends Shape {
	    ...
	    public double area() { return length * width;}
	}
	
	public class Triangle extends Shape {
		...
		public double area() { return (base * height)/2;}
		...
	}
	
	public class Circle extends Shape {
		...
		public double area() { return Math.PI * radius * radius;}
		...
	}
	
The area method in each class can be improved by moving it up into the Shape class. The code smell is Duplicated Code. I used the Form Template Method to put common code in the superclass and differing code in subclasses. The common code in this case was multiplying the two inputs which was done in Shape. The differing code could be seen in the Triangle class where we had to take the result of the super method and divide it by 2 and the Circle class where we had to take the result and multiply it by PI.

***Code result***

    public class Shape {
	    ...
		public double area(double length1, double length2) { return length1 * length2;}
		...
	}
	
	public class Square extends Shape {
		...
		public double area() { return super.area(length, width);}
		...
	}
	
	public class Rectangle extends Shape {
		...
		public double area() { return super.area(length, width);}
		...
	}
	
	public class Triangle extends Shape {
		...
		public double area() { return super.area(base, height)/2;}
		...
	}
	
	public class Circle extends Shape {
		...
		public double area() { return super.area(radius, radius) * Math.PI;}
		...
	}
				
To test I created Circle, Square and Rectangle objects with specified dimensions and called the area method. I didn't have to create a test for Triangle since my previous refactor had an area calculation already.

***Testing code for Circle area***

	@Test
	public void testCircleArea() {
		Circle c = new Circle(10, 0, 0);
		double expectedArea = 314.16;
		assertEquals(expectedArea, c.area(), 1);
	}
	
***Testing code Square area***

	@Test
	public void testSquareArea() {
		Square s = new Square(6, 6, 0, 0);
		double expectedArea = 36;
		assertEquals(expectedArea, s.area());
	}

***Testing code Rectangle area***

	@Test
	public void testRectangleArea() {
		Rectangle r = new Rectangle(9, 9, 0, 0);
		double expectedArea = 81;
		assertEquals(expectedArea, r.area());
	}

This code is now better structured after refactoring because the duplicated calculation of area was extracted up into the parent class Shape. The structure makes sense because every shape has an area. The result of this refactoring does suggest further refactoring, specifically for the Circle class which will be done later in the fourth refactor.

***SHA: 7fc9c7a21a05d377a97c72d551327b94f87b9f5b*** (Square and Rectangle)
***SHA: 489fa1426c136592426c2146040cbc042bceea41*** (Circle)
***SHA:1950232ca35eec1f390450c620d9bdcb2d601f05*** (Triangle)


#

## Third Refactor
***Code to be altered***

    public class Point {
		...
		public double distance(Point point) {
			double xDisplacement = point.x - x;
			double yDisplacement = point.y - y;
			xDisplacement *= xDisplacement;
			yDisplacement *= yDisplacement;
			double distance = Math.sqrt(xDisplacement + yDisplacement);
			return distance;
		}
		...
	}

The distance method has a lot of calculations that could be broken up. The code smell is Long Method. I used Replace Temp with Query to enable the extraction by creating function queries.

***Code result***

    public class Point {
		...
		public double distance(Point point) {
			return Math.sqrt(xDisplacement(x, point.x) + yDisplacement(y, point.y));
		}
  
		private double xDisplacement(double x1, double x2) {
			return (x2 - x1) * (x2 - x1);
		}
		
		private double yDisplacement(double y1, double y2) {
			return (y2 - y1) * (y2 - y1);
		}
		...
	}

To test I created two points and used the newly modified distance method.

***Testing code for distance between two points***

    @Test
	public void testPointDistance() {
		Point p1 = new Point(0, 0);
		Point p2 = new Point(10, 0);
		double expecetedDistance = 10;
		assertEquals(expecetedDistance, p1.distance(p2));
	}

This code is now better structured after refactoring because the distance calculation is a lot smaller than before. It turned from 6 lines to 1 line of code. The refactoring also introduced function queries for the x-displacement and y-displacement which can now be used whenever we need it. The result of this refactoring doesn't seem to suggest any further refactoring.

***SHA: 7f93140fd05a273192153f844f1fa3a9de0daf10***

#

## Fourth Refactor
***Code to be altered***

    public class Circle extends Shape {
	    ...
	    public double area() {
			return super.area(radius, radius) * Math.PI;
		}
		...
	}
	
	public class Shape {
		...
		public double area(double length1, double length2) { 
			return length1 * length2;
		}
		...
	}

This method was a result of the second refactor where we made all the subclasses use the area method from Shape's class. Calculating the area of a circle doesn't align with how Shape's area method does it which takes two inputs and multiplies them together. It just awkwardly works because circle passes the radius twice. The code smell is Feature Envy which means a class is doing a calculation that belongs somewhere else. I used the Move Method to modify and keep the area calculation inside the Circle class which avoids using the super area method from Shape. 

***Code result***

    public class Circle extends Shape {
		...
		public double area() {
			return radius * radius * Math.PI;
		}
		...
	}

To test I used the previously written test in refactor 2 for calculating Circle's area.

***Testing code for Circle's area***

    @Test
	public void testCircleArea() {
		Circle c = new Circle(10, 0, 0);
		double expectedArea = 314.16;
		assertEquals(expectedArea, c.area(), 1);
	}

This code is now better structured after refactoring because it makes more sense that the circle has it's own area method. It is the only shape to have a radius, thus it wouldn't make sense to use the Shape's area method which takes in 2 lengths. The result of the refactoring doesn't seem to suggest any further refactoring.

***SHA: f4696fedc64dfe62872833161e40bb5481f738a8***

#

## Fifth Refactor
***Code to be altered***

    public class Rectangle extends Shape {
		...
		public double distance(Rectangle r) {
			Point p1 = super.getOrigin();
			Point p2 = r.getOrigin();
			return p1.distance(p2);
		}
	}
	
	

In order to calculate the distance between two rectangles we had to get the origin coordinates for the rectangles by asking Shape and then to calculate the distance by asking Point. The code smell is Message Chains which means there is an unnecessary intermediate relationship, in this case Rectangle doesn't need to be involved. I used the Move Method to let the Shape class handle the distance method.

***Code result***

    public class Shape {
		...
		public double distance(Shape shape) {
			return origin.distance(shape.getOrigin());
		 }
	}

To test I created two rectangles with specified origin points and called the distance method which is now in Shape's class. I also created another test to calculate the distance between two different shapes. 

***Testing code for Circle's area***

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

This code is now better structured after refactoring because the Rectangle class no longer needs to communicate to Shape and Point to get the distance. Instead we can now use the distance method in Shape and it will handle the distance directly with Point, thus we have removed the intermediate relationship with Rectangle. This refactoring also allows us to calculate the distance between any two shapes now, whereas before we could only calculate the distance for Rectangles. The result of this refactoring doesn't seem to suggest any further refactoring. 

***SHA: 088181417d515a97fd88ea8a96e3c5cc55b2e1f1***

#

## Sixth Refactor (larger with branch and merge)
***Code to be altered***

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
			return super.area(length, width);
		}
		public double circumference() {
			return (2 * length) + (2 * width);
		}
	}

The Square class is the exact same as the Rectangle class. The code smell is Duplicated Code. I used Extract Subclass to make Square be a child of Rectangle.

***Code result***

	public class Square extends Rectangle {
		public Square(double lengthVal, double xVal, double yVal) {
			super(lengthVal, lengthVal, xVal, yVal);
		}
	}

To test I used the previously written tests that involved Square objects.


This code is now better structured after refactoring because all Square class has now is its constructor. This makes sense as you can say a Square is a special type of Rectangle where the lengths and widths are the same. The Square class is now much simpler and it doesn't seem to suggest any further refactoring.

***SHA:6b2ff95a899bb1a0fa96b70b6e2a4ca50965331e*** (This was branched off into subclassSquare)
***SHA:25cbd03b95170353255b161163b598718cd09f54*** (This was the merge back into master)

