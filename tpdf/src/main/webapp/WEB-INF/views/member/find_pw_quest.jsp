<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.tpdf.shoot.vo.MemberVo" %>  
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- JSTL라이브러리 -->

<% int result = (Integer)session.getAttribute("result"); %>
<% String member_pw = (String)session.getAttribute("member_pw"); %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/find_pw_quest.css">

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/find_pw_quest.js"></script>

<html>
<body>
	<c:choose>
		<c:when test="${result == 1}">
			<div class="window">
			<h4>비밀번호는 <b>${member_pw}</b>입니다.</h4>
			<% session.removeAttribute("member_pw"); member_pw = null; %> <!-- 세션 삭제, 변수 초기화 -->
			<br>
			<button type="button" onclick="close_window()">확인</button>
			</div>
		</c:when>
		<c:otherwise>
			<div class="window">
			<h4>정답이 아닙니다. <br>다시 입력해주세요.</h4>
			<br>
			<button onclick="history.back()">재입력</button>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>