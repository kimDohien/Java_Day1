package day6;

import java.util.Scanner;

public class ArrayRandomEx02 {

	public static void main(String[] args) {
		/*
		 * 랜덤으로 1-9사이의 숫자를 중복되지 않게 3개 생성하여 배열 저장하는코드.
		 * 
		 */

		int min = 1, max = 9;
		int arr[] = new int[3];

		// 배열에 저장된 중복되지 않은 수가 3개가 될때까지 반복해야힘
		for (int i = 0; i < arr.length; i++) {
			// 랜덤한 수 생성

			arr[i] = (int) (Math.random() * (max - min + 1) + min);
			//배열에 저장된 수 중에서 랜덤한 수와 일치하는 숫자가 있는지 없는지 확인하여
			//배열에 저장된 숫자개수만큼 확인
			for (int j = 0; j < i; j++) {

				if (arr[i] == arr[j]) {

					
					i--;

				}

			}

		}

		for (int i = 0; i < arr.length; i++) {

			System.out.print(arr[i] + " ");

		}

	}
}
