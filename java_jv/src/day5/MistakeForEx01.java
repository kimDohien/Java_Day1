package day5;

public class MistakeForEx01 {

	public static void main(String[] args) {
		// ;에 의해 실행문 출력에 오류가 날수있다. 

		int i;
		for(i =1 ; i<= 5 ;i++) 
		{
			System.out.println(i);
		}
//		int i;
//		for(i =1 ; i<= 5 ;i++) ; <- 세미콜론을 for바로 뒤에 붙이면 여기서 반복문 끝이 나기때문에. 
//								 	답이 6이 나온다. 
//		{
//			System.out.println(i);
//		}
//		
		
		
		i=5;
		if(i%2==0);
		{
			System.out.println("짝수");
		}
//				//else는 if문이 필요한데 if문이 없어서 오류가 난다 .
//		else {  //오류나는 이유는 if 괄호 뒤에 세미콜론으로 끝냈기때문이다.
//			System.out.println("홀수");
//		}
		
		//조건문, 반복문은 실행문이 한줄이면 {}가 생략이 가능
		for(i=1; i<=5; i++);
		System.out.println(i);
		
	}
	
	

}
