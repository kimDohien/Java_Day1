package day5;

public class WhileEx01 {

	public static void main(String[] args) {
		/*while문 문법
		 * 
		 * <방법1>
		 * while(조건식){
		 * 		실행문;
		 * }
		 * 
		 * 
		 * <방법2>
		 * 초기화;
		 * while(조건식){
		 * 		실행문;
		 * 		증감식;
		 * }
		 * 
		 * continue는 while문에서 조건식으로 건너뛴다. 
		 * (while문에서는 증감식 위치는 없고 실행문안에 증감식이 포함되어있다.)
		 * 
		 * ※while문에서는 조건식을 생략할수 없다.
		 * ※while문에서 무한루프를 만들려면 조건식에 true를 넣어주면 된다.
		 * 
		 */

		int i =1;
		for(i=1; i<=5 ; i++) {
			System.out.println("Hello World!");
		}
		
	System.out.println("-----------------");
		
	//while문으로 변경
		i=1;
		while(i<=5) {
			System.out.println("Hello World!");
			i++;
		}
		
		//증감식을 조건식 안에 적을수도 있다.
		i=1;
		while(i++ <=5) {
			System.out.println("Hello World!");
			
		
		
	}

}
}
