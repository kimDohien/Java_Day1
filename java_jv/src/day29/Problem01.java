package day29;

import java.util.Scanner;

public class Problem01 {

	public static void main(String[] args) {
		
		/*아래 코드를 실행했을 때 결과와 결과가 그렇게 나오는 이유를 설명하세요.
		 */
		Scanner scan = new Scanner(System.in);
		String str1 = "abc";
		String str2 = "abc";
		String str3 = scan.next();//abc를 입력했다고 가정
		
		System.out.println(str1==str2);
		System.out.println(str1==str3);

		
	}

}
