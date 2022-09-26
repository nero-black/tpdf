<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board_modify.css">
<body>
<main>

<form action="${pageContext.request.contextPath}/board_modify_process.do" method="post" enctype="form-data">

<pre>
<input type="text" name="title" id="title" placeholder="제목" value="A선수가 짱" />
<textarea name="content" id="content" placeholder="내용">
솔직히 못하는게 없는 선수라고 봅니다.

공격도 잘해, 수비도 잘해

그렇다고 누구처럼 인성 논란이 있는 것도 아니고
심판이 옐로우 카드 들면 정중하게 이의제기 한 다음에 진행하는 인성까지.

부족한 점이 없지 않나요?
</textarea>
<div id="file_form">
<input type="file" name="file" id="file" />
<p>* 사진은 한 장만 등록할 수 있으며, 본문 상단에 표시됩니다.
</div>
<div id="file_remove">
<a id="file_remove_process" href="#">파일 삭제</a>
<p>* 다른 사진을 등록하려면 기존의 사진을 삭제해야 합니다.
</div>
</pre>
</form>
<button id="submit" onclick="location.href='#' ">수정</button>
<button id="cancel" onclick="window.history.back();">취소</button>
<!-- 기존에 보고있던 게시글로 이동 -->

</main>
</body>
</html>

<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->