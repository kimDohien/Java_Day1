package day16;

import java.util.HashSet;

public class SetEx01 {

	public static void main(String[] args) {
		
		//set 중복X,순서X
		HashSet<Integer> set = new HashSet<Integer>(); 
		
//		set.add(10);
//		set.add(10);
//		set.add(10);
//		System.out.println(set);
//		//값은 10하나만 출력
		
		set.add(10);
		set.add(5);
		set.add(10);
		set.add(1);
		set.add(100);
		set.add(22);
		System.out.println(set);
		//값 : [1, 100, 5, 22, 10] ->순서보장 X
		
		
		
		
		

	}

}
