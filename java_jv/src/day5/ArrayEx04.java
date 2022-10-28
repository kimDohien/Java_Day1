package day5;

import java.util.Scanner;

public class ArrayEx04 {

	public static void main(String[] args) {
		/*학생 5명의 / 국어 성적을 입력받고 / 출력하는 코드를 작성하세요.
		 * 반복횟수 : i는 0부터 배열의 크기보다 작을때까지 1씩증가
		 * 규칙성 : 콘솔에서 입력받은 정수를 배열 i번지에 저장 후 배열 i번지에 있는 값을 출력
		 * 
		 * 
		 */
		
		
		int Score;
		Scanner scan = new Scanner(System.in);
		
		
		
		int arr[] = new int[5];
		for(int i = 0; i<arr.length; i++ ){
			System.out.println((i+1) +" 번째 학생의 성적을 입력하세요 : ");
			//i+1 을 써야하는 이유는 i가 0부터 시작이기 때문에 +1을 해줘야함.
			Score = scan.nextInt();
			arr[i] = Score;
			//위에 두줄을 score[i]=scan.nextInt(); 로 써도 상관없음.
			
		}
		for (int i : arr) {
				System.out.println(i);
			}

//		<방법2>
//		for(int i = 0; i<arr.length; i++ ){
//			System.out.println((i+1) +" 번째 학생의 성적을 입력하세요 : ");
//			score[i]=scan.nextInt();
//			System.out.println(i+1 +" 번째 학생의 성적을 입력하세요 :" + score[i]);
		
		
		
		/*
		 * 학생 성적의 평균을 구하는 코드를 작성하세요.
		 */
		
		int sum = 0;
		for(int i = 0 ; i<arr.length; i++ ){
			sum += arr[i];
		}
		double avg = (double)sum / arr.length;
		System.out.println("학생 성적의 평균은 :"+ avg);
		
		//향상된 for문 이용
		sum=0;
		
		for (int i : arr) {
			sum +=i;
			
		}
		avg = (double)sum / arr.length;
		System.out.println("학생들의 평균 :" + avg);
						
				
			}
	}


