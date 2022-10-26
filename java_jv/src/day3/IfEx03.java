package day3;

public class IfEx03 {

	public static void main(String[] args) {
		/*조건식1 참 => 실행문1 실행
		 * if(조건식1){
		 * 		실행문1;
		 * }
		 * 
		 * 조건식1이 거짓, 조건식 2 참 = > 실행문2 실행
		 * else if(조건식2){
		 * 		실행문2
		 * }
		 * 
		 * 조건식1, 조건식2 거짓 = > 실행문3 실행
		 * else(조건식3){
		 * 		실행문3;
		 * }
		 * 
		 * if : 반드시 시작은 if로 시작. 무조건 1개 필요.
		 * else if : 0개 이상 (여러개 있을수 있음 or 없을수도 있음)
		 * else : 0개 또는 1개 , else에는 괄호가 안들어감.
		 */
		
		//정수가 양수, 음수 , 0인지 판별하는 코드 작성.
		
		int num = 10;
		if (num > 0) {
			System.out.println(num + "은/는 양수");
			}else if (num == 0){
				System.out.println(0);
			}else {
				System.out.println(num + "은 음수");
			}
		}
}
