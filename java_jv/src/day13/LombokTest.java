package day13;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class LombokTest {

	public static void main(String[] args) {
		TestA a = new TestA();
		a.setNum(10);
		System.out.println(a.getNum()); //toString()확인
		System.out.println(a);
		TestA b = new TestA();
		b.setNum(10);
		System.out.println(a.equals(b));//equals()확인
	}

}

//@Data //@getter @setter @ToString @EqualsAndHashCode @RequiredArgsConsturctor 를 합쳐놓은게 data어노테이션
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor //기본 생성자를 추가해준다
class TestA{
	private int num;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestA other = (TestA) obj;
		if (num != other.num)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}
	
	
	
}