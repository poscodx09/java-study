package prob05;

public abstract class Shape {
	private int width;
	private int height;
	
	public Shape(int w, int h) {
		this.width = w;
		this.height = h;
	}
	
	public double getArea() {
		return width * height;
		
	}
	public double getPerimeter() {
		return (width+height)*2;
	}
}
