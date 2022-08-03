package board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.EmpBoardDTO;
import board.service.EmpBoardService;
import emps.model.EmpsDTO;
import emps.service.EmpsService;

@WebServlet("/board/detail")
public class EmpBoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private EmpBoardService service = new EmpBoardService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/jsp/board/detail.jsp";
		String id = request.getParameter("id");		// 글번호
		
		EmpsService empsService = new EmpsService();
		
		EmpBoardDTO data = service.getData(Integer.parseInt(id));
		// 게시물 정보 조회
		if(data != null) {
			HttpSession session = request.getSession();
			service.incViewCnt(session, data);
			//incViewCnt 메서드에서 data에 조회수가 +1 되면 반영되어 request를 통해 view로 넘어간다.
			EmpsDTO empData = empsService.getId("" + data.getEmpId());
			//작성자의 아이디가 아닌 이름이 필요하므로
			
			request.setAttribute("data", data);
			request.setAttribute("empData", empData);
			
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		} else {
			// 데이터가 조회되지 않은 경우
			// 별도의 에러 페이지로 전환
		}
	}

}
