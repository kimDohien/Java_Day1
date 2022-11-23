package day24;

import java.io.File;
import java.io.IOException;

public class FileEx01 {

	public static void main(String[] args) {
		File f = new File("C:\\Users\\user2\\Downloads\\test.txt"); //D/C 안넣어져있는거를 상대경로라고 함.
		try {
			if(f.createNewFile()) {
				System.out.println("파일이 생성되었습니다. ");
			}else {
				System.out.println("파일 생성이 실패하였습니다.");
			}
		} catch (IOException e) {
			System.out.println("IOException이 발생했습니다. ");;
		}
	}

}
