package day3;

import java.util.Scanner;

public class SwitchEx04 {

	public static void main(String[] args) {
		/* 월을 입력받아 해당하는 월의 마지막 일을 출력하는 코드를 작성하세요.
		 * 31일 있는 달 : 1 3 5 7 8 10 12
		 * 30일 있는 달 : 4 6 9 11
		 * 28일 있는 달 : 2
		 */
		
		Scanner Scan = new Scanner(System.in);
		System.out.println("월을 입력하세요 : ");
		int mon = Scan.nextInt();
	
		
		Scan.close();
		
		switch(mon) {
		case 1,3,5,7,8,10,12 : 	//※int를 쓰면 case에 문자열,문자상태로 쓰면 안되고 정수형태로 써야한다.
			System.out.println(mon + "월은 31일까지 있습니다.");
			break;
		case 4,6,9,11 :
			System.out.println(mon + "월은 30일까지 있습니다.");
			break;	
		case 2 :
			System.out.println(mon + "월은 28일까지 있습니다.");
			break;	
		default:
			System.out.println(mon + "월은 없습니다.");
			
		}
	}

}
