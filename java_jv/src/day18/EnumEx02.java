package day18;

import java.util.Scanner;

public class EnumEx02 {

	public static void main(String[] args) {
		/*오늘의 요일을 영어로 입력받아 한글로 출력하는 코드를 작성하시오.
		 * ex)
		 * 요일 :WENDSDAY
		 * 수요일
		 * 
		 */
	
		//열거형 쓰지않고 하는법
		Scanner scan= new Scanner(System.in);
		System.out.println("요일 : ");
		String day = scan.next();
		switch(day) {
		case "Monday":
			System.out.println("월요일");
			break;
		case "Tuesday":
			System.out.println("화요일");
			break;
		case "Wendsday":
			System.out.println("수요일");
			break;
		case "Thursday":
			System.out.println("목요일");
			break;
		case "Friday":
			System.out.println("금요일");
			break;
		case "Saturday":
			System.out.println("토요일");
			break;
		case "Sunday":
			System.out.println("일요일");
			break;
		default : 
			System.out.println("잘못 입력하였습니다.");
		}
		
		
		//열거형으로 했을경우
		try {
		Week week = Week.valueOf(day);
		switch(week) {
		case Monday:
			System.out.println("월요일");
			break;
		case Tuesday:
			System.out.println("화요일");
			break;
		case Wendsday:
			System.out.println("수요일");
			break;
		case Thursday:
			System.out.println("목요일");
			break;
		case Friday:
			System.out.println("금요일");
			break;
		case Saturday:
			System.out.println("토요일");
			break;
		case Sunday:
			System.out.println("일요일");
			break;
		//default처리 X,예외처리 O
			}
		}catch(Exception e) {
			System.out.println("잘못 입력하였습니다. ");
		}
		
	}
}
enum Week{
	Monday,Tuesday,Wendsday,Thursday,Friday,Saturday,Sunday
}
