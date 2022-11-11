package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortEx02 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("toi");
		list.add("nha");
		list.add("muon");
		list.add("di");
		list.add("ve");
		
		System.out.println(list);
//		값 :[toi, nha, muon, di, ve]
		Collections.sort(list); 
		System.out.println(list);
//		값 : [di, muon, nha, toi, ve]
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		
			
		
		System.out.println(list);	
//		값 : [di, muon, nha, toi, ve]
	}

}
