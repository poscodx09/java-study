package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PhoneList01 {

	public static void main(String[] args) {
		
		BufferedReader br = null;
		
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
			// 1. 기반스트림
			FileInputStream fis = new FileInputStream(file);
			
			// 2. 보조스트림1
			InputStreamReader isr = new InputStreamReader(fis);
			
			// 3. 보조스트림2
			br = new BufferedReader(isr);
			
			// 4. 처리
			String line = null;
			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "\t");
				
				int index = 0;
				while (st.hasMoreElements()) {
					String token = st.nextToken();
					
					if (index == 0) {
						System.out.print(token + ":");
					} else if (index == 1){
						System.out.print(token + "-");
					} else if (index == 2){
						System.out.print(token + "-");
					} else {
						System.out.println(token);
					}
					
					index++;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		

	}

}
