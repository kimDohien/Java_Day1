package day25;

public class RecursionFunctionEx01 {
	/*
	 * 재귀함수 (함수의 실행문) : 자신을 다시 호출하는 함수.
	 * - 잘못 작성하면 스택 오버 플로우(무한루프)가 발생할수 있음
	 */
	public static void main(String[] args) {
	//print(10);//스택 오버 플로우 발생
		
		/*
		 * 양수 정수 n!을 구하는 코드를 작성하세요.
		 * n! =1x2x3x....xn
		 * n*(n-1)!
		 * n*(n-1)*(n-2)!
		 * 
		 * ※0! =1
		 */
	System.out.println(factorial(5));

	}
	public static long factorial(int num) {
		if(num<0)
			throw new RuntimeException("음수는 팩토리얼을 구할수 없다.");
		if(num ==1 || num ==0) //1! ,0! => 1
			return 1; //탈출조건 
		//n*(n-1)!
		return num * factorial(num-1);
		
	}
	
	public static void print(int num) {
		System.out.println(num);
		print(num);
	}

}
