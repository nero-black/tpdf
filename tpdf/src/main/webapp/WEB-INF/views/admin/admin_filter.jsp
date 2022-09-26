<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin_filter.css">

<body>

<div id="admin_filter">
		<br><br><br>
		<h3>필터 단어　： </h3>
		<br>
		<textarea readonly>욕설, 정치인, 특정 성향 단어..</textarea>
		<form action="${pageContext.request.contextPath}/admin_filter_process.do" method="post" id="admin_filter_form">
		<h3>추가할 단어： </h3>
		<input type="text" id="admin_filter_word" name="admin_filter_word" placeholder="필터에 추가할 단어 입력" required />
 	</form>
	<button id="admin_filter_process" onclick="document.getElementById('admin_filter_form').submit();">필터 추가</button>
	<button id="admin_filter_reset" onclick="location.href = '${pageContext.request.contextPath}/admin_filter_reset.do'; ">필터 초기화</button>
	<button id="return" onclick="history.back()">돌아가기</button>
</div>
<hr class="clear_line">
</body>
</html>
<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->