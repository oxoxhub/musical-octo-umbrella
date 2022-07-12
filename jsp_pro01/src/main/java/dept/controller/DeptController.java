package dept.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dept.model.DeptDTO;
import dept.service.DeptService;

@WebServlet("/depts")
public class DeptController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DeptService service = new DeptService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("depts조회테스트");
		String search = request.getParameter("search");
		//mvc.jsp에서 부서 조회 버튼을 누른순간 name="search"의 value는 null이 된다.
		String page = request.getParameter("page");
		String sort = "deptId";
		int count = 5;
		
		
		HttpSession session = request.getSession();
		if(session.getAttribute("pgc") != null) {
			System.out.println("1.session pgc : " + session.getAttribute("pgc"));
			count = Integer.parseInt(session.getAttribute("pgc").toString());
			System.out.println("1.count : " + count);
		}
		
		if(session.getAttribute("sort") != null) {
			sort = (String)session.getAttribute("sort");
		}
		
		if(request.getParameter("pgc") != null) {
			System.out.println("2.request pgc : " + request.getParameter("pgc"));
			count = Integer.parseInt(request.getParameter("pgc"));
		}
		
		if(request.getParameter("sort") != null) {
			sort = request.getParameter("sort");
		}
		
		session.setAttribute("pgc", count);
		session.setAttribute("sort", sort);
		
		System.out.println("3.session pgc : " + session.getAttribute("pgc"));
		System.out.println("3.request pgc : " + request.getParameter("pgc"));
		

		//session.setMaxInactiveInterval(30);
		//session.removeAttribute("pgc"); //속성을 지우는 것
		//session.invalidate(); //세션 만료
		//session = request.getSession(true);
		//System.out.println("만료 후 : " + session.getId());
		
		/*
		System.out.println("1.pgc : " + request.getParameter("pgc"));
		Cookie cookies[] = request.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().equals("pgc")) {
				count = Integer.parseInt(c.getValue());
				System.out.println("2.count : " + count);
				System.out.println("c.getValue : " + c.getValue());
			}
		}
		
		System.out.println("3.count : " + count);
		Cookie cookie = null;
		if(request.getParameter("pgc") != null) {
			count = Integer.parseInt(request.getParameter("pgc"));
			System.out.println("4.count : " + count);
			cookie = new Cookie("pgc", request.getParameter("pgc"));
			System.out.println("5. : " + cookie);
		} else {
			cookie = new Cookie("pgc", String.valueOf(count));
				if(cookie.getName().equals("pgc")) {
					System.out.println("cookie.getValue : " + cookie.getValue());
				}
			System.out.println("6.pgc : " + request.getParameter("pgc"));
			System.out.println("7.count : " + count);
		}
		//cookie.setMaxAge(30);
		//cookie.setPath("/depts");
		response.addCookie(cookie);
		*/
		
		//request.setAttribute("pgc", count);
		request.setAttribute("menuLocation", "depts"); //네비게이션
		List<DeptDTO> datas = null;
		if(search == null) {	// 검색한 값이 있는지 없는지
			int pageNum = 1;	// 현재 페이지(첫화면에서는 1페이지)
			if(page != null) {
				if(!page.isEmpty() && page.matches("\\d+")) {
					pageNum = Integer.parseInt(page);
				}
			}
			datas = service.getPage(pageNum, count, sort);	// 설정한 갯수에 따른 데이터 갯수만 가져오기
			request.setAttribute("page", pageNum);	// 현재 페이지
			request.setAttribute("pageList", service.getPageNumberList(count));	//표시될 페이지의 숫자 갯수
		} else {
			DeptDTO data = service.getDeptId(search);
			if(data != null) {
				datas = new ArrayList<DeptDTO>();
				datas.add(data);
			}
		}
		
		request.setAttribute("datas", datas);
		//object로 업캐스팅 되기때문에 jsp에서는 다운캐스팅을 꼭 해줘야한다.
		String view = "/WEB-INF/jsp/dept/index.jsp";
		request.getRequestDispatcher(view).forward(request, response);
		
	}

}
