package day5;

public class DoWhileEx01 {

	public static void main(String[] args) {
		/*for문, while문 은 상황에 따라서 한번도 동작하지 않을 수 있다.
		 * do while문은 최소 1번은 실행된다.
		 * 
		 * <문법>
		 * do{
		 * 		실행문;
		 * }whiel(조건식); //※조건식 뒤 세미콜론은 필수.
		 */
		
		//Hello 출력되지 않음.
		for(int i =1; i<=5;  i++) {
			System.out.println("Hello");
		}
		
		
		//<예제>
		//조건식이 거짓이어도 최소 한번은 실행된다.
		int j =1;
		do {
			System.out.println("Hello world!");
		}while(j>=5);
		
		
	}

}
