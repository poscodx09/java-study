package chapter04;

public class WrapperClassTest01 {

	public static void main(String[] args) {
		// 직접 생성하면 heap 상에 객체가 존재하게 된다.
		// 리터럴을 사용하면 JVM 안의 Constant Pool에서 관리하게 된다.
		Integer i = new Integer(10);
		Character c = new Character('c');
		Boolean b = new Boolean(true);
		
		Integer j1 = 10;
		Integer j2 = 20;
		
		System.out.println(j1 != j2);

	}

}
