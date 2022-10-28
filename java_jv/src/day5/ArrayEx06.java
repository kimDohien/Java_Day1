package day5;

import java.util.Scanner;

public class ArrayEx06 {

	public static void main(String[] args) {
		/*
		 * 정수 4개짜리 배열을 생성한 후, 4자리 숫자를 입력받아 배열에 저장해라
		 * 1234
		 * 0번지에 : 1
		 * 1번지에 : 2
		 * 2번지에 : 3
		 * 3번지에 : 4
		 */
	
		
		//4자리 정수를 입력
		Scanner Scan = new Scanner(System.in);
		int size = 4;  //size라고 한 이유는 언제든 숫자가 바뀔수 있게 하기 위해서
		System.out.println(size + "자리 정수를 입력하세요 : ");
		int num = Scan.nextInt();		
		
		 //반복횟수 : 4번
		 // num에서 1의 자리를 추출		1234에서 4를 추출
		 // 
		 // 추출된 1의 자리를 배열에 저장	arr[3]=4
		 // num에서 1의 자리를 제거하여 num에 저장 1234에서 123을num에 저장
		  
		int num2=num; 
		int arr[] = new int[size];
		
		for(int i = size -1 ; i>=0; i-- ){ //거꾸로 저장해야해서 size-1해야함. 0번째까지.
 			arr[i] = num % 10; //1의자리를 수출하기 위해서 %10을 하는것.
 			num = num / 10; // 다르게 쓰면 : num /= 10;
		}
		for(int tmp : arr) {
			System.out.print(tmp);
		}
		
		System.out.println("-----------");
		
		//<방법2>
		int i = size -1;
		while(num2 > 0) {
			arr[i] = num % 10;
			num =  num / 10; // num /=10;
		}
		for(int tmp: arr) {
			System.out.println(tmp);
		}
		
		
	}

}
