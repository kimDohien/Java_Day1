package day26;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Ex02ClientMain {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * 서버에 연결을 요청하고 연결이 되면 exit를 입력하기 전까지 문자열을 서버에 전송하는 작업
		 */

		Socket socket = null;

		try {

			socket = new Socket();
			socket.connect(new InetSocketAddress(5001));
			System.out.println("[Connect Completed]");
			
			send(socket);//메소드

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	// 메소드 생성
	public static void send(Socket socket) {
		try {
			OutputStream os = socket.getOutputStream();
			while (true) {
				System.out.println("write word to send : ");
				String str = scan.nextLine();
				if (str.equals("exit"))// if로 exit를 입력하기전까지 반복되도록
					break;
				byte[] bytes = str.getBytes("UTF-8");

				os.write(bytes);
				os.flush();

			}
			os.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
