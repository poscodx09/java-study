package io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PhoneList02 {

	public static void main(String[] args) {
		
		Scanner scanner = null;
		
		try {
			File file = new File("./phone.txt");
			if (!file.exists()) {
				System.out.println("File Not Found");
				return;
			}
			
			System.out.println("== 파일정보 ==");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "bytes");
			Long timestamp = file.lastModified();
			Date date = new Date(timestamp);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			System.out.println(sdf.format(date));
			
			System.out.println("== 전화정보 == ");

			scanner = new Scanner(file);
			// 4. 처리
			while(scanner.hasNextLine()) {
				String name = scanner.next();
				String phone01 = scanner.next();
				String phone02 = scanner.next();
				String phone03 = scanner.next();
				
				System.out.println(name + ":" + phone01 + "-" + phone02 + "-" + phone03);
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

	}

}
