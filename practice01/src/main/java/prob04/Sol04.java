package prob04;

import java.util.Scanner;

public class Sol04 {

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		for (int i = 0; i < str.length()+1; i++) {
			System.out.println(str.substring(0, i));
		}
		scanner.close();
	}
}