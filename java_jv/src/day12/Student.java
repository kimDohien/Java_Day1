package day12;

public class Student {
	public int grade, classNum, num;
	public String name;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classNum;
		result = prime * result + grade;
		result = prime * result + num;
		return result;
	}
	@Override
	//euqals를 이용하면 두 객체가 같은지 다른지 알수있다.
	public boolean equals(Object obj) {
		
		if (this == obj) //같은객체를 공유하면 당연히 트루
			return true;
		if (obj == null) //매개변수가 null이면 비교 불가능
			return false;
		if (getClass() != obj.getClass())//class정보를 return함(obj가 같은 클래스의 객체가 아닌경우)
			return false;
		Student other = (Student) obj;
		if (classNum != other.classNum)
			return false;
		if (grade != other.grade)
			return false;
		if (num != other.num)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Student [grade=" + grade + ", classNum=" + classNum + ", num=" + num + ", name=" + name + "]";
	}
	
	
}
