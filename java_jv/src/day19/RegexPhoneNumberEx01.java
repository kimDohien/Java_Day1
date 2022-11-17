package day19;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexPhoneNumberEx01 {

	public static void main(String[] args) {
		// 전화번호 정규표현식을 작성하여 입력받은 번호가 전화번호가 맞는지 출력하는 코드를 작성하세요.
		//규칙1.
		//010-1234-5678 [O]
		//010-12345678 [X]
		//011-1234-5678[X]
	
		Scanner scan = new Scanner(System.in);
		String Regex ="^(010)-\\d{4}-\\d{4}$";
		//^(010)-\\d{4}-\\d{4}$ => ^(010)(-\\d{4}){2}$
		System.out.println("핸드폰 번호를 입력하세요 >");
		String email = scan.next();
		boolean res = Pattern.matches(Regex, email);
		if(res) {
			System.out.println("핸드폰 번호가 확인되었습니다.");
		}else {
			System.out.println("맞지 않는 핸드폰 번호 입니다.");
		}
	}

}
