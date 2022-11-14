package day16;

import java.util.HashSet;
import java.util.Iterator;

public class SetEx02 {

	public static void main(String[] args) {
		HashSet<Integer> set =  new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(11);
		
		//향상된for문을 통해 접근(요자식이 조금 더 유용)
		for(Integer tmp :  set) { 
			System.out.println(tmp + " ");
		}
		System.out.println();
		
		//Iterator을 통해 접근
		Iterator<Integer> it = set.iterator(); 
		while(it.hasNext()) { //여기는 거의 공식..처럼외우면됨
			Integer tmp = it.next();
			}
		System.out.println();
	}

}
