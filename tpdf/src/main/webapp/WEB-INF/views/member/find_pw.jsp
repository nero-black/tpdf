<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.tpdf.shoot.vo.MemberVo" %>  
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- JSTL라이브러리 -->

<% String member_id = (String)session.getAttribute("member_id"); %>
<% int result = (Integer)session.getAttribute("result"); %>
<% String quest = (String)session.getAttribute("quest"); %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/find_pw.css">

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/find_pw.js"></script>

<html>
<body>
	<c:choose>
		<c:when test="${result == 1}">
			<div class="window">
			<h4><%= quest %></h4>
			<br>
			<c:if test="${quest != '설정된 질문이 없습니다. 사이트 관리자에게 문의해주세요.'}">
			<form action="${pageContext.request.contextPath}/find_pw_quest.do" method="get" id="quest_form" name="quest_form">
			<input type="hidden" id="member_id" name="member_id" value="<%= member_id %>" required />
			<input type="text" id="member_answer" name="member_answer" placeholder="정답입력"  maxlength="10" required />
			<button type="button" onclick="quest_answer()">확인</button>
			</form>
			</c:if>
			<c:if test="${quest == '설정된 질문이 없습니다. 사이트 관리자에게 문의해주세요.'}">
			<button onclick="close_window()">확인</button>
			</c:if>
			<br>
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