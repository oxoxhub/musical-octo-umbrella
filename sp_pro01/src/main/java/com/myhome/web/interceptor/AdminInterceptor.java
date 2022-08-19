package com.myhome.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.myhome.web.emp.model.EmpDTO;

public class AdminInterceptor implements HandlerInterceptor {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		
		// 관리자 계정으로 로그인을 한 경우 별도의 관리자 페이지가 만들어지게 한다.
		if(session.getAttribute("loginData") != null) {
			EmpDTO empDto = (EmpDTO)session.getAttribute("loginData");
			
			if(empDto.getDeptId() == 10) {
				String oldView = modelAndView.getViewName();
				System.out.println("oldView : " + oldView);
				if(!oldView.startsWith("redirect:")) {
					//리다이렉트가 아닐때 admin 경로를 붙여야한다.
					modelAndView.setViewName("admin/" + oldView);
					// admin/board/detail 주소로 변경된다.
				}
			}
		}
	}
}
