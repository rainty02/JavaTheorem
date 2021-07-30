package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Command;
import service.InvalidCommandImpl;
import service.LoginCommandImpl;
import service.LogoutCommandImpl;
import service.MemberListCommandImpl;
import service.MyPageCommandImpl;

public class FrontController extends HttpServlet {

	private Map<String, Command> commands = new HashMap<String, Command>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		// 설정파일의 경로 가져오기
		String configFile = config.getInitParameter("config");
		Properties prop = new Properties();
		FileInputStream fis = null;
		
		// 설정 파일의 시스템 경로
		String configPath = config.getServletContext().getRealPath(configFile);
		
		try {
			fis = new FileInputStream(configPath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Iterator<Object> itr = prop.keySet().iterator();
		while(itr.hasNext()) {
			String command = (String) itr.next();
			String commandClassName = prop.getProperty(command);
				
			try {
				// 해당 클래스의 인스턴스 생성
				Class commandClass = Class.forName(commandClassName);
				Command commandObj = (Command) commandClass.newInstance();
				commands.put(command, commandObj);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 사용자 요청 분석
		String commandUri = request.getRequestURI();
		// 입력된 Uri 중 컨텍스트 경로가 0번째 위치하면
		if(commandUri.indexOf(request.getContextPath()) == 0 ) {
			// 입력한 Uri 경로 중 컨텍스트 경로의 길이만큼 지운다 : /mvc/guest/list.do - > /mvc을 지움
			commandUri = commandUri.substring(request.getContextPath().length());
		}
		
		// 결과 페이지 : 기본 페이지
		String viewPage = "/WEB-INF/views/index.jsp";
		Command command = null;
		
		// 커맨드 키값에 맞는 밸류값
		command = commands.get(commandUri);
		if (command == null) {
			command = new InvalidCommandImpl();
		}
		viewPage = command.getPage(request, response);
		
//		// 2. 요청 처리
//		if(commandUri.equals("/list_view.do")) {
//			// 처리할 서비스 메소드 실행
//			MemberListCommandImpl ml = new MemberListCommandImpl();
//			viewPage = ml.getPage(request, response);
//		} else if (commandUri.equals("/logout.do")) {
//			LogoutCommandImpl lo = new LogoutCommandImpl();
//			viewPage = lo.getPage(request, response);
//		} else if (commandUri.equals("/loginForm.do")) {
//			LoginCommandImpl lg = new LoginCommandImpl();
//			viewPage = lg.getPage(request, response);
//		} else if (commandUri.equals("/mypage.do")) {
//			MyPageCommandImpl mp = new MyPageCommandImpl();
//			viewPage = mp.getPage(request, response);
//		} 
		
		// viewPage 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
	

}
