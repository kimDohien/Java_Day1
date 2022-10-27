package day4;

public class BreakPrimeNumberEx01 {

	public static void main(String[] args) {
		//break문을 이용하여 소수를 판별하는 예제
		//6 => 5,4,3 
		//7 => 65432 1 =>소수
		
		int num=6;
		int i;
		for(i = num-1 ; i >= 1; i--) {
			if(num % 1 == 0) {
				break;
			}
			
		}
		if(i ==1) {
			System.out.println(num + "는 소수이다.");
			
		}else {
			System.out.println(num + "는 소수가 아니다.");
		}
			
	}

}
