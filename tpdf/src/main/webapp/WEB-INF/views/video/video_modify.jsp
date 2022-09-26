<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/video_modify.css">
<script src="${pageContext.request.contextPath}/resources/js/video_modify.js"></script>
<body>
<main>
<form action="${pageContext.request.contextPath}/video_modify_process.do" method="post" enctype="form-data" name="modify_form" id="modify_form">
<input type="hidden" name="video_idx" id="video_idx" value="${videoVo.video_idx}" required />
<input type="text" name="title" id="title" placeholder="제목" maxlength="50" value="${videoVo.title}" required />
<input type="text" name="video_source" id="video_source" placeholder="출처" maxlength="20" value="${videoVo.video_source}" required  />
<br>
<textarea name="content" id="content" placeholder="영상 설명" maxlength="500" required>${videoVo.content}</textarea>
<br>
<div id="file_form">
<p>* 영상을 삭제하려면 게시글을 삭제해야 합니다.</p>
</div>
</form>
<button id="submit" onclick="modify_video()">수정</button>
<button id="cancel" onclick="window.history.back()">취소</button>
<hr class="clear_line">
</main>
</body>
</html>

<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->