package com.bitcamp.cob.game.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.cob.game.dao.GameDao;
import com.bitcamp.cob.game.domain.GameMain;
import com.bitcamp.cob.game.domain.GamePage;
import com.bitcamp.cob.game.domain.SearchType;

@Service
public class GamePageService {

	
	@Autowired
	private SqlSessionTemplate template;
	
	
	public GamePage getGamePage(int idx){
		
		return template.getMapper(GameDao.class).selectGamePage(idx);
				
	}

	public List<GameMain> getGameMain(SearchType searchType){
		
		return template.getMapper(GameDao.class).searchGame(searchType);
	
	}	
	
}
