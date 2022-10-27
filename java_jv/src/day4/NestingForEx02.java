package day4;

public class NestingForEx02 {

	public static void main(String[] args) {
		/*2부터 100사이의 소수를 출력하는 코드를 작성하세요.
		 * 반복회수 :  num을 2부터 100까지 1씩 증가
		 * 규칙성 : num이 소수이면 num을 출력
		 * 		 반복회수 :  i는 1부터 num 까지 1씩증가
		 * 		 규칙성 : num을 i로 나누었을 때 나머지가 0과 같다면 count를 1 증가
		 * 		 반복문 종료후 : count가 2이면 num을 출력
		 * 반복문 종료 후 : 없음
		 */
		
		int num,i,count=0;			//
		
		for(num=2; num <=100; num++) {
			for(i=1,count=0 ;  i <=num ; i++) { //count를 계속 초기화해줘야 하기때문에 꼭 안에 넣어서 써줘야함
				if(num % i ==0) {
					count++; 
				}
			}
			if(count == 2) {
				System.out.println(num + " ");
	}				
		}	
	}
		
		
			
		
	}


