package prob02;

import java.util.Scanner;

public class Sol02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[5];
		double sum = 0;

		/* 코드 작성 */
		for (int i = 0; i < intArray.length; i++) {
			int n = scanner.nextInt();
			sum += n;
		}
		
		System.out.println("평균은 " + sum/intArray.length + " 입니다");
		
		
		scanner.close();
	}
}
