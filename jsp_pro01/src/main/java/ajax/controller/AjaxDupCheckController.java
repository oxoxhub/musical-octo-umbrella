package ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.model.DeptDTO;
import dept.service.DeptService;
import emps.model.EmpsAllDTO;
import emps.service.EmpsService;

@WebServlet("/ajax/dupCheck")
public class AjaxDupCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DeptService deptService = new DeptService();
	private EmpsService empsService = new EmpsService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String value = request.getParameter("value");
		response.setContentType("application/json; charset=utf-8");

		boolean data = false;
		String errMessage = "";
		if(name != null) {
			switch(name) {
				case "deptId":
					if(deptService.getDeptId(value) != null) {
						data = true;
						errMessage = "	\"errMessage\": \"해당 부서 ID는 이미 존재합니다.\"";
					}
					break;
				case "empId":
					if(empsService.getEmpsId(value) != null) {
						data = true;
						errMessage = "	\"errMessage\": \"해당 직원 ID는 이미 존재합니다.\"";
					}
					break;
				case "email":
					if(empsService.existEmail(value) == true) {
						data = true;
						errMessage = "	\"errMessage\": \"해당 직원 EMAIL은 이미 존재합니다.\"";
					}
					break;	
			}
			
			PrintWriter out = response.getWriter();
			if(data) {
				out.println("{");
				out.println("	\"errCode\": \"duplicate\",");
				out.println(errMessage);
				out.println("}");
				out.flush();
			} else {
				out.println("{");
				out.println("	\"errCode\": \"notDuplicate\",");
				out.println("	\"errMessage\": \"정상.\" ");
				out.println("}");
				out.flush();
			}
		}
	}

}