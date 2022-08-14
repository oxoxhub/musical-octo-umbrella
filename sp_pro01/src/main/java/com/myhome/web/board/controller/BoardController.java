package com.myhome.web.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.myhome.web.board.model.BoardDTO;
import com.myhome.web.board.service.BoardService;
import com.myhome.web.board.vo.BoardVO;
import com.myhome.web.comment.model.CommentDTO;
import com.myhome.web.comment.service.CommentService;
import com.myhome.web.common.util.Paging;
import com.myhome.web.emp.model.EmpDTO;
import com.myhome.web.emp.service.EmpService;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService service;
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping(value="")
	public String getList(Model model, HttpSession session
			, @RequestParam(defaultValue="1", required=false) int page
			, @RequestParam(defaultValue="0", required=false) int pageCount) {
		logger.info("getList(page={}, pageCount={})", page, pageCount);
		
		List datas = service.getAll();
		
		if(session.getAttribute("pageCount") == null) {
			session.setAttribute("pageCount", 5);
		}
		
		if(pageCount > 0) {
			session.setAttribute("pageCount", pageCount);
		}
		
		pageCount = Integer.parseInt(session.getAttribute("pageCount").toString());
		
		Paging paging = new Paging(datas, page, pageCount);
		
		model.addAttribute("datas", paging.getPageData());
		model.addAttribute("pageData", paging);
		
		return "board/list";
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String getDetail(Model model
			, @RequestParam int id
			, @SessionAttribute("loginData") EmpDTO empDto
			, @RequestParam(defaultValue="1", required=false) int page) {
		logger.info("getDetail(id={}, page={})", id, page);
		
		BoardDTO data = service.getData(id);
		// 게시물 번호로 게시글 데이터 가져오기
		
		if(data != null) {
			service.incViewCnt(empDto, data); //조회수
			
			List commentDatas = commentService.getDatas(data.getId());
			//게시글 번호로 게시글에 달린 댓글 정보들 가져오기
			
			Paging commentPage = new Paging(commentDatas, page, 5);
			
			model.addAttribute("data", data);
			model.addAttribute("commentPage", commentPage);
			
			return "board/detail";
		} else {
			model.addAttribute("error", "해당 데이터가 존재하지 않습니다.");
			return "error/notExists";
		}
	}
	
	@GetMapping(value="/add")
	public String add() {
		logger.info("add()");
		return "board/add";
	}
	
	@PostMapping(value="/add")
	public String add(@SessionAttribute("loginData") EmpDTO empDto
			, @ModelAttribute BoardVO boardVo) {
		logger.info("add(boardVo={})", boardVo);
		
		BoardDTO data = new BoardDTO();
		data.setTitle(boardVo.getTitle());
		data.setContent(boardVo.getContent());
		data.setEmpId(empDto.getEmpId());
		
		int id = service.add(data);
		if(id != -1) {
			return "redirect:/board/detail?id=" + id;
		} else {
			return "board/add";
		}
	}
	
	@GetMapping(value="/modify")
	public String modify(Model model
			, @RequestParam int id
			, @SessionAttribute("loginData") EmpDTO empDto) {
		logger.info("modify(empDto={}, id={})", empDto, id);
		
		BoardDTO data = service.getData(id);
		if(data != null) {
			if(data.getEmpId() == empDto.getEmpId()) {
				model.addAttribute("data", data);
				return "board/modify";
			} else {
				model.addAttribute("error", "해당 작업을 수행할 권한이 없습니다.");
				return "error/permission";
			}
		} else {
			model.addAttribute("error", "해당 데이터가 존재하지 않습니다.");
			return "error/noExists";
		}
	}
	
	@PostMapping(value="/modify")
	public String modify(Model model
			, @ModelAttribute BoardVO boardVo
			, @SessionAttribute("loginData") EmpDTO empDto) {
		logger.info("modify(empDto={}, boardVo={})", empDto, boardVo);
		
		BoardDTO data = service.getData(boardVo.getId());
		
		if(data != null) {
			if(data.getEmpId() == empDto.getEmpId()) {
				data.setTitle(boardVo.getTitle());
				data.setContent(boardVo.getContent());
				
				boolean result = service.modify(data);
				if(result) {
					return "redirect:/board/detail?id=" + data.getId();
				} else {
					return modify(model, data.getId(), empDto);
				}
			} else {
				model.addAttribute("error", "해당 작업을 수행할 권한이 없습니다.");
				return "error/permission";
			}
		} else {
			model.addAttribute("error", "해당 데이터가 존재하지 않습니다.");
			return "error/notExists";
		}
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping(value="/delete", produces="application/json; charset=utf-8")
	@ResponseBody
	public String delete(@SessionAttribute("loginData") EmpDTO empDto
			, @RequestParam int id) {
		logger.info("delete(empDto={}, id={})", empDto, id);
		
		BoardDTO data = service.getData(id);
		
		JSONObject json = new JSONObject();
		
		if(data == null) {
			//삭제할 데이터 없음
			json.put("code", "notExists");
			json.put("message", "이미 삭제된 데이터 입니다.");
		} else {
			if(data.getEmpId() == empDto.getEmpId()) {
				//작성자, 수정자 동일인
				boolean result = service.remove(data);
				if(result) {
					//삭제 완료
					json.put("code", "success");
					json.put("message", "삭제가 완료되었습니다.");
				} else {
					//삭제 실패
					json.put("code", "fail");
					json.put("message", "삭제 작업 중 문제가 발생하였습니다.");
				}
			} else {
				//작성자, 수정자 동일인 아님 - 권한 없음
				json.put("code", "permissionError");
				json.put("message", "삭제 할 권한이 없습니다.");
			}
		}
		
		return json.toJSONString();
	}
	
	@PostMapping(value="/like", produces="application/json; charset=utf-8")
	@ResponseBody
	public String like(@SessionAttribute("loginData") EmpDTO empDto
			, @RequestParam int id) {
		logger.info("like(empDto={}, id={})", empDto, id);
		
		BoardDTO data = service.getData(id);
		
		JSONObject json = new JSONObject();
		
		if(data == null) {
			json.put("code", "noData");
			json.put("message", "해당 데이터가 존재하지 않습니다.");
		} else {
			service.incLike(empDto, data);
			json.put("code", "success");
			json.put("like", data.getLike());
		}
		
		return json.toJSONString();
	}
	
	@PostMapping(value="/comment/add")
	public String commentAdd(@SessionAttribute("loginData") EmpDTO empDto
			, @RequestParam int bid
			, @RequestParam String content) {
		logger.info("commentAdd(empDto={}, bid={}, content={})", empDto, bid, content);
		
		CommentDTO data = new CommentDTO();
		data.setbId(bid);
		data.setContent(content);
		data.setEmpId(empDto.getEmpId());
		
		boolean result = commentService.add(data);
		
		if(result) {
			return "redirect:/board/detail?id=" + data.getbId();
		} else {
			return "redirect:/board/detail?id=" + data.getbId();
		}
	}
	
	@PostMapping(value="/comment/delete", produces="application/json; charset=utf-8")
	@ResponseBody
	public String commentDelete(HttpSession session
			, @RequestParam int id) {
		logger.info("commentDelete(id={})",id);
		
		CommentDTO data = commentService.getData(id);	// 댓글 데이터
		EmpDTO empData = (EmpDTO)session.getAttribute("loginData");
		
		JSONObject json = new JSONObject();
		
		if(data.getEmpId() == empData.getEmpId()) {
			boolean result = commentService.remove(data);
			if(result) {
				json.put("code", "success");
			} else {
				json.put("code", "error");
			}
		} else {
			json.put("code", "error");
		}
		
		return json.toJSONString();
	}
	
	@PostMapping(value="/comment/modify", produces="application/json; charset=utf-8")
	@ResponseBody
	public String commentModify(@RequestParam int id
			, @RequestParam String content
			, @SessionAttribute("loginData") EmpDTO empDto) {
		logger.info("commentModify(id={}, content={})", id, content);
		//cid == comment.id 코멘트 고유번호
		
		JSONObject json = new JSONObject();
		
		CommentDTO data = commentService.getData(id); // 댓글 데이터
		
		if(data.getEmpId() == empDto.getEmpId()) {
			//댓글 작성자 아이디와 로그인 사용자 아이디가 같을 때 수정가능
			data.setContent(content);
			boolean result = commentService.modify(data);
			if(result) {
				json.put("code", "success");
				json.put("value", data.getContent());
			}
		}
		
		return json.toJSONString();
	}

}

