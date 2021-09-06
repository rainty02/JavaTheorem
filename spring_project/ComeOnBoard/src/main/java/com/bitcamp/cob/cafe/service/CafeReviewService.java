package com.bitcamp.cob.cafe.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.cob.cafe.dao.CafeDao;
import com.bitcamp.cob.cafe.domain.Cafe;
import com.bitcamp.cob.cafe.domain.CafeReview;

@Service
public class CafeReviewService {

	@Autowired
	private SqlSessionTemplate template;

	// 카페리뷰 출력
	public List<CafeReview> getCafeReview(int idx) {
		return template.getMapper(CafeDao.class).getCafeReview(idx);
	}
	
	// 카페 리뷰 작성
	public int writeCafeReview(CafeReview cafeReview) {
		System.out.println(cafeReview);
		return template.getMapper(CafeDao.class).writeCafeReview(cafeReview);
	}
}