package day27;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex01_Server {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(5001));
			System.out.println("[Server Start]");
			while(true) { //무한루프 만듬
				System.out.println("[Connecting]");
				Socket socket = serverSocket.accept(); //수락된 client소켓정보를 가져옴
				System.out.println("[Connectiong Complete]");
			}
		} catch (Exception e) { //모든 예외를 처리할수있는 Exception 
			e.printStackTrace();
		}

	}

}
