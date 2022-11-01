package day7;

public class MethodEx03 {

	public static void main(String[] args) {
		// 주어진 정수 num이 소수인지 아닌지 판별하는 코드를 작성하세요.
		/*
		 * 단, 메소드를 이용할것
		 * 
		 */

		PrimeNumber(6);
		System.out.println(isPrimeNumber(2));
		
		
	}

	/*
	 * 기능 : 정수가 주어지면 소수인지 아닌지 출력하는 메소드
	 * 매개변수 : 주어진 정수 => 정수 => int num 
	 * 리턴타입 : 출력한다=없음 =>void 
	 * 메소드명 :PrimeNumber
	 */
	
	public static void PrimeNumber(int num) {
		int i=0, count=0; //안에서 따로 선언 해줘야함
		for (i = 1,count=0; i <=num; i++) {
			if (num % 1 == 0) {
				count++;
			}
		
		}
	if(count == 2) {
		System.out.println(num + " 은 소수이다.");
	}else {
		System.out.println(num + "는 소수가 아니다.");
		
		}
	}
	
	/*
	 * 기능 : 정수가 주어지면 소수인지 아닌지 알려주는 메소드
	 * 매개변수 : 주어진 정수 => 정수 => int num 
	 * 리턴타입 : 소수인지 아닌지 =>boolean
	 * 메소드명 :isPrimeNumber
	 */
	public static boolean isPrimeNumber(int num1) {
		for (int i = 2; i <num1; i++) {
			//1과 num을 제외한 약수
			
			if (num1 % i == 0) { //약수인지 아닌지 판별
				return false;//한번이라도 나누어졌으니 소수가 아니므로 false
			}
		}
		return num1 <= 1 ? false : true;  // 나눠진 수가 없으니 해당수는 소수 
		//그런데 num1이 0밑으로 음수값도 false로 나타내기 위해 num1<=1을 써준거임
	}
	
}

