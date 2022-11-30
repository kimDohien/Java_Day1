package day28;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;

public class EqualsEx01 {

	public static void main(String[] args) {
		/*
		 * List에서 제공하는 indexOf 와 contains
		 */

		List<Test> list = new ArrayList<Test>();
		list.add(new Test(1, 1));
		list.add(new Test(3, 1));
		list.add(new Test(2, 1));
		list.add(new Test(3, 1));
		list.add(new Test(4, 1));
		list.add(new Test(1, 5));
		System.out.println(list);
		int index = list.indexOf(new Test(2, 2));
		System.out.println("indexOf : " + index);

		Test t = new Test(2, 1);
		System.out.println("equals : " + t.equals(new Test(2, 2)));
		/*
		 * 리스트.indexOf(비교객체)에서 Objects.equals를 호출하는데,
		 * Objects.equals(비교객체, 리스트에서 꺼낸 객체) 를 호출하기 때문에
		 * 순서가 바뀌면 override한 의미가 있지만..순서를 꼭 맞춰주길.
		 * 비교객체.equals( 리스트에서 꺼낸 객체)로 비교
		 * 아래indexOf는 Integer.equals(Test 객체)를 하기 때문에 -1이나옴
		 * =>왜냐면 Integer은 우리가 만든 객체가 아니기떄문이다.
		 * 
		 */
		index = list.indexOf((Integer) 2); // 2라는 Integer있는지 확인
		System.out.println("indexOf : " + index); // 출력 => -1
		System.out.println("equals : " + t.equals((Integer) 2)); // 출력=> true
		System.out.println(Objects.equals(new Test(2, 1), (Integer) 2));
		System.out.println(Objects.equals((Integer) 2, new Test(2, 1)));

		List<Test> list2 = new ArrayList<Test>();
		list2.add(new Test(1,1));
		list2.add(new Test(2,1));
		System.out.println("두 리스트 비교 : "+ list.containsAll(list2)); //값 => true
		list2.add(new Test(10,1));
		System.out.println("두 리스트 비교 : "+ list.containsAll(list2)); //없는객체인 10,1을 추가하며 값=>false
		//contains는 위치가 아니라 있는지 없는지만 판별하는거라 true,false 로 나온다.
		
	}
}
@Data
//데이터어노테이션 안에 equals/hashcode포함 
//=> 모든필드를 비교해서 모든 필드가같은경우에만 객체를 비교하도록 override
class Test {

	int num1;
	int num2;

	public Test(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) { // 매개변수와 내 클래스 정보가 다를때
			if (obj instanceof Integer) {
				if (num1 == (Integer) obj) {
					return true;
				}
			}
			return false;
		}
		Test other = (Test) obj;
		if (num1 != other.num1)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num1;
		return result;
	}

}