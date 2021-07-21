package ncs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		
		try {			
			String sql = "insert into member (ID, PW, NAME) values (?, ?, ?)";
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
}