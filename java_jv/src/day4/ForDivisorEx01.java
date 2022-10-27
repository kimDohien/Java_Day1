package day4;

public class ForDivisorEx01 {

	public static void main(String[] args) {
		/* 정수 num의 약수를 출력하는 코드를 작성하세요.
		 * 약수 : 나누었을 때 나머지가 0이 되게하는 수
		 * 6의 약수 :  1,2,3,6 
		 * 반복횟수 :  1부터 num까지 1씩 증가
		 * 규칙성 :  num을 i로 나누었을떄 나머지가 0과 같다면 i출력
		 */
		//
		int  num = 6, i ;
		
//		for ( i = 1 ; i <= num ; i++) {
//			if( num % i == 0) {
//				System.out.println( i + " ");
//			}	
//		}
//		
		
		for( i =1 ; i <=6  ; i++) {
			if(num % i ==0 ) {
			 System.out.println( i + " " );	// " "는 공백
			}
		}
		
	}

}
