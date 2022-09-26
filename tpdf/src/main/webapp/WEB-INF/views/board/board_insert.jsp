<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board_insert.css">
<script src="${pageContext.request.contextPath}/resources/js/board_insert.js"></script>
<body>
<main>

<form action="${pageContext.request.contextPath}/board_insert_process.do" method="post" enctype="form-data">

<pre>
<input type="text" name="title" id="title" placeholder="제목" />
<textarea name="content" id="content" placeholder="내용"></textarea>
<div id="file_form">
<input type="file" name="file" id="file" />
<p>* 사진은 한 장만 등록할 수 있으며, 본문 상단에 표시됩니다.
</div>
</pre>
</form>
<button id="submit" onclick="location.href='#' ">등록</button>
<button id="cancel" onclick="insert_cancel()">취소</button>

</main>
</body>
</html>

<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->