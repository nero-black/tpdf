<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.tpdf.shoot.vo.MemberVo" %>  
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- JSTL라이브러리 -->

<% String member_id = (String)session.getAttribute("member_id"); %>
<% int result = (Integer)session.getAttribute("result"); %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/id_check.css">

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/find_id.js"></script>

<html>
<body>
	<c:choose>
		<c:when test="${result == 1}">
			<div class="window">
			<h4>회원님의 아이디는 <b><%= member_id %></b>입니다.</h4>
			<br>
			<button onclick="close_window()">확인</button>
			</div>
		</c:when>
		<c:otherwise>
			<div class="window">
			<h4>입력하신 정보와 일치하는 아이디가 없습니다. <br>다시 입력해주세요.</h4>
			<br>
			<button onclick="close_window()">확인</button>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>