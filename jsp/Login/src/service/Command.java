package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	
	//String getPage(HttpServletRequest request);
	
	String getPage(HttpServletRequest request, HttpServletResponse response);

}
