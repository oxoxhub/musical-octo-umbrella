package com.myhome.web.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myhome.web.dept.model.DeptDTO;
import com.myhome.web.dept.service.DeptService;
import com.myhome.web.login.service.LoginService;
import com.myhome.web.login.vo.LoginVO;

@Controller
public class LoginController {
	
	
	@Autowired
	private LoginService service;
	@Autowired
	private DeptService deptService;
	
	@GetMapping(value="/login")
	public String login(Model model) {
		List<DeptDTO> deptDatas = deptService.getAll();
		model.addAttribute("deptDatas", deptDatas);
		return "login/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(LoginVO loginVo, String url
			, HttpServletRequest request
			, HttpSession session, Model model) {
		
		boolean result = service.getLogin(session, loginVo);
		
		if(result) {
			//로그인 성공
			if(!url.isEmpty()) {
				if(url.startsWith(request.getContextPath())) {
					//맨 앞에 /web 이 자동으로 붙어있기때문에 삭제를 해준다.
					url = url.replace(request.getContextPath(), "");
				}
				return "redirect:" + url;
			} else {
				//메인화면으로 보내기
				return "redirect:/";
			}
		} else {
			//로그인 실패
			return login(model);
		}
		
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		// session.invalidate();
		session.removeAttribute("loginData");
		return "redirect:/";
	}
}
