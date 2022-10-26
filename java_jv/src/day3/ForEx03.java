package day3;

public class ForEx03 {

	public static void main(String[] args) {
		//구구단 2단을 출력하는 코드를 작성하세요.
		
		/*반복횟수 : i는 1부터 9까지 1씩 증가
		 * 규칙성: 2 X ? = ??를 출력
		 * 
		 * 출력예시
		 * 2 X 1 = 2
		 * 2 X 2 = 4
		 * 2 X 3 = 6
		 * ...
		 * 2 X 9 = 18
		 */
		
		int i;
		int num = 2;
		for( i = 1 ; i <=9 ; i++ ) {
			System.out.println(num +"X "+ i + " = " + i*num);
			
		}

	}

}
