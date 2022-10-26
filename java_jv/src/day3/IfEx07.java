package day3;

import java.util.Scanner;

public class IfEx07 {

	public static void main(String[] args) {
		/* 두 정수와 문자를 입력받아 산술연사자이면 산술연산 결과를 출력하는 코드를 작성하세욧.
		 * 예시
		 * 두 정수와 문자를 입력하세요 (예 :  1+2) : 1/2
		 * 1/2 = 0.5
		 * ?는 산술연산자가 아닙니다.
		 * */
	
		Scanner Scan = new Scanner(System.in);
		System.out.print("두 정수와 문자를 입력하세요 (예: 1 + 2) : ");
		int num1 = Scan.nextInt();
		char ch = Scan.next().charAt(0);
		int num2 = Scan.nextInt();

		if(ch == '+' ) {
			System.out.println(""+num1 + ch + num2 + "=" + (num1 +num2) );
		}else if( ch =='-' ) {
			System.out.println(""+num1 + ch + num2 + "=" + (num1 -num2) );
		}else if( ch =='*' ) {
			System.out.println(""+num1 + ch + num2 + "=" + (num1 * num2) );
		}else if( ch =='/' ) {
			System.out.println(""+num1 + ch + num2 + "=" + ((double)num1 / num2) );
		}else if( ch =='%' ) {
			System.out.println(""+num1 + ch + num2 + "=" + (num1 % num2) );
		
		
		}else {System.out.println(ch + "는 산술연산자가 아닙니다.");
		}
		Scan.close();
	}

}
