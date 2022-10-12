<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin_point.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/admin_point.js"></script>

<body>
<main>
<div id="admin_point">
	<form action="${pageContext.request.contextPath}/admin_point_process.do" method="post" id="admin_point_form">
		<br><br><br>
		<h3>대상 닉네임： </h3>
		<input type="text" class="admin_point" id="member_name" name="member_name" placeholder="포인트를 지급할 대상의 닉네임" maxlength="8" required />
		<h3>지급 포인트： </h3>
		<input type="text" class="admin_point" id="member_point" name="member_point" placeholder="지급할 포인트의 양"  maxlength="5" required />
	</form>
	<h4>※ 지급 포인트를 마이너스 (-) 값으로 입력하면 회수됩니다.</h4>
	<br><br>
	<button id="submit" onclick="admin_point()">포인트 지급</button>
	<button id="return" onclick="location.href='admin_index.do'">돌아가기</button>
</div>
</main>
</body>
</html>
<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->