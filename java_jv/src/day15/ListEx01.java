package day15;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import day14.Student;

public class ListEx01 {

	public static void main(String[] args) {
		/*list를 이용하여 다음 기능을 갖는 오늘의 할일 프로그램을 작성하세요.
		 * 
		 * 메뉴
		 * 1.할일 추가
		 * 2.할일 확인
		 * 3.종료
		 * 
		 * 메뉴선택 : 1
		 * ------------------
		 * 할일 입력 : 오후 수업 참여
		 * ------------------
		 *  메뉴
		 * 1.할일 추가
		 * 2.할일 확인
		 * 3.할일삭제
		 * 4.종료
		 *  메뉴선택 : 1
		 * ------------------
		 * 할일 입력 : 저녁
		 * ------------------
		 * 메뉴
		 * 1.할일 추가
		 * 2.할일 확인
		 * 3.할일삭제
		 * 4.종료
		 * 메뉴선택 : 2
		 * ----------
		 * 1.오후 수업 참여
		 * 2.저녁
		 * -----------
		 * 메뉴
		 * 1.할일 추가
		 * 2.할일 확인
		 * 3.할일삭제
		 * 4.종료
		 * 메뉴선택 : 3
		 * 1.오후 수업참여
		 * 2.저녁선택
		 * 삭제할 할일 번호 선택 :1
		 * 1번 할일이 삭제되었습니다.
		 * ------------------
		 *  메뉴
		 * 1.할일 추가
		 * 2.할일 확인
		 * 3.할일삭제
		 * 4.종료
		 * 메뉴선택 : 4
		 * 프로그램 종료
		 * 
		 */
		int menu=-1;
		Scanner scan = new Scanner(System.in); //반복문 안에 넣어도 되지만 반복문 밖에 쓰는게 조금더 효율적이다.
		
		ArrayList<String> todoList = new ArrayList<String>();//문자열 관리하기때문에 String을씀
		do{
			//메뉴출력
			printMenu();
			
			
			//메뉴선택
			try { //예외처리 해줌
			menu = scan.nextInt();
			
			//메뉴실행(관리할 리스트, 메뉴)
				runMenu(todoList,menu);
			}catch(InputMismatchException e) {
				System.out.println("-------------");
				System.out.println("예외발생 : 정수를 입력하세요");
				System.out.println("-------------");
				scan.nextLine(); 
				//InputMismatchException 예외를 하면 마지막 scan.nextLine();을 마지막에 꼭 붙여줘야한다.
			} 
				catch (Exception e) {
				System.out.println("-------------");
				System.out.println(e.getMessage());
				System.out.println("-------------");
			}
		}while(menu != 4);
			
		
		
	}

		
	

	//메뉴실행
	private static void runMenu(ArrayList<String> todoList,int menu) throws Exception {
		Scanner scan = new Scanner(System.in);
		switch(menu) {
		case 1 :
			//1.할일을 입력받는다(공백 포함해서 입력받아야함)
			System.out.println("할 일 입력: ");
			String todo = scan.nextLine();
			//2.리스트에 입력된 할일을 추가
			todoList.add(todo); //순차적으로 0번지부터 추가
			
			
		case 2 :
			//숫자가 없으면 향상된 포문으로 출력해도 되지만 ,,숫자가 있기에 일반 for문사용
			for(int i=0 ; i<todoList.size();i++) {
				System.out.println(i+1+". "+todoList.get(i));
			}
			break;
			
		case 3 :
			//할일확인
			deleteTodo(todoList);
			
			int index = scan.nextInt()-1;//화면에 보여지는것은 1,2지만 실제는 0번지부터시작이라서..
			
			//잘못된번호를 입력한 경우
//			if(index<0 || index>= todoList.size()) {
//				throw new Exception("예외발생 : 삭제할 번호를 잘못 입력했습니다.");
//			}
			break;
		
		case 4 :
			System.out.println("프로그램 종료");
			break;
		
			
		default :
			throw new Exception("예외발생 : 잘못된 메뉴입니다.");
		}
	}
	

	private static ArrayList<String> deleteTodo (ArrayList<String> todoList) {
		//할일이 없으면 없다고 알려줘야한다.
		if(todoList == null || todoList.size()==0) {
			System.out.println("저장된 할 일이 없습니다.");
		}
		//할 일 확인
		for(int i=0 ; i<todoList.size();i++) {
			System.out.println(i+1+". "+todoList.get(i));
		}
		Scanner scan = new Scanner(System.in);
		//삭제할 할일 번호 입력
		System.out.print("삭제할 번호를 입력하세요 : ");
		int num= scan.nextInt();
	
		//입력한 번호에 맞는 할일 삭제
		todoList.remove(num-1);
		System.out.print( num + "번이 삭제되었습니다.");
		return todoList;
	}




	//메뉴
	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1.할 일 추가");
		System.out.println("2.할 일 확인");
		System.out.println("3.할 일 삭제");
		System.out.println("4.종료");
		System.out.println("메뉴 선택 : ");
	}
}
