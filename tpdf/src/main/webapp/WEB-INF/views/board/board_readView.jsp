<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->

<% MemberVo member_info = (MemberVo)request.getAttribute("member_info"); %>
<html>
	<head>
			
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board_view.css">
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		
	 	<title></title>
	</head>
	
	<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='readForm']");
			
			// 수정 
			$(".update_btn").on("click", function(){
				formObj.attr("action", "/board/board_updateView");
				formObj.attr("method", "get");
				formObj.submit();				
			})
			
			
			// 삭제
			$(".delete_btn").on("click", function(){
				
				var deleteYN = confirm("삭제하시겠습니까?");
				if(deleteYN == true){
					
				formObj.attr("action", "/board/board_delete");
				formObj.attr("method", "post");
				formObj.submit();
					
				}
			})
			
			// 취소
			$(".list_btn").on("click", function(){
				
				location.href = "/board/board_list";
			})
			
			// 목록
			$(".list_btn").on("click", function(){
			
			location.href = "/board/board_list?page=${scri.page}"
			+"&perPageNum=${scri.perPageNum}"
			+"&searchType=${scri.searchType}&keyword=${scri.keyword}";
			})
			//댓글작성 
			$(".replyWriteBtn").on("click", function(){
				  var formObj = $("form[name='replyForm']");
				  formObj.attr("action", "/board/board_replyWrite");
				  formObj.submit();
				});
			
			//댓글 수정 View
			$(".replyUpdateBtn").on("click", function(){
				location.href = "/board/board_replyUpdateView?board_idx=${read.board_idx}"
								+ "&page=${scri.page}"
								+ "&perPageNum=${scri.perPageNum}"
								+ "&searchType=${scri.searchType}"
								+ "&keyword=${scri.keyword}"
								+ "&board_reply_idx="+$(this).attr("data-board_reply_idx");
			});
					
			//댓글 삭제 View
			$(".replyDeleteBtn").on("click", function(){
				location.href = "/board/board_replyDeleteView?board_idx=${read.board_idx}"
								+ "&page=${scri.page}"
								+ "&perPageNum=${scri.perPageNum}"
								+ "&searchType=${scri.searchType}"
								+ "&keyword=${scri.keyword}"
								+ "&board_reply_idx="+$(this).attr("data-board_reply_idx");
			});
			
			
		})
	</script>
	
	<body>
	<main>
	
		<div id="root" class="container">
			
			<section id="container">
				<form name="readForm" role="form" method="post">
				  <input type="hidden" id="board_idx" name="board_idx" value="${read.board_idx}" />
				  <input type="hidden" id="page" name="page" value="${scri.page}"> 
				  <input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
				  <input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
				  <input type="hidden" id="keyword" name="keyword" value="${scri.keyword}"> 
				  <input type="hidden" id="file_idx" name="file_idx" value="">
				</form>
				<div class="form-group">
					<!-- <label for="title" class="col-sm-2 control-label">제목</label>  -->
					<pre><input type="text" id="title" name="title" class="form-control" value="${read.title}" readonly="readonly" /></pre>
				</div>
				<hr style="width:1010px; margin-top:10px; margin-left:100px;" />
				<div class="form-group">
					<!-- <label for="writer" class="col-sm-2 control-label">작성자</label> -->
					<input type="text" id="writer" name="writer" class="form-control" value="${read.writer}"  readonly="readonly"/>
				</div>
				 | 
				<div class="form-group" id="wdate">
					<!-- <label for="regDate" class="col-sm-2 control-label">작성날짜</label> -->
					<fmt:formatDate value="${read.regDate}" pattern="yyyy-MM-dd" />	
				</div>
				
				<!-- <span>파일 목록</span>
				<div class="form-group" style="border: 1px solid #dbdbdb;">
					<c:forEach var="file" items="${file}">
						${file.origin_file_name}(${file.file_size}kb)<br>
					</c:forEach>
				</div>
				 -->
				
				<div class="form-group" >
					
					<!-- <label for="content" class="col-sm-2 control-label">내용</label> -->
					<c:forEach var="file" items="${file}">
					<img id="file" src="${pageContext.request.contextPath}/resources/img/board/${file.origin_file_name}" width="300px;" height="200px;"> 
					</c:forEach>
					<div id="ex">
					사진을 대신해 넣어본 div (임시) 사진을 대신해 넣어본 div (임시) 사진을 대신해 넣어본 div (임시) 사진을 대신해 넣어본 div (임시) 사진을 대신해 넣어본 div (임시)
					</div>
					<div id="content">
					<pre><!-- <textarea id="content" name="content" class="form-control" readonly="readonly"> --><c:out value="${read.content}" /><!-- </textarea> --></pre>
					</div>
				</div>
				
				<hr style="width:1200px; margin-top:10px; margin-left:0px;" /> <!-- margin-left:100px; -->
				
				<div id="post_menu">
					<c:if test="${(member_name == read.writer && member_name != null ) || member_grade == 2}">
					<button type="button" id="remove" class="delete_btn btn btn-danger">삭제</button>
					</c:if>
					<c:if test="${(member_name == read.writer && member_name != null )}">
					<button type="button" id="modify" class="update_btn btn btn-warning">수정</button>
					</c:if>
					<button type="button" id="list" class="list_btn btn btn-primary">목록</button>	
				</div>
				
				<hr class="clear_line" />
				
								<!-- 댓글 -->
				<hr style="border:double 2px rgb(220, 220, 220); margin-top:20px;" />
				<br>
				<div id="reply">
				  <ol class="replyList">
				    <c:forEach items="${replyList}" var="replyList">
				      <li>
				        <p>
				        <!-- 작성자 : --> <b>${replyList.writer}</b> <!-- <br /> -->
				        <!-- 작성 날짜 :  --><fmt:formatDate value="${replyList.regDate}" pattern="(yyyy-MM-dd)" />
				        </p>
				
				        <pre>&nbsp;> <textarea class="comment_input" style="border:none;">${replyList.content}</textarea></pre>
				        
				        <div>
						  <!-- <button type="button" class="replyUpdateBtn btn btn-warning" data-board_reply_idx="${replyList.board_reply_idx}">수정</button>
						  <button type="button" class="replyDeleteBtn btn btn-danger" data-board_reply_idx="${replyList.board_reply_idx}">삭제</button> -->
						</div>
				      </li>
				      <hr style="width:1200px; border:solid 0.5px rgb(220, 220, 220); margin-top:10px;" />
				    </c:forEach>   
				  </ol>
				  <hr style="border:double 2px rgb(220, 220, 220);" />
				</div>
				<form name="replyForm" method="post" class="form-horizontal">
				  <input type="hidden" id="board_idx" name="board_idx" value="${read.board_idx}" />
				  <input type="hidden" id="page" name="page" value="${scri.page}"> 
				  <input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
				  <input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
				  <input type="hidden" id="keyword" name="keyword" value="${scri.keyword}"> 
				   
				
				  <c:if test="${member_grade >= 1}">
				  <div class="form-group">
						<!-- <label for="writer" class="col-sm-2 control-label">댓글 작성자</label>
						<div class="col-sm-10">-->
							<input type="hidden" id="writer" name="writer" class="form-control" value="${member_name}" />
						</div> 
					</div> 
					<div class="form-group">
						<!-- <label for="content" class="col-sm-2 control-label">댓글 내용</label> -->
						<div class="col-sm-10">
							<input type="text" id="content_comment" name="content" maxlength="75" class="form-control"/>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" id="comment_insert" class="replyWriteBtn btn btn-success">작성</button>
						</div>
					</div>
					</c:if>



				</form>
			</section>
		</div>
		</main>
	</body>
</html>
<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->