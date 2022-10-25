package day2;

import java.util.Scanner;

public class scannerEx01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요 : ");
		int num = scan.nextInt();
		System.out.println(num);

		System.out.println("실수를 입력하세요 : ");
		double num2 = scan.nextDouble();
		System.out.println(num2);
		
		System.out.println("정수A 와 정수B를 입력하세요 : ");
		int A = scan.nextInt();
		int B = scan.nextInt();
		System.out.println(A);
		System.out.println(B);
		
		scan.close();		

	}

}


