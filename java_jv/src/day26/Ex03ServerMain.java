package day26;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ex03ServerMain {
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
				
				read(socket);//메소드만듬
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	//메소드 생성
	public static void read(Socket socket) {//socket필요
		Thread t = new Thread (()->{
			try {
			System.out.println("[Connect Complete]"+ socket.getRemoteSocketAddress());
			
			//작업
			InputStream is = socket.getInputStream();
			while(true) {
				byte []bytes = new byte[1024];//읽어와야한는 배열 만들어줌
				int readCount = is.read(bytes);//읽어온 read를 bytes에 담아준다
				if(readCount == -1)
					break;
				String str = new String(bytes,0,readCount,"UTF-8");
				System.out.println(str);
			}
			is.close();
			}catch(Exception e) {
				System.out.println("client connect end");
				e.printStackTrace();
			}
		});
		t.start();
	}
}
