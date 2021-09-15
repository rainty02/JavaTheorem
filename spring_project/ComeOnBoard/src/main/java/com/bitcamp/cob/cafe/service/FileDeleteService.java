package com.bitcamp.cob.cafe.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.cob.cafe.dao.CafeDao;
import com.bitcamp.cob.cafe.domain.CafeImgInfo;

@Service
public class FileDeleteService {

	@Autowired
	private SqlSessionTemplate template;
	
	public List<CafeImgInfo> getImgList(CafeImgInfo cafeImgInfo) {
		return template.getMapper(CafeDao.class).getImgList(cafeImgInfo);
	}

}
