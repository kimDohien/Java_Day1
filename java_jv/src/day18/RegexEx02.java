package day18;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexEx02 {

	public static void main(String[] args) {
		/* 아이디 정규표현식
		 * 영문 소문자 5~20자리로 구성, 숫자오 툭수기호 _ - 만 사용가능
		 */
		
		String regex = "^[a-z0-9_\\-]{5,20}$";
		Scanner scan = new Scanner(System.in);
		System.out.println("ID입력 : ");
		String id = scan.next();
		boolean res = Pattern.matches(regex, id);
		if(res) {
			System.out.println("올바른 아이디입니다.");
		}else {
			System.out.println("영문 소문자 5~20자리로 구성, 숫자와 툭수기호 _ - 만 사용가능");
		}
			
	}

}
