package day24;

import java.io.File;
import java.io.IOException;

public class FileEx02 {

	public static void main(String[] args) {
		File f = new File("D:/test2/test");
			//폴더한개 생성
			if(f.mkdir()) {
				System.out.println("폴더가 생성되었습니다. ");
			}else {
				System.out.println("폴더 생성에 실패하였습니다.");
			}
			
			//여러폴더 생성
			if(f.mkdirs()) {
				System.out.println("폴더들이 생성되었습니다. ");
			}else {
				System.out.println("이미 폴더들이 있습니다.");
			}
			
			//파일 디렉토리 정보 메소드
			if(f.isDirectory()) //생성한게 폴더이면 폴더명이 나오게
			System.out.println("폴더명 : " + f.getName());
			if(f.isFile())//생성한게 파일이면 파일명이 나오게
				System.out.println("파일명 : "+ f.getName());
			
			
			//폴더 삭제
			if(f.delete()) {
				System.out.println("폴더가 삭제되었습니다."); //test폴더 삭제하고 test2폴더만 남음.
			}else {
				System.out.println("없는 폴더 입니다.");
			}
	}

}
