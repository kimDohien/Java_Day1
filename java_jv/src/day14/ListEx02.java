package day14;

import java.util.ArrayList;
import java.util.Iterator;

public class ListEx02 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);//리스트는 중복이 가능하고, 순서가 유지된다.
		list.add(2);
		list.add(0,10); //0번지에 10을 넣는다는 의미
		list.remove(1); //1번지에 있는 것을 지우고싶다는 의미
		list.remove((Integer)10);//10이라는 값을 지우고 싶다는 의미. 10번지의 값을 지운다는것이 아님.
		System.out.println(list);
		System.out.println("1이 있나요 ? "+list.contains(1));
		System.out.println("1이 어디에있나요 ? "+list.indexOf(1)+"번지");
		System.out.println("1번지에 있는 값 : "+ list.get(1));
		
		
		//ⓐ방법
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i)+" ");
		}
		//ⓑ방법
		System.out.println();
		for(Integer tmp : list) {
			System.out.println(tmp + " ");
		}
		//ⓒ방법 - Iterator를 이용한 방법
		System.out.println();
		Iterator<Integer> it = list.iterator(); 
		while(it.hasNext()) { 
			Integer tmp = it.next();
			System.out.println(tmp + " ");
		}
		System.out.println();		
	}

}
