package member.service;

import java.util.Date;

import member.dao.Dao;
import member.domain.Member;
import member.domain.RegRequest;

public class MemberRegService {

	// Dao dao = new MemberDao();
	private Dao dao;
	private int num;
	
	// 프로퍼티 방식 : setter 메소드 이용, 기본 생성자 필요
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	// 생성자 정의
	// 기본 생성자
	public MemberRegService() {
		System.out.println("MemberRegService()");
	}
	
	// 정수데이터를 받는 생성자
	public MemberRegService(int num) {
		//this.dao = dao;
		System.out.println("MemberRegService 인스턴스 생성");
	}	
	
	// 인스턴스와 정수데이터를 받는 생성자
	public MemberRegService(Dao dao, int num) {
		this.dao = dao;
		this.num = num;
		System.out.println("MemberRegService 인스턴스 생성");
	}
	
	// 의존 설정시 생성자 필요
	public MemberRegService(Dao dao) {
		this.dao = dao;
		System.out.println("MemberRegService 인스턴스 생성");
	}
	
	public void regMember(RegRequest request) throws Exception {

		// 중복 이메일 체크, 예외발생
		Member member = dao.selectByEmail(request.getEmail());
		
		if(member != null) {
			throw new Exception("이미 존재하는 이메일주소입니다.");
		}
		
		Member newMember = new Member(0, request.getEmail(), request.getPassword(), request.getName(), new Date());
		
		dao.insert(newMember);
	}
		
}
