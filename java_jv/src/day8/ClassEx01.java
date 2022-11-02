package day8;

public class ClassEx01 {

	public static void main(String[] args) {
		//기본 생성자 호출
		Point pt = new Point();
		pt.printPoint();
		pt.move(5, 3);
		pt.printPoint();
		
		//생성자 오버로딩 호출
		Point pt1 = new Point(3,1);
		pt1.printPoint();
		
		//복사 생성자 호출(생성자 오버로딩)
		Point pt2 = new Point(pt1);
		pt2.printPoint();
	}

}

/*2차원 좌표형명의 점을 나타내는 클래스
 * -필드
 * x좌표, y좌표
 * 
 * -메소드(기능)
 * 좌표 출력 기능
 * 좌표 이동 기능
 * 
 * class 이름 {
 * 
 * }
*/
//<필드>
class Point{
	private int x,y; //멤버변수 정수는 자동으로 기본값(0)으로 초기화 된다.
	public void printPoint() {
		System.out.println("좌표 : " + x + "," + y);
	}
//<메소드>
	public void move(int x1, int y1){ //x,y가 이동한 거리
		x = x1;
		y = y1;
		//일반적으로 필드의 값을 바꾸는것 리턴타입이 void
	}
//<생성자>
	public Point() {
		x =3;
		y =3;
	}
	public Point(int x1, int y1) {
		x= x1;
		y= y1;
	}
	public Point(Point pt) {
		x= pt.x;
		y= pt.y;
	}
}

