package day7;

public class MethodEx06 {

	public static void main(String[] args) {
		int [] arr = {1,3,5};
		test (arr);
		for(int tmp : arr) {
			System.out.println(tmp+ " ");
		}
	}
public static void test(int []arr) {
	arr= new int[3];
	arr[0] =10;
}
}
//매개변수로 배열을 전달할때 arr= new int[3]; 로 인해서 main에 있는 arr이 바뀌지 않는다.