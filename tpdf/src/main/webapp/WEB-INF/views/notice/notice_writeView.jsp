<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<body>
	
		<div id="root">
			<header>
				<h1> 게시판</h1>
			</header>
			<script type="text/javascript">
				$(document).ready(function(){
					var formObj = $("form[name='writeForm']");
					$(".write_btn").on("click", function(){
						if(fn_valiChk()){
							return false;
						}
						formObj.attr("action", "/notice/notice_write");
						formObj.attr("method", "post");
						formObj.submit();
					});
				})
				function fn_valiChk(){
					var regForm = $("form[name='writeForm'] .chk").length;
					for(var i = 0; i<regForm; i++){
						if($(".chk").eq(i).val() == "" || $(".chk").eq(i).val() == null){
							alert($(".chk").eq(i).attr("title"));
							return true;
						}
					}
					
				}
				/* //파일추가
				function fn_addFile(){
					var fileIndex = 1;
					//$("#fileIndex").append("<div><input type='file' style='float:left;' name='file_"+(fileIndex++)+"'>"+"<button type='button' style='float:right;' id='fileAddBtn'>"+"추가"+"</button></div>");
					$(".fileAdd_btn").on("click", function(){
						$("#fileIndex").append("<div><input type='file' style='float:left;' name='file_"+(fileIndex++)+"'>"+"</button>"+"<button type='button' style='float:right;' id='fileDelBtn'>"+"삭제"+"</button></div>");
					});
					$(document).on("click","#fileDelBtn", function(){
						$(this).parent().remove();
						alert("실행");
					});
				} */
			</script>
			<hr />
			 
			 <div>
			 	<%@include file="nav.jsp" %>
			 </div>
			<hr />
			
			<section id="container">
				<form name="writeFrom" role="form" method="post" action="/notice/notice_write" enctype="multipart/form-data">
					<table>
						<tbody>
							<tr>
								<td>
									<label for="title">제목</label><input type="text" id="title" name="title" class="chk" title="제목을 입력하세요."/>
								</td>
							</tr>	
							<tr>
								<td>
									<label for="content">내용</label><textarea id="content" name="content" class="chk" title="내용을 입력하세요."></textarea>
								</td>
							</tr>
							<tr>
								<td>
									<label for="writer">작성자</label><input type="text" id="writer" name="writer" class="chk" title="작성자를 입력하세요."/>
								</td>
								</tr>
								<tr>
								
							<tr>
								<td>
									<input type="file" name="file">
								</td>
							</tr>
							<tr>
								<td>						
									<button class="write_btn" type="submit">작성</button>	
									<!-- <button class="fileAdd_btn" type="button">파일추가</button> -->	
								</td>
							</tr>			
						</tbody>			
					</table>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>
<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->