package day6;

import java.util.Scanner;

public class ArrayUpDownEx01 {

	public static void main(String[] args) {
		/*
		 * updown 게임을 무조건 3번 반복해서 맞춘 3번의 횟수를 배열에 저장하여 출력하는 코드를 작성하세요 각 게임당 몇번 만에 맞췄는지를
		 * 배열에 저장하여 출력하는 코드를 작성
		 */

		// 1.반복횟수를 정함
		int coin = 3; // 게임 3회
		int record[] = new int[coin];// 몇번 실행해서 맞춰는지 기록해야함
		int min = 1, max = 100;

		Scanner scan = new Scanner(System.in);// 스캐너는 반복문 위에

		while (coin-- > 0) {
			int r = (int) (Math.random() * (max - min + 1) + min);

			// System.out.println(r); 랜덤값 나옴.

			System.out.println(min + " ~ " + max + "사이의 랜덤한 수를 맞추세요.");
			int num;
			int trycount = 0;
			do {
				trycount++;// 반복문 실행될때마다 횟수 증가
				System.out.print("숫자를 입력하세요 : ");
				num = scan.nextInt();
				if (num == r) {
					System.out.println("정답입니다.");
					record[record.length - coin - 1] = trycount;

				}

				else if (num > r) {
					System.out.println("DOWN");
				} else {
					System.out.println("UP");
				}

			} while (r != num);

		}
		for(int i=0; i<record.length; i++) {
			System.out.println(i+1 +"번째 게임횟수 : " + record[i]);
		}
	}
}
