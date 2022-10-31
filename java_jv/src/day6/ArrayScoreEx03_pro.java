package day6;

import java.util.Scanner;

public class ArrayScoreEx03_pro {

	public static void main(String[] args) {

		Scanner Scan = new Scanner(System.in);

		int sdtCount = 5;
		int kor[] = new int[5];
		int eng[] = new int[5];
		int math[] = new int[5];
		int sum1 = 0, sum2 = 0, sum3 = 0;
		double avg;

		// 학생별 국어,영어,수학 성적을 입력
		for (int i = 0; i <= sdtCount; i++) {
			System.out.print(i + 1 + "학생의 국어성적 : ");
			kor[i] = Scan.nextInt();
			System.out.print(i + 1 + "학생의 영어성적 : ");
			eng[i] = Scan.nextInt();
			System.out.print(i + 1 + "학생의 수학성적 : ");
			math[i] = Scan.nextInt();

			// 과목별 합
			sum1 += kor[i];
			sum2 += eng[i];
			sum3 += math[i];
			/*
			 * <과목별 합 다른방법> double sum1 = 0;sum2 = 0;sum3 = 0; }for(int i=0 ; i<stdCount;
			 * i++){ sum1 += kor[i]; sum2 += eng[i]; sum3 += math[i];
			 * 
			 */
		}

		// 과목별 평균
		avg = (double) sum1 / kor.length;
		System.out.println("국어 성적의 평균은 :" + avg);
		avg = (double) sum2 / eng.length;
		System.out.println("영어 성적의 평균은 :" + avg);
		avg = (double) sum3 / math.length;
		System.out.println("수학 성적의 평균은 :" + avg);

		/*
		 * <성적의 평균 구하는 다른방법> System.out.println("국어 성적의 평균은 :"+korsum / stdCount);
		 * System.out.println("영어 성적의 평균은 :"+engsum / stdCount);
		 * System.out.println("수학 성적의 평균은 :"+mathsum / stdCount);
		 */

		// 학생별 평균

		for (int i = 0; i < sdtCount; i++) {
			double sum = kor[i] + eng[i] + math[i];
			System.out.println("학생" + (i + 1) + "의 성적 평균은 : " + sum / 3);

		}

	}

}
