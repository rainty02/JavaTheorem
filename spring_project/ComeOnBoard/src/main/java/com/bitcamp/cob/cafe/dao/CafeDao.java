package com.bitcamp.cob.cafe.dao;



import java.util.List;

import com.bitcamp.cob.cafe.domain.Cafe;

public interface CafeDao {

	// 카페 리스트 출력 - 기본
	List<Cafe> cafeList(String type);

}
