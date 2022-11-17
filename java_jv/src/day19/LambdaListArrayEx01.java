package day19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LambdaListArrayEx01 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(/*Arrays.asList(1,2,5,169,20)*/);
		list.add(1);
		list.add(10);
		list.add(-1);
		list.add(100);
		list.add(22);
		
		System.out.println(list);
		
		Collections.sort(list, (a,b)->a-b);
		System.out.println(list);
			
	}

}

