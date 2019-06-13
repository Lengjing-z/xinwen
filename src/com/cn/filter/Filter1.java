package com.cn.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.vo.User;

/**
 * Servlet Filter implementation class Filter1
 */
@WebFilter(filterName="/Filter1",urlPatterns={"*.jsp"})
public class Filter1 implements Filter {

    /**
     * Default constructor. 
     */
    public Filter1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request2 = (HttpServletRequest)request;
		HttpServletResponse response2 = (HttpServletResponse)response;
		User user = (User)request2.getSession().getAttribute("user");
		String path=request2.getRequestURI();
		if(path.indexOf("/login.jsp")>-1){//登录页面不过滤
			chain.doFilter(request, response);//递交给下一个过滤器
            return;
        }
		if(path.indexOf("/register.jsp")>-1){//注册页面不过滤
			chain.doFilter(request2, response2);
            return;
        }
		if(user == null) {
			
			response2.sendRedirect("login.jsp");
		}else
			chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
