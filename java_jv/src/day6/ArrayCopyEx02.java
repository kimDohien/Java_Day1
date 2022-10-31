package day6;

public class ArrayCopyEx02 {

	public static void main(String[] args) {
		int arr1[] = new int[] {1,2,3};
		int arr2[];
		
		//깊은복사 예제1
		arr2 = new int[arr1.length];
		for(int i = 0; i<arr1.length; i++) {
			arr2[i]=arr1[i];
		}
		//arr2=arr1; //arr1을 얕은 복사해서 arr2를 만듬.
				//arr1과 arr2 값 확인
		for(int i =0; i<arr1.length;i++) {
			System.out.println("arr["+i+"] = "+ arr1[i]+", arr2["+i+ "] =" +arr2[i]);
		}
		
		arr1[0]=10; // arr1의 값만 10으로 변경 했음. 값은 arr2[0]도 10으로 나옴.
		System.out.println("-----------------");
		
		//arr1과 arr2 값 확인, arr1, arr2모두 10이 출력.
		
		for(int i =0; i<arr1.length;i++) {
			System.out.println("arr["+i+"] = "+ arr1[i]+", arr2["+i+ "] =" +arr2[i]);
		}
//깊은 복사는 얕은복사와 달리 복사하고 서로다른 개체를 만들기때문에. 하나의 배열값을 바꿔도 달라지지않음.
		
	}

}
