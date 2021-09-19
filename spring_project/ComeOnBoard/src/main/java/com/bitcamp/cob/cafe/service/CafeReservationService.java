package com.bitcamp.cob.cafe.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.cob.cafe.dao.CafeDao;
import com.bitcamp.cob.cafe.domain.CafeReservation;

@Service
public class CafeReservationService {

	@Autowired
	private SqlSessionTemplate template;
	
	public List<CafeReservation> getReservList(CafeReservation cafeReservation) {
		List<CafeReservation> getList = null;
		return template.getMapper(CafeDao.class).getReservList(cafeReservation);
	}

}
