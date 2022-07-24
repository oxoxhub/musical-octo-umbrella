<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String menuLocation = "";
	if(request.getAttribute("menuLocation") != null) {
		menuLocation = (String)request.getAttribute("menuLocation");
	}
%>
<header>
	<nav class="top-nav center">
		<ul class="nav">
			<li class="nav-item dropdown">
				<a class="nav-link" href="#">JSP/Servlet</a>
				<ul class="nav dropdown-nav">
					<li class="nav-item">
						<a class="nav-link" href="./jsp/script_tag">JSP - Script Tag</a>
					</li>
					<li class="nav-item">
						<a class="nav-link"  href="./jsp/request">JSP - request</a>
					</li>
					<li class="nav-item">
						<a class="nav-link"  href="./jsp/response">JSP - response</a>
					</li> 
					<li class="nav-item">
						<a class="nav-link"  href="./jsp/mvc">JSP/Servlet - MVC Model</a>
					</li> 
				</ul>
			</li>
			<c:if test="${not empty sessionScope.loginData}">
				<c:forEach items="${sessionScope.permData}" var="perm">
					<c:if test="${perm.tableName eq 'employees'}">
						<c:if test="${perm.pRead}">
							<li class="nav-item <%=menuLocation.equals("emps") ? "active" : "" %>">
								<a class="nav-link" href="./emps">직원</a>
							</li>
						</c:if>
					</c:if>
					<c:if test="${perm.tableName eq 'departments'}">
						<c:if test="${perm.pRead}">
							<li class="nav-item <%=menuLocation.equals("depts") ? "active" : "" %>">
								<a class="nav-link" href="./depts">부서</a>
							</li>
						</c:if>
					</c:if>
					<c:if test="${perm.tableName eq 'locations'}">
						<c:if test="${perm.pRead}">
							<li class="nav-item <%=menuLocation.equals("locs") ? "active" : "" %>" >
								<a class="nav-link" href="./locs">지역</a>
							</li>
						</c:if>
					</c:if>
				</c:forEach>
				<li class="nav-item">
					<c:url var="myInfoUrl" value="/myinfo" />
					<a class="nav-link" href="${myInfoUrl}">내정보</a>
				</li>
				<li class="nav-item">
					<c:url var="logoutUrl" value="/logout" />
					<a class="nav-link" href="${logoutUrl}">로그아웃</a>
				</li>
			</c:if>
		</ul>
	</nav>
</header>
