package day3;

import java.util.Scanner;

public class IfEx05 {

	public static void main(String[] args) {
		//정수 num이 2의 배수이면  2의 배수라고 출력하고
		//3의 배수이면 3의 배수라고 출력하고
		//6의 배수이면 6의 배수라고 출력하고
		//2,3,6의 배수가 아니면 2,3,6의 배수가 아닙니다 라고 출력
		//단 6의 배수는 6의 배수라고만 출력.
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("정수를 입력하세요 : ");
		int num = scan.nextInt();
		
		scan.close();
		
		//<방법2>
		if(num % 2 == 0 && num %3 != 0) {
			System.out.println(num +"는 2의 배수입니다.");
		}else if(num % 3 ==0 && num % 2 != 0 ) {
			System.out.println(num + "는 3의 배수입니다.");
		}
		else if (num % 6 == 0) {
			System.out.println(num + "는 6의 배수입니다.");
		}else {System.out.println(num + "2,3,6의 배수가 아닙니다.");
		}
		
		//<방법 1>
		if(num % 6 == 0 ) {
			System.out.println(num +"는 6의 배수입니다.");
		}else if(num % 3 ==0 ) {
			System.out.println(num + "는 3의 배수입니다.");
		} else if (num % 2 == 0) {
			System.out.println(num + "는 2의 배수입니다.");
		}else {System.out.println(num + "2,3,6의 배수가 아닙니다.");
		}
		}
		

	}


