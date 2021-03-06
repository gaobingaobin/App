package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	private FilterConfig Config;
	

	public void destroy() {
	

	}


	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		 HttpServletRequest request = (HttpServletRequest) arg0;
         HttpServletResponse response = (HttpServletResponse) arg1;
         HttpSession session = request.getSession();
       
        	if(session.getAttribute("username")!=null){
        		arg2.doFilter(request, response);
        	}
        	else{
        		response.sendRedirect(request.getContextPath()+"/index.jsp");
        	}
         }


	public void init(FilterConfig arg0) throws ServletException {
		Config = arg0;

	}

}
