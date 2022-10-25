package day2;

public class OperatorEx06 {

	public static void main(String[] args) {
		/* 논리연산자
		 * && : 둘다 참이면 참, 나머지는 거짓
		 *    	말로 표현했을때 ~이고, ~이면
		 * || :  둘다 거짓이면 거짓, 나머지는 참
		 * 		 말로 표현했을때 ~이거나
		 * ! :  반대를 표현
		 *  	말로 표현했을때 ~가 아닌
		 */

			int score = 85;
			//score가 80점 이상(>=)이고 90점 미만(<)인가;
			boolean isB = score >= 80 && score < 90;
			System.out.println(score +"점은 B학점인가? "+ isB);
				}

}
