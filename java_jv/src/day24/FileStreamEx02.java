package day24;

import java.io.*;

public class FileStreamEx02 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
		fis = new FileInputStream("test.txt");
		fos = new FileOutputStream("test.txt");
		dis = new DataInputStream(fis);
		dos = new DataOutputStream(fos);
		
		
		dos.writeUTF("김도현");
		dos.writeUTF("2000-02-01");
		
		dos.writeUTF("김지수");
		dos.writeUTF("2000-01-02");
		
		dos.writeUTF("김명수");
		dos.writeUTF("2000-04-03");
		
		while(true) {
			String name =dis.readUTF();
			String birth = dis.readUTF();
			System.out.println(name+" : "+birth);
		}
		
		}catch(EOFException e) {
			System.out.println("파일 읽기가 완료되었습니다.");
		}catch(Exception e) { //최상위클래스이기떄문에 Exception으로 하면 모든 예외가 처리됨.
			e.printStackTrace();
		}finally {
			try {
			fis.close();
			fos.close();
			dis.close();
			dos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
