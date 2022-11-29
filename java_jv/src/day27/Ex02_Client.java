package day27;

import java.net.InetSocketAddress;
import java.net.Socket;

public class Ex02_Client {

	public static void main(String[] args) {
	 Socket socket = null;
	 
	 try {
	 socket = new Socket();
	 System.out.println("[Try Connecting]");
	 socket.connect(new InetSocketAddress("localhost",5001)); //localhost : 내부 아이피 주소를 말함. 생략해도됨
	 System.out.println("[Connect Success]");
	 
	 }catch(Exception e) {
		 System.out.println("[Connect Fail]");
	 }
	}

}
