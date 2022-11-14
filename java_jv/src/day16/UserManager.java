package day16;

import java.util.ArrayList;
import java.util.Scanner;

import lombok.Data;

@Data

public class UserManager {
	
	private String id;
	private String pass;
	private String name;
	private int age;
	private String rrn;
	
	public UserManager(String id, String pass, String name, int age, String rrn) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.age = age;
		this.rrn = rrn;
	}

	public UserManager(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}

	@Override
	public String toString() {
		return 	"[" + "ID : " + id + ", "+"비밀번호 : " + pass + ", "+"이름 : " + name + ", "+"나이 : " + age + ", "+"주민등록번호 : " + rrn + "]";
	}

	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserManager other = (UserManager) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void update(String pass, String name, int age, String rrn) {
		this.pass = pass;
		this.name = name;
		this.age = age;
		this.rrn = rrn;
		
	}

	




	

	
	
}