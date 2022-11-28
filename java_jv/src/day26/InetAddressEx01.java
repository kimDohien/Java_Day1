package day26;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressEx01 {

	public static void main(String[] args) {
		
		InetAddress ia = null;
		try {
			//로컬호스트 주소
			ia = InetAddress.getByName("localhost");
			System.out.println(ia);
			
			//네이버 주소
			ia = InetAddress.getByName("www.naver.com");
			System.out.println(ia);
			
			//내 pc 주소
			ia = InetAddress.getLocalHost();
			System.out.println(ia);
			
			//네이버주소가 하나인지 여러개인지 확인(향상된for문 이용)
			InetAddress []ias= InetAddress.getAllByName("www.naver.com");
			for(InetAddress tmp : ias) {
				System.out.println(tmp);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
