package com.bitcamp.cob.group.dao;


import java.util.ArrayList;


import com.bitcamp.cob.group.domain.Group;
import com.bitcamp.cob.group.domain.NicknameMemidxGrpidx;
import com.bitcamp.cob.group.domain.RegGroup;
import com.bitcamp.cob.group.domain.SearchType;
import com.bitcamp.cob.group.domain.TitleAndContent;


public interface GroupDao {
	
	//update할 제목, 내용
	public int updateCreatedTitleAndContent(TitleAndContent tac);
	
	

	//모임 게시글 생성
	public int insertGroupBoardContent(Group group);
	
	//모임 게시글 출력
	public Group selectGroupBoardContent(int grpIdx); //매개변수에 grpIdx를 전달해줘야 처리가 가능하다!!
	
	//모임 게시글 업데이트
	public int updateGroupBoardContent(Group group);
	
	//모임 수정내용 불러오기
	public Group reSelectContent(Group group);
	
	//모임 게시글 삭제
	public int deleteGroupBoardContent(int grpIdx);
	
	
	
	
	
	// 모임글 게시판 <List>형식으로 select
	public ArrayList<Group> selectList(int a, int b);
	
	// 전체 게시물의 갯수
	public int selectAllCount(SearchType searchType);
	
	// 검색을 이용한 모임 게시판 select
	public ArrayList<Group> selectListBySearch(SearchType searchType);

	
	
	
	// 내가 만든 모임 select (여러개일수도 있으니 List로 받아야 한다)
	public ArrayList<Group> selectMyGroup(int memIdx);
	
	//참가한 모임 select
	public RegGroup selectJoinGroup();
	
	//모임 참가 (groupreg에 insert)
	public int insertJoinGroup(int memIdx, int grpIdx);

	//모임에 참가한 사람의 닉네임 가져오기
	public ArrayList<NicknameMemidxGrpidx> selectRegGroupNicknameMemidxGrpidx(int grpIdx);
	
	//모임 참가 수락/거절
	public int judgeRequest(int memIdx, int grpIdx);
	
	
}
