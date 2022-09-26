<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/live_controller.css">
<body>
<main>

<form action="${pageContext.request.contextPath}/live_controller_process.do" method="post" enctype="form-data">

<pre>
<input type="text" name="title" id="title" placeholder="실시간 영상 제목" required" />
<textarea name="content" id="content" placeholder="내용"></textarea>
<div id="link">
<input type="text" name="live_link" id="live_link" placeholder="예) https://youtu.be/86YLFOog4GM" />
<p>
* 실시간 영상은 짧게 줄어든 링크로만 등록해야 합니다. (영상 우클릭 - URL복사)
<br>
* 갱신시 기존에 작성된 포인트 댓글들이 사라집니다.</p>
</div>
</pre>

</form>
<button id="submit" onclick="location.href='#' ">갱신</button>
<button id="cancel" onclick="window.history.back();">취소</button>

</main>
<hr class="clear_line">
</body>
</html>

<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->