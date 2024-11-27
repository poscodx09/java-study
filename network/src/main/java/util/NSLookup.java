package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);		
		String address = "";
		try {
			
			while(!("exit".equals(address))) {
				address = scanner.nextLine();
				if ("exit".equals(address)) {
					System.out.println("시스템 종료");
					break;
				}
				else {
					InetAddress[] InetAddresses = InetAddress.getAllByName(address);
					
					for (InetAddress inetAddress : InetAddresses) {
						System.out.println(address + " : " + inetAddress.getHostAddress());
					}

				}
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
