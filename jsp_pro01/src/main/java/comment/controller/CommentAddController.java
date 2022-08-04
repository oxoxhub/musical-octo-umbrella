package comment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comment.model.CommentDTO;
import comment.service.CommentService;
import emps.model.EmpsDTO;

@WebServlet("/comment/add")
public class CommentAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CommentService service = new CommentService();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String bid = request.getParameter("bid");	// 게시글 번호
		String content = request.getParameter("content"); // 댓글 내용
		
		EmpsDTO empData = (EmpsDTO)session.getAttribute("loginData");
		//댓글 작성자 아이디를 가져오기 위해서

		CommentDTO commentData = new CommentDTO();
		commentData.setbId(Integer.parseInt(bid));
		commentData.setContent(content);
		commentData.setEmpId(empData.getEmpId());
		
		boolean result = service.add(commentData);
		
		if(result) {
			response.sendRedirect(request.getContextPath() + "/board/detail?id=" + commentData.getbId());
		} else {
			response.sendRedirect(request.getContextPath() + "/board/detail?id=" + commentData.getbId());
		}
	}

}
