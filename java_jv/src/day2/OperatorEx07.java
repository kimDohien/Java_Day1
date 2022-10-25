package day2;

public class OperatorEx07 {

	public static void main(String[] args) {
		/* 조건 선택 연산자
		 * - 조건식 ? 참일때 : 거짓일때;
		 */
		//주어진 성적이 60점 이상이면 pass 아니면 fail이 출력되도록 코드를 작성
		int score = 80;
		String result = score >=60 ? "pass" : "fail";
						//조건식 ? 참일때 :  거짓일때;
						//성적이 60점 이상이면 ? pass : fail;
						//성적이 60점 이상이면 ? "pass" : "fail";
		System.out.println(score + "점은 " + result);
		

	}

}
