package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortEx01 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(10);
		list.add(4);
		list.add(-1);
		list.add(15);
		
		System.out.println(list);
//		값 : [1, 10, 4, -1, 15]
		Collections.sort(list); //하나짜리 sort는 일반적으로 오름차순
		System.out.println(list);
//		값 : [-1, 1, 4, 10, 15]
		
		
		//내림차순으로 정리하려면..
		//comparator인터페이스를 구현한 구현 클래스가 필요하다.
		Collections.sort(list, new Comparator<Integer>() {//list트 뒤에 익명클래스를 만들어준다

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
			
		});
		
		System.out.println(list);	
//		값: [15, 10, 4, 1, -1]
		
		
	}

}
