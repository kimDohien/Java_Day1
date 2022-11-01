package day7;

public class MethodEx05 {

	public static void main(String[] args) {
		// 1부터 10까지 합을 구한는 코드를 작성하세요.
		
		/*
		 * 기능 : 시작수 부터 끝수 사이에 모든 정수를 더하고, 그 합을 알려주는 메소드
		 * 매개변수 : 시작숫자, 끝숫자 => 정수 => int min, int max 
		 * 리턴타입 : 더한결과 = > 정수(int)
		 * 메소드명 :sum
		 */
	
		int min =10 , max = 1;
		System.out.println(min + "부터"+ max + "까지의 합 : "+ sum(min,max));
		
	}

	public static int sum(int min,int max) {
		if(min>max) {
			int tmp = min;
			min = max;
			max=tmp;
			//숫자 바꾸는 코드
		}
	int sum =0;
	for(int i = min ; i <= max; i++) {
		
			sum +=i;
		}
	
	return sum;
	}
	
}	
	
	
//	
//	<내가 한 코드>
//	sum(5,10);
//	
//	}
//
//	public static void sum(int min,int max) {
//	int sum1 =0;
//	for(int i=min ; i<=max; i++) {
//		sum1 +=i;
//	}
//	
//	System.out.println(sum1);

