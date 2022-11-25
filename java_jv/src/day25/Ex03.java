package day25;

import java.util.ArrayList;
import java.util.Random;

public class Ex03 {

	public static void main(String[] args) {
		//1에서 9 사이의 숫자를 핸덤하게 9번 뽑아서 일려로 출력하는 코드를 작성
		ArrayList<Integer> list = new ArrayList<Integer>(); //1~9까지 넣음
		ArrayList<Integer> res = new ArrayList<Integer>();//1~9에서 빼서 res에 넣어줌
		
		int min=1,max=9;
		for(int i = min; i<=max; i++)
			list.add(i);//1~9까지 값을 차례대로 추가.
		
		//리스트에있는거를 랜덤으로 번지를 찍어서 꺼냄.
		while(list.size()!=0) {//리스트 사이즈가 0이 아닐때까지 반복
			int r = random(0,list.size()-1); //0번지부터 번지까지.
			Integer num = list.remove(r);
			res.add(num);
		}
		System.out.println(res);
	}
	public static int random(int min, int max) {//랜덤변수 만드는 메소드
		if(max<min) {
			int tmp = max;
			max =min;
			min = tmp;
		}
		Random r = new Random();
		//랜덤이라는 클래스 안에 nextInt에 정수값을 넣으면 0이상 정수미만의 랜덤한 정수를 알려줌
		return r.nextInt(max - min +1)+min;
	}
}
