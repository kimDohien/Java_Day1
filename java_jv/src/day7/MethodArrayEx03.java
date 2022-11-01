package day7;

public class MethodArrayEx03 {

	public static void main(String[] args) {
		// 배열에 정수 num이 '있는지 없는지' 확인하는 코드를 작성하세요. 메코드 이용
		
		/*
		 * 기능 : 배열에 정수 num이있는지 알려주는 메소드
		 * 매개변수 : 정수, 배열 => int arr[], int num
		 * 리턴타입 : 있는지 없는지 => boolean
		 * 메소드명 : contains
		 *
		 */
		
		int arr[]= {1,2,3,4,5};
		int num =2;
		if(contains(arr,num)) {
			System.out.println(num+"은 배열에 있습니다.");
		}else {System.out.println(num+"은 배열에 없습니다.");
		}
	}
		
	public static boolean contains(int [] arr, int num) {
		for(int tmp : arr) { //상향식for문
			if(num==tmp) {
				return true;
				
			}
		}
		return false;
	}
		
		
		
	
	
}
	
	

