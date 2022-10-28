package day5;

public class ArrayEx05 {

	public static void main(String[] args) {
		/*
		 * 5개짜리 배열을 생성하여 2부터 5개의 소수를 배열에 저장하고 출력하세요.
		 * 
		 */
	
		
		int num = 2 ; //소수인지 판별하려는 수
		int i; //약수를 찾기위해 1부터 num까지 증가시키려는 수
		int count=0; //num의 약수 개수를 저장하는 수
		int arr[] = new int[5]; //소수를 저장할 5개짜리 정수 배열
		int index = 0; // 소수를 저장할 배열의 번지
		
		for(num =2; ; num++) {
			//num가 소수인지 판별하는 코드
			for( i = 1 , count=0; i <= num ; i++ ) {
				if( num % i == 0)			{
					 count++; 
				}
			}
			
			if (count == 2) {
				arr[index] = num;
				index++;
			}
			if(index == arr.length) {
				break;
			}
		}
		for (int tmp : arr) {
			System.out.println(tmp + " ");
		}
		}
			
			
		
	

	}




