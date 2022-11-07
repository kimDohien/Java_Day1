package day_11;

public class StringEx01 {

	public static void main(String[] args) {
		
		//string은 class이다. 
		//대문자로 시작한다.
		
		/*String 클래스는 문자열의 값을 수정할수 없다.
		 *StringBuffer 클래스는 문자열의 값 수정할수있다. 
		 *=>기존의 각각번지에 새로운 문자열로 바뀌는것. 기존 문자가 없어지고 새로만드는게 아님.
		 *StringBuilder와 클래스는 StringBuffer와 동일하다.
		 *StringBuffer는 쓰레드에서 Safe기능 제공하고 , String Builder는 제공하지 않는다.
		 *
		 *" "문자열을 통해서 저장가능, str = new String();생성자를 통해서 저장도 가능하다.
		 *
		 */
		
		//기존에 했던 abc값은 없어지고 def가 새로 만들어져서 연결되는것이다.
		String str = "abc";
		System.out.println(str);
		str = "def";
		System.out.println(str);
		
		
		/*length() : 문자열 길이 */
		
		System.out.println("문자열의 길이 : " + str.length());
		//배열길이 : 3 출력 됨. def가 3개의 배열이니까.
		int []arr = new int[5];
		System.out.println("배열의 길이 : " + arr.length);
		
		/* ★ indexOf(문자 또는 문자열 올수있음) : 해당 문자열/문자를 0번지부터 탐색하여 
		 * 							첫번째로 만나는 문자열/문자의 시작번지, 없는경우에는 -1 */
		System.out.println("e의 첫번째 위치 : " +  str.indexOf("e"));
		
		/* ★lastIndexOf(문자 또는 문자열 : 해당 문자열/문자를 마지막 번지부터 탐색하여 
		 * 								첫번째로 만나는 문자열/문자의 시작번지, 없는경우에는 -1*/
		System.out.println("e의 마지막번째 위치 : " +  str.lastIndexOf("e"));
		
		/* contains(문자열 또는 문자) : 해당 문자열/문자가 있는지 없는지를 알려줌 */
		
		
		/*subString(시작번지) : 문자열의 시작번지부터 끝까지 부분 문자열을 추출
		 *subString(시작번지, 마지막번지) :  문자열의 시작번지 부터 마지막 번지-1 까지 부분마자열을 추출
		 */
		System.out.println("0번지부터 부분문자열"+str.substring(0));
		System.out.println("2번지부터 부분문자열"+str.substring(1,3));
		
		
		
		/* equals(문자열) : 문자열과 같은지 다른지를 알려줌
		 * 문자열은 참조변수이기 때문에  == 를 통해서는 정확히 같은지 다른지를 비교할수 없다.
		 * 문자열을 비교할때는 ==를 쓰면 안된다. 
		 * 
		 * 리터럴 문자열은 리터럴들만 모여있는 공간에 할당이 된다.
		 * 같은 리터럴 문자열이 있는 경우 새로 만들지 않고 기존에 있는 리터럴 문자열의 주소를 반환
		 */

		String str1 = "abc";
		String str2 = "abc";
		String str3 = new String("abc");
		System.out.println("str1 : "+str1);
		System.out.println("str2 : "+str2);
		System.out.println("str3 : "+str3);
		System.out.println("str1 과 str2가 같다?(==) " + (str1 ==str2));
		//true라고 뜨는 이뉴는 st1과 str2 주소가 같기때문.
		System.out.println("str1 과 str3이 같다?(==) " + (str1 ==str3));
		//false라고 뜨는 이유는 주소를 비교하는데,, str1과 str3이 주소가 다르기때문이다.
		System.out.println("str1 과 str2가 같다?(equals) " + (str1.equals(str2)));
		System.out.println("str1 과 str3이 같다?(equals) " + (str1.equals(str3)));
		//그렇기 때문에 equals를 써줘서 비교해야한다.
		
		
		
		/*charAt(번지)  : 문자열에서 해당 번지에 있는 문자열을 반환
		 */
		String str4 ="Hello";
		System.out.println(str4 + "문자열에 2번지에 있는 문자 : "+str4.charAt(2));
		
		
		/*split(정규표현식) : 정규표현식을 기준으로 문자열을 추출하여 배열로 만듬 
		 */
		String fruit = "사과,배,오렌지,귤";
		String [] fruits =fruit.split(","); //배열로 반환하기때문에 배열로 표시
		for(String tmp : fruits) {
			System.out.println(tmp);
		}
		
		/*trim() : 시작 문자 앞에 있는 공백을 제거하고 마지막 문자 뒤에있는 공백을 제거한다.
		 */
		String str5 = "\n\n    \t안녕 하세요. \n\n";
		System.out.println("trim전 문자열 : "+str5);
		System.out.println("trim후 문자열 : "+str5.trim());
		
		
		
	}

}
