<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<html>
	<head>
			
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 	<title>게시판</title>
	</head>
	
	<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='readForm']");
			
			// 수정 
			$(".update_btn").on("click", function(){
				formObj.attr("action", "/notice/notice_updateView");
				formObj.attr("method", "get");
				formObj.submit();				
			})
			
			
			// 삭제
			$(".delete_btn").on("click", function(){
				
				var deleteYN = confirm("삭제하시겠습니가?");
				if(deleteYN == true){
					
				formObj.attr("action", "/notice/notice_delete");
				formObj.attr("method", "post");
				formObj.submit();
					
				}
			})
			
			// 취소
			$(".list_btn").on("click", function(){
				
				location.href = "/notice/notice_list";
			})
			
			// 목록
			$(".list_btn").on("click", function(){
			
			location.href = "/notice/notice_list?page=${scri.page}"
			+"&perPageNum=${scri.perPageNum}"
			+"&searchType=${scri.searchType}&keyword=${scri.keyword}";
			})
			//댓글작성 
			$(".replyWriteBtn").on("click", function(){
				  var formObj = $("form[name='replyForm']");
				  formObj.attr("action", "/notice/notice_replyWrite");
				  formObj.submit();
				});
			
			//댓글 수정 View
			$(".replyUpdateBtn").on("click", function(){
				location.href = "/notice/notice_replyUpdateView?notice_idx=${read.notice_idx}"
								+ "&page=${scri.page}"
								+ "&perPageNum=${scri.perPageNum}"
								+ "&searchType=${scri.searchType}"
								+ "&keyword=${scri.keyword}"
								+ "&notice_reply_idx="+$(this).attr("data-notice_reply_idx");
			});
					
			//댓글 삭제 View
			$(".replyDeleteBtn").on("click", function(){
				location.href = "/notice/notice_replyDeleteView?notice_idx=${read.notice_idx}"
								+ "&page=${scri.page}"
								+ "&perPageNum=${scri.perPageNum}"
								+ "&searchType=${scri.searchType}"
								+ "&keyword=${scri.keyword}"
								+ "&notice_reply_idx="+$(this).attr("data-notice_reply_idx");
			});
			
			
		})
	</script>
	
	<body>
	
		<div id="root" class="container">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />
			 
			 <div>
			 	<%@include file="nav.jsp" %> 
			 </div>
			<hr />
			
			<section id="container">
				<form name="readForm" role="form" method="post">
				  <input type="hidden" id="notice_idx" name="notice_idx" value="${read.notice_idx}" />
				  <input type="hidden" id="page" name="page" value="${scri.page}"> 
				  <input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
				  <input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
				  <input type="hidden" id="keyword" name="keyword" value="${scri.keyword}"> 
				  <input type="hidden" id="file_idx" name="file_idx" value="">
				</form>
				<div class="form-group">
					<label for="title" class="col-sm-2 control-label">제목</label>
					<input type="text" id="title" name="title" class="form-control" value="${read.title}" readonly="readonly" />
				</div>
				<div class="form-group" >
					
					<label for="content" class="col-sm-2 control-label">내용</label>
					<c:forEach var="file" items="${file}">
					<img src="${pageContext.request.contextPath}/resources/img/notice/${file.origin_file_name}" width="300px;" height="200px;"> 
					</c:forEach>
					<textarea id="content" name="content" class="form-control" readonly="readonly"><c:out value="${read.content}" /></textarea>
				</div>
				<div class="form-group">
					<label for="writer" class="col-sm-2 control-label">작성자</label>
					<input type="text" id="writer" name="writer" class="form-control" value="${read.writer}"  readonly="readonly"/>
				</div>
				<div class="form-group">
					<label for="regDate" class="col-sm-2 control-label">작성날짜</label>
					<fmt:formatDate value="${read.regDate}" pattern="yyyy-MM-dd" />	
				</div>
				<span>파일 목록</span>
				<div class="form-group" style="border: 1px solid #dbdbdb;">
					<c:forEach var="file" items="${file}">
						${file.origin_file_name}(${file.file_size}kb)<br>
					</c:forEach>
				</div>
				<div>
					<button type="button" class="update_btn btn btn-warning">수정</button>
					<button type="button" class="delete_btn btn btn-danger">삭제</button>
					<button type="button" class="list_btn btn btn-primary">목록</button>	
				</div>
				<%-- <!-- 댓글 -->
				<div id="reply">
				  <ol class="replyList">
				    <c:forEach items="${replyList}" var="replyList">
				      <li>
				        <p>
				        작성자 : ${replyList.writer}<br />
				        작성 날짜 :  <fmt:formatDate value="${replyList.regDate}" pattern="yyyy-MM-dd" />
				        </p>
				
				        <p>${replyList.content}</p>
				        
				        <div>
						  <button type="button" class="replyUpdateBtn btn btn-warning" data-notice_reply_idx="${replyList.notice_reply_idx}">수정</button>
						  <button type="button" class="replyDeleteBtn btn btn-danger" data-notice_reply_idx="${replyList.notice_reply_idx}">삭제</button>
						</div>
				      </li>
				    </c:forEach>   
				  </ol>
				</div>
				<form name="replyForm" method="post" class="form-horizontal">
				  <input type="hidden" id="notice_idx" name="notice_idx" value="${read.notice_idx}" />
				  <input type="hidden" id="page" name="page" value="${scri.page}"> 
				  <input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
				  <input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
				  <input type="hidden" id="keyword" name="keyword" value="${scri.keyword}"> 
				   
				
				  <div class="form-group">
						<label for="writer" class="col-sm-2 control-label">댓글 작성자</label>
						<div class="col-sm-10">
							<input type="text" id="writer" name="writer" class="form-control" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="content" class="col-sm-2 control-label">댓글 내용</label>
						<div class="col-sm-10">
							<input type="text" id="content" name="content" class="form-control"/>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" class="replyWriteBtn btn btn-success">작성</button>
						</div>
					</div> --%>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>
<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->