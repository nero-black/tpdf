<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board_view.css">
<script src="${pageContext.request.contextPath}/resources/js/board_view.js"></script>
<body>
<main>

<div id="title">A선수가 짱</div>
<div id="writer">도배맨</div>| <div id="wdate">2022.08.30 00:00</div>
<div id="hit">조회수: 2</div>| <a href="" id="share" onclick="board_share(this.href); return false;">게시글 공유</a></button>
<hr class="mid_line">
<div id="file"><img src="${pageContexst.request.contextPath}/resources/img/hot_video.png" alt="첨부 이미지"></div>
<div id="content">
솔직히 못하는게 없는 선수라고 봅니다.<br>
<br>
공격도 잘해, 수비도 잘해<br>
<br>
그렇다고 누구처럼 인성 논란이 있는 것도 아니고<br>
심판이 옐로우 카드 들면 정중하게 이의제기 한 다음에 진행하는 인성까지.<br>
<br>
부족한 점이 없지 않나요?
</div>
</pre>
<div id="vote">
<button id="vote_up" onclick="confirm('이 게시글을 추천하시겠습니까?'); ">추천</button>
<div id="vote_up_n">1</div>
<button id="vote_down" onclick="confirm('정말로 이 게시글을 비추천하시겠습니까?'); ">비추천</button>
<div id="vote_down_n">0</div>
</div>

<hr class="mid_line">

<br>
<button id="report" onclick="confirm('허위 신고시 제제될 수 있습니다.\n정말로 신고하시겠습니까?'); ">신고</button>
<button id="remove" onclick="confirm('정말로 삭제하시겠습니까?'); ">삭제</button>
<button id="modify" onclick="location.href='${pageContext.request.contextPath}/board_modify.do' ">수정</button>
<button id="list" onclick="location.href='${pageContext.request.contextPath}/board_list.do' ">목록</button>

<hr class="clear_line">

<br>
<table id="comment_list">
<tr> <th>글읽는사람</th> <td>팬 관리에는 실패한 것 같네요.</td> <td class="comment_date">2022.08.30 00:01</td> </tr>
<tr> <th>작성자의닉네임은</th> <td>댓글의 내용은</td> <td class="comment_date">2022.08.30 00:01</td> </tr>
<tr> <th>작성자의닉네임은</th> <td>댓글의 내용은</td> <td class="comment_date">2022.08.30 00:01</td> </tr>
<tr> <th>작성자의닉네임은</th> <td>댓글의 내용은 댓글의 내용은 댓글의 내용은 댓글의 내용은 댓글의 내용은 댓글의 내용은 댓글의 내용은 </td> <td class="comment_date">2022.08.30 00:01</td> </tr>
</table>
</div>

<div id="comment">
<form action="${pageContext.request.contextPath}/board_comment.do" method="post">
<div id="comment_name">관리자</div> <textarea id="comment_content" name="comment_content" placeholder="댓글 내용을 입력해주세요."></textarea>
</form>
<button id="comment_insert" onclick="location.href='#' ">등록</button>
</div>

</main>
<hr class="clear_line">
</body>
</html>

<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->