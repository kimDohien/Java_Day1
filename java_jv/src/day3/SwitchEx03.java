package day3;

public class SwitchEx03 {

	public static void main(String[] args) {
		// IfEx06 예제를 switch 문으로 변경
		char ch = '-';
		
		switch (ch) {
		case '+', '-', '*', '/', '%' :
			System.out.println(ch + "는 산술 연산자 입니다.");
		 	break;
		default:
			System.out.println(ch + "는 산술연산자가 x");
		}

	}

}
