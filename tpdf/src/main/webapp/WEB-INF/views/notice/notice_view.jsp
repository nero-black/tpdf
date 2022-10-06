<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 --> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>
</head>
<style>

* {margin:0; padding:0;}

main {width:1200px; height:1000px; margin:0 auto;}
hr.clear_line {clear:both; border:0;}

#title {width:600px; height:30px; padding-left:10px; margin:50px 0 20px 400px;
		font-size:20px; font-weight:bold; line-height:10px;}
		
		
#writer {width:600px; height:30px; padding-left:10px; margin:20px 0 20px 400px;
		font-size:20px; font-weight:bold; line-height:10px;}

#content {width:800px; height:480px; font-size:15px; padding:10px 0 0 10px; margin:10px 0 0 400px;}



#cancel {float:right;  width:100px; height:30px; background:whitesmoke; 
          text-align:center; line-height:18px; font-size:18px; border:solid 1px gray; margin:15px 20px 0 0;}
#submit {float:right;  width:100px; height:30px; background:whitesmoke; 
          text-align:center; line-height:18px; font-size:18px; border:solid 1px gray; margin:15px 300px 0 0;}


</style>

<body>
	<label>제목</label>
	${view.title}<br />
	<label>작성자</label>
	${view.writer}<br />
	<label>내용</label>
	${view.content}<br />
	

	<br/><br/>
	
	<div>
		<a href="/notice/notice_modify?notice_idx=${view.notice_idx}">게시물 수정</a>
		<a href="/notice/notice_delete?notice_idx=${view.notice_idx}">게시물 삭제</a>
	</div>
	
	
	
</body>
</html>
<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->