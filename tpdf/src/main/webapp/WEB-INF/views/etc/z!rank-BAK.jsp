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
    <div id="rank">
      <p>순위/득점</p>
      <table border="1"> 
        <tr>
          <th>경기날짜</th> <th>경기시간</th> <th>팀이름1</th> <th>아이콘1</th> <th>점수</th> <th>:</th> 
          <th>점수</th> <th>아이콘2</th> <th>팀이름2</th>
        </tr>
      </table>
    </div>

    <div id="schedule">
      <p>일정/결과</p>
      <table border="1">
        <tr>
          <th>경기날짜</th>
          <th>경기시간</th>
          <th>팀이름1</th>
          <th>아이콘1</th>
          <th>아이콘2</th>
          <th>팀이름2</th>
        </tr>
        <tr>
          <td>날짜</td>
          <td>시간</td>
          <td>팀</td>
          <td>아이콘1</td>
          <td>아이콘2</td>
          <td>팀</td>
        </tr>
        <tr>
          <td>날짜</td>
          <td>시간</td>
          <td>팀</td>
          <td>아이콘1</td>
          <td>아이콘2</td>
          <td>팀</td>
        </tr>
        <tr>
          <td>날짜</td>
          <td>시간</td>
          <td>팀</td>
          <td>아이콘1</td>
          <td>아이콘2</td>
          <td>팀</td>
        </tr>
      </table>
    </div>
    <br><br><br>
<hr class="clear_line">
  </main>

</body>
</html>

<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->