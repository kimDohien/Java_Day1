package day3;

public class SwitchEx01 {

	public static void main(String[] args) {
		/*switch(식 또는 변수명){
		 * case 값1 :  	 if(식 == 값1)
		 * 		실행문1;  
		 * 		break;
		 * case 값2 :		else if(식 == 값2)
		 * 		실행문2;
		 * 		break;
		 * default :		else
		 * 		실행문3;
		 * 
		 * }
		 * -case 옆에 있는 값들은 정수, 문자, 문자열만 올 수 있따.
		 * 	변수명은 올수 없다. 상수(리터럴 + final변수)
		 * -break :  switch 문을 빠져나가는 역할
		 * -default : else와 같음. 생략가능
		 * - Switch문 사용하는 경우
		 * 	1. 식의 값이 제한적일때 : %연산자 사용하는 경우
		 * 	2. 사용하는 변수 값이 제한적일 때 :  산술연산자를 이용한 계산 예제
		 * - break문이 없으면 break있는 실행문까지 계속 수행됨.(다음 case의 값과 달라도 이동한다)
		 * -여러 경우를 같이 처리하고 싶으면
		 *  case 값1, 값2, 값3 :
		 *  
		 */
		
		int num = 0;
		switch(num % 2) {
		case 0:
			System.out.println(num + "짝수");
			break;
		default :
			System.out.println(num + "홀수");
		}
	}

}
