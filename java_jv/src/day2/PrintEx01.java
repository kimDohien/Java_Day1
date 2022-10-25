package day2;

public class PrintEx01 {

	public static void main(String[] args) {
		/* println() : 원하는 값을 출력한 후 엔터
		 * 				()안에 값을 생략 가능함 - 괄호 안에 정수,실수v.v...다 들어갈수있음
		 * print() : 원하는 값을 출력
		 * 				()안에 값을 생략 불가함
		 * 문자열 + 정수 => 문자열
		 * 정수 + 문자열 => 문자열
		 * 문자 + 문자열 => 문자열
		* */
		
		//예제1
		String name = "Gil Dong Hong";
		int age = 20;
		System.out.println(name + "의 나이는 " + age + " 살 입니다.");
		
		//예제2
		int num1 =10;
		int num2 =20;
		char operator = '+';
		//값 : 10+20
		System.out.println("" + num1 + operator + num2);
		
	}

}
