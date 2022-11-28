package day26;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	//소켓을 통해서 읽고 쓰고 할수있는 클라이언트를 만듬
	private Socket socket;

	//생성자
	public Client(Socket socket) {
		this.socket = socket;
	}
	
	public void read() {//socket을 지우는 이유는 필드 있기때문
		Thread t = new Thread (()->{
			try {
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
	
	public void send() {//socket을 지우는 이유는 필드 있기때문
		Scanner scan = new Scanner(System.in);
		Thread t = new Thread (()->{
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
	});
		t.start();
	}
}
