<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% MemberVo member_info = (MemberVo)request.getAttribute("member_info"); %>
    
    <%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
    
    <c:if test="${member_grade == null}">
	<% response.sendRedirect("need_login.do"); %>
	</c:if> <!-- 비회원 접속 방지 -->

<html>
	<head>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board_insert.css" />
	 	<title>게시판</title>
	</head>
	<body>
	<main>
		<div id="root">
			<script type="text/javascript">
				$(document).ready(function(){
					var formObj = $("form[name='writeForm']");
					$(".write_btn").on("click", function(){
						if(fn_valiChk()){
							return false;
						}
						formObj.attr("action", "/board/board_write");
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
			
			<section id="container">
				<form name="writeFrom" role="form" method="post" action="/board/board_write" enctype="multipart/form-data">
					<table>
						<tbody>
							<tr>
								<td>
									<!-- <label for="title">제목</label> --><input type="text" id="title" name="title" class="chk" title="제목을 입력하세요." placeholder="제목" />
								</td>
							</tr>	
							<tr>
								<td>
									<!-- <label for="content">내용</label> --><textarea id="content" name="content" class="chk" title="내용을 입력하세요."placeholder="내용" ></textarea>
								</td>
							</tr>
							<tr>
								<td>
									<!-- <label for="writer">작성자</label> --> <input type="hidden" id="writer" name="writer" class="chk" value="${member_name}" />
								</td>
								</tr>
								<tr>
								
							<tr>
								<td>
									<div id="file_form">
									<input type="file" name="file">
									<p>* 사진은 한 장만 등록할 수 있으며, 본문 상단에 표시됩니다.</p>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<button id="submit" class="write_btn" type="submit" ">등록</button>
									<button id="submit" type="button" style="margin-right:10px;" class="write_btn" onclick="history.back()">취소</button>
									<!-- <button class="fileAdd_btn" type="button">파일추가</button> -->	
								</td>
							</tr>			
						</tbody>			
					</table>
				</form>
			</section>
		</div>
		</main>
	</body>
</html>
<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->