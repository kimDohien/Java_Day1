package day_11;

public class StringEx02 {

	public static void main(String[] args) {
		/*문자열 str에 search가 몇번 등장하는지 확인한느 코드를 작성 */
		String str = "Hello world! My name is Hong";
		String Search = "o";
		
	
		String tmp =str ; //나중에 o라는 문자열이 몇번있는지 출력하기위해서 tmp라고 다시지정해주는거임.
		int count =0;
		
		while(true) {
			/*System.out.println(tmp);
			 * o를 찾고 그다음부터 찾기 시작함.
			 */
			//str에서 search가 있는 위치를 찾음(indexOf이용)
			int index =tmp.indexOf(Search);
			if(index == -1) { //index가 -1이면 반복분을 빠져나옴
				break;
			}
				//-1이 아니면 부분 문자열을 추출
				tmp = tmp.substring(index+Search.length());
				count++;
		}
			System.out.println(str+"에는 "+Search +"가 " + count +"번있습니다.");
		
		

	}

}
