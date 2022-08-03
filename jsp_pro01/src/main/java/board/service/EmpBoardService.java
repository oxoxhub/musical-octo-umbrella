package board.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import board.model.EmpBoardDAO;
import board.model.EmpBoardDTO;
import board.model.EmpBoardStaticsDTO;
import emps.model.EmpsDTO;

public class EmpBoardService {
	
	public int add(EmpBoardDTO data) {
		EmpBoardDAO dao = new EmpBoardDAO();
		
		int seq = dao.getNextSeq();
		data.setId(seq);
		
		boolean result = dao.insertData(data);
		
		if(result) {
			dao.commit();
			dao.close();
			return data.getId();
		}
		dao.rollback();
		dao.close();
		return -1;
	}

	public EmpBoardDTO getData(int id) {
		EmpBoardDAO dao = new EmpBoardDAO();
				
		EmpBoardDTO data = dao.selectData(id);
		dao.close();
		
		return data;
	}

	public void incViewCnt(HttpSession session, EmpBoardDTO data) {
		EmpBoardDAO dao = new EmpBoardDAO();
		
		EmpBoardStaticsDTO staticsData = new EmpBoardStaticsDTO();
		staticsData.setbId(data.getId());
		staticsData.setEmpId(((EmpsDTO)session.getAttribute("loginData")).getEmpId());
		
		staticsData = dao.selectStatics(staticsData);
		//사용자 아이디 + 글번호로 조회수 통계가 담긴 테이블 검색
		
		boolean result = false;
		if(staticsData == null) {
			//조회한 기록이 없다면
			
			result = dao.updateViewCnt(data);
			//특정 글번호 조회수 +1 추가한다
			
			staticsData = new EmpBoardStaticsDTO();
			staticsData.setbId(data.getId());
			staticsData.setEmpId(((EmpsDTO)session.getAttribute("loginData")).getEmpId());
			dao.insertStatics(staticsData);
			//조회한 기록도 추가한다.
			
		} else {
			//조회한 기록이 있다면 7일이 지났는지 확인한다
			long timeDiff = new Date().getTime() - staticsData.getLatestViewDate().getTime();
			if(timeDiff / (1000 * 60 * 60 * 24) >= 7) {
				result = dao.updateViewCnt(data);	// 7일이 지났다면 조회수 +1이 가능하므로 추가해준다.
				dao.updateStatics(staticsData);		// 조회한 날짜도 새로 업데이트해준다.
			}
		}
		
		if(result) {
			data.setViewCnt(data.getViewCnt() + 1);
			//반환하지 않는 이유는 객체 주소가 고유하기 때문이다.
			dao.commit();
			dao.close();
		}
		dao.rollback();
		dao.close();
	}

	public void incLike(HttpSession session, EmpBoardDTO data) {
		EmpsDTO empData = (EmpsDTO)session.getAttribute("loginData");
		EmpBoardDAO dao = new EmpBoardDAO();
		
		EmpBoardStaticsDTO staticsData = new EmpBoardStaticsDTO();
		staticsData.setbId(data.getId());			// 게시글 번호
		staticsData.setEmpId(empData.getEmpId());	// 로그인한 사용자의 아이디
		
		staticsData = dao.selectStatics(staticsData);
		//조회수, 추천 여부를 체크하는 EMP_BOARDS_STATICS 테이블을 조회
		
		//이전에 추천을 했는지 안 했는지 확인
		if(staticsData.isLiked()) {
			// 이전에 추천을 한 기록이 있으면 -> 추천 취소로 전환
			staticsData.setLiked(false);
			data.setLike(data.getLike() - 1);
		} else {
			// 이전에 추천을 한 기록이 없으면 -> 추천으로 전환
			staticsData.setLiked(true);
			data.setLike(data.getLike() + 1);
		}
		dao.updateStaticsLike(staticsData);	// 로그인 사용자가 추천했는지 아닌지를 업데이트
		boolean result = dao.updateLike(data);	// 게시글의 총 추천수를 업데이트
		
		if(result) {
			dao.commit();
		} else {
			dao.rollback();
		}
		dao.close();
	}

	public List<EmpBoardDTO> getAll() {
		EmpBoardDAO dao = new EmpBoardDAO();
		List<EmpBoardDTO> datas = dao.selectAll();
		dao.close();
		return datas;
	}

	public boolean remove(EmpBoardDTO data) {
		EmpBoardDAO dao = new EmpBoardDAO();
		
		EmpBoardStaticsDTO staticsData = new EmpBoardStaticsDTO();
		staticsData.setbId(data.getId());
		
		dao.deleteStaticsData(staticsData);
		boolean result = dao.deleteData(data);
		
		if(result) {
			dao.commit();
		} else {
			dao.rollback();
		}
		dao.close();
		return result;
	}
}
