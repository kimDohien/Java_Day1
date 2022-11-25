package day25;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		/*
		 * 컴퓨터와 가위,바위,보를 하는 프로그램을 작성하세요. 
		 * ex) 사용자 : 가위 
		 * 컴퓨터 : 보 
		 * 사용자가 이겼습니다. 
		 * 더하시겠습니까?(y/n):y 
		 * 사용자 : 가위 
		 * 컴퓨터 : 보 
		 * 컴퓨터가 이겼습니다. 
		 * 사용자가 이겼습니다. 
		 * 더 하시겠습니까?(y/n) :n
		 */
	
		Scanner scan = new Scanner(System.in);
		String reply;
		do {
			System.out.println("사용자 : ");
			String game = scan.next();

			String rsp[] = { "가위", "바위", "보" };
			int com = (int) (Math.random() * 3);
			String computer = rsp[com];
			System.out.println("컴퓨터 : " + computer);
				if(game.equals(computer)) {
					System.out.println("비겼습니다.");
				}else if(game.equals("가위")&&computer.equals("바위") ) {
					System.out.println("졌습니다.");
				}else if(game.equals("가위")&&computer.equals("보") ) {
					System.out.println("이겼습니다.");
				}else if(game.equals("바위")&&computer.equals("보") ) {
					System.out.println("졌습니다.");
				}else if(game.equals("보")&&computer.equals("가위") ) {
					System.out.println("졌습니다.");
				}else if(game.equals("바위")&&computer.equals("가위") ) {
					System.out.println("이겼습니다.");
				}else if(game.equals("보")&&computer.equals("바위") ) {
					System.out.println("이겼습니다.");
				}
			System.out.println("더 하시겠습니까? (y/n) : ");
			reply = scan.next();
			}while (reply == "n");
		
	}
}
