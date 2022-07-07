<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, locs.model.LocsDTO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>지역 조회 결과</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/default.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/form.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/navigation.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/paging.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/required.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/table.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/required.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/module/navigation.jsp" %>
	<h1>지역 조회 결과</h1>
	<div>
		<button type="button" onclick="location.href='./locs/add'">추가</button>
	</div>
	<div>
		<form action="./locs" method="get">
			<div>
				<input type="text" name="search">
				<button type="submit">조회</button>
			</div>
		</form>
	</div>
	<table>
		<tr>
			<th>Location Id</th>
			<th>street address</th>
			<th>postalCode</th>
			<th>city</th>
			<th>state province</th>
			<th>country Id</th>
		</tr>
		<c:if test="${not empty datas}">
			<c:forEach items="${datas}" var="data">
				<tr>
					<td>${data.locId}</td>
					<td>${data.stAddr}</td>
					<td>${data.postal}</td>
					<td>${data.city}</td>
					<td>${data.state}</td>
					<td>${data.ctyId}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>