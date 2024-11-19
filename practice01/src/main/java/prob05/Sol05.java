package prob05;

import java.util.Scanner;

public class Sol05 {
	public static void main(String[] args) {

		/* 코드 작성 */
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i <= 100; i++) {
			String number = String.valueOf(i);
			if (number.contains("3") || number.contains("6") || number.contains("9")) {
		        System.out.println(number + " 짝");
		    }
		}

	}
}
