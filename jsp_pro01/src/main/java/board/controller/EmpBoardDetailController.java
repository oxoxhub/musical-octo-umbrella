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
import comment.model.CommentDTO;
import comment.service.CommentService;
import common.util.Paging;
import emps.model.EmpsDTO;
import emps.service.EmpsService;

@WebServlet("/board/detail")
public class EmpBoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private EmpBoardService service = new EmpBoardService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/jsp/board/detail.jsp";
		String id = request.getParameter("id");		// 게시글 번호
		
		EmpsService empsService = new EmpsService();
		
		EmpBoardDTO data = service.getData(Integer.parseInt(id));
		// 게시물 번호로 게시글 데이터 가져오기
		
		if(data != null) {
			HttpSession session = request.getSession();
			service.incViewCnt(session, data);
			//incViewCnt 메서드에서 data에 조회수가 +1 되면 반영되어 request를 통해 view로 넘어간다.
			//게시글 데이터를 담은 객체주소는 변하지 않았으므로
			
			EmpsDTO empData = empsService.getId("" + data.getEmpId());
			//게시글 작성자의 아이디가 아닌 게시글 작성자의 이름이 필요하므로 작성자의 정보 가져오기
			
			CommentService commentService = new CommentService();
			List commentDatas = commentService.getDatas(data.getId());
			//게시글 번호로 게시글에 달린 댓글 정보들 가져오기
			
			String page = request.getParameter("page");
			page = page == null ? "1" : page;
			
			Paging commentPage = new Paging(commentDatas, Integer.parseInt(page), 5);
			
			request.setAttribute("data", data);	// 게시글 데이터
			request.setAttribute("empData", empData);	// 작성자 데이터
			request.setAttribute("commentPage", commentPage);	// 댓글 데이터와 페이징
			
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		} else {
			// 데이터가 조회되지 않은 경우
			// 별도의 에러 페이지로 전환
		}
	}

}
