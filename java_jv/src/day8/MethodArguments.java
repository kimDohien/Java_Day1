package day8;

public class MethodArguments {

	public static void main(String[] args) {
		/*매개 변수의 개수를 다양하게 하고 싶을 때
		 * 
		 * 매개변수에 자료형 ... 배열명 => 메소드에서 배열처럼 사용
		 * 
		 * 가변인자는 반드시 매개변수 마지막에 사용
		 */

		System.out.println(sum());
		System.out.println(sum(1));
		System.out.println(sum(1,2));
		System.out.println(sum(1,2,3));
		//매개변수를 ,로 여러개 입력 
	}
	
	public static int sum(int ...nums) { //가변인자
		if(nums==null || nums.length ==0) { //넘버스가 널이거나, 넘버스의길이가 0이거나
			return 0;
		}
		int sum =0;
		for(int num : nums) {
			sum +=num;
		}
		return sum;
		
	}
	public static int sum(int num) {
		return num;
	}
	
	public static void test(int grade, int classNum,String name, int ...score ) {
		//가변인자는 항상 마지막에 오도록 해야한다.
		
	}

}
