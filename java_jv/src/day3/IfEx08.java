package day3;

import java.util.Scanner;

public class IfEx08 {

	public static void main(String[] args) {
		/*점수를 정수로 입력받아 입력받은 성적에 맞는 학점을 출력하는 코드를 작성하세요.
		 * A :90 ~ 100
		 * B :80 ~ 89
		 * C :70 ~ 79
		 * D :60 ~ 69 
		 * E :0 ~ 59
		 * 잘못된 성적 :  그 외
		 */
		
		//정수를 입력받아 score에 저장
		Scanner Scan = new Scanner(System.in);
		System.out.println("점수를 입력하세요 : ");
		int num = Scan.nextInt();
		
		Scan.close();
		
		if(num>100 || num <0) {
			System.out.println(num + "은 그 외");
		}
		if(num >=90 ) {
			System.out.println("A");
			
		}else if(num >=80 ){
			System.out.println("B");
		}
		else if(num >=70 ){
			System.out.println("C");
		}
		else if(num >=60 ){
			System.out.println("D");	
		}
		else if(num >=0 ){
			System.out.println("E");
		}
		
	}

		
	
	}



		
		


