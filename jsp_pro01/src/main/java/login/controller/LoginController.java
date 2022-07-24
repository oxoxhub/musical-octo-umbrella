package login.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dept.model.DeptDTO;
import dept.service.DeptService;
import login.service.LoginService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptService deptService = new DeptService();
	private String view = "/WEB-INF/jsp/index.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		RequestDispatcher rd = null;
		if(session.getAttribute("loginData") == null) {
			List<DeptDTO> deptDatas = deptService.getAll();
			request.setAttribute("deptDatas", deptDatas);
			rd = request.getRequestDispatcher(view);
		} else {
			rd = request.getRequestDispatcher("/WEB-INF/jsp/index2.jsp");
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//index.jsp
		String empId = request.getParameter("empId");		//직원ID
		String deptId = request.getParameter("deptId");		//부서명
		String empName = request.getParameter("empName");	//이름
		
		HttpSession session = request.getSession();
			
		LoginService loginService = new LoginService();
		boolean result = loginService.getLogin(session, empId, deptId, empName);
		//로그인 성공시 사용자의 정보와 권한을 조회하여 세션에 저장한다.
		
		if(result) {
			//로그인 성공
			System.out.println("로그인 성공");
			response.sendRedirect(request.getContextPath() + "/"); //메인
		} else {
			//로그인 실패
			System.out.println("로그인 실패");
			List<DeptDTO> deptDatas = deptService.getAll();
			request.setAttribute("deptDatas", deptDatas);	//로그인창으로 다시 부서정보를 넘겨준다
			
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
				
	}

}
