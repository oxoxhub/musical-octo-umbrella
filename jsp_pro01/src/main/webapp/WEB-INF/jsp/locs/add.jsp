<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="locs.model.LocsDTO" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>지역 추가</title>
</head>
<body>
	<h1>지역 추가 화면</h1>
	<%
		String locId = "", stAddr = "", postal = "", city = "", state = "", ctyId = "";
		if(request.getAttribute("error") != null) {
			LocsDTO data = (LocsDTO)request.getAttribute("data");
			locId = String.valueOf(data.getLocId());
			stAddr = data.getStAddr();
			postal = data.getPostal();
			city = data.getCity();
			state = data.getState();
			ctyId = data.getCtyId();
	%>
			<script type="text/javascript">
				alert("<%=request.getAttribute("errorMsg") %>");
			</script>
	<%
		}
	%>
	<form action="./add" method="post">
		<div>
			<input type="text" name="locId" value="<%=locId %>" placeholder="지역 ID">
		</div>
		<div>
			<input type="text" name="stAddr" value="<%=stAddr %>" placeholder="주소">
		</div>
		<div>
			<input type="text" name="postal" value="<%=postal %>" placeholder="국제 우편번호">
		</div>
		<div>
			<input type="text" name="city" value="<%=city %>" placeholder="도시">
		</div>
		<div>
			<input type="text" name="state" value="<%=state %>" placeholder="주">
		</div>
		<div>
			<input type="text" name="ctyId" value="<%=ctyId %>" placeholder="국가 ID">
		</div>
		<div>
			<button type="submit">저장</button>
		</div>
	</form>
</body>
</html>