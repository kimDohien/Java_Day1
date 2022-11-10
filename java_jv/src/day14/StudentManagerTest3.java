package day14;

import java.util.ArrayList;
import java.util.Scanner;

import day9.HighStudent;

public class StudentManagerTest3 {

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
	ArrayList<Student> stds = new ArrayList<Student>();
	
	int menu = -1;
	int count = 0; //초기에 저장된 학생수
	//반복	
	for( ;menu != 4 ;) {
		//메뉴출력
		printMenu();
		
		//메뉴선택
	    menu = scan.nextInt();
	    
		//선택한 메뉴에 따른 기능 실행
		runMenu(menu,stds); 
		
		
		}//for문 끝
	}//main끝
	
	private static void runMenu(int menu, ArrayList<Student> stds) {
		Scanner scan = new Scanner(System.in);
		
		switch(menu) {
		case 1:
			if(addStudent(stds)){ 
				System.out.println("학생을 추가했습니다.");
				
			}else {
				System.out.println("학생을 추가하지 못했습니다.");
			}
			break;
			
			
			case 2:
			//2.학생 성적 추가
			//학생 정보를 입력(학년,반,번호)
			if(addScore(stds)) {
				System.out.println("성적을 등록했습니다.");
			}else {
				System.out.println("성적 등록에 실패하였습니다.");
			}
			break;

			
			case 3:
			//3.학생 정보 출력
			printStudentList(stds);
			break;
			
			case 4:
			System.out.println("프로그램 종료");
			break;
		default :
			System.out.println("잘못된 메뉴~");
		}
	
	}

	private static void printStudentList(ArrayList<Student> stds) {
		for(Student tmp : stds) {
			System.out.println(tmp);
			tmp.printScore();
		}
		
	}

	private static boolean addScore(ArrayList<Student> stds) {
		System.out.println("<학생 성적 추가> ");
		System.out.println("학생 정보를입력하세요> ");
		Student tmp = scanStduentsBaseInfo();
		
		int index = stds.indexOf(tmp);//학생이 몇번지에 있는지
		if(index == -1) {
			return false; 
		}
		
		//성적 정보를 입력(과목,학기,중간,기말 수행)
		System.out.println("성적 정보를 입력하세요>");
		return stds.get(index).addScore( scanScore());
	}

	private static boolean addStudent(ArrayList<Student> stds) {
		Scanner scan = new Scanner(System.in);
		System.out.println("학생 정보를입력하세요> ");
		Student tmp = scanStduentsBaseInfo();
		
		System.out.print("이름 : ");
		tmp.setName(scan.next());
	
		//기존 학생정보가 있는지 없는지 확인
		int index = stds.indexOf(tmp);
		if(index == -1) { 
			stds.add(tmp);
			return true;
		}
		return false;
	}

	private static Score scanScore() {
		Scanner scan = new Scanner(System.in);
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
		return new Score(title, term, midScore, finalScore, performance);
	}

	private static Student scanStduentsBaseInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("학년 : ");
		int grade=scan.nextInt();
		System.out.print("반 : ");
		int classNum=scan.nextInt();
		System.out.print("번호 : ");
		int num=scan.nextInt();
		return new Student(grade,classNum, num);
	}

	private static int indexOfStudent(Student[] stds, int count, Student tmp) {
		for(int i=0 ; i<count; i++) {
			if(stds[i].equals(tmp)) {
				return i ;//찾았으면 찾은 번지를 알려준다
			}
		}
		return -1;
	}

	//메뉴
	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1.학생 정보 추가");
		System.out.println("2.학생 성적 추가");
		System.out.println("3.학생 정보 추가");
		System.out.println("4.프로그램 종료");
		System.out.println("메뉴 선택 : ");
		
	}

}
