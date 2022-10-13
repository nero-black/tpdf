<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- JSTL라이브러리 -->
<%@ page import = "com.tpdf.shoot.vo.AdminVo" %>  
<%@ page import="java.util.*" %>

<c:if test="${member_grade != 2}">
<% response.sendRedirect("invalid.do"); %>
</c:if> <!-- 부정 접속 방지 -->

<% List<AdminVo> memberList = (List)request.getAttribute("memberList"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin_ban.css">

<body>
<main>

		<c:if test="${empty memberList}">
		<table id="empty_list">
			<tr><td>가입한 회원이 없습니다.</td></tr>
		</table>
		</c:if>
		
		<div id="ban">
		<c:if test="${not empty memberList}">
		<table>
	        <tr>
	        	<th>ID</th> <th>닉네임</th> <th>이메일</th> <th>포인트</th> <th>가입일</th> <th>탈퇴여부</th> <th>제제</th>
        	<% for (AdminVo adminVo : memberList ) {	%>
	        </tr>
	        	<td><%= adminVo.getMember_id() %></td> <td><%= adminVo.getMember_name() %></td>
	        	<td><%= adminVo.getMember_email() %></td>
	        	<td><%= adminVo.getMember_point() %></td>
	        	<td><%= adminVo.getReg_date_() %></td>
	        	<td><%= adminVo.getDel_yn() %></td>
	        	<td>
	        	<a href="admin_ban_process.do?member_idx=<%= adminVo.getMember_idx() %>"
						onclick="if(!confirm('정말로 해당 회원을 강제탈퇴시키시겠습니까?')) return false;">
	        	<button type="button" class="ban_process">강제탈퇴</button></a>
	        	</td>
	        </tr>
	        <% } %> 
		</table>
		</c:if>
		<br>
		<button id="return" onclick="location.href='admin_index.do'">돌아가기</button>
		<div id="page">
		<< < <b>1</b> > >>
		</div>
		<div id="search">
			<form name="search_form" action="${pageContext.request.contextPath}/admin_ban_search.do">
				<select name="search_type" id="search_type">
				<option value="id">아이디</option>
				<option value="name">닉네임</option>
				</select>
				<input type="text" id="search_value" name="search_value" placeholder="검색할 내용 입력" />
				<button id="search_submit">검색</button>
			</form>
		</div>
	</div>
</main>
<hr class="clear_line">
</body>
</html>

<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->