package day32;

import java.util.StringTokenizer;

public class StringTokenizerEx01 {

	public static void main(String[] args) {
		//split을 통한 예제
		String str = "abc,def,ghi";
		String [] arr = str.split(",.");
		for(String tmp : arr) {
			System.out.println(tmp);
		}
		
		//StringTokenizer을 이용한 예제
		System.out.println("----------");
		StringTokenizer st = new StringTokenizer(str,".,");
		System.out.println("개수 : "+st.countTokens());
							//countTkoens는 토큰 개수가 몇개인지 알려줌
		while(st.hasMoreElements()) {
			String tmp = st.nextToken();
			System.out.println(tmp);
		}
		
		//StringTokenizer을 이용한 예제
		System.out.println("----------");
		//true를 추가하면 구분자(토큰)도 같이 나옴
		st = new StringTokenizer(str,".,",true); 
		System.out.println("개수 : "+st.countTokens());
		while(st.hasMoreElements()) {
			String tmp = st.nextToken();
			System.out.println(tmp);
		}
	}

}
