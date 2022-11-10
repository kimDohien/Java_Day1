package day14;

import java.util.Calendar;

public class CalenderEx01 {

	public static void main(String[] args) {
		/*Calendar 클래스 : 날짜와 관련된 클래스
		 * get이라는 메소드를 통해서 년도,월,일,시,분,초···다양한 정보를 가져옴
		 */
		Calendar cal = Calendar.getInstance();
//		System.out.println(cal);
		cal.add(Calendar.YEAR,1); //지금 시간으로부터 1년뒤를 추가
		cal.add(Calendar.YEAR,-1); //지금 시간으로부터 1년전 추가한거임
		
		int year = cal.get(Calendar.YEAR); //year은 클래스필드이고 상수라는 뜻
//		int year = cal.get(1); year의 초기값이 1이라서 이렇게 써도 상관은 없지만..위에처럼 쓰는게 좋다.
		System.out.print(year+"년 ");
		
		int month = cal.get(Calendar.MONTH)+1; //month는 0부터 시작하기때문에 +1을 해줘야한다
		System.out.print(month+"월 ");
		
		int date = cal.get(Calendar.DATE);
		System.out.print(date+"일 ");
		
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		System.out.print(hour + "시 ");
		
		int min = cal.get(Calendar.MINUTE);
		System.out.print(min + "분 ");
		
		
		
	}

}
