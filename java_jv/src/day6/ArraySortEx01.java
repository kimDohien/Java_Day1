package day6;

import java.util.Arrays;
import java.util.Collections;

public class ArraySortEx01 {

	public static void main(String[] args) {
		// 버블 정렬을 이용한 배열정렬
		int arr[]= {1,3,5,7,2,8,6,9};
		for(int i = 0; i<arr.length-1;i++) {
			for(int j= 0; j<arr.length-1-i;j++) {//마지막 전꺼가 마지막꺼랑 비교해야하니까 -1 해줘야함
			//두 수를 바꿔야함
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] =tmp;
				}
			}
			for(int tmp : arr) {
			System.out.print(tmp + " "); 
		}
		System.out.println();
	}
	
	System.out.println("-----------") ;
	int arr2[] = {9,8,7,6,5,4,3,2};
	Arrays.sort(arr2);
	for(int tmp : arr2) {
		System.out.println(tmp + " ");
	}
	
	
//	System.out.println("-----------") ;
//	int arr3[ ] = {9,8,7,6,5,4,3,2};
//	Arrays.sort(arr3, Collections.reverseOrder());
//	for(int tmp : arr3) {
//		System.out.println(tmp + " ");
	}
	
}

