<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/point_check.css">
<body>

<div id="point">

<br><br><br>

<!-- table로 포인트 기록이 출력 -->
<table border="1">
<tr>
<th>날짜</th>
<th>적립 포인트</th>
<th>적립 사유</th>
<th>처리자</th>
</tr>
<tr>
<td>2022-09-01</td>
<td>99,999</td>
<td>관리 권한</td>
<td>관리자</td>
</tr>
<tr>
<td>2022-09-02</td>
<td>99,999</td>
<td>관리 권한</td>
<td>관리자</td>
</tr>
</table>

<br><br>

<button id="return" onclick="history.back()">돌아가기</button>
</div>

</body>
</html>
<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->