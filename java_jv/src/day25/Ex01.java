package day25;

import java.util.Scanner;

public class Ex01 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * 정수를 입력받아 입력받은 정수가 0이상이면 0부터 입력받은 수까지 합을 구하고 
		 * 입력받은 정수가 0미만이면 0부터 입력받은 수까지 차를
		 * 구하는 코드를 작성하시오. 
		 * 예) 정수입력 : 3 
		 * 0~3까지 합 : 6 
		 * 정수 입력 : -3 
		 * 0~-3까지 누적 차 : 6
		 */

		System.out.println("정수를 입력 : ");
		int num = scan.nextInt();

		int sum = 0;
		if (num >= 0) {
			for (int i = 0; i <= num; i++) {
				sum += i;
			}
			System.out.println("0부터 " + num + "까지의 합 : " + +sum);
			} else {
			for (int i = 0; i >= num; i--) {
				sum -= i;
			}
			System.out.println("0부터 " + num + "까지의 누적 차 : " + +sum);
		}
	}
}
