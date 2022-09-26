<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/notice_view.css">
<script src="${pageContext.request.contextPath}/resources/js/notice_view.js"></script>
<body>
<main>

<div id="title">제목</div>
<div id="writer">작성자작성자작성</div>| <div id="wdate">2022.08.30 00:00</div>
<div id="hit">조회수: 77,777</div>| <a href="" id="share" onclick="notice_share(this.href); return false;">게시글 공유</a></button>
<hr class="mid_line">
<div id="file"><img src="${pageContexst.request.contextPath}/resources/img/hot_video.png" alt="첨부 이미지"></div>
<div id="content">글 내용입니다. 글 내용입니다. 글 내용입니다. 글 내용입니다. 글 내용입니다. </div>
</pre>
<hr class="mid_line">
<br>
<button id="remove" onclick="confirm('정말로 삭제하시겠습니까?'); ">삭제</button>
<button id="modify" onclick="location.href='${pageContext.request.contextPath}/notice_modify.do' ">수정</button>
<button id="list" onclick="location.href='${pageContext.request.contextPath}/notice_list.do' ">목록</button>
</main>
<hr class="clear_line">
</body>
</html>

<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->