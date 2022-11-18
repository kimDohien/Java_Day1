package day20;

import lombok.Data;

@Data
public class phoneNumber {
	String name,job, phoneNum;
	
public phoneNumber(String name, String job, String phoneNum) {
		this.name = name;
		this.job = job;
		this.phoneNum = phoneNum;
	}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	phoneNumber other = (phoneNumber) obj;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
}
}

