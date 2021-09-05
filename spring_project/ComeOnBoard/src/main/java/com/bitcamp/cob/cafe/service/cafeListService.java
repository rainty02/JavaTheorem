package com.bitcamp.cob.cafe.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.cob.cafe.dao.CafeDao;
import com.bitcamp.cob.cafe.domain.Cafe;

@Service
public class cafeListService {

	@Autowired
	private SqlSessionTemplate template;
	
	private CafeDao dao;
	
	public List<Cafe> cafeList(String type) {
		
		return template.getMapper(CafeDao.class).cafeList(type);
		
	}
}