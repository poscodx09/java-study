package chapter03;

public class StudentText02 {
	
	public static void main(String[] args) {
		Student s1 = new Student();
		
		// 업캐스팅 - 자식 클래스가 부모 클래스 타입으로 캐스팅, 캐스팅 연산자 괄호 생략 가능, 암묵적 형변환
		Person p1 = s1;
		
		// 다운캐스팅 - 부모 클래스를 자식 클래스 타입으로 캐스팅, 타입 셍략 불가능, 명시적 형변환
		Student s2 = (Student) p1;
		
	}

}
