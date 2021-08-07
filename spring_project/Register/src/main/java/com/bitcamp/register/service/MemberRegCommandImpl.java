package com.bitcamp.register.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.register.dao.Dao;
import com.bitcamp.register.dao.MemberDao;
import com.bitcamp.register.domain.Member;
import com.bitcamp.util.ConnectionProvider;

@Service
public class MemberRegCommandImpl implements Command {

	@Autowired
	private Dao dao;
	
	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		int resultCnt = 0;
		
		Member member = new Member();		
		
		Connection conn = null;
		MemberDao dao = null;
		
		File newFile = null;
		
		try {
		// 1. multipart/form-data 여부 확인
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if(isMultipart){
			
			// 2. 파일을 저장할 Factory 객체 생성
			DiskFileItemFactory factory = new DiskFileItemFactory();
			
			// 3. 요청 처리(form의 input들을 분리)를 위해서 ServletFileUpload 생성
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			// 4. 사용자 요청을 파싱(분리 : 원하는 형태로 분리 input -> FileItem)
			// FileItem -> input 데이터를 저장하고 있는 객체
			List<FileItem> items = upload.parseRequest(request);
			
			Iterator<FileItem> itr = items.iterator();
			
			while(itr.hasNext()){
				
				FileItem item = itr.next(); // formfield : (text, checkbox, hidden) / file 등등
				
				// file과 formfield를 구분
				if(item.isFormField()){
					
					// 회원 아이디, 회원 이름, 비밀번호
					String paramName = item.getFieldName();
					
					if(paramName.equals("memberid")) {
						member.setMemberid(item.getString("utf-8"));
					} else if(paramName.equals("password")) {
						member.setPassword(item.getString("utf-8"));
					} else if(paramName.equals("membername")) {
						member.setMembername(item.getString("utf-8"));
					}
				} else {
					// 사진 데이터 처리
					// 경로
					String uploadUri = "/uploadfile";
					String dir = request.getSession().getServletContext().getRealPath(uploadUri);
					
					File saveDir = new File(dir);
					
					// 디렉토리가 없다면 생성
					if(!saveDir.exists()) {
						saveDir.mkdir();
					}
					
					String paramName = item.getFieldName();
					if(paramName.equals("photo")) {
						
						// 파일이름, 사이즈
						if(item.getName()!=null && item.getSize()>0) {
							// 저장
							newFile = new File(saveDir, item.getName());
							item.write(newFile);
							// DB에 저장할 파일의 이름
							member.setMemberphoto(item.getName());
							System.out.println("파일을 저장했습니다.");
						}
					}
				}
			}
		} else {
			throw new Exception("multipart 타입이 아닙니다.");
		}
		
		// DB insert
		// Connection, MemberDao
		
		conn = ConnectionProvider.getConnection();
		//dao = MemberDao.getInstance();
		
		resultCnt = dao.insertMember(conn, member);
		
		} catch (SQLException e) {
			e.printStackTrace();
			// 예외발생시 파일 삭제
			if(newFile!=null && newFile.exists()) {
				newFile.delete();
				System.out.println("파일을 삭제했습니다.");
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("result", resultCnt);
		
		return "/WEB-INF/views/reg_view.jsp";

	}

}
