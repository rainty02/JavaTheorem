package com.bitcamp.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.app.member.mapper.MemberMapper;

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
	
	private MemberMapper dao;
	
	public String idCheck(String id) {
		
		String result = "Y";
		//Connection conn = null;
				
		dao = template.getMapper(MemberMapper.class);
		
		//conn = ConnectionProvider.getConnection();
		if(dao.selectById(id) > 0 ) {
			result = "N";
		}		
		return result;
	}
}
