package member.service;

import member.dao.Dao;
import member.domain.Member;

public class ChangePasswordService {

	Dao dao;
	
	public ChangePasswordService(Dao dao) {
		this.dao = dao;
	}
	
	public void changePassword(String email, String oldPw, String newPw) throws Exception {
		
		Member member = dao.selectByEmail(email);
		
		if(member == null) {
			throw new Exception("존재하지 않는 회원입니다.");
		}
		
		member.chagePassword(oldPw, newPw);
		
		dao.update(member);
	}
	
}
