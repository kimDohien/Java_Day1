package day15;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WordListMain {

	public static void main(String[] args) {
		
		/*영어 단어장 프로그램을 구현하세요.
		 * 메뉴
		 * 1.단어 추가
		 * 2.단언 확인
		 * 3.단어 수정
		 * 4.단어 삭제
		 * 5.종료
		 *메뉴선택 : 1
		 *단어 : apple [한단어, 공백입력X]
		 *뜻 : 사기 [한 문장]
		 *"------------------"
		 *  메뉴
		 * 1.단어 추가
		 * 2.단언 확인
		 * 3.단어 수정
		 * 4.단어 삭제
		 * 5.종료
		 * 메뉴선택 : 2
		 * 단어 입력 : apple [원하는 단어 검색] 
		 * 뜻 : 사기
		 * "------------------"
		 * 메뉴
		 * 1.단어 추가
		 * 2.단언 확인
		 * 3.단어 수정
		 * 4.단어 삭제
		 * 5.종료
		 * 메뉴선택 : 3
		 * 단어 입력 :  apple
		 * 1. apple : 사가
		 * [여러개를 추가할수있게]
		 * 수정할 번호 : 1
		 * 뜻 : 사과
		 * 수정이 완료되었습니다.
		 * "------------------"
		 *  메뉴
		 * 1.단어 추가
		 * 2.단언 확인
		 * 3.단어 수정
		 * 4.단어 삭제
		 * 5.종료
		 * 메뉴선택 : 4
		 * 단어 입력 : apple
		 * 1. apple : 사과
		 * 삭제가 완료되었습니다.
		 * "------------------"
		 * 
		 */
		
		Scanner scan = new Scanner(System.in);
		ArrayList<Word> vocaList= new ArrayList<Word>();
		int menu=-1; //예외처리를 하기때문에 초기화를 해야한다.
		do {
			printMenu();
			try {	
			menu=scan.nextInt();
			runMenu(menu,vocaList);
			}catch(InputMismatchException e) {
				System.out.println("-------------");
				System.out.println("예외발생 : 정수를 입력하세요");
				System.out.println("-------------");
				scan.nextLine(); 
			} 
			catch (Exception e) {
			System.out.println("-------------");
			System.out.println(e.getMessage());
			System.out.println("-------------");
		}
			
		}while(menu != 5);
		
		
	}
	private static void runMenu(int menu, ArrayList<Word> vocaList) throws Exception {
		Scanner scan = new Scanner(System.in);
		switch(menu) {
		case 1:
			insertWord(vocaList); 
			System.out.println(vocaList);
			break;
			
		case 2:
			printWord(vocaList);
			
			break;
			
		case 3:
			updateWord(vocaList);
			break;
			
		case 4:
			deleteWord(vocaList);
			break;
			
		case 5:
			System.out.println("프로그램 종료");
			break;
			
		default :
			System.out.println("번호를 잘못 입력하였습니다.");
		}
		
	}
	
	//단어 삭제
	private static void deleteWord(ArrayList<Word> vocaList) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("단어 입력 : ");
		String word = scan.next();
		
		ArrayList<Integer> indexList = findWordList(word,vocaList);
		System.out.println(indexList);
		
		if(indexList ==null || indexList.size()==0) {
			throw new Exception("예외발생 : 삭제하려는 단어가 단어장에 없습니다.");
			
		}
		for(int i=0; i< indexList.size();i++) {
			int index = indexList.get(i);
			System.out.println(i+1+". "+ vocaList.get(i));
		}
		//수정할 단어 번호를 입력
		System.out.println("삭제할 번호 입력 : ");
		int index = scan.nextInt()-1;
		
		
		if(index<0|| index >= indexList.size()) {
			throw new Exception("예외발생 : 번호를 잘못 입력했습니다.");
		}
		
		vocaList.remove((int)indexList.get(index));
		//언박싱(=형변환)을 안해주면 객체로 비교해서 엉뚱한것이 처리될수 있다.
		System.out.println("단어가 삭제되었습니다.");
		
	}
	//단어 수정
	private static void updateWord(ArrayList<Word> vocaList) throws Exception {
		Scanner scan = new Scanner(System.in);
		if(vocaList == null || vocaList.size()==0) {
			System.out.println("--------------------------");
			System.out.println("예외발생 : 단어장이 비어있습니다ㅏ.");
			System.out.println("--------------------------");
		}
		//단어 입력
		System.out.println("단어 입력 : ");
		String word = scan.next();
		//단어장에서 입력 단어와 일치하느 단어 객체들을 가져온다
		//예)실제 단어번지 : 1,2,4
		//0번지:1, 1번지 :2 , 2번지 3...
		ArrayList<Integer> indexList = findWordList(word,vocaList);
		System.out.println(indexList);
		
		//가져온 단어 객체들을 출력
		//예)화면에서 보여준 단어번호 1,2,3
		
		 //예외발생
		if(indexList ==null || indexList.size()==0) {
			throw new Exception("예외발생 : 수정하려는 단어가 단어장에 없습니다.");
			
		}
		for(int i=0; i< indexList.size();i++) {
			int index = indexList.get(i);
			System.out.println(i+1+". "+ vocaList.get(i));
		}
		//수정할 단어 번호를 입력
		System.out.println("수정할 번호 입력 : ");
		int index = scan.nextInt()-1;
		
		//예외발생
		if(index<0|| index >= indexList.size()) {
			throw new Exception("예외발생 : 번호를 잘못 입력했습니다.");
		}
		
		
		//수정할 뜻을 입력
		System.out.println("뜻 : "); 
		scan.nextLine();
		String mean = scan.nextLine();
		
		//선택된 단어의 뜻을 수정
		Word tmp = vocaList.get(indexList.get(index)); //get은 주소르 가져옴
		tmp.setMean(mean); //수정하기 위해서 setMean을 만듬
		//tmp가 값을 수정하면 단어장에있는 뜻도 같이 수정됨. 
//		vocaList.set(indexList.get(index), tmp); 
		
		System.out.println("수정되었습니다.");
	}
	
	
	//단어장에서 입력 단어가 몇번지에 있는지 알려준다.
	private static ArrayList<Integer> findWordList(String word, ArrayList<Word> vocaList) {
	ArrayList<Integer> list = new ArrayList<Integer>(); //새 리스트 만들어줌
		for(int i = 0; i<vocaList.size(); i++) {
			if(vocaList.get(i).equals(word)) {
				list.add(i);
			}
		}
		return list;
	}
	

	
	//단어 확인
	private static void printWord(ArrayList<Word> vocaList) {
		if(vocaList == null || vocaList.size()==0) {
			System.out.println("--------------------------");
			System.out.println("예외발생 : 단어장이 비어있습니다ㅏ.");
			System.out.println("--------------------------");
		}
		System.out.println("--------------");
		for(Word tmp :  vocaList) {
			System.out.println(tmp);
		}
		System.out.println("--------------");
	}
	private static void insertWord(ArrayList<Word> vocaList) {
		Scanner scan = new Scanner(System.in);
		//단어 입력
		System.out.print("단어 입력 : ");
		String word= scan.next();
		scan.nextLine(); //단어입력후 엔터를 처리해주려고 스캔.넥라를 집어넣음
		//뜻 입력
		System.out.print("뜻 입력: ");
		String mean= scan.nextLine(); //공백포함 한문장으로 해야하기때문에  nextLine
		
		//단어 객체
		Word tmp = new Word(word, mean);
		
		//객체를 리스트에 추가
		vocaList.add(tmp);
		
		
	}
	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1.단어 추가");
		System.out.println("2.단어 확인");
		System.out.println("3.단어 수정");
		System.out.println("4.단어 삭제");
		System.out.println("5.종료");
		System.out.println("메뉴 선택 : ");
	}

}
