package com.bitcamp.cob.group.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.cob.group.dao.GroupDao;

@Service
public class DeleteGroupBoardService {

	@Autowired
	private SqlSessionTemplate template;
	
	public int deleteBoard(int grpIdx) {
		
		return template.getMapper(GroupDao.class).deleteGroupBoardContent(grpIdx);
		
	}
	
}
