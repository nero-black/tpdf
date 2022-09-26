<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin_report.css">
<body>
<main>
	<button id="list_align_a" onclick="#">◀ 글번호 정렬 ▶</button>
	<button id="list_align_b" onclick="#">◀ 추천순 정렬 ▶</button>
		<div id="report">
		<table>
	        <tr>
	          <th>글 번호</th> <th>제목</th> <th>작성자</th> <th>등록일</th> <th>조회수</th> <th>추천</th> <th>신고</th>
	        </tr>
	        <tr> <td>1</td> <td><a href="${pageContext.request.contextPath}/notice_view.do">테스트용 게시글 제목</a></td> <td>도배맨</td> <td>2022.08.30</td> <td>77,777</td> <td>0</td> <td>1</td> </tr>
</table>
		<br>
		<button id="return" onclick="history.back()">돌아가기</button>
		<div id="page">
		<< < <b>1</b> > >>
		</div>
		<div id="search">
			<select name="search_type" id="search_type">
			<option value="title">제목</option>
			<option value="writer">작성자</option>
			</select>
			<input type="text" id="search_value" name="search_value" placeholder="검색할 내용 입력" />
			<button id="search_submit" onclick="#">검색</button>
		</div>
	</div>
</main>
</body>
</html>

<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->