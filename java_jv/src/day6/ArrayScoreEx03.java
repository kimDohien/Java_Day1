package day6;

import java.util.Scanner;

public class ArrayScoreEx03 {

	public static void main(String[] args) {
		/*5명 학생의 국어,영어,수학 성적을 저장하기 위한 배열을 만들고,
		 * Scanner를 이용하여 입력받아, 국어평균, 영어평균, 수학평균을 구한느 코드를 작성하세요.
		 * 
		 */
		
		
		int Score1,Score2,Score3;
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("국어성적 : ");
		int kor[] = new int[5];
		for(int i = 0; i<kor.length; i++ ){
			
			Score1 = scan.nextInt();
			kor[i] = Score1;
		
		}
		for (int i : kor) {
				
			}
		System.out.println("영어성적: ");
		int eng[]= new int[5];
		for(int i = 0; i<eng.length; i++ ){
			
			Score2 = scan.nextInt();
			eng[i] = Score2;
		
		}
		for (int i : eng) {
				
			}
		System.out.println("수학성적 : ");
		int math[] = new int[5];
		for(int i = 0; i<math.length; i++ ){
			
			Score3 = scan.nextInt();
			math[i] = Score3;
		
		}
		for (int i : math) {
			
			}
		
		
		
		
		
	
						
				

			
			
		
			
			
	}

}

