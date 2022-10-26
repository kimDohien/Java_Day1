package day3;

public class IfEx02 {

	public static void main(String[] args) {
		// 정수 num이 홀수인지 짝수인지 판별하는 코드를 작성해라
		int num = 5;
		//정수 num이 짝수이면 짝수라고 출력, num이 짝수가 아니면 홀수라고 출력
		//정수 num을 2로 나누었을 때 나머지가 0과 같다면 짝수라고 출력
		if (num % 2 == 0) {
			System.out.println(num + "은/는 짝수");
		}
		//정수 num이 짝수가 아니면 홀수라고 출력
		else{
			System.out.println(num + "은/는 홀수");	
		}
		
	
	}

}
