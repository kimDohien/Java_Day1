package day4;

public class ForPrimeNumberEx01 {

	public static void main(String[] args) {
		/* 정수 num이 소수인지 아닌지 판별하는 코드를 작성하세요.
		 * 소수는 약수가 1과 자기 자신뿐인 수 : 2 3 5 7 11 13 ...
		 * 1은 소수가 아니다. 
		 * 반복횟수 :  1부터 num까지 1씩 증가
		 * 규칙성 :  i가 num의 약수이면 약수의개수(count)를 1증가.
		 *  */
		int num = 2 , i, count=0;
		for( i = 1 ; i <= num ; i++ ) {
			if( num % i == 0)			{
				 count++; //++count; //count = count +1; // count+=1;
			}
		}
				
			
		if (count == 2) {
			System.out.println(num + "는 소수");	
		}else {System.out.println(num + "는 소수 X");	
			
		}	
			
				
			
		}
	}


