package day26;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ex01ServerMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		final String encode = "UTF-8";

		//1.서버소켓 생성;
		ServerSocket serverSocket =null; //2.예외발생할수도 있어서 null입력.
		
		try {//4.예외발생 try,catch
			serverSocket = new ServerSocket(); //3.포트번호 정함(포트번호 밑에서 받게하려고 지움) + 소켓객체 생성
			serverSocket.bind(new InetSocketAddress(5001)); //4.bind를 통해 포트번호 연결
			while(true) {
				System.out.println("connecting");//5.
				Socket socket = serverSocket.accept(); //6.클라이언트가 허락하면 소켓 생성
				InetSocketAddress isa = (InetSocketAddress)(socket.getRemoteSocketAddress()); //7.연결된소켓에 주소를 가져옴
				System.out.print("connect complete"+isa.getAddress());//8.지금은 같은 pc로 해서 주소가 같을거임..
				
				InputStream is = socket.getInputStream();
				byte [] bytes = new byte[1024]; 
				int readCount = is.read(bytes); //일거온 스트림을 bytes에 저장
				//readCount 매개변수가 있으면 하나씩 읽어옴, 매개변수 있으면 bytes만큼 채워넣어줌
				String str = new String(bytes,0,readCount,encode);
				//바이트배열 넣어주고 0번지부터 읽어온 갯수만큼 변환해주고 UTF-8로 읽음
				System.out.println(str);
				
				//콘솔에서 문자열을 입력받아
				//클라이언트로 전송
				OutputStream os =  socket.getOutputStream();
				str = scan.nextLine();//원하는 문자열입력
				bytes = str.getBytes(encode); //encode가 UTF-8인거 위에 선언해줌
				os.write(bytes);//os.write메소드를 통해서 전송
				os.flush();//밀어냄
				System.out.println("[send completed]");
				is.close();
				os.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
