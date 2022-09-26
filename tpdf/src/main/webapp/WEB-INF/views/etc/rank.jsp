<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/rank.css">
<body>
  <main>
  	<div id="sub_menu">
  		<a href="${pageContext.request.contextPath}/rank.do">순위표</a> |
  		<a href="${pageContext.request.contextPath}/schedule.do">경기 일정</a> |
		<a href="${pageContext.request.contextPath}/live_video.do">실시간 방송</a>
  	</div>
    <div id="rank">
      <table border="1">
      <caption>순위/득점</caption>
        <tr>
          <th>경기날짜</th> <th>경기시간</th> <th>팀이름1</th> <th>아이콘1</th> <th>점수</th> <th>:</th> 
          <th>점수</th> <th>아이콘2</th> <th>팀이름2</th>
        </tr>
        <tr>
          <th>경기날짜</th> <th>경기시간</th> <th>팀이름1</th> <th>아이콘1</th> <th>점수</th> <th>:</th> 
          <th>점수</th> <th>아이콘2</th> <th>팀이름2</th>
        </tr>
        <tr>
          <th>경기날짜</th> <th>경기시간</th> <th>팀이름1</th> <th>아이콘1</th> <th>점수</th> <th>:</th> 
          <th>점수</th> <th>아이콘2</th> <th>팀이름2</th>
        </tr>
        <tr>
          <th>경기날짜</th> <th>경기시간</th> <th>팀이름1</th> <th>아이콘1</th> <th>점수</th> <th>:</th> 
          <th>점수</th> <th>아이콘2</th> <th>팀이름2</th>
        </tr>
        <tr>
          <th>경기날짜</th> <th>경기시간</th> <th>팀이름1</th> <th>아이콘1</th> <th>점수</th> <th>:</th> 
          <th>점수</th> <th>아이콘2</th> <th>팀이름2</th>
        </tr>
      </table>
    </div>
    <br><br><br>
<hr class="clear_line">
  </main>

</body>
</html>

<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->