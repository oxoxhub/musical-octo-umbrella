package jsp.cotroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp/script_tag")
public class JspScriptController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String[] interest = request.getParameterValues("interest");
//		if(interest != null) {
//			for(String s: interest) {
//				System.out.println(s);
//			}
//		}
//		System.out.println(interest);
		
		String phone = request.getParameter("phone");
		String[] address = request.getParameterValues("address");
		System.out.println(phone);
		if(address != null) {
			for(String s: address) {
				System.out.println(s);
			}
		}
		
		String view = "/WEB-INF/jsp/jsp/script_tag.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}

}
