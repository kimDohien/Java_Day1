package day19;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexEx01 {

	public static void main(String[] args) {
		/*이메일 주소를 입력받아 이메일 형식이 맞는지 확인하는 코드를 작성하세요.
		 * 단,정규표현식 이용.
		 * abc123@naver.com
		 * abc123@xxx.or.kr
		 */
		Scanner scan = new Scanner(System.in);
		String Regex ="^[a-zA-Z0-9\\-_]+@[a-zA-Z0-9]{2,}(\\.[a-zA-Z]+){1,2}$";
		System.out.println("이메일을 입력하세요 >");
		String email = scan.next();
		boolean res = Pattern.matches(Regex, email);
		if(res) {
			System.out.println("이메일이 확인되었습니다.");
		}else {
			System.out.println("맞지 않는 이메일 입니다.");
		}
		
	}

}
