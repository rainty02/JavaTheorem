package ncs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	
	// 싱글톤
	private MemberDao() {}
	private static MemberDao dao = new MemberDao();
	public static MemberDao getInstance() {
		return dao;
	}
	
	// 멤버 추가
	public int insertMem(Connection con, Member mem) {
		
		int result = 0;	
		PreparedStatement pstmt = null;	
		
		String sql = "insert into member (ID, PW, NAME) values (?, ?, ?)";
		
		try {		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPw());
			pstmt.setString(3, mem.getName());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Close.close(pstmt);
		}
		return result;	
	}
	
	// 전체 멤버 출력
	public List<Member> selectMem(Connection con){
		
		List<Member> list = null;
		Statement stmt = null;
		ResultSet rs =null;
		
		String sql = "select * from member";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			list = new ArrayList<Member>();
			while(rs.next()) {
				list.add(new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close.close(rs);
			Close.close(stmt);
		}
		return list;		
	}
	
}