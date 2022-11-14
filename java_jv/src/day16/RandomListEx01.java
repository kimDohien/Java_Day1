package day16;

import java.util.ArrayList;
import java.util.HashSet;

public class RandomListEx01 { //정수들에서 중복되지 않은 값 추출하기

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int maxCount =3, min =1, max=9; 
		//10이하의 수로 하면 정렬이 되는데,,10 넘어서 숫자로 지정하면 정렬안됨.
		
		HashSet<Integer> set = new HashSet<Integer>();
		while(set.size() < maxCount) {
			int r = (int)(Math.random()*(max - min +1)+min);
			set.add(r);
			
		}
		list.addAll(set); //collection은 list의 부모클래스
		System.out.println(list);
	}

}
