<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.tpdf.shoot.vo.MemberVo" %>  
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- JSTL라이브러리 -->

<% String id_check = request.getParameter("id_check"); %>

<% int result = (Integer)session.getAttribute("result"); %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/id_check.css">

<html>
<body>
	<c:choose>
		<c:when test="${result == 0}">
			<div class="window">
			<h4><%= id_check %>은(는) 사용할 수 있는 아이디입니다.</h4>
			<br>
			<button onclick="id_check_s()">닫기</button>
			</div>
		</c:when>
		<c:otherwise>
			<div class="window">
			<h4><%= id_check %>은(는) 사용할 수 없는 아이디입니다.</h4>
			<br>
			&nbsp;<button onclick="id_check_s()">닫기</button>
			</div>
		</c:otherwise>
	</c:choose>
	<input type="hidden" value="<%= id_check %>" />

</body>
</html>