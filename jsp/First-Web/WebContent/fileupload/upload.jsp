<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 사용자가 전송한 데이터, 파일 저장 -> view 페이지로 파일의 경로를 전달(공유) -> 해당 경로의 이미지(파일) 출력
	// 사용자 폼 데이터(text)
	String title = null;
	// 서버에 저장된 파일이름
	String newFile = null;
	
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
				// 일반 input type 처리
				// 파라미터 이름, 해당 폼의 데이터(String)
				String paramName = item.getFieldName();
				if(paramName.equals("title")){
					String paramValue = item.getString("utf-8");
					title = paramValue;
					
					//out.println("title : " + title + "<br>");
				} else if(paramName.equals("title2")){
					// ....
				}
				
			} else {
				// type=file 처리
						
				// 웹 경로
				String uploadUri = "/upload";
				// 시스템 경로
				String dir = request.getSession().getServletContext().getRealPath(uploadUri);
				
				//out.println("path : " + dir);
						
				String paramName = item.getFieldName();
				
				if(paramName.equals("photo")){
					String userFileName = item.getName(); 		// 파일의 이름
					String contentType = item.getContentType(); // 파일의 컨텐트 타입
					long fileSize = item.getSize();				// byte 사이즈 (long타입 반환)
					
					out.println("fileName : " + userFileName + "<br>");
					out.println("contentType : " + contentType + "<br>");
					out.println("fileSize : " + fileSize + "<br>");
				
					// 파일 유효성 조건
					if(userFileName != null && fileSize > 0){
						File savePath = new File(dir, userFileName);
						item.write(savePath);
						System.out.println("데이터가 저장되었습니다.");
						newFile = userFileName;
					}
					
				} else if(paramName.equals("file")){
					// ....
				}
			}
		}
	}
	
	request.setAttribute("title", title);
	request.setAttribute("photo", newFile);
	
%>
<jsp:forward page="upload_view.jsp"/>









