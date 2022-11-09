package day13;

import java.util.Scanner;

import day9.HighStudent;

public class StudentManagerTest {

	public static void main(String[] args) {
		/*학생 성적 관리 프로그램을 작성하세요.
		 * -작성하기 위해 필요한 작업들을 주석으로 정리해보세요
		 * 
		 * 1.프로그램에 필요한 기능 정리
		 * 메뉴
		 * 	1.학생 정보 추가
		 * 	2.학생 성적 추가
		 * 	3.학생 정보 출력
		 * 	4.프로그램 종료
		 * 
		 * 2.프로그램 실행 과정은 어떻게 할것인지
		 * 	기능
		 * 	1.학생정보 추가
		 *  - 학년,반,번호,이름을 입력하여 학생 정보 추가
		 *  - 학년,반,번호가 같은 학생이 이미 있으면 추가하지 않음
		 * 	2.학생 성적 추가
		 * 	-학년 반 번호로 학생을 검색한 후 있으면 성적을 추가한다
		 * 	-성적 추가시 과목명,학기, 중간, 기말, 수행평가를 입력하여 추가한다
		 * 	-이미 추가된 과목(학기랑 과목명이 같으면)이면 추가하지 않음
		 * 	3.학생 정보 출력
		 *  
		 * 3.정보를 효율적으로 관리하기 위해 클래스를 만들것인가? 만든다면 어떤 클래스를 만들것인가?
		 * -학생class HighStudent
		 * -성적class Score
		 * 
		 * 4. 프로그램 실행 과정을 주석으로 작성
		 * 
		 */
	
	Scanner scan = new Scanner(System.in);
	Student[] stds= new Student[30]; //학생 배열 설정
	int count = 0; //초기에 저장된 학생수
	//반복	
	for( ; ;) {
		//메뉴출력
	System.out.println("메뉴");
	System.out.println("1.학생 정보 추가");
	System.out.println("2.학생 성적 추가");
	System.out.println("3.학생 정보 추가");
	System.out.println("4.프로그램 종료");
	System.out.println("메뉴 선택 : ");
		//메뉴선택
	int menu = scan.nextInt();
	
	int grade, classNum, num;
		String name;
		
		//선택한 메뉴에 따른 기능 실행
	if(menu ==1) {
		//1.학생정보 추가
		//학생 정보를 입력(학년,반,번호,이름)
		
		System.out.println("학생 정보를입력하세요> ");
		System.out.print("학년 : ");
		grade=scan.nextInt();
		System.out.print("반 : ");
		classNum=scan.nextInt();
		System.out.print("번호 : ");
		num=scan.nextInt();
		System.out.print("이름 : ");
		name=scan.next();
		System.out.println("["+grade + "학년 "+ classNum + "반 "+num+"번호 "+name+"]");
		
		//입력한 학생 정보가 없으면 추가
		/*=>학생 정보들 중에서 하나씩 비교하여 학년,반,번호가 같은 학생이 있는지 확인해서 
		 *  없으면 마지막 학생 뒤에 추가
		 */
		
		//기존 학생정보가 있는지 없는지 확인
		int index =-1;
		Student tmp = new Student(grade, classNum,num,name);
		for(int i=0 ; i<count; i++) {
			if(stds[i].equals(tmp)) {
				index = i ;//찾았으면 찾은 번지를 알려준다
			}
		}
		if(index == -1 && count<stds.length) { //일치하는 학생이 없으면 && 학생 배열보다 개수가 적으면
			stds[count] =tmp;
			count++; //한명 추가했으니까 카운트업
		}
		
		
		
		
	}else if(menu ==2) {
		//2.학생 성적 추가
		//학생 정보를 입력(학년,반,번호)
		//입력한 학생 정보가 없으면 조건문 종료(continue를 통해 조건식으로)
		
		System.out.println("<학생 성적 추가> ");
		System.out.println("학생 정보를입력하세요> ");
		System.out.print("학년 : ");
		grade=scan.nextInt();
		System.out.print("반 : ");
		classNum=scan.nextInt();
		System.out.print("번호 : ");
		num=scan.nextInt();
		System.out.println(grade + "학년 "+ classNum + "반 "+num+"번호 ");
		
		//정보가 있는지 확인
		int index =-1;
		Student tmp = new Student(grade, classNum,num);
		for(int i=0 ; i<count; i++) {
			if(stds[i].equals(tmp)) {
				index = i ;//찾았으면 찾은 번지를 알려준다
			}
		}
		if(index == -1) {
			continue; //조건식으로 건너뜀
		}
		
		
		
		//성적 정보를 입력(과목,학기,중간,기말 수행)
		System.out.println("성적 정보를 입력하세요>");
		System.out.println("과목 : ");
		String title = scan.next();
		System.out.println("학기 : ");
		int term = scan.nextInt();
		System.out.println("중간 시험점수 : ");
		int midScore = scan.nextInt();
		System.out.println("기말 시험점수 : ");
		int finalScore = scan.nextInt();
		System.out.println("수행평가 : ");
		int performance = scan.nextInt();
		
		//입력한 성적 정보가 없으면 추가
		//선택한 학생의 성적 정보들 중에서 과목,학기가 같은 성적 정보가 없으면 추가
		// index 번지에 있는..학생
		boolean res = stds[index].addScore(new Score(title, term, midScore, finalScore, performance));
		if(res) {
			System.out.println("성적을 등록했습니다.");
		}else {
			System.out.println("성적 등록에 실패하였습니다.");
		}
//		stds[index].addScore(new Score(title, term, midScore, finalScore, performance));
//		stds[index].printScore();
		
	}else if(menu ==3) {
		//3.학생 정보 출력
		//저장된 학생 정보를 출력
		for(int i =0;i<count ;i++ ) {
			System.out.println(stds[i]);
		}
		
		System.out.println("3.학생 정보 추가");
		
	}else if(menu ==4) {
		System.out.println("4.프로그램 종료");
		break;
	}else {
		System.out.println("잘못된 메뉴");
	}
		
		}


	
	}

}


	

