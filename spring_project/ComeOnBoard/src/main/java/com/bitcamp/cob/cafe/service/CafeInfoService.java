package com.bitcamp.cob.cafe.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.cob.cafe.dao.CafeDao;
import com.bitcamp.cob.cafe.domain.Cafe;
import com.bitcamp.cob.cafe.domain.CafeReview;

@Service
public class CafeInfoService {

	@Autowired
	private SqlSessionTemplate template;
	
	public Cafe getCafeInfo(int idx) {
		return template.getMapper(CafeDao.class).getCafeInfo(idx);		
	}

	public int cafeReg(Cafe cafe, HttpServletRequest request) {
		System.out.println(cafe);
		return template.getMapper(CafeDao.class).cafeReg(cafe);
	}

}