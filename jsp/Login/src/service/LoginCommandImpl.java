package service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import domain.Member;
import util.ConnectionProvider;
import util.CookieBox;

public class LoginCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {

		// 사용자가 전달한 데이터를 받고 -> DB에서 확인 -> 로그인 처리
		// 로그인 처리 -> Session 객체에 사용자 정보를 저장
		// reid 확인 하고 값을 받아오면 쿠키 설정
		String memberId = request.getParameter("memberid");
		String password = request.getParameter("password");
		String reid = request.getParameter("reid");

		// 아이디, 비밀번호 체크 후 로그인
		boolean loginChk = false;

		Connection conn = null;
		MemberDao dao = null;
		try {
			if (memberId != null && password != null && memberId.trim().length() > 2 && password.trim().length() > 3) {

				conn = ConnectionProvider.getConnection();
				dao = MemberDao.getInstance();

				Member member = dao.selectByIdPw(conn, memberId, password);

				if (member != null) {
					// 회원의 정보를 Session 객체에 저장
					// session.setAttribute("member", member);
					request.getSession().setAttribute("loginInfo", member.toLoginInfo());
					loginChk = true;
				}
			}

			// ID 저장을 위한 쿠키 설정
			// reid 값의 유무 체크
			if (reid != null && reid.equals("on")) {
				// 쿠키 저장 : 사용자 ID를 저장
				response.addCookie(CookieBox.makeCookie("reid", memberId, "/", 60 * 60 * 24 * 365));
			} else {
				// 쿠키값을 저장하지 않는다!!!
				response.addCookie(CookieBox.makeCookie("reid", memberId, "/", 0));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		request.setAttribute("loginChk", loginChk);

		return "/WEB-INF/views/login.jsp";
	}
}
