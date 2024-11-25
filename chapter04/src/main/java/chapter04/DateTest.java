package chapter04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date now = new Date();
		
		System.out.println(now);
		printDate01(now);
		
	}
	
	private static void printDate01(Date now) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(now);
		System.out.println(date);
	}
	
	private static void printDate02(Date now) {
		// +1900
		int year = now.getYear();
		
		// 0~11, +1
		int month = now.getMonth();
		int hours = now.getHours();
		int minutes = now.getMinutes();
		int seconds = now.getSeconds();		
	}

}
