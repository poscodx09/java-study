package prob01;

import java.util.Scanner;

public class Sol01 {
	public static void main(String[] args) {
		
		/* 코드 작성 */
		
		Scanner scanner = new Scanner(System.in);
		
		
		int number = scanner.nextInt();

		if (number % 3 == 0) {
			System.out.println("3의 배수입니다.");
		}
		
		scanner.close();
	}
}