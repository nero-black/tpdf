<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.tpdf.shoot.vo.MemberVo" %>  
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- JSTL라이브러리 -->

<% String member_id = request.getParameter("member_id"); %>

<% int result = (Integer)session.getAttribute("result"); %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/id_check.css">

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/id_check.js"></script>

<html>
<body>
	<c:choose>
		<c:when test="${result == 0}">
			<div class="window">
			<h4><b><%= member_id %></b>은(는) 사용할 수 있는 아이디입니다.</h4>
			<br>
			<button onclick="id_check_s()">사용하기</button>
			</div>
		</c:when>
		<c:otherwise>
			<div class="window">
			<h4><b><%= member_id %></b>은(는) 사용할 수 없는 아이디입니다.<br> 다른 아이디를 입력해주세요.</h4>
			<br>
			<button onclick="id_check_f()">다시 입력하기</button>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>