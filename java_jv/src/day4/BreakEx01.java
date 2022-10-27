package day4;

public class BreakEx01 {

	public static void main(String[] args) {
		
		int i;
		for (i =1 ; i<=5 ; i++) {
			System.out.println("Hello world!");
			if(i == 3 ) {
				break; 
				//break를 만나면 증감식으로 가지 않고 3일때 결과값이 멈추게 되어 반복문을 빠져나온다. 
			}
		}
	}

}
