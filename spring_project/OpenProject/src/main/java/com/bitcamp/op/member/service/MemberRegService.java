package com.bitcamp.op.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.dao.Dao;
import com.bitcamp.op.member.dao.JdbcTemplateMemberDao;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.dao.mybatisMemberDao;
import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.MemberRegRequest;

@Service
public class MemberRegService {

	final String UPLOAD_URI = "/uploadfile";
	
	//@Autowired
	//private MemberDao dao;
	
	//@Autowired
	//private JdbcTemplateMemberDao dao;
	
	//@Autowired
	//private mybatisMemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	private Dao dao;
	
		
	public int memberReg(MemberRegRequest regRequest, HttpServletRequest request) {

		int resultCnt = 0;
		//Connection conn = null;
		File newFile = null;	
		
		try {
			// 1. 파일 저장
			// 시스템 경로
			String path = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
			// 새로운 저장 폴더 : File
			File newDir = new File(path);	
			// 폴더가 존재하지 않으면 폴더 생성
			if(!newDir.exists()) {
				newDir.mkdir();
				System.out.println("저장 폴더를 생성했습니다.");
			}
			// 파일 저장시 파일이름이 같으면 덮어씀 -> 회원별 고유한 파일 이름으로 저장
			String newFileName = regRequest.getMemberid()+System.currentTimeMillis();
			// 파일 저장 : 새로운 File 객체
			newFile = new File(newDir, newFileName);
			
			// Member 객체 생성 : 저장된 파일의 이름을 set
			Member member = regRequest.toMember();
			System.out.println(member.getMemberphoto());
			if(!regRequest.getPhoto().isEmpty() && regRequest.getPhoto()!=null) {
				regRequest.getPhoto().transferTo(newFile);
				member.setMemberphoto(newFileName);
			} else {
				member.setMemberphoto("photo.png");
			}
			
			// 2. dao 저장
			//conn = ConnectionProvider.getConnection();
			dao = template.getMapper(Dao.class);			
			resultCnt = dao.insertMember(member);
			
			System.out.println("IDX : " + member.getIdx());
			// idx 값은 자식 테이블의 insert시 외래키로 사용
			// 자식 테이블 insert 구문에 사용
			
			
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//JdbcUtil.close(conn);
		}
		
		return resultCnt;
	}	
}
