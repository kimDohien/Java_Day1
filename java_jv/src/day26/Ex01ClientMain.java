package day26;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;



public class Ex01ClientMain {
	
	public static void main(String[] args) {
		Socket socket = null;
		Scanner scan = new Scanner(System.in);
		try {
			//<연결>
			socket =new Socket(); 
			socket.connect(new InetSocketAddress(5001));
			System.out.println("[연결 완료]");
			
			//output스트림 연결
			OutputStream os =  socket.getOutputStream(); //new가 아니라 socket을 통해 연결
			//보내려는 문자열을 byte배열로 변환
			String str =scan.nextLine();
			byte [] bytes = str.getBytes("UTF-8");
			//바이로 변환(문자열을 바이트로 반환해주는 메소드) , UTF-8로 해줘야 한글이 안깨짐
			//전송
			os.write(bytes);//읽어주고
			os.flush();//flush를 통해 밀어준다
			
			
			//서버에서 문자열을 입력받아
			bytes = new byte[1024]; //앞에서 입력한 byte와 상관없이 문자열을 제대로 입력할수있따.
			InputStream is = socket.getInputStream(); //소켓을 통해 inputstream생성
			int readCount = is.read(bytes); //배열에다 읽어옴
			str = new String(bytes,0,readCount,"UTF-8");
			//콘솔에 출력
			System.out.println("[send completed]");
			
			os.close();//output스트림 객체 닫음
			is.close();//Input스트림 객체 닫음
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}
	
}
