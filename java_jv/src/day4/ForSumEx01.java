package day4;

public class ForSumEx01 {

	public static void main(String[] args) {
		// 1부터 10사의 짝수의 합을 구하는 코드를 작성하세요. 
		//반복 횟수 : i는 1부터 10까지 1씩증가. 
		// 규칙성 : i가 짝수이면(if문쓰기) sum += i를 실행
		
		int i, sum = 0;
		for( i = 1 ; i <=10  ; i++) {  
			// for( i = 1, sum = 0 ; i <=10  ; i++) 이렇게 써도 상관없음. 
			//위에 sum 변수를 선어해서 밑에 안쓴거임
			if( i % 2 ==0 ) {
				sum += i;
			}
			
		}
		System.out.println("1부터 10까지 짝수 합 : " + sum);
		

}
}
