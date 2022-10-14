<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<html>
	<head>
	<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 	<title>게시판</title>
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='updateForm']");
			
			$(".cancel_btn").on("click", function(){
				event.preventDefault();
				location.href = "/notice/notice_readView?notice_idx=${update.notice_idx}"
					   + "&page=${scri.page}"
					   + "&perPageNum=${scri.perPageNum}"
					   + "&searchType=${scri.searchType}"
					   + "&keyword=${scri.keyword}";
			})
			
			$(".update_btn").on("click", function(){
				if(fn_valiChk()){
					return false;
				}
				formObj.attr("action", "/notice/notice_update");
				formObj.attr("method", "post");
				formObj.submit();
			})
		})
			
		function fn_valiChk(){
			alert("실행중");
			var updateForm = $("form[name='updateForm'] .chk").length;
			for(var i = 0; i<updateForm; i++){
				if($(".chk").eq(i).val() == "" || $(".chk").eq(i).val() == null){
					alert($(".chk").eq(i).attr("title"));
					return true;
				}
			}
		}
		/* function fn_addFile(){
			var fileIndex = 1;
			//$("#fileIndex").append("<div><input type='file' style='float:left;' name='file_"+(fileIndex++)+"'>"+"<button type='button' style='float:right;' id='fileAddBtn'>"+"추가"+"</button></div>");
			$(".fileAdd_btn").on("click", function(){
				$("#fileIndex").append("<div><input type='file' style='float:left;' name='file_"+(fileIndex++)+"'>"+"</button>"+"<button type='button' style='float:right;' id='fileDelBtn'>"+"삭제"+"</button></div>");
			});
			$(document).on("click","#fileDelBtn", function(){
				$(this).parent().remove();
				
			});
		}
 		var fileNoArry = new Array();
 		var fileNameArry = new Array();
 		function fn_del(value, name){
 			
 			fileNoArry.push(value);
 			fileNameArry.push(name);
 			$("#fileNoDel").attr("value", fileNoArry);
 			$("#fileNameDel").attr("value", fileNameArry);
 		} */
		
	</script>
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
				<form name="updateForm" role="form" method="post" action="/notice/notice_update">
					<input type="hidden" name="notice_idx" value="${update.notice_idx}" readonly="readonly"/>
					<input type="hidden" id="fileNoDel" name="fileNoDel[]" value=""> 
					<input type="hidden" id="fileNameDel" name="fileNameDel[]" value="">
					
					<table>
						<tbody>
							<tr>
								<td>
									<label for="title">제목</label><input type="text" id="title" name="title" value="${update.title}" class="chk" title="제목을 입력하세요."/>
								</td>
							</tr>	
							<tr>
								<td>
									<label for="content">내용</label><textarea id="content" name="content" class="chk" title="내용을 입력하세요."><c:out value="${update.content}" /></textarea>
								</td>
							</tr>
							<tr>
								<td>
									<label for="writer">작성자</label><input type="text" id="writer" name="writer" value="${update.writer}" readonly="readonly" class="chk" title="작성자를 입력하세요."/>
								</td>
							</tr>
							<tr>
								<td>
									<label for="regDate">작성날짜</label>
									<fmt:formatDate value="${update.regDate}" pattern="yyyy-MM-dd"/>					
								</td>
							</tr>
							<%-- <tr>
								<td id="fileIndex">
									<c:forEach var="file" items="${file}" varStatus="var">
									<div>
										<input type="hidden" id="file_idx" name="file_idx_${var.index}" value="${file.file_idx }">
										<input type="hidden" id="FILE_NAME" name="FILE_NAME" value="file_idx_${var.index}">
										<a href="#" id="fileName" onclick="return false;">${file.origin_file_name}</a>(${file.file_size}kb)
										<button id="fileDel" onclick="fn_del('${file.file_idx}','file_idx_${var.index}');" type="button">삭제</button><br>
									</div>
									</c:forEach>
								</td>
							</tr>	 --%>	
						</tbody>			
					</table>
					<div>
						<button type="submit" class="update_btn">저장</button>
						<button type="submit" class="cancel_btn">취소</button>
					<!-- 	<button type="button" class="fileAdd_btn">파일추가</button> -->
					</div>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>
<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->