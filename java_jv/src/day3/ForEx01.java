package day3;

public class ForEx01 {

	public static void main(String[] args) {
		/* for(1.초기화; 2.5.8 조건식; 4.7 증감식){
		 * 		3.6 실행문;  //숫자는 순서를 의미
		 * }
		 * 
		 * 1.초기화 : 조건식 또는 실행문에서 사용하는 변수를 초기화
		 * 			for문 시작시 한번만 실행, 생략 가능
		 * 2.5.8 조건식 :  거짓이면 반복문 종료
		 * 				 참이면 반복문을 실행
		 * 				 생략 가능 그러나 but 생략하면 무조건 참
		 * 
		 * 3.6 실행문 :  실행
		 * 4. 증감식 : 조건식에서 사용하는 변수를 증가/ 감소시켜서 반복문 횟수를 결정
		 * 			 생략 가능함. 
		 * 
		 * ● 초기화 + 조건식 + 증감식을 => 반복 횟수를 결정
		 * ● 실행문 : 규칙적인 작업 
		 */

		int i = 1; //i++, i+1, ++i 등등으로 적어도 상관없음.
		for ( i =1 ; i <= 5 ; i++  ) {
			System.out.println("hi");
		}
	}

}