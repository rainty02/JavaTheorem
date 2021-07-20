package jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dept.domain.Dept;

public class DeptDAO {

//	private DeptDAO() {}
//	static private DeptDAO dao = new DeptDAO();
//	public static DeptDAO getInstance() {
//		return dao;
//	}
	
	private static DeptDAO instance;
	private DeptDAO() {}
	public static DeptDAO getInstance() {
		if(instance == null) {
			instance = new DeptDAO();
		}
		return instance;
	}
	
	static ArrayList<Dept> getList(Connection con){
		
		ArrayList<Dept> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
				
		try {			
			String sqlSelect = "select * from project.dept";
			con.prepareStatement(sqlSelect);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	void aaaaaa() {}
}
