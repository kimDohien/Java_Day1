package day5;

import java.util.Scanner;

public class ForUpDownEx01 {

	public static void main(String[] args) {
		/* 랜덤한 수를 생성하여 해당 수를 맞추는 코드를 작성하세요.
		 * 예시 :  생성한 랜덤한 수 70 (랜덤으로 생성한 코드는 반복문에 들어가면 안됨)
		 * 1~100사이의 랜덤한 수를 맞추세요. 
		 */
		
		/* 랜덤수를 맞추기
		 * 반복횟수 :  맞출때까지 => 랜덤수 r과 입력한 수가 일치하지 않을때까지
		 * 규칙성:
		 * -1. 숫자를 입력하세요 :  안내문구 출력
		 * -2. 정수를 입력받음
		 * -3. 입력받은 정수가 r과 같으면 정답입니다.라고 출력하고
		 * 		입력받은 정수가 r보다 크면 Down이라고 출력하고
		 *     	아니면 UP이라고 출력한다.
		 * 반복문 종료 후 : 없음.
		 */
		
		
		int min = 1, max = 100, num = min -1; 
		int r = (int)(Math.random()*(max - min + 1)+min);
				
		
		Scanner Scan = new Scanner(System.in);
		
			//반복횟수 
		for( ;r !=num ; ) {
			
			//1.
			System.out.print("숫자를 입력하세요 : ");
			
			//2.
			int Result = Scan.nextInt();
			
			//3.
			if(num == r) {
				System.out.println("정답");
			}else if(num>70) {
				System.out.println("Down");
			}else {System.out.println("Up");
		}
			
			
	
		
	
		
		
	
		
		
		}
		
	}
}
		
		
		
		
	


