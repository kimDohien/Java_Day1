package day6;

import java.util.Scanner;

public class ArrayRandomEx01 {

	public static void main(String[] args) {
		// 랜덤으로 1-9사이의 숫자3개를 생성하여 배열 저장하는 코드를 저장

		Scanner scan = new Scanner(System.in);

		int min = 1, max = 9;
		int arr[] = new int[3];

		for (int i = 0; i < 3; i++) {
			arr[i] = (int) (Math.random() * (max - min + 1) + min);
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		// 정수를 입력받아 랜덤한 수에 있는지 없는지 확인해서 알려주는 코드를 작성하세요.
		//정수를 입력하세요 : 4
		//4는 있습니다.

		System.out.println("정수를 입력하세요 : ");
		int num = scan.nextInt();
		boolean isDuplicated = false;
		
		for(int i =0; i<arr.length; i++) {
			//i 번지에 있는 값과 num이 같으면
			if(arr[i]==num) {
				//중복 됐다고 저장함
				isDuplicated = true; //있으면 듀플리케이트를 트루로 바꿈.
				break;
			}
		}
		//중복 됐으면 있다고 출력하고 아니면 없다고 출력
		if (isDuplicated) {
			System.out.println(num + "랜덤 안에 있음.");
		} else {
			System.out.println("없음.");

		}

	}

}
