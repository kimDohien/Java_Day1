package day24;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import lombok.Data;

public class StudentMain {
	/*
	 * 학생 정보 관리 프로그램을 작성하세요.
	 * 1.학생 추가(이름,학년,반,번호)
	 * 2.학생 출력 
	 * 3.종료
	 * -프로그램 시작전 학생 정보를 읽어오는 기능 추가(load)
	 * -프로그램 종료전 학생 정보를 저장하는 기능 추가(save)
	 */
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		String fileName ="student.txt";//파일생성
		int menu =0;
		ArrayList<Student> list = new ArrayList<Student>();
		load(list,fileName); //파일을 읽어오는거니까 inputstream만 활용
		do {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			runMenu(menu,list); 
		}while(menu!=3);
		save(list,fileName);//(학생리스트,파일네임)파일을 저장하는거니까 outputstream만 활용
	
	}//메인끝

	private static void save(ArrayList<Student> list, String fileName) {//저장기능
		if(list ==null)  
			throw new RuntimeException("예외발생 : 등록된 학생이 없습니다.");
			//파일에 찍어내주는거기때문에 출력.
			try(ObjectOutputStream oos = 
					new ObjectOutputStream(new FileOutputStream(fileName))) {
				for(Student std : list) {
					oos.writeObject(std);
				}
				System.out.println("저장했습니다.");
			}catch(FileNotFoundException e) {
				System.out.println(fileName+"을 생성할수 없어서,저장에 실패하였습니다.");
			}catch (Exception e) {
				System.out.println("저장에 실패했습니다.");
		}
				
	}
				
	private static void load(ArrayList<Student> list,String fileName) {//읽기 기능
		if(list ==null)  
			throw new RuntimeException("등록된 학생이 없습니다.");
			//파일에 찍어내주는거기때문에 출력.
			try(ObjectInputStream ois = 
					new ObjectInputStream(new FileInputStream(fileName))) {
				while(true) {
					Student std = (Student)ois.readObject();
					list.add(std);
				}
			}catch(FileNotFoundException e) {
				System.out.println(fileName+"이 없어서 불어오기에 실패하였습니다.");
			}catch(EOFException e) { //IOException보다 EOFException이 먼저 있어야함
				System.out.println("불러오기 완");
			}catch (Exception e) {
				System.out.println("불러오기에 실패했습니다.");
		}
				
	}
		
	private static void runMenu(int menu, ArrayList<Student> list) {//기능실행
		switch(menu) {
		case 1: //학생 추가
			addStudent(list);
			break;
		case 2://학생 출력
			printStudent(list);
			break;
			
		case 3:
			System.out.println("종료합니다.");
			break;
			
		default :
			System.out.println("잘못된 메뉴 입니다.");
		}
		
	}
		
	private static void printStudent(ArrayList<Student> list) {//학생 출력
		if(list ==null) {
			System.out.println("등록된 학생이 없습니다.");
		}
		if(list.size()==0) {
			System.out.println("학생 정보가 없습니다.");
			return;
		}
		for(Student tmp : list) {
			System.out.println(tmp);
		}
	}

	private static void addStudent(ArrayList<Student> list) {//학생 추가
		if(list ==null) {
			throw new RuntimeException("예외발생 : 학생을 관리할 리스트가 없습니다.");
		}
		System.out.println("추가할 학생의 정보를 입력하세요.");
		System.out.println("이름 : ");
		String name = scan.nextLine();
		System.out.println("학년 : ");
		int grade = scan.nextInt();
		System.out.println("반 : ");
		int classNum = scan.nextInt();
		System.out.println("번호 : ");
		int number = scan.nextInt();
		
		Student std = new Student(name, grade, classNum,number);
		if(list.indexOf(std)!= -1) {
			System.out.println("학생 정보를 추가하지 못하였습니다.");
		}
		list.add(std);
		System.out.println("학생정보가 추가되었습니다.");
	}

	private static void printMenu() {
		System.out.println("====MENU====");
		System.out.println("1.학생 추가");
		System.out.println("2.학생 출력");
		System.out.println("3.종료");
		System.out.println("============");
		System.out.println("메뉴 입력 : ");
		
	}

}//클래스 끝
