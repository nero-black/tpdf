<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- JSTL라이브러리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/video_view.css">
<script src="${pageContext.request.contextPath}/resources/js/video_view.js"></script>
<body>
<main>
<div id="file">
<iframe width="960" height="540" src="https://www.youtube.com/embed/${videoVo.file}" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>
<div id="title"><pre><c:out value="${videoVo.title}" /></pre></div>
<div id="source"><pre><c:out value="${videoVo.video_source}" /></pre></div>| <div id="wdate">${videoVo.wdate_d}</div>
<div id="hit">조회수: ${videoVo.hit}</div>| <a href="" id="share" onclick="video_share(this.href); return false;">영상 공유</a></button>
<hr class="mid_line">
<div id="content">
<pre><c:out value="${videoVo.content}" /></pre> <!-- pre를 통해 태그도 그대로 표시되도록 함 -->
</div>
</pre>
<hr class="mid_line">
<input id="remove_idx" type="text" value="${videoVo.video_idx}" />
<c:if test="${ member_grade == 2 }">
<button id="remove" onclick="video_delete()">삭제</button>
<button id="modify" onclick="location.href='${pageContext.request.contextPath}/video_modify.do?video_idx=${videoVo.video_idx}' ">수정</button>
</c:if>
<button id="list" onclick="location.href='${pageContext.request.contextPath}/video_list.do' ">목록</button>
<br>
</main>
<hr class="clear_line">
</body>
</html>

<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->