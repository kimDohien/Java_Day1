package day22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Predicate;

import lombok.Getter;
	
public class AttendanceMain {
	private static Scanner scan = new Scanner(System.in);
	/*<출석부 관리 프로그램 >
	 * 1.학생 등록 (이름,생년월일)
	 * 2.학생 수정
	 * -이름과 생년월일로 검색해서 이름과 생년월일 수정
	 * 3.학생 삭제
	 * -이름과 생년월일로 검색해서 이름과 생년월일 수정
	 * 4.학생 출결확인
	 * -이름과 생년월일을 검색해서 해당학생의 모든출결을 확인
	 * ex)2022-11-22 : 출석
	 * 5.출석 확인 
	 * - 날짜 입력 : 2022-11-22
	 * - (출석 : 0, 지각 : /, 조퇴 : \, 결석 :X)
	 * - ex)홍길동 출석현황 : X (등록된 학생이름이 자동으로 뜨도록)
	 * 		고길동 출석현황 : 
	 * 6.출석 수정
	 * -날짜 입력
	 * -수정할 학생의 이름과 생년월일을 입력
	 * 7.출석삭제
	 * -날짜 입력하여 해당 날짜 출석 삭제
	 * 8.날짜별 출석 확인
	 * -날짜 입력하여 해당 날짜의 모든 학생의 출석 여부를 확인
	 * 9.프로그램 종료
	 * 
	 *학생(Student)클래스 : 이름 , 생년월일
	 *학생 일지 클래스(StudentLog) : 이름,생년월일, 출결
	 *일지 클래스(Log): 날짜 , 학생일지들(이름,생년월일,출결)
	 *출석부 클래스(Attendance) :학생들, 일지들
	 * 
	 */
	public static void main(String[] args) {
		
		
		
	Attendance attendance = new Attendance();
	//출석부를 만듦..(출석부 안에 우리가 원하는 리스트가 이미 존재해서 list를 안하고 출석부를 쓴거임)
	int menu =0;	
	do {	
		try {
		//메뉴 출력
		printmenu();
		//메뉴 입력
		menu=scan.nextInt();
		scan.nextLine();
		//메뉴에따른 기능 실행
		runMenu(menu,attendance);
		}catch(Exception e) {//예외발생하면 실행을 멈추는게 아니라 겟메세지를 통해서 예외내용을 띄우도록..해줌
			System.out.println(e.getMessage());
		}
	}while(menu !=9);

	
	}//main끝	
	
