<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/video_insert.css">
<script src="${pageContext.request.contextPath}/resources/js/video_insert.js"></script>
<body>
<main>
<form action="${pageContext.request.contextPath}/video_insert_process.do" method="post" enctype="form-data" name="upload_form" id="upload_form">
<input type="text" name="title" id="title" placeholder="제목" maxlength="50" required />
<input type="text" name="video_source" id="video_source" placeholder="출처" maxlength="20" required  />
<br>
<textarea name="content" id="content" placeholder="영상 설명" maxlength="500" required></textarea>
<br>
<div id="file_form">
<br>
<span>링크: https://youtu.be/</span><input type="text" name="file" id="file" placeholder="주소 뒷부분" maxlength="20" required />
<p>* 복사된 주소위 뒷부분만 입력해주세요.</p>
<p>예) https://www.youtube.com/watch?v=abcdefg1234 또는 https://youtu.be/abcdefg1234에서 abcdefg1234만 입력</p>

</div>
</form>
<button id="submit" onclick="insert_video()">등록</button>
<button id="cancel" onclick="insert_cancel()">취소</button>
<hr class="clear_line">
</main>
</body>
</html>

<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->