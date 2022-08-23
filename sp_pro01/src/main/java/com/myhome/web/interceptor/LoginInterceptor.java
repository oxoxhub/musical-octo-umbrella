package com.myhome.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.myhome.web.emp.model.EmpDTO;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginData") == null) {
			String qs = "";
			if(request.getQueryString() != null) {
				// getQueryString 메서드는 파라메터 값을 가져온다.
				qs = "?" + request.getQueryString();
			}
			EmpDTO empData = new EmpDTO();
			session.setAttribute("loginData", empData);
			response.sendRedirect(request.getContextPath() + "/login?url=" + request.getRequestURI() + qs);
			// request.getContextPath() = /web
			// 예로들어 request.getRequestURI() = /web/board/detail
			// 예로들어 qs = ?id=24
			System.out.println("로그인 인터셉터 프리핸들");
			return false; //false를 반환하면 응답으로 넘어감
		} else {
			return true; //true로 반환하면 다음 인터셉터 또는 컨트롤러로 이동
		}
	}
}
