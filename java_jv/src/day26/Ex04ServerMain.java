package day26;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ex04ServerMain {
	public static void main(String[] args) {
		/*
		 * 클라이언트가 연결을 요청하면 연결을 하고, 연결이 종료되기 전까지
		 * 클라이언트가 전송한 문자열을 계속 출력함
		 */
		Scanner scan = new Scanner(System.in);
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(/*"192.168.10.6",*/5001));
			//"192.168.10.6" 상대방 주소에 들어가서 동시연결한거
			
			
			
			while(true) {
				System.out.println("[Connecting]");
				Socket socket = serverSocket.accept();
				
				Client c = new Client(socket);
				c.read();
				c.send();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
