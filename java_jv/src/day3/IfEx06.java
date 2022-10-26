package day3;

import java.util.Scanner;

public class IfEx06 {

	public static void main(String[] args) {
		// Scanner를 입력받아 + - * / % 이면 산술 연산자라고 출력하고
		// 아니면 산술연산자가 아닙니다 라고 출력하는 코드를 작성
		
		//char ch변수를 위에 쓴거를 밑에 합쳐서 써서char ch = Scan ~~
		Scanner Scan =  new Scanner(System.in);
		System.out.println("문자를 입력하세요 : ");
		char ch = Scan.next().charAt(0);
		Scan.close();
		
		//ch 가 +같 '거나', - 같'거나' ····
		if(ch == '+' || ch =='-' || ch =='*' || ch =='/' || ch =='%') {
		System.out.println( ch + "는 산술연자 입니다.");
		}else {System.out.println( ch + "는 산술연산자가 아닙니다.");
		}
		}
		
		
	}
	

