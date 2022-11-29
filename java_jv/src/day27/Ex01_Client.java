package day27;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import day27.Ex02_Server.Client;

public class Ex01_Client {

	public static void main(String[] args) {
	 Socket socket = null;
	 
	 try {
	 socket = new Socket();
	 System.out.println("[Try Connecting]");
	 socket.connect(new InetSocketAddress("localhost",5001)); //localhost : 내부 아이피 주소를 말함. 생략해도됨
	 System.out.println("[Connect Success]");
	 send(socket,"DH");
	 receive(socket);

	 }catch(Exception e) {
		 System.out.println("[Connect Fail]");
	 }
	}
		public static void receive(Socket socket) { //클라이언트는 자기꺼 하나만 관리하면 되기때문에 클리스만들 필요 X
			Thread t = new Thread(() -> {
				InputStream is = null;
				try {
					byte [] bytes = new byte[1024]; 
					is = socket.getInputStream();
					
					while(true) { 
						int readCount = is.read(bytes); 
						
						if(readCount ==-1) 
							break;
						
						String str = new String(bytes, 0 , readCount, "UTF-8");
						int index = str.indexOf(","); //토큰은 내가 어떻게 send에서 보내는지에따라 같이 설정하면 됨
						if(index == -1)
							continue;
						String name =str.substring(0,index) ; //0번지 부터 index까지(index는 콤마의 위치를 뜻함)
						String message=str.substring(index+1);//index(=,)있는 다음번지부터 부분 문자열을 뽑는다
						System.out.println(name +"> "+message);
					}
					is.close();
					
				}catch(Exception e) {
					
				}finally {
					
					try {
						//읽어오는중 예외가 발생(클라이언트 접속종료)했으면 socket을 닫아줘야함
						if(socket != null && !socket.isClosed()) 
							socket.close();
						System.out.println("[Client Clsoe]");
						}catch(Exception e2) {
							System.out.println("[!ClientSocket Close Fail!]");
						}
				}

				});
				t.start();
	}
	
		
	public static void send(Socket socket,String name) { //name은 ID같은것
		Thread t = new Thread(()->{
		Scanner scan = new Scanner(System.in);
		
			try {
				OutputStream os = socket.getOutputStream(); 
				while(true) {
					String str = scan.nextLine();
					if(str.equals("exit")) { //exit를 입력하면 반복문 빠져나감
						break;
					}
					str = name+","+str; //"이름,보내려는 메세지" 이렇게 출력되도록
					byte [] bytes = str.getBytes("UTF-8");
					os.write(bytes);
					os.flush();
				}
			
				
			}catch(Exception e) {
				
			}finally {
				System.out.println("The End");
				try {
					if(socket != null && !socket.isClosed()) //소켓이 닫쳐있지않면 닫아준다.
						socket.close();
				}catch(Exception e) {
					System.out.println("!Client fail to close socket!");
				}
			}
		});
		t.start();
	}
}
