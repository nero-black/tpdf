<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->

<c:if test="${member_grade != 2}">
<% response.sendRedirect("invalid.do"); %>
</c:if> <!-- 부정 접속 방지 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin_index.css">

<body>
<main>
<div id="adminpage">
	<br><br>
	<button id="admin_point" onclick="location.href = '${pageContext.request.contextPath}/admin_point.do';">포인트 지급</button>
	<br>
	<button id="admin_report" onclick="location.href = '${pageContext.request.contextPath}/admin_report.do'; ">신고게시글</button>
	<br>
	<!-- <button id="admin_filter" onclick="location.href = '${pageContext.request.contextPath}/admin_filter.do'; ">필터 관리</button>
	<br>  -->
	<button id="admin_ban" onclick="location.href = '${pageContext.request.contextPath}/admin_ban.do'; ">강제 탈퇴</button>
	<br>
	<button id="return" onclick="history.back()">돌아가기</button>
</div>
<hr class="clear_line">
</main>
</body>
</html>
<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->