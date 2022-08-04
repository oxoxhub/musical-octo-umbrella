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

@WebServlet("/comment/delete")
public class CommentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CommentService service = new CommentService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");	//comments테이블 pk넘버
		
		CommentDTO commentData = service.getData(Integer.parseInt(id));
		EmpsDTO empData = (EmpsDTO)session.getAttribute("loginData");
		
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		
		if(commentData.getEmpId() == empData.getEmpId()) {
			boolean result = service.remove(commentData);
			if(result) {
				sb.append(String.format("\"%s\": \"%s\",", "code","success"));
				sb.append(String.format("\"%s\": \"%s\" ","message","삭제되었습니다."));
			} else {
				sb.append(String.format("\"%s\": \"%s\",", "code","error"));
				sb.append(String.format("\"%s\": \"%s\" ","message","삭제 작업중 문제가 발생하였습니다."));
			}
		} else {
			sb.append(String.format("\"%s\": \"%s\",", "code","error"));
		}
		
		sb.append("}");
		response.getWriter().print(sb.toString());
		response.getWriter().flush();
	}

}
