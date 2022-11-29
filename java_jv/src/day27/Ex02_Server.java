package day27;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;




public class Ex02_Server {
	
	//내가 연결된 클라이언트 정보를 알고있어야 하기때문에, 클라이언트 정보를 ClientList에 저장
	private static ArrayList<Client> clientList = new ArrayList<Client>();

	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(5001));
			System.out.println("[Server Start]");
			while (true) { // 무한루프 만듬
				Socket socket = serverSocket.accept(); // 수락된 client소켓정보를 가져옴

				Client client = new Client(socket);
				client.recieve();
				clientList.add(client);
				
				System.out.println("[Client Logged in] - Number of people courrently logged in : "+clientList.size());
			}
		} catch (Exception e) { // 모든 예외를 처리할수있는 Exception
			System.out.println("[Server Exception : Close Server]");
		}
	}
		
	//
		static class Client {

			private Socket socket;// socket 객체 생성

			public Client(Socket socket) {
				this.socket = socket;
			}

			public void recieve() { // read대신 recieve로 변수명 수정
				Thread t = new Thread(() -> {
				InputStream is = null;
				try {
					byte [] bytes = new byte[1024]; //바이트변형 해서 한번에 읽어올수있는 최대 바이트 = 1024
					is = socket.getInputStream();
					/*read(): 1바이트를 읽어와서 정수로 알려줌
					 *raad(byte []bytes) : bytes크기만큼 한번에 읽어와서 bytes배열에 저장하고, 
					 *					   읽어온 갯수를 정수로 알려줌 */
					
					while(true) { //읽어오는거를 채팅 끝날때까지 반복해야하니까 while문으로 반복해줌
						int readCount = is.read(bytes); //readCount 는 읽어온 개수 
						
						if(readCount ==-1) 
							break;
						
						String str = new String(bytes, 0 , readCount, "UTF-8");
						/* byte[]에 있는 byte들을 문자열로 변환, 
						 * 0번지부터 readCount개수만큼 변화한하고 인코딩은 UTF-8 */
						
						if(clientList.size()==0) {
							continue;
						}
						for(Client tmp : clientList) {
							tmp.send(str);
						}
					}
					is.close();
					
				}catch(Exception e) {
//					e.printStackTrace();
					
				}finally {
					try {
						//읽어오는중 예외가 발생(클라이언트 접속종료)했으면 socket을 닫아줘야함
						if(socket != null && !socket.isClosed()) 
							socket.close();
						//clientList에서 접속 종료한 클라이언트를 제거
						clientList.remove(this);
						System.out.println("[Client Clsoe] - Number of people currently logged in : "+clientList.size());
						
						}catch(Exception e2) {
							System.out.println("[!ClientSocket Close Fail!]");
							
						}
				}

				});
				t.start();
			}

			public void send(String data) {
				Thread t = new Thread(()->{
					
					OutputStream os=  null;
					try {
						os = socket.getOutputStream();
						byte [] bytes = data.getBytes("UTF-8"); 
						os.write(bytes);
						os.flush();
					}catch(Exception e) {
						System.out.println("[!Server Exception!]");
					}
					
				});
				t.start();
			}
		}

	}


