<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/notice.css">
<body>


<main>
<div id="nav">
	<%@ include file="./notice_include.jsp" %>
</div>
	<button id="list_align_a" onclick="#">최신순</button>
	<button id="list_align_b" onclick="#">추천순</button>
		<br><br>
		<div id="notice">
		<table>
			<thead>
	        <tr>
	          <th>번호</th>
	          <th>제목</th>
	          <th>작성자</th>
	          <th>작성일</th>
	          <th>조회수</th>
	        </tr>
	        </thead>
	       <tbody>
	        	<c:forEach items="${list}" var="list">
	        	<tr>
	        		<td>${list.notice_idx}</td>
	        		<td>
	        		<a href="/notice/notice_view?notice_idx=${list.notice_idx}">${list.title}</a>
	        		</td>
	        		<td>
	        			<fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd"/>
	        		</td>
	        		<td>${list.writer}</td>
	        		<td>${list.viewCnt}</td>
	        		
	        	</tr>     		        	
	        	</c:forEach>
	        </tbody> 
		</table>
		<br>
		<button id="notice_insert" onclick="location.href='/notice/notice_write'">글쓰기</button>
		<div id="page">
		
		<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-caret-left-fill" viewBox="0 0 16 16">
  		<path d="m3.86 8.753 5.482 4.796c.646.566 1.658.106 1.658-.753V3.204a1 1 0 0 0-1.659-.753l-5.48 4.796a1 1 0 0 0 0 1.506z"/>
		</svg>
		<b>1</b> 2 3 4 5 6 7 8 9 10
		<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-caret-right-fill" viewBox="0 0 16 16">
  		<path d="m12.14 8.753-5.482 4.796c-.646.566-1.658.106-1.658-.753V3.204a1 1 0 0 1 1.659-.753l5.48 4.796a1 1 0 0 1 0 1.506z"/>
		</svg>
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