package chapter04;

public class ObjectTest02 {

	public static void main(String[] args) {
		Point p1 = new Point(10, 20);
		Point p2 = new Point(10, 20);
		Point p3 = p1;
		
		// == : 두 객체의 동일성
		System.out.println(p1 == p2);	// false
		System.out.println(p1 == p3);	// true
		
		// equals: 두 객체의 동질성(내용비교)
		// 부모 클래스 Object의 기본 구현은 동일성(==) 비교와 같다.
		System.out.println(p1.equals(p2));	// false (기본 구현은 동일성 비교)
		System.out.println(p3.equals(p1));	// true
		
		System.out.println(p1.hashCode() == p2.hashCode());
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		
		

	}

}
