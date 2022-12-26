package db.day2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//인터페이스 구현부
public class studentDAOImp implements studentDao{
	Connection con ;
	ResultSet rs; 
	Statement stmt;
	PreparedStatement pstmt; //쿼리가 먼저 준비되어있어야 사용가능
	
	//DAO생성자
	public studentDAOImp(Connection con) throws SQLException {
		this.con = con;
		if(con != null) 
			stmt = con.createStatement(); //stmt를 con을통해 만들어줌
	}
	
	public ArrayList<StudentV01> selectAllStudent() throws SQLException { //학생정보 전부 출력
		if(stmt == null) {
			return null;
		}
		 String sql = "select st_num, st_name,st_semester,st_status,st_pr_num from student"; // sql로 불러옴
        //가급적 *(=all)보다는 속성명을 써주는게 좋다.
		 rs = stmt.executeQuery(sql); //ResultSet을 이용해 쿼리실행
		 ArrayList<StudentV01> list = new ArrayList<StudentV01>();
        while(rs.next()) { //반복문을통해 값을 꺼내옴. next()는 다음으로 이동. 
        	//이동을 제대로했으면 true,이동 못하면 false
        	String st_num = rs.getString(1);
        	String st_name = rs.getString(2);
        	int st_semester = rs.getInt(3);
        	String st_status = rs.getString(4);
        	String st_pr_num = rs.getString(5);
        	//type에 맞게 가져와야한다. getString, getInt...
        	StudentV01 std = new StudentV01(st_num,st_name,st_semester,st_status,st_pr_num);
        	list.add(std);
        }
        return list;
	}

	@Override
	public StudentV01 selectStudentBySt_num(String st_num) throws SQLException { //학생정보출력
		if(con == null) {
			return null;
		}
		String sql = "select st_num, st_name,st_semester,st_status,st_pr_num from student where st_num =?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,st_num); //1번째의 물음표에 변수st_num에 있는 값으로 문자열을 설정해주세요.
		rs = pstmt.executeQuery();
		if(rs.next()) { //학번 이외의 나머지
			String st_name = rs.getString(2);
	    	int st_semester = rs.getInt(3);
	    	String st_status = rs.getString(4);
	    	String st_pr_num = rs.getString(5);
	    	StudentV01 std = new StudentV01(st_num,st_name,st_semester,st_status,st_pr_num);	
	    	return std; 
		}
		return null;
	}

	@Override
	public boolean insertStudent(StudentV01 std) {//학생 정보 추가(예외처리를 직접 해줌)
		if(con == null) {//연결을 하고 실행해야하는데,,연결을 안하고 실행하면 null이 들어가게됨.그거의 예외
			return false;
		}
		String sql = "insert into student values(?,?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, std.getSt_num());
			pstmt.setString(2, std.getSt_name());
			pstmt.setInt(3, std.getSt_semester());
			pstmt.setString(4, std.getSt_status());
			pstmt.setString(5, std.getSt_pr_num());
			
			int count = pstmt.executeUpdate();
			if(count ==0) {
			return false; //0이면 실패
				}
			} catch (SQLException e) {
			return false;
		}
		return true;//0아니면 성공
	}

	@Override
	public boolean deleteStudent(String st_num) {//학생 삭제
		if(con == null) {//연결을 하고 실행해야하는데,,연결을 안하고 실행하면 null이 들어가게됨.그거의 예외
			return false;
		}
		String sql = "delete from student where st_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, st_num);
			int count = pstmt.executeUpdate();
			if(count ==0) {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
		
		
		return true;
	}

	@Override
	public boolean updateStudent(StudentV01 std, int subMenu) {//학생 정보 수정
		if(con == null) {//연결을 하고 실행해야하는데,,연결을 안하고 실행하면 null이 들어가게됨.그거의 예외
			return false;
		}
		String sql = "update student set "
				+"st_name =? , st_semester =? , st_status= ? , st_pr_num =? "
				+"where st_num =? ";
		try {
			StudentV01 dbStd = selectStudentBySt_num(std.getSt_num()); //학번을 통해 학생정보 가져옴
			if(dbStd == null)
				return false;
			switch(subMenu) {
			case 1: dbStd.setSt_name(std.getSt_name());break;
			case 2: dbStd.setSt_semester(std.getSt_semester());break;
			case 3: dbStd.setSt_status(std.getSt_status());break;
			case 4: dbStd.setSt_pr_num(std.getSt_pr_num());break;
			default : return false;
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dbStd.getSt_name());
			pstmt.setInt(2, dbStd.getSt_semester());
			pstmt.setString(3, dbStd.getSt_status());
			pstmt.setString(4, dbStd.getSt_pr_num());
			pstmt.setString(5, dbStd.getSt_num());
//			System.out.println(pstmt); 확인용
			int count = pstmt.executeUpdate();
			if(count ==0) {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
}
