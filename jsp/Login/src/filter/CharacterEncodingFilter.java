package filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class CharacterEncodingFilter
 */
@WebFilter(
		dispatcherTypes = {DispatcherType.REQUEST }
					, 
		asyncSupported = true, 
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "encoding", value = "utf-8")
		})
public class CharacterEncodingFilter implements Filter {

    private String encoding;    
    
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// 인코딩값 설정
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		httpRequest.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
		String paramValue = fConfig.getInitParameter("encoding");
		if(paramValue != null) {
			this.encoding = "utf-8";
		} else {
			this.encoding = paramValue;
		}
	}

}
