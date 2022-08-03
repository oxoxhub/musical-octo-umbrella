package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.EmpBoardService;
import common.util.Paging;

@WebServlet("/board")
public class EmpsBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpBoardService boardService = new EmpBoardService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/jsp/board/list.jsp";
		
		String page = request.getParameter("page");
		page = page == null ? "1" : page;
		
		List datas = boardService.getAll();
		
		Paging paging = new Paging(datas, Integer.parseInt(page), 5);
		
		request.setAttribute("datas", paging);
		
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

}
