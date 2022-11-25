package day25;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//오류가 뜨는 이유는 Ex04_3에 열거형이 적혀있기때문이다.신경 안써도됨.

public class Ex04_4 {
	public static void main(String[] args) {
//		컴퓨터와 가위,바위,보를 하는 프로그램을 작성하세요. 
//		연속 세번 이길때까지 반복하시오
		Scanner scan = new Scanner(System.in);
		int count =0;
		do {
			try {
				System.out.println("사용자 : ");
				RPS user = RPS.valueOf(scan.next());
				RPS com= randomRPS();
				System.out.println("컴퓨터 : "+com);
				State state = resultState(user,com);
				printState(state);
				count = state == State.WIN ? count+1 : 0;
			}catch(IllegalArgumentException e) {
				System.out.println("입력을 잘못했습니다.");
			}
			
			
		}while(count!=3);
		scan.close();
		
	}//메인끝
	


	private static void printState(State state) {//판별 메세지 출력
		switch(state) {
		case WIN:
			System.out.println("사용자가 이겼습니다.");
			break;
		case LOSE:
			System.out.println("컴퓨터가 이겼습니다.");
			break;
		default:
			System.out.println("비겼습니다.");
		}
	}

	private static State resultState(RPS user, RPS com) {//결과 판별
		if(user == com) 
			return State.DRAW;
		switch(user) {
		case 가위:
			return com == RPS.보 ? State.WIN : State.LOSE;
		case 바위:
			return com == RPS.가위 ? State.WIN : State.LOSE;
		default:
			return com == RPS.바위 ? State.WIN : State.LOSE;
		}
	}

	private static RPS randomRPS() {//랜덤 메소드
		RPS [] rpss = RPS.values(); //가위바위보인애들을 각각 번지에서 리턴해줌
		int r = (int)(Math.random()*3);
		return rpss[r];
	}
}//클래스끝
enum RPS{//열거형
		가위,바위,보
}
enum State{//열거형(사용자 기준 이김,짐 판별)
	WIN,LOSE,DRAW
}
	