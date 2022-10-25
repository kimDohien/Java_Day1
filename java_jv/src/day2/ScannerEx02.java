package day2;

import java.util.Scanner;

public class ScannerEx02 {

	public static void main(String[] args) {
		/*next() : 공백(스페이스,탭)을 제외한 한 단어를 입력받음. 
		 * 		   다음 공백이 나오기 전까지 문자열을 가져온다.
		 *nextline() : 공백(스페이스,탭)을 포함한 문자열을 가져온다.
		 */
		
		Scanner scan= new Scanner(System.in);
		
		System.out.println("Typing one sentence : ");
		String str1 = scan.nextLine();
		System.out.println(str1);
		
		System.out.println("Typing one word : ");
		String str2 = scan.next();
		System.out.println(str2);
		
		
		
		scan.close();
	}

}
