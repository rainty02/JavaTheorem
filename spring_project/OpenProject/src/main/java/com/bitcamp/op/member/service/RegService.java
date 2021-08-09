package com.bitcamp.op.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.domain.MemberFile;

@Service
public class RegService {

	@Autowired
	MemberDao dao;
	
	final String UPLOAD_URI = "/uploadfile";
	
	public int register(MemberFile memberFile, HttpServletRequest request) {
		
		int insertChk = 0;
		Connection conn = null;
				
		try {
			conn = ConnectionProvider.getConnection();
			insertChk = dao.insertMember(conn, memberFile);
			
			saveFile(request, memberFile.getPhoto());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return insertChk;
	}
	
	private void saveFile(HttpServletRequest request, MultipartFile multiPartFile) throws IllegalStateException, IOException {
		String saveDir = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
		File newFile = new File(saveDir, multiPartFile.getOriginalFilename());
		multiPartFile.transferTo(newFile);
	}
	
}
