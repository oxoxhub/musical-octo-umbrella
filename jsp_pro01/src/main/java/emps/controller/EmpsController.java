package emps.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import emps.model.EmpsAllDTO;
import emps.model.EmpsDTO;
import emps.service.EmpsService;

@WebServlet("/emps")
public class EmpsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String view = "/WEB-INF/jsp/emps/index.jsp";
	private EmpsService service = new EmpsService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		String page = request.getParameter("page");
		String sort = "empsId";
		int count = 5; //한페이지에 보여질 게시물 갯수
		
		if(page == null) {
			page = "1";
		}
		
		HttpSession session = request.getSession();
		if(session.getAttribute("pgc") != null) {
			count = Integer.parseInt(session.getAttribute("pgc").toString());
		}
		
		if(session.getAttribute("sort") != null) {
			sort = (String)session.getAttribute("sort");
		}
		
		if(request.getParameter("pgc") != null) {
			count = Integer.parseInt(request.getParameter("pgc"));
		}
		
		if(request.getParameter("sort") != null) {
			sort = request.getParameter("sort");
		}
		
		request.setAttribute("menuLocation", "emps");
		session.setAttribute("pgc", count);
		//request.setAttribute("pgc", count);
		session.setAttribute("sort", sort);
		
		if(search == null) {
			//검색한 값이 없는 첫 화면
			int pageNum = 1;	// 사용자가 요청한 페이지가 없을 때 초기화 값
			if(page != null) {
				//page == 사용자가 요청한 페이지. 가 있을 때
				if(!page.isEmpty() && page.matches("\\d+")) {
					pageNum = Integer.parseInt(page); //요청한 페이지를 현재 페이지로
				}
			}
			List<EmpsDTO> datas = service.getPage(pageNum, count, sort); // between 가져올 데이터
			List<Integer> pageList = service.getPageNumberList(count); //하단 페이지넘버 갯수 구하기
			request.setAttribute("datas", datas);
			request.setAttribute("page", pageNum);
			request.setAttribute("pageList", pageList);
		} else {
			//검색한 값이 있는 상세페이지
			EmpsAllDTO data = service.getEmpsId(search);
			if(data != null) {
				List<EmpsAllDTO> allDatas = new ArrayList<EmpsAllDTO>();
				allDatas.add(data);
				request.setAttribute("datas", allDatas);
			}
		}
		
		//List<EmpsDTO> datas = service.getAll();

		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

}
