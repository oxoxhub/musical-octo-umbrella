package com.myhome.web.board.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myhome.web.board.model.BoardDAO;
import com.myhome.web.board.model.BoardDTO;
import com.myhome.web.board.model.BoardStaticsDTO;
import com.myhome.web.emp.model.EmpDTO;

@Service
public class BoardService {

	
	@Autowired
	private BoardDAO dao;
	
	public List<BoardDTO> getAll() {
		List<BoardDTO> datas = dao.selectAll();
		return datas;
	}
	
	public BoardDTO getData(int id) {
		BoardDTO data = dao.selectData(id);
		return data;
	}
	
	public int add(BoardDTO data) {
		int seq = dao.getNextSeq();
		data.setId(seq);
		
		boolean result = dao.insertData(data);
		
		if(result) {
			return data.getId();
		}
		return -1;
	}

	public boolean modify(BoardDTO data) {
		boolean result = dao.updateData(data);
		return result;
	}

	public boolean remove(BoardDTO data) {
		BoardStaticsDTO staticsData = new BoardStaticsDTO();
		staticsData.setbId(data.getId());
		
		dao.deleteStaticsData(staticsData);
		boolean result = dao.deleteData(data);
		
		return result;
	}

	@Transactional
	public void incViewCnt(EmpDTO empDto, BoardDTO data) {
		BoardStaticsDTO staticsData = new BoardStaticsDTO();
		staticsData.setbId(data.getId());	// 게시글 번호
		staticsData.setEmpId(empDto.getEmpId());	// 로그인한 사람의 아이디
		
		staticsData = dao.selectStatics(staticsData);
		//사용자 아이디 + 글번호로 EMP_BOARDS_STATICS 테이블에 정보가 있는지 조회
		
		boolean result = false;
		if(staticsData == null) {
			//게시글을 조회한 기록이 없다면
			
			result = dao.updateViewCnt(data);
			//EMP_BOARDS 테이블에 게시글의 조회수 +1 추가한다
			if(!result) {
				throw new RuntimeException("조회수 통계 업데이트 처리에 문제가 발생 하였습니다.");
			}
			
			staticsData = new BoardStaticsDTO();
			staticsData.setbId(data.getId());
			staticsData.setEmpId(empDto.getEmpId());
			result = dao.insertStatics(staticsData);
			//EMP_BOARDS_STATICS 테이블에 조회한 기록도 추가한다.
			if(!result) {
				throw new RuntimeException("조회수 통계 추가 처리에 문제가 발생 하였습니다.");
			}
			
		} else {
			//조회한 기록이 있다면 7일이 지났는지 확인한다
			long timeDiff = new Date().getTime() - staticsData.getLatestViewDate().getTime();
			if(timeDiff / (1000 * 60 * 60 * 24) >= 7) {
				result = dao.updateViewCnt(data);	// 7일이 지났다면 조회수 +1이 가능하므로 추가해준다.
				if(!result) {
					throw new RuntimeException("조회수 업데이트 처리에 문제가 발생 하였습니다.");
				}
				dao.updateStatics(staticsData);		// 조회한 날짜도 새로 업데이트해준다.
				if(!result) {
					throw new RuntimeException("조회수 통계 업데이트 처리에 문제가 발생 하였습니다.");
				}
			}
		}
		
		if(result) {
			data.setViewCnt(data.getViewCnt() + 1);
			//반환하지 않는 이유는 객체 주소가 고유하기 때문이다.
		}
	}

	public void incLike(EmpDTO empDto, BoardDTO data) {
		BoardStaticsDTO staticsData = new BoardStaticsDTO();
		staticsData.setbId(data.getId());			// 게시글 번호
		staticsData.setEmpId(empDto.getEmpId());	// 로그인한 사용자의 아이디
		
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
		dao.updateStaticsLike(staticsData);		// 로그인 사용자가 추천했는지 아닌지를 업데이트
		boolean result = dao.updateLike(data);	// 게시글의 총 추천수를 업데이트
	}

}
