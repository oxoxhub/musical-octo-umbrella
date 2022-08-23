package com.myhome.web.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PermissionDeniedDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.myhome.web.emp.model.EmpDTO;
import com.myhome.web.login.model.PermDTO;
import com.myhome.web.login.model.PermissionDAO;

@Component
@Aspect
public class PermissionAOP {

	@Autowired
	private PermissionDAO dao;
	private static final Logger logger = LoggerFactory.getLogger(PermissionAOP.class);
	
	// 모든 서비스 클래스의 메서드 중 get 으로 시작하는 메서드만 선택될 수 있게 PointCunt 으로 설정한다.
	@Pointcut(value="execution(public * com.myhome.web..*Service.get*(..))")
	private void permSelectCut() {}
	
	//모든 서비스 클래스의 메서드 중 add 로 시작하는 메서드만 선택될 수 있게 PointCunt 으로 설정한다.
	@Pointcut(value="execution(public * com.myhome.web..*Service.add*(..))")
	private void permInsertCut() {}
	
	//모든 서비스 클래스의 메서드 중 modify 로 시작하는 메서드만 선택될 수 있게 PointCunt 으로 설정한다.
	@Pointcut(value="execution(public * com.myhome.web..*Service.modify*(..))")
	private void permUpdateCut() {}
	
	//모든 서비스 클래스의 메서드 중 remove 로 시작하는 메서드만 선택될 수 있게 PointCunt 으로 설정한다.
	@Pointcut(value="execution(public * com.myhome.web..*Service.remove*(..))")
	private void permDeleteCut() {}
	
	private PermDTO getPermission(JoinPoint joinPoint) {
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpServletResponse resp = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
		HttpSession session = req.getSession();
		EmpDTO empData = (EmpDTO)session.getAttribute("loginData");
		
		System.out.println("1:" + joinPoint.getSignature().toShortString()); 	// 1:DeptService.getAll()
		String serviceName = joinPoint.getSignature().toShortString().split("\\.")[0];
		System.out.println("2:" + serviceName);		// 2:DeptService
		serviceName = serviceName.split("Service")[0].toLowerCase();
		System.out.println("3:" + serviceName);		// 3:dept
		
		PermDTO data = new PermDTO();
		data.setTableName("other");
		if(empData != null) {
			data.setEmpId(empData.getEmpId());
			data.setTableName(serviceName);
		}
		System.out.println("로그인 emp 아이디 -> " + data.getEmpId());
		System.out.println("로그인 테이블 네임 ->" + data.getTableName());
		
		boolean result = dao.selectData(data);
		
		return data;
	}
	
	@Before(value="permSelectCut()")
	public void beforePermSelect(JoinPoint joinPoint) throws Exception {
		PermDTO perm = this.getPermission(joinPoint);
		
		if(perm != null) {
			if(!perm.ispRead()) {
				//req.setAttribute("error", "추가적인 메시지");
				throw new PermissionDeniedDataAccessException("조회 권한이 없습니다.", null);
			} else {
				System.out.println("조회 권한이 있다.");
			}
		} else {
			throw new PermissionDeniedDataAccessException("권한 정보가 없습니다.", null);
		}
	}
	
	@Before(value="permInsertCut()")
	public void beforePermInsert(JoinPoint joinPoint) throws Exception {
		PermDTO perm = this.getPermission(joinPoint);
		
		if(perm != null) {
			if(!perm.ispAdd()) {
				//req.setAttribute("error", "추가적인 메시지");
				throw new PermissionDeniedDataAccessException("추가 권한이 없습니다.", null);
			} else {
				System.out.println("추가 권한이 있다.");
			}
		} else {
			throw new PermissionDeniedDataAccessException("권한 정보가 없습니다.", null);
		}
	}
	
	@Before(value="permUpdateCut()")
	public void beforePermUpdate(JoinPoint joinPoint) throws Exception {
		PermDTO perm = this.getPermission(joinPoint);
		
		if(perm != null) {
			if(!perm.ispUpdate()) {
				//req.setAttribute("error", "추가적인 메시지");
				throw new PermissionDeniedDataAccessException("수정 권한이 없습니다.", null);
			} else {
				System.out.println("수정 권한이 있다.");
			}
		} else {
			throw new PermissionDeniedDataAccessException("권한 정보가 없습니다.", null);
		}
	}
	
	@Before(value="permDeleteCut()")
	public void beforePermDelete(JoinPoint joinPoint) throws Exception {
		PermDTO perm = this.getPermission(joinPoint);
		
		if(perm != null) {
			if(!perm.ispDelete()) {
				//req.setAttribute("error", "추가적인 메시지");
				throw new PermissionDeniedDataAccessException("삭제 권한이 없습니다.", null);
			} else {
				System.out.println("삭제 권한이 있다.");
			}
		} else {
			throw new PermissionDeniedDataAccessException("권한 정보가 없습니다.", null);
		}
	}
}
