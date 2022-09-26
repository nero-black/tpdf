<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/event_add.css">
<script src="${pageContext.request.contextPath}/resources/js/event_add.js"></script>
<body>
<main>
	<div id="admin_event_add">
	<h1>이벤트 추가</h1>
	<form name="event_add_form" id="event_add_form" action="${pageContext.request.contextPath}/event_add_process.do" method="post">
	<input type="text" id="team_a" name="team_a" placeholder="첫 번째 팀" required />
	vs
	<input type="text" id="team_b" name="team_b" placeholder="두 번째 팀" required />
	</form>
	<br><br>
	<button id="event_add" onclick="event_add()">이벤트 추가</button>
	<button id="return" onclick="location.href='${pageContext.request.contextPath}/event_list.do' ">돌아가기</button>
	<br><br><br>
	<h3>※주의: 이벤트의 내용은 수정 및 변경할 수 없습니다.</h3>	
	</div>

</main>
</body>
</html>

<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->