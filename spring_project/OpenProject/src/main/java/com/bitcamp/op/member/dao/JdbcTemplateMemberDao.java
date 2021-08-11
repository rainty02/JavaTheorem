package com.bitcamp.op.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.MemberFile;
import com.bitcamp.op.member.domain.MemberRegRequest;

@Repository
public class JdbcTemplateMemberDao {
		
	@Autowired
	private JdbcTemplate template;

	// Member 타입
	public int insertMember(Member member) throws SQLException {

		int resultCnt = 0;
		
		String sql1 = "insert into membert (memberid,password,membername) values (?, ?, ?)";
		String sql2 = "insert into membert (memberid,password,membername,memberphoto) values (?, ?, ?, ?)";
		
		if(member.getMemberphoto() == null) {
			resultCnt = template.update(sql1, member.getMemberid(), member.getPassword(), member.getMembername());
		} else {
			resultCnt = template.update(sql2, member.getMemberid(), member.getPassword(), member.getMembername(), member.getMemberphoto());
		}
		
		return resultCnt;

	}
	
	// MemberFile 타입
	public int insertMember(Connection conn, MemberFile memberFile) throws SQLException {

		int resultCnt = 0;

		PreparedStatement pstmt = null;

		String sql1 = "insert into membert (memberid,password,membername) values (?, ?, ?)";
		String sql2 = "insert into membert (memberid,password,membername,memberphoto) values (?, ?, ?, ?)";
		
		try {
			
			if(memberFile.getPhoto() == null) {
				pstmt = conn.prepareStatement(sql1);
				pstmt.setString(1, memberFile.getMemberid());
				pstmt.setString(2, memberFile.getPassword());
				pstmt.setString(3, memberFile.getMembername());
			} else {
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, memberFile.getMemberid());
				pstmt.setString(2, memberFile.getPassword());
				pstmt.setString(3, memberFile.getMembername());
				pstmt.setString(4, memberFile.getPhoto().getOriginalFilename());
			}

			resultCnt = pstmt.executeUpdate();

		} finally {
			JdbcUtil.close(pstmt);
		}
		return resultCnt;

	}

	public List<Member> selectList(Connection conn) {

		List<Member> list = null;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();

			String sql = "select * from membert";

			rs = stmt.executeQuery(sql);

			list = new ArrayList<Member>();

			while (rs.next()) {
				list.add(new Member(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4),
						rs.getString(5),
						rs.getTimestamp(6)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}

		return list;

	}
	
	public Member selectByIdPw(String id, String pw) {
				
		List<Member> list = template.query("select * from membert where memberid=? and password=?", new MemberRowMapper(), id, pw);
		return list.isEmpty() ? null : list.get(0);
	}

	// ID 중복여부 확인을 위한 id 값으로 검색 -> 개수 반환
	public int selectById(String memberId) throws SQLException {
		
		return template.queryForObject("select count(*) from membert where memberid=?", Integer.class, memberId);
	}

		
	public int deleteMember(Connection conn, int midx) {
		
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql = "delete from membert where idx = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, midx);
			
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return resultCnt;
	}
}