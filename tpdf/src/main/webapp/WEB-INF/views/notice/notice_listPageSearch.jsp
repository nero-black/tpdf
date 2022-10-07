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
<style>
	#icon{color:black;}
</style>
<body>


<main>
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
		<div>
		<c:if test="${page.prev}">
		 	<span> <a id="icon" href="/notice/notice_listPageSearch?num=${page.startPageNum - 1}${page.searchTypeKeyword}"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-caret-left-fill" viewBox="0 0 16 16">
  		<path d="m3.86 8.753 5.482 4.796c.646.566 1.658.106 1.658-.753V3.204a1 1 0 0 0-1.659-.753l-5.48 4.796a1 1 0 0 0 0 1.506z"/>
		</svg></a>  </span>
		</c:if>
		<c:forEach begin="${page.startPageNum}" end="${page.endPageNum}" var="num">
		 	<span> 
		  <c:if test="${select != num}">
		   	<a href="/notice/notice_listPageSearch?num=${num}${page.searchTypeKeyword}">${num}</a>
		  </c:if>    		  
		  <c:if test="${select == num}">
		   	<b>${num}</b>
		  </c:if>
		  </span>
		</c:forEach>
		
		<c:if test="${page.next}">
		 <span> <a id="icon"  href="/notice/notice_listPageSearch?num=${page.endPageNum + 1}${page.searchTypeKeyword}"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-caret-right-fill" viewBox="0 0 16 16">
  		<path d="m12.14 8.753-5.482 4.796c-.646.566-1.658.106-1.658-.753V3.204a1 1 0 0 1 1.659-.753l5.48 4.796a1 1 0 0 1 0 1.506z"/>
		</svg></a>  </span>
		</c:if>
			<%-- <c:forEach begin="1" end="${pageNum}" var="num">
				<span>
					<a href="/notice/notice_listPage?num=${num}">${num}</a>
				</span>
			</c:forEach> --%>
		</div>
		
		
		
		<br>
		<button id="notice_insert" onclick="location.href='/notice/notice_write'">글쓰기</button>
		<div id="page">
		
	
		
		
		</div>
		<div>
		 <select name="searchType">
		     <option value="title" <c:if test="${page.searchType eq 'title'}">selected</c:if>>제목</option>
		     <option value="content" <c:if test="${page.searchType eq 'content'}">selected</c:if>>내용</option>
		     <option value="title_content" <c:if test="${page.searchType eq 'title_content'}">selected</c:if>>제목+내용</option>
		     <option value="writer" <c:if test="${page.searchType eq 'writer'}">selected</c:if>>작성자</option>
		 </select>
		 
		 <input type="text" name="keyword" value="${page.keyword}"/>
		 
		 <button type="button" id="searchBtn">검색</button>
		</div>
	</div>
	<script>
	
	 document.getElementById("searchBtn").onclick = function () {
	    
	  let searchType = document.getElementsByName("searchType")[0].value;
	  let keyword =  document.getElementsByName("keyword")[0].value;
	  
	  location.href = "/notice/notice_listPageSearch?num=1" + "&searchType=" + searchType + "&keyword=" + keyword;
	 };
	</script>
</main>
</body>
</html>

<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->