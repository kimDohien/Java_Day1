package day2;

import java.util.Scanner;

public class OperatorEx05 {

	public static void main(String[] args) {
		/*예제
		 * 홍길동 학생의 국어, 영어, 수학 점수를 콘솔에 입력받고,(Scanner)
		 * 홍길동 학생의 세과목의 평균 성적을 콘솔에 출력하는 코드를 작성하소
		 * 테스트는 81 90 100을 입력하여 90.33333 이 나와야한다.
		 */
		int kor, eng, math, sum;
		double avg;
		
		//scanner통해 성적 입력
		Scanner scan = new Scanner(System.in);
		System.out.println("국어 : ");
		kor = scan.nextInt();
		
		System.out.println("영어 : ");
		eng = scan.nextInt();
		
		System.out.println("수학 : ");
		math = scan.nextInt();
	
		scan.close();
		
		//총점을 계산
		sum=kor+eng+math;
		
		//평균을 계산
		avg = sum /3.0;
		//avg = (double)sum /3;
		//avg = sum /3.0; 두가지 방법으로 형변화 해줄수 있따. 
		
		
		
		//평균을 출력
		System.out.println("평균은" + avg + "입니다.");
		
		//통과입니까? true/false
		//기준 : 평균이 60점 이상
		//통과를 알려주는 변수, 실패를 알려주는 변수
		boolean isPass = avg >=60;
		boolean isFail = avg <60;
		System.out.println( "통과입니까?" + isPass);
		System.out.println( "통과입니까?" + !isFail);
		
	}

}
