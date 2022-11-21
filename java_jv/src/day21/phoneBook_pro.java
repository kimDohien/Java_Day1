package day21;

import java.util.ArrayList;

import lombok.Data;
@Data
public class phoneBook_pro {
	//한사람당 연락처 하나 저장해서 그거를 리스트로 쓰려하는 class
	private String name, company;
	ArrayList<phoneNumber_pro> pnList;
	
	public phoneBook_pro(String name, String company, ArrayList<phoneNumber_pro> pnList) {
		this.name = name;
		this.company = company;
		this.pnList = pnList;
	}

	public void print() {
		System.out.println("============");
		System.out.println("이름 : "+ name);
		System.out.println("직장 : "+ company);
		for(phoneNumber_pro tmp : pnList)
			System.out.println(tmp);
		System.out.println("============");
	}

	public void update(String name, String company) {
		this.name = name;
		this.company = company;
	}

	public void printPhoneNumbers() {
		for(int i =0 ; i<pnList.size();i++) {
			System.out.println(i+1 +". "+ pnList.get(i).toString());
		}
		
		
	}

	
}
