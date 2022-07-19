package emps.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dept.model.DeptDAO;
import dept.model.DeptDTO;
import dept.service.DEPT_SERVICE_STATUS;
import emps.model.EmpsAllDTO;
import emps.model.EmpsDAO;
import emps.model.EmpsDTO;
import emps.model.EmpsDetailDTO;

public class EmpsService {

	public List<EmpsDTO> getAll() {
		EmpsDAO dao = new EmpsDAO();
		List<EmpsDTO> datas = dao.selectAll();
		dao.close();
		
		return datas;
	}
	
	public List<EmpsAllDTO> getEmps() {
		EmpsDAO dao = new EmpsDAO();
		List<EmpsAllDTO> datas = dao.selectEmps();
		dao.close();
		
		return datas;
	}

	public List<EmpsDTO> getPage(int pageNumber, int count, String sort) {
		int start = (pageNumber - 1) * count + 1;
		int end = start + count - 1;
		
		EmpsDAO dao = new EmpsDAO();
		List<EmpsDTO> datas = dao.selectPage(start, end, sort);
		dao.close();
		
		return datas;
	}

	public List<Integer> getPageNumberList(int count) {
		EmpsDAO dao = new EmpsDAO();
		int rowCount = dao.rowCount();
		dao.close();
		
		List<Integer> pageList = new ArrayList<Integer>();
		int pageNum = (rowCount - 1) / count;
		for (int n = 0; n <= pageNum; n++) {
			pageList.add(n + 1);
		}
		return pageList;
	}
	
	public List<Integer> getPageNumberList() {
		return getPageNumberList(10);
	}

	public EmpsDetailDTO getEmpDetail(int empId) {
		EmpsDAO dao = new EmpsDAO();
		EmpsDetailDTO data = dao.selectEmpDetail(empId);
		dao.close();
		return data;
	}

	public boolean setEmp(EmpsDTO empsData, EmpsDetailDTO empsDetailData) {
		//수정
		EmpsDAO dao = new EmpsDAO();
		
		boolean res1 = dao.updateEmp(empsData);
		boolean res2 = dao.updateEmpDetail(empsDetailData);
		
		if(res1 && res2) {
			dao.commit();
			dao.close();
			return true;
		} else {
			dao.rollback();
			dao.close();
			return false;
		}
		
	}

	public EMPS_SERVICE_STATUS addEmps(EmpsAllDTO empsData) {
		// 추가
		EmpsDAO dao = new EmpsDAO();
		EMPS_SERVICE_STATUS status = EMPS_SERVICE_STATUS.SUCCESS;
		
		String fullName[] = empsData.getEmpName().split(" ", 2);
		if(fullName.length == 2) {
			empsData.setFirstName(fullName[0]);
			empsData.setLastName(fullName[1]);
		}
		
		//empId 중복체크
		if(getEmpsId(empsData.getEmpId()) != null) {
			status = EMPS_SERVICE_STATUS.EMPS_ID_DUPLICATED;
		}
		
		//email 중복체크
		if(existEmail(empsData.getEmail())) {
			status = EMPS_SERVICE_STATUS.EMAIL_DUPLICATED;
		}
		
		//jobId 존재유무
		if(!existJobId(empsData.getJobId())) {
			status = EMPS_SERVICE_STATUS.JOB_ID_NOT_EXISTS;
		}
		
		//mngId 존재유무
		if(getEmpsId(empsData.getMngId()) == null) {
			status = EMPS_SERVICE_STATUS.MNG_ID_NOT_EXISTS;
		}
		
		//deptId 존재유무
		if(!existDeptId(empsData.getDeptId())) {
			status = EMPS_SERVICE_STATUS.DEPT_ID_NOT_EXISTS;
		}
		
		switch (status) {
		case SUCCESS:
			if (dao.insertEmps(empsData)) {
				dao.commit();
			} else {
				status = EMPS_SERVICE_STATUS.FAILED;
				dao.rollback();
			}
		default:
			dao.close();
		}

		return status;

	}
	
	public EMPS_SERVICE_STATUS modifyEmps(EmpsAllDTO empsData) {
		// 추가
		EmpsDAO dao = new EmpsDAO();
		EMPS_SERVICE_STATUS status = EMPS_SERVICE_STATUS.SUCCESS;
		
		String fullName[] = empsData.getEmpName().split(" ", 2);
		if(fullName.length == 2) {
			empsData.setFirstName(fullName[0]);
			empsData.setLastName(fullName[1]);
		}
		
		//email 중복체크
		if(existEmail(empsData.getEmail())) {
			status = EMPS_SERVICE_STATUS.EMAIL_DUPLICATED;
		}
		
		//jobId 존재유무
		if(!existJobId(empsData.getJobId())) {
			status = EMPS_SERVICE_STATUS.JOB_ID_NOT_EXISTS;
		}
		
		//mngId 존재유무
		if(getEmpsId(empsData.getMngId()) == null) {
			status = EMPS_SERVICE_STATUS.MNG_ID_NOT_EXISTS;
		}
		
		//deptId 존재유무
		if(!existDeptId(empsData.getDeptId())) {
			status = EMPS_SERVICE_STATUS.DEPT_ID_NOT_EXISTS;
		}
		
		switch (status) {
		case SUCCESS:
			if (dao.updateEmps(empsData)) {
				dao.commit();
			} else {
				status = EMPS_SERVICE_STATUS.FAILED;
				dao.rollback();
			}
		default:
			dao.close();
		}

		return status;

	}
	
	public boolean existDeptId(int deptId) {
		// deptId 유무
		EmpsDAO dao = new EmpsDAO();
		boolean result = dao.existDeptId(deptId);
		return result;
	}

	public boolean existJobId(String jobId) {
		// jobId 유무
		EmpsDAO dao = new EmpsDAO();
		boolean result = dao.existJobId(jobId);
		return result;
	}

	public boolean existEmail(String email) {
		// 이메일 유무
		EmpsDAO dao = new EmpsDAO();
		boolean result = dao.existEmail(email);
		dao.close();
		return result;
	}

	public EmpsAllDTO getEmpsId(String id) {
		boolean isNumber = id.matches("\\d+");
		if (isNumber) {
			int empsId = Integer.parseInt(id);
			EmpsDAO dao = new EmpsDAO();
			EmpsAllDTO data = _getEmpsId(empsId);
			dao.close();
			return data;
		}
		return null;
	}
	
	public EmpsAllDTO getEmpsId(int id) {
		EmpsDAO dao = new EmpsDAO();
		EmpsAllDTO data = _getEmpsId(id);
		dao.close();
		return data;
	}
	
	private EmpsAllDTO _getEmpsId(int id) {
		EmpsDAO dao = new EmpsDAO();
		EmpsAllDTO data = dao.searchEmpsId(id);
		return data;
	}

}

