package day25;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		/*
		 * 정수를 다섯번 입력하여 배열/리스트에 저장하는 코드를 작성하세요. 
		 * 정수가 홀수이면 그대로 저장, 정수가 짝수이면 -를 붙여서 저장
		 * 
		 */
		int size = 5;
		ArrayList<Integer> arr1 = new ArrayList<Integer>();

		Scanner scan = new Scanner(System.in);
		
		for(int i=0; i<size;i++) {
			System.out.println("정수 입력 : ");
			int num = scan.nextInt();
			if(num % 2 !=0 ) {
				arr1.add(num);//홀수 저장
		}else { 
			arr1.add(-num);//짝수 저장
			}
		}
		for(int num : arr1) {//잘 저장됐는지 확인
			System.out.println(num+"");
		}
		
	}
}
