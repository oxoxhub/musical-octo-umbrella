package locs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import locs.model.LocsDTO;
import locs.service.LOCS_SERVICE_STATUS;
import locs.service.LocsService;

@WebServlet("/locs/add")
public class LocsAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LocsService service = new LocsService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/jsp/locs/add.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String locId = request.getParameter("locId");
		String stAddr = request.getParameter("stAddr");
		String postal = request.getParameter("postal");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String ctyId = request.getParameter("ctyId");
		
		LocsDTO data = new LocsDTO();
		data.setLocId(Integer.parseInt(locId));
		data.setStAddr(stAddr);
		data.setPostal(postal);
		data.setCity(city);
		data.setState(state);
		data.setCtyId(ctyId);

		LOCS_SERVICE_STATUS status = service.addLocs(data);
		
		String view = "/WEB-INF/jsp/locs/add.jsp";
		switch(status) {
			case SUCCESS:
				response.sendRedirect("/jsp01/locs?search=" + data.getLocId());
				return;
			case LOC_ID_DUPLICATED:
				request.setAttribute("errorMsg", "지역 ID 중복 오류가 발생하였습니다.");
				break;
			case CTY_ID_NOT_EXISTS:
				request.setAttribute("errorMsg", "국가 ID가 존재하지 않습니다.");
				break;
			case FAILED:
				request.setAttribute("errorMsg", "알 수 없는 오류가 발생하였습니다.");
				break;
		}
		
		request.setAttribute("data", data);
		request.setAttribute("error", true);
		request.getRequestDispatcher(view).forward(request, response);
	}

}
