package emps.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emps.model.EmpsAllDTO;
import emps.service.EMPS_SERVICE_STATUS;
import emps.service.EmpsService;

@WebServlet("/emps/add")
public class EmpsAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpsService service = new EmpsService();
	private String view = "/WEB-INF/jsp/emps/add.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher(view).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empId = request.getParameter("empId");
		String empName = request.getParameter("empName");
		String email = request.getParameter("email");
		String jobId = request.getParameter("jobId");
		String deptId = request.getParameter("deptId");
		String phone = request.getParameter("phone");
		String salary = request.getParameter("salary");
		String commission = request.getParameter("commission");
		String mngId = request.getParameter("mngId");
		
		EmpsAllDTO empsData = new EmpsAllDTO();
		
		empsData.setEmpId(empId);
		empsData.setEmpName(empName);
		empsData.setEmail(email);
		empsData.setPhone(phone);
		empsData.setHireDate(new Date(new java.util.Date().getTime()));
		empsData.setJobId(jobId);
		empsData.setSalary(salary);
		empsData.setCommission(commission);
		empsData.setMngId(mngId);
		empsData.setDeptId(deptId);
		
		EMPS_SERVICE_STATUS status = service.addEmps(empsData);
		
		if(status == EMPS_SERVICE_STATUS.SUCCESS) {
			System.out.println("emps 추가 성공");
			response.sendRedirect(request.getContextPath() + "/emps?search=" + empsData.getEmpId());
			return;
		}
		
		System.out.println("emps 추가 실패");
		request.setAttribute("data", empsData);
		request.getRequestDispatcher(view).forward(request, response);
	}

}
