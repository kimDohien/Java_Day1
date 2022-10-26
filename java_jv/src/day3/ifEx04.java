package day3;

public class ifEx04 {

	public static void main(String[] args) {
		// 정수 num이 3의 배수이면 3의 배수라고 출력하고 , 아니면 3의 배수가 아닙니다.를 출력해라.
		
		int num = 9;
		//num을 3으로 나누었을때 나머지가 0과 같다면 3의 배수라고 출력
		if(num % 3 == 0) {
			System.out.println(num + "은 3의 배수입니다.");
		//아니면 3의 배수가 아닙니다.
		}else {System.out.println(num + "은 3의 배수가 아닙니다." );
		}

	}

}
