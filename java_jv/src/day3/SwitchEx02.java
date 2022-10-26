package day3;

import java.util.Scanner;

public class SwitchEx02 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받아 산술 연산 결과를 하는 코드를 switch 문으로 작성하세요.
		 *  */
		Scanner Scan = new Scanner(System.in);
		System.out.print("두 정수와 문자를 입력하세요 (예: 1 + 2) : ");
		int num1 = Scan.nextInt();
		char ch = Scan.next().charAt(0);
		int num2 = Scan.nextInt();
		
		switch(ch) {
		case   '+' :
			System.out.println(""+num1 + ch + num2 + "=" + (num1 +num2));
		break;
		
		case   '-' :
			System.out.println(""+num1 + ch + num2 + "=" + (num1 - num2));
		break;

		case  '*' :
			System.out.println(""+num1 + ch + num2 + "=" + (num1 *num2));
		break;

		case  '/' :
			System.out.println(""+num1 + ch + num2 + "=" + (num1 / num2));
		break;
		
		case  '%' :
			System.out.println(""+num1 + ch + num2 + "=" + (num1 % num2));
		break;

		default :
			System.out.println(ch + "는 산술연산자가 아닙니다.");
		
			
		}
		
	}

}
