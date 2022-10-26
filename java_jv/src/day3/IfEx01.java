package day3;

public class IfEx01 {

	public static void main(String[] args) {
		/* ㅇㅇㅇ하면 ㅁㅁㅁ한다.
		 * ㅇㅇㅇ: 조건식
		 * ㅁㅁㅁ :  실행문
		 * 
		 * if(조건식){
		 * 실행문 ;
		 * }
		 * */
		
		//<예제> 정수 num이 0보다 크면 양수라고 출력하는 코드를 작성
		/*if ( 정수 num이 0 보다 크다){
		 * 		양수라고 출력;
		 * }
		 * */
		
		int num = 10;
		if(num > 0) {
			System.out.println(num + "은 양수입니다.");
		}
		
		//정수 num이 0과 같으면 0이라고 출력
		if(num == 0) {
			System.out.println(0);
			
		}
		
		//정수 num이 0보다 작으면 음수라고 출력
		if(num <0) {
			System.out.println(num + "음수입니다.");
		}
	}

}
