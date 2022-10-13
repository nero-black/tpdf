<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
	 	<title>게시판</title>
	</head>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<style type="text/css">
			li {list-style: none; float: left; padding: 6px;}
		</style>
	<body>
		<div id="root">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />
			 <div>
			 	<%@include file="nav.jsp" %>
			 </div>
			
			<hr />
			
			<section id="container">
				<form role="form" method="get">
					<table>
						<tr><th>번호</th><th>제목</th><th>작성자</th><th>등록일</th></tr>
						
						<c:forEach items="${list}" var = "list">
							<tr>
								<td><c:out value="${list.board_idx}" /></td>
								<td>
									<a href="/board/board_readView?board_idx=${list.board_idx}&
																		page=${scri.page}&
																		perPageNum=${scri.perPageNum}&
																		searchType=${scri.searchType}&
																		keyword=${scri.keyword}">
																		<c:out value="${list.title}" /></a>
								</td>
								<td><c:out value="${list.writer}" /></td>
								<td><fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd"/></td>
							</tr>
						</c:forEach>
						
					</table>
					<div class="search">
					    <select name="searchType">
					      <option value="n"<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>-----</option>
					      <option value="t"<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
					      <option value="c"<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
					      <option value="w"<c:out value="${scri.searchType eq 'w' ? 'selected' : ''}"/>>작성자</option>
					      <option value="tc"<c:out value="${scri.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
					    </select>
					
					    <input type="text" name="keyword" id="keywordInput" value="${scri.keyword}"/>
					
					    <button id="searchBtn" type="button">검색</button>
					    <script>
					      $(function(){
					        $('#searchBtn').click(function() {
					          self.location = "board_list" + "${paging.makeSearch(1)}" + "?searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
					        });
					      });   
					    </script>
					  </div>
					<div>
					  <ul>
					    <c:if test="${Paging.prev}">
					    	<li><a href="board_list${Paging.makeSearch(Paging.startPage - 1)}">이전</a></li>
					    </c:if> 
					
					    <c:forEach begin="${Paging.startPage}" end="${Paging.endPage}" var="idx">
					    	<li><a href="board_list${Paging.makeSearch(idx)}">${idx}</a></li>
					    </c:forEach>
					
					    <c:if test="${Paging.next && Paging.endPage > 0}">
					    	<li><a href="board_list${Paging.makeSearch(Paging.endPage + 1)}">다음</a></li>
					    </c:if> 
					  </ul>
					</div>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>