	private static void runMenu(int menu,Attendance attendance) {
		//<지역변수 생성> 만든이유 :  ateendance.get하기 귀찮아서..
		ArrayList<Student> stds=  attendance.getStds(); //학생관리
		ArrayList<Log>logs = attendance.getLogs();//일지관리
		
		switch(menu){
			case 1: //1.학생 등록
				managementStudents(stds); //학생을 관리
				break;
			case 2://2.출석관리
				managementLogs(logs, stds); //출석 일지를 관리(+학생정보가 추가,빠질수도 있기에 stds 추가)
				break;
			case 3://3.프로그램 종료
				System.out.println("프로그램 종료");
				break;
			default :
				System.out.println("메뉴를 잘못 입력하였습니다.");
		}
	}
	
	
	
private static void managementLogs(ArrayList<Log> logs, ArrayList<Student> stds) {//출석관리
		printSubMenu(2);//서브메뉴2번출력
		int subMenu= scan.nextInt();
		scan.nextLine();
		printBar();
		switch(subMenu) {
		case 1:
			checkLog(logs,stds);//디엠자잉-전체(학생들정보,출석부 필요)
			sortLogs(logs);//출석부 정렬
			break;
		case 2://출석확인(개별)
			printLogsByStudent(logs);
			break;
		case 3://출석확인(날짜별)
			printLogsByDate(logs);
			break;
		case 4://출석 수정
			updateLogs(logs);
			break;
		case 5://출석 삭제
			deleteLogs(logs);
			break;
		case 6:
			printStr("!취소!");
			break;
		default :	
			printStr("!잘못된 메뉴입니다!");
		}
		
	}

private static void deleteLogs(ArrayList<Log> logs) {//출석 삭제
	//날짜입력
	System.out.println("날짜 입력 : ");
	String date = scan.nextLine();
	printBar();
	
	if(checkLogDate(logs,date)) {//출석일지에 해당날짜가 있는지 없는지 확인.
		printStr("해당 일자에 등록된 출석이 없습니다.");
		return;//없으면 pass 있으면 이름,생년월일 등록
	}
	for(int i = 0; i<logs.size();i++) {
		if(logs.get(i).getDate().equals(date)){//i번지에 있는것을 가져와서 date를 비교함
			logs.remove(i);
			printStr("삭제가 완료됐습니다.");
			return;
		}
	}
}

private static void updateLogs(ArrayList<Log> logs) {//출석 수정
	//날짜입력
	System.out.println("날짜 입력 : ");
	String date = scan.nextLine();
	printBar();
	
	if(checkLogDate(logs,date)) {//출석일지에 해당날짜가 있는지 없는지 확인.
		printStr("해당 일자에 등록된 출석이 없습니다.");
		return;//없으면 pass 있으면 이름,생년월일 등록
	}
	//수정하려는 이름,생년월일,출석 상태입력 입력(동명이인이 있을수 있으니까 생년월일 입력)
	System.out.println("이름 : ");
	String name = scan.nextLine();
	System.out.println("생년월일 : ");
	String birth = scan.nextLine();
	System.out.println("출석 상태 입력 : ");
	String State = scan.nextLine();
	printBar();
	//입력한 정보와 일치하는 출석 정보를 수정
	for(Log log : logs) {
		if(log.getDate().equals(date)) {//날짜가 일치하면
			for(StudentLog slog : log.getSlogs()) {
				String tmpName = slog.getStd().getName();
				String tmpBirth = slog.getStd().getBirth();
				if(tmpName.equals(name)&&tmpBirth.equals(birth)) {
					slog.setState(State);
				}
			}
			printStr("수정이 완료되었습니다.")	;
			return;
		}
	}
	
}

private static void printLogsByDate(ArrayList<Log> logs) {//출석확인-날짜별
	//날짜입력
	System.out.println("날짜 입력(예.2022.02.17) : ");
	String date = scan.nextLine();
	printBar();
	//날짜와 일치하는 출석 기록 확인
	//출력 예) 학생명(생일) : O
	for(Log log : logs) {
		if(log.getDate().equals(date)) {//입력한 날짜가 log에 있는 날짜와 같으면
			for(StudentLog slog : log.getSlogs()) {//학생한명씩 나와야함
				String name = slog.getStd().getName();
				String birth = slog.getStd().getBirth();
				System.out.println(name+"("+birth+") : " + slog.getState());
			}
		}
	}
}

private static void printLogsByStudent(ArrayList<Log> logs) {//출석확인-개인
	if(logs == null||logs.size()==0) {
		printStr("등록된 출석체크가 없습니다.");
		return;
	}
	//이름 입력
	System.out.println("이름 입력 : ");
	String name = scan.nextLine();
	printBar();
	//입력받은 이름과 일치하는 출석체크 목록을 확인
	//출력 예 ) 2022.11.23 : O
	for(Log log : logs) {
		for(StudentLog slog : log.getSlogs()) {
			if(slog.getStd().getName().equals(name)) {
				System.out.println(log.getDate()+":"+slog.getState());//날짜출력(날짜는 log에있음,출석은slog에 있음)
			}
		}
	}
}

private static void sortLogs(ArrayList<Log> logs) {//출석부 정렬
	if(logs == null ||logs.size()==0)
		return;
	Collections.sort(logs, (o1,o2)->o1.getDate().compareTo(o2.getDate())); //람다식씀
	//날짜를 비교할때 문자열을 비교하는 compareTo를 제공
}

private static void checkLog(ArrayList<Log> logs, ArrayList<Student> stds) {//출석 체크
	//날짜 입력
	System.out.println("날짜 입력(예.1998.02.17) : ");
	String date = scan.nextLine();
	printBar();
	//이미 입력된 날짜인지 확인
	if(checkLogDate(logs,date)) {//모든일지에서 날짜 체크해야함
		System.out.println("이미 출석 체크한 일자입니다.");
		return; }//같은날 있으면 return
	//출석 상태 정보 출력(출석 : 0, 지각 : /, 조퇴 : \, 결석 :X)
	printStr("출석 : 0, 지각 : /, 조퇴 : \\, 결석 :X");
	
	//StudentLog(이름,생년월일,출석을 생성하는 클래스)를 리스트로 생성
	//Ex)홍길동(20.05.05) : 0 =>이 하나가 Log
	ArrayList<StudentLog> stdLogs = new ArrayList<StudentLog>();
	
	//반복 => 출석부를 만듬
	for(Student std : stds) {
		//학생이름+생일 출력
	System.out.print(std.getName()+"("+std.getBirth()+")"+":");	
		//출석상태 입력
	String state = scan.nextLine();
	//StudentLog를 생성
	StudentLog stdLog = new StudentLog(std,state);
	//StudentLog 리스트에 추가
	stdLogs.add(stdLog);		
	}
	//StudentLog 리스트와 날짜를 이용하여 Log객체 생성
	Log log = new Log(stdLogs,date);
	//Log 리스트에 생서된 Log객체를 추가
	logs.add(log);
}

private static boolean checkLogDate(ArrayList<Log> logs, String date) {//출석체크-중복날짜확인
	if(logs == null || date == null )
		throw new RuntimeException("일지 리스트가 없거나 날짜가 없습니다."); //return false로 해도됨
	if(logs.size()==0)
		return false;
	for(Log log : logs) {
		if(log.getDate().equals(date))
			return true;
	}
	return false;
}

private static void managementStudents(ArrayList<Student> stds) { //학생관리 기능실행
		printSubMenu(1);
		int subMenu = scan.nextInt();
		scan.nextLine();
		switch(subMenu) {
		case 1://학생 추가
			addStudent(stds);
			break;
		case 2://수정
			updateStudent(stds);
			break;
		case 3://삭제
			deleteStudent(stds);
			break;
		case 4://취소
			printStr("!취소!");
			break;
		default:
			printStr("메뉴를 잘못입력했습니다.");
		}
	}
	
private static void deleteStudent(ArrayList<Student> stds) {//학생 삭제
	if(stds == null)
		throw new RuntimeException("예외발생 : 학생 정보를 관리하는 리스트가 없습니다.");
	System.out.println("이름 : ");
	String name = scan.nextLine();
	System.out.println("생년월일 : ");
	String birth = scan.nextLine();
	scan.nextLine();
	Student std = new Student(name,birth);
	int index = stds.indexOf(std);
	if(index == -1) {//예외처리
		printStr("입력정보와 일치하는 학생이 없습니다.");
		return;
	}
	stds.remove(index);
	printStr("학생 정보를 삭제했습니다.");
//	System.out.println(stds); //수정확인용
	
		
	}

private static void updateStudent(ArrayList<Student> stds) {//학생 수정
		if(stds == null)
			throw new RuntimeException("예외발생 : 학생 정보를 관리하는 리스트가 없습니다.");
		System.out.println("이름 : ");
		String name = scan.nextLine();
		System.out.println("생년월일 : ");
		String birth = scan.nextLine();
		scan.nextLine();
		Student std = new Student(name,birth);
		int index = stds.indexOf(std);
		if(index == -1) {
			printStr("입력정보와 일치하는 학생이 없습니다.");
			return;
		}
		//수정 입력
		System.out.println("수정할 이름,생년월일을 입력하세요.");
		System.out.println("이름 : ");
		name = scan.nextLine();
		System.out.println("생년월일 : ");
		birth = scan.nextLine();
		//만들어진 새로운객체를 set을 이용해서 바로 덮어쓰기한다. 
		std = new Student(name,birth);
		stds.set(index, std);
//		System.out.println(stds); //수정확인용
		printStr("학생 정보를 수정했습니다.");

	}

private static void addStudent(ArrayList<Student> stds) {//학생추가
		if(stds == null)
			throw new RuntimeException("예외발생 : 학생 정보를 관리하는 리스트가 없습니다.");//학생정보를 담을수 있는 리스트가 없어서느 안되서 예외처리를 일부러 해줌
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("생년월일(예.yy.mm.dd) : ");
		String birth= scan.nextLine();
		//객체를 만들어서 name,birth를 넣어줌
		Student std = new Student(name, birth);
		//중복확인(이름과 생년월일이 같은 학생은 추가 X)
		if(stds.indexOf(std)!=-1) {
		printStr("학생 정보를 추가하지 못했습니다.");
		return;
		}
		//이름과 생년월일이 같은 학생이 없다면 추가
		stds.add(std);
//		System.out.println(stds); //확인용
		printStr("학생 정보를 추가했습니다.");
	}

private static void printSubMenu(int menu) {//서브메뉴(학생관리,출석관리)
		switch(menu) {
		case 1://학생등록
			System.out.println("***학생 관리 메뉴****");
			System.out.println("1.학생 추가");
			System.out.println("2.학생 수정");
			System.out.println("3.학생 삭제");
			System.out.println("4.취소");
			System.out.println("-----------------");
			System.out.println("번호 입력 : ");
			break;
		case 2:
			System.out.println("***출석 관리 메뉴****");
			System.out.println("1.출석 체크 - 전체");
			System.out.println("2.출석 확인 - 개별");
			System.out.println("3.출석 확인 - 날짜별");
			System.out.println("4.출석 수정");
			System.out.println("5.출석 삭제");
			System.out.println("6.취소");
			System.out.println("-----------------");
			System.out.println("번호 입력 : ");
			break;
		default: 
			printStr("잘못된 메뉴입니다.");
		}
		
	}
	
private static void printBar() {
		System.out.println("==============");
	}
	
private static void printStr(String str) {
		System.out.println(str);
		printBar();
	}
	
public static void printmenu() {//메인메뉴
		System.out.println("******MENU******");
		System.out.println("1.학생 관리  ");
		System.out.println("2.출석 관리 ");
		System.out.println("3.종료 ");
		System.out.println("-----------------");
		System.out.println("번호 입력 : ");
		
	}
}//class끝
