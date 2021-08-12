package com.bitcamp.op.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.MemberFile;
import com.bitcamp.op.member.domain.MemberRegRequest;
import com.bitcamp.op.member.domain.SearchIdPw;

@Repository
public class mybatisMemberDao {
		
	@Autowired
	private SqlSessionTemplate template;
	
	private final String NAME_SPACE = "com.bitcamp.op.member.dao.memberMapper";

	// Member 타입
	public int insertMember(Member member) throws SQLException {
		
		return template.update(NAME_SPACE+".insertMember", member);
	}
	
	public int insertMember1(final Member member) throws SQLException {

		int resultCnt = 0;
		
		// 자동 증가한 컬럼의 값을 저장할 객체
//		KeyHolder holder = new GeneratedKeyHolder();
//		resultCnt = template.update(
//				new PreparedStatementCreator() {
//					
//					@Override
//					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//						String sql2 = "insert into membert (memberid,password,membername,memberphoto) values (?, ?, ?, ?)";
//						PreparedStatement pstmt = con.prepareStatement(sql2, new String[] {"idx"});
//						pstmt.setNString(1, member.getMemberid());
//						pstmt.setNString(2, member.getPassword());
//						pstmt.setString(3, member.getMembername());
//						pstmt.setString(4, member.getMemberphoto());
//						
//						return pstmt;
//					}
//				}
//				, holder);
//		
//		Number idx = holder.getKey();
//		member.setIdx(idx.intValue());
		
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
		
		return template.selectOne(NAME_SPACE+".selectByIdPw", new SearchIdPw(id, pw));
	}

	// ID 중복여부 확인을 위한 id 값으로 검색 -> 개수 반환
	public int selectById(String memberId) throws SQLException {
		
		return template.selectOne(NAME_SPACE+".selectById", memberId);
	}

		
	public int deleteMember(int midx) {
		
//		int resultCnt = 0;
//		PreparedStatement pstmt = null;
//		
//		String sql = "delete from membert where idx = ?";
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, midx);
//			
//			resultCnt = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			JdbcUtil.close(pstmt);
//		}
		//return resultCnt;
		
		return template.update("delete from membert where idx = ?", midx);
	}
}