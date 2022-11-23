package day24;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamEx01 {

	public static void main(String[] args) {
		
		FileOutputStream fos = null; //1.널로 먼저 초기화해주고
		FileInputStream fis = null; //읽어오는
		try { //2.try,catch로 예외처리
			fos = new FileOutputStream("test.txt");
			char ch ='\u0000';
			for(int i =0; i<200; i++) {
//				System.out.print(ch);
				fos.write(ch);
					++ch;
			}
			fis = new FileInputStream("test.txt");
			int num;
			for(int i =0; i<200; i++) {
				num= fis.read();
				System.out.println((char)num);
				
			}
		}catch(FileNotFoundException e) {
			System.out.println("파일을 찾지 못했습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
				fis.close();
				//이메소드를 실행할떄 IOException이 발생할수 있습니다.
			} catch (IOException e) {
				e.printStackTrace();
			} //close스트림은 finally안에서 닫아줘야한다.
			//예외가 날수있어서 예외처리르 또 해줘야함.
		}
		
	}

}
