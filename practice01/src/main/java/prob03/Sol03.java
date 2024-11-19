package prob03;

import java.util.Scanner;

public class Sol03 {
	
	public static void main(String[] args) {

		/* 코드 작성 */

		while(true) {
			Scanner scanner = new Scanner(System.in);
			
			int number = scanner.nextInt();
			int sum = 0;
			if (number % 2 != 0) {
				for (int i = 0; i <= number; i++) {
					if (i % 2 != 0) {
						sum += i;
					}
				}
			}
			else {
				for (int i = 0; i <= number; i++) {
					if (i % 2 == 0) {
						sum += i;
					}
				}
			}
			System.out.println("결과값: "+ sum);
		}
	}
}
