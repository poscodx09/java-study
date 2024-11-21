package prob01;

import java.util.Scanner;

public class Sol01 {
	public static void main(String[] args) {
		
		// final 클래스에 붙일 경우, 상속 못하는 클래스
		// final 변수에 붙일 경우, 상수
		
//		int[] arr = new int[5];
//		int[] arr2 = {10, 20, 30, 40, 50};
//		int[] arr3 = new int[] {10, 20, 30, 40, 50};
		
		// Book 객체 생성 안되고 공간만 만들어줌
		// 레퍼런스만 저장
//		Book[] books = new Book[4]
		
		
		Scanner scanner = new Scanner(System.in);

		final int[] MONEYS = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};

		/* 코드 작성 */
		int num = scanner.nextInt();
		int i = 0;
		int cnt = 0;
		while (num > 0) {
			if (num > MONEYS[i]) {
				cnt += 1;
				num -= MONEYS[i];
				System.out.println(MONEYS[i] + "원 : " + cnt + "개");
			}
			else {
				cnt = 0;
				i ++;
			}
		}
		
		scanner.close();
 	}
}