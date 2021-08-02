package member.service;

import java.util.Date;

import member.dao.Dao;
import member.domain.Member;
import member.domain.RegRequest;

public class MemberRegService {

	// Dao dao = new MemberDao();
	Dao dao;
	
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
