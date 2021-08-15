package com.bitcamp.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.Dao;
import com.bitcamp.op.member.dao.JdbcTemplateMemberDao;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.dao.mybatisMemberDao;

@Service
public class IdCheckService {

	//@Autowired
	//private MemberDao dao;
	
	//@Autowired
	//private JdbcTemplateMemberDao dao;
	
	//@Autowired
	//private mybatisMemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	private Dao dao;
	
	public String idCheck(String id) {
		
		String result = "Y";
		//Connection conn = null;
				
		dao = template.getMapper(Dao.class);
		
		//conn = ConnectionProvider.getConnection();
		if(dao.selectById(id) > 0 ) {
			result = "N";
		}		
		return result;
	}
}
