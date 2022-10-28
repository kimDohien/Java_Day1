package day5;

public class VariableEx01 {

	public static void main(String[] args) {
		/* 변수는 선언된 위치에서 같은 {}내에서 사용이 가능하다.
		 * 
		 * 
		 */
		
		int i = 0;
		for(int j = 1; j<=5; j++) { 
			//반복문 안 초기화내에서j를 선언했음. j는 선언된 중괄호 안에서만 실행가능. 
			//반복문 초기화에서 변수를 선언하면 이미 선언된 변수를 초기화 할수 없다. 
			//for(int j = 1 , i=5 ; j<=5; j++) => i가 이미 선언되어있어서 오류가 난다. 
			System.out.println(j);
		}
		//System.out.println(j);
		// 에러발생. 위 {}안 반복문에서만 실행가능.
		
		

	}

}
