package com.bitcamp.cob.member.dao;

import org.apache.ibatis.annotations.Param;

import com.bitcamp.cob.member.domain.LoginInfo;
import com.bitcamp.cob.member.domain.Member;

public interface MemberDao {
	
	// 회원 가입
	int insertMember(Member member);
	
	// ID 중복값 체크
	int selectById(String memId);
	
	// 비밀번호 확인
	int selectByPw(String memPassword);
	
	// 닉네임 중복값 체크
	int selectByNickName(String nickName);
	
	// 로그인 
	LoginInfo selectByIdPw(String memId, String memPw);
	
	// 정보 변경 위한 기존 입력 정보 받아오기
	LoginInfo selectByIdx(int memIdx);
	
	// 회원 정보 수정
	int updateMember(Member member);
	
	// 비밀번호 변경
	int updatePwById(@Param("memId")String memId, @Param("memPassword")String memPassword);
	
	// 사진 변경
	int updateMemPhoto(@Param("memIdx")int memIdx, @Param("memPhoto")String memPhoto);
	
	// 탈퇴, 아이디 삭제
	int deleteMember(int memIdx);
	

}
