package paint;

public class PaintApp {

	public static void main(String[] args) {
		Point point1 = new Point();
		point1.setX(10);
		point1.setY(20);	
//		point1.show();
		drawPoint(point1);

		Point point2 = new Point(100, 200);
//		point2.show();
		drawPoint(point2);
		point2.show(false);
		
		ColorPoint point3 = new ColorPoint(50, 100, "red");
//		ColorPoint point3 = new ColorPoint();
		point3.setX(50);
//		point3.setY(100);
//		point3.setColor("red");
//		drawColorPoint(point3);
		drawPoint(point3);
		
	}
	
	// 다형성, 오버라이드
	public static void drawPoint(Point point) {
		point.show();
	}
	
//	public static void drawColorPoint(ColorPoint colorPoint) {
//		colorPoint.show();
//	}

}
