<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin_ban.css">
<body>
<main>
	<button id="list_align_a" onclick="#">◀ 번호순 정렬 ▶</button>
	<button id="list_align_b" onclick="#">◀ 신고순 정렬 ▶</button>
		<div id="ban">
		<table>
	        <tr>
	        	<th>ID</th> <th>닉네임</th> <th>이메일</th> <th>포인트</th> <th>가입일</th> <th>탈퇴여부</th> <th>제제</th>
	        </tr>
	        	<td>dobeman</td> <td>도배맨</td>
	        	<td>dobe@man.com</td>
	        	<td>90</td>
	        	<td>2022.09.01</td>
	        	<td>N</td>
	        	<td><button class="ban_process" onclick="#">강퇴</button></td>
	        </tr>
</table>
		<br>
		<button id="return" onclick="history.back()">돌아가기</button>
		<div id="page">
		<< < <b>1</b> > >>
		</div>
		<div id="search">
			<select name="search_type" id="search_type">
			<option value="title">아이디</option>
			<option value="writer">닉네임</option>
			</select>
			<input type="text" id="search_value" name="search_value" placeholder="검색할 내용 입력" />
			<button id="search_submit" onclick="#">검색</button>
		</div>
	</div>
</main>
<hr class="clear_line">
</body>
</html>

<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->