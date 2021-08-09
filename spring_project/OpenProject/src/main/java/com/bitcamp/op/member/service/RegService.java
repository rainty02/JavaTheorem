package com.bitcamp.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.domain.Member;

@Service
public class RegService {

	@Autowired
	MemberDao dao;
	
	public int register(Member member, HttpSession session, HttpServletResponse response) {
		
		int insertChk = 0;
		
		// 전달받은 멤버 객체로 회원가입 처리
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			insertChk = dao.insertMember(conn, member);
			
			if(insertChk!=0) {
				// 회원가입
				session.setAttribute("insertChk", insertChk);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return insertChk;
	}
}
