<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 --> 
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

	<form method="post">

	<input type="text" id="title" name="title" placeholder="제목"/><br />
	
	<input type="text" id="writer" name="writer" placeholder="작성자"/><br />
	
	<textarea cols="50" id="content" rows="9" name="content" placeholder="내용"></textarea><br />
	
	<button id="submit" type="submit">작성</button>
	<button id="cancel">취소</button>
	<br><br><br><br>
	</form>
</body>
</html>
<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->