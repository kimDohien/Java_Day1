package day10;

import java.util.Scanner;

import day5.ForUpDownEx01;
import day8.MethodBaseballGameEx01;

public class UpDownGameManager {

	public static void main(String[] args) {
		/*UpDown게임을 구현하세요.
		 * 1.플레이
		 * 2.기록확인
		 * 3.종료
		 * 
		 */
		int menu;
		Record [] records = new Record[5];
		do {
		//메뉴
		printMenu(
				"------메뉴------",
				"1. 플레이",
				"2. 기록확인",
				"3. 종료",
				"----------------",
				"메뉴를 선택하세요 : "
				);
		
		//메뉴출력
		 menu = insesrtInt();
		 
		// 메뉴에 따른 기능 실행 : 선택한 메뉴, 기록정보
		runMenu(menu,records);
		
		}while(menu!=3);//실행조건이지 종료조건이 아님.
	}

	/**
	 * 주어진 기록정보를 이용하여 메뉴에 따른 기능을 실행하는 메소드
	 * @param records 기록정보
	 * @param menu 선택한 메뉴
	 */
	private static void runMenu(int menu,Record[] records) {
		switch(menu) {
		
		case 1 :
			//플레이를 하고 나면 몇번만에 맞췄는지 알아야 한다.
			int trycount = playGame();
			
			//기존 기록보다 좋으면 기록을 추가
			writeRecord(records, trycount);
			break;
				
		
		case 2 :
			
			printRecords(records);
			
			break;
			
		case 3 :
			
			System.out.println("종료합니다.");
			break;
		
		default :
			System.out.println("잘못된 메뉴입니다.");
		
		}
		
	}
	
	
	
	private static void printRecords(Record[] records) {
		for(int i =0; i<records.length; i++) {
			System.out.println(i+1+"위 ");
			if(records[i] !=null) {
				records[i].print();
			}else {
				System.out.println();
			}
		}
		
	}

	/**
	 * 기록 정보보다 사용자 기록이 좋으면 기록을 추가하는 메소드
	 * @param records 기록정보
	 * @param trycount 사용자 기록
	 */
	
	//rank,record 합친 메소드
	private static void writeRecord(Record[] records, int tryCount) {
		int index =0;
		for(int i = 0; i<records.length; i++) {
			//1등부터 비교하여 나보다 기록이 좋으며 내 순위가 하나씩 뒤로 밀리는것
			if(records[i] != null && tryCount>records[i].getCount() ) {
				index++;
			}
			//기록이 없느 처음 순위를 내 기록으로 하기위해 i를 index에 저장
			else if (records[i]==null){
				index = i;
				break;
			}
			//비교순위보다 내가 기록이 좋으면 반복문 종료
			else {
				index = i;
				break;
			}
		}
		//순위안에 못들으면 빠져나간다
		if(index==5) {
			return;
		}
		//
		Scanner scan = new Scanner(System.in);
		System.arraycopy(records, index, records, index+1, records.length - index-1);
		System.out.println("이름 입력(예 : kdh) > ");
		String name = scan.next();
		records[index]=new Record(tryCount,name);
	}

	private static int playGame() {
		//랜덤수 생성
		int num = random(1,100);
		int tryCount = 0;
		int user;
		do {
		//사용자 입력
		System.out.println("정수 입력 : ");
		user = insesrtInt();	
		//Up Down판별
		if(user>num) {
			System.out.println("Down");
		}else if(user<num) {
			System.out.println("Up");
		}else {
			System.out.println("정답!!");
		}
		tryCount++;
	}while(num != user);
		return tryCount;
	}
		
		//랜덤 메소드
		private static int random(int min, int max) {
			return(int)(Math.random()*(max - min + 1)+min);
		}
	

	private static void addRecord(Record[] records, int tryCount) {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름을 입력(예 : JIK) : ");
		String name= scan.next();
		Record r = new Record(tryCount, name);
		
		int index =0;
		for(Record record : records) {
			if(record != null && record.getCount()<tryCount) {
				index++;
				
			}
		}
		
		for(int i = records.length -2 ; i >index  ; i--) {
			records[i] = records[i-1];
		}
		records[index]=r;
	}
		
	


	/**콘솔에서 정수를 입력받아, 입력받은 정수를 알려주는 메소드
	*@return 입력받은 정수 = >메뉴
	**/
	private static int insesrtInt() {
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}

	private static void printMenu(String...strs) {
		//printmenu를 호출하는 곳은 main. 
		//프린트메뉴는 static메소드 이기때문에 static을 붙여줘야한다.
		
		for(int i =0; i<strs.length;i++) {
			System.out.print(strs[i]);
			if(i != strs.length -1) { 
				System.out.println();
			}
		
	}
	


}
	
	
	
}//끝

