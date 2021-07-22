package jdbc.util;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

// 서블릿 클래스
public class Loader extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		String params = config.getInitParameter("driver");
		
		// DB 드라이버 로드
		try {
			if(params != null) {	
				Class.forName(params);
				System.out.println("드라이버를 로드했습니다.");			
			} else {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("드라이버를 로드했습니다.");
			}	
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드를 실패했습니다.");
		}
	}
}