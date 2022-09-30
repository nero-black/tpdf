<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.*, java.io.*"%>
<%@ page import="org.json.simple.*"%>
<%@ page import="org.json.simple.parser.JSONParser"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/rank.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>
/* alert("test"); */
 

var v= "";
$(document).ready(function () {
	
		
	$.ajax({
	    url:"${pageContext.request.contextPath}/data5.do",
	    type : "get",
	    dataType: "json",
	    success: function(data) { 
	       /* alert("성공"); */
	       
		      /* alert(data.standings.length); */ //standings의 갯수 3개
		    //   alert(data.standings.table.position);
		      
		   //    alert(data.standings[0].table[0].position);
		       $.each(data.standings, function(index){
		    	  /* alert(index); */
		     	
		    	if(this.type == "TOTAL"){ //타입이 토탈인 것들의 갯수 
		    	  $.each(data.standings[index].table, function(tindex){		
		     		 /*  alert("index:"+index); */ //index 0 값 20번반복 
		     		  /*  alert("tindex:"+tindex);  *///tindex 1~20 1회반복
		    		 /* alert(this.position); */ //1~20 3번반복
		     		/* alert("포지션 있나요?"); */
		     		/* alert("이미지테스트"); */
						 var x = this.team.crest;
					/* 	alert(x); */
		     		
		     		  v1 = "<tr><td>"+this.position+"</td><td>"
		     		  +"<img src='"+x+"'height=20 width=20>"+"&nbsp;"+this.team.name+"</td><td>"
		     		  +this.playedGames+"</td><td>"
		     		  +this.points+"</td><td>"
		     		  +this.won+"</td><td>"
		     		  +this.draw+"</td><td>"
		     		  +this.lost+"</td><td>"
		     		  +this.goalsFor+"</td><td>"
		     		  +this.goalsAgainst+"</td><td>"
		     		  +this.goalDifference+"</td></tr>";
		     		  
		     		  v = v+v1;
		     		  
		     	     	 
		     	 	});
		    	  }   
		       });
		      
		    	  $("#rank").html("<table border='6' width=100%  border-collapse: collapse; >"
		    			  		+"<th>순위</th>"
		    			  		+"<th align='left'>팀</th>"
		    			  		+"<th>경기수</th>"
		    			  		+"<th>승점</th>"
		    			  		+"<th>승</th>"
		    			  		+"<th>무</th>"
		    			  		+"<th>패</th>"
		    			  		+"<th>득점</th>"
		    			  		+"<th>실점</th>"
		    			  		+"<th>득점차</th>"
		    			  		
		    			  				+v+"</table>"); 

		        
	     
	    },
	      error:function(request,status,error){        
	    	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    }
	    
	});
	
});
</script>
<style>
	#rank{border:1px solid #fff; }
	th, td{padding: 5px; }
	#league_menu a {
	 color:#fff;
  	 text-decoration: none;
  	 background-color: #afafaf;
     color: maroon;
     padding:15px 80px 15px 80px;
     text-align: center;
     text-decoration: none;
     display: inline-block;
     cursor: pointer;
     font-weight: bold;
  }
</style>
<body>
  <main>
  	<div id="sub_menu">
  		<a href="${pageContext.request.contextPath}/rank.do">순위표</a> |
  		<a href="${pageContext.request.contextPath}/schedule.do">경기 일정</a> |
		<a href="${pageContext.request.contextPath}/live_video.do">실시간 방송</a>
  	</div>
  	<div id="league_menu">
  		<a href="${pageContext.request.contextPath}/rank.do">프리미어리그</a> 
  		<a href="${pageContext.request.contextPath}/rank2.do">챔피언스리그</a> 
		<a href="${pageContext.request.contextPath}/rank3.do">라리가</a>
		<a href="${pageContext.request.contextPath}/rank4.do">분데스리가</a>
		<a href="${pageContext.request.contextPath}/rank5.do">세리에</a>
  	</div>
  	<br><br>
    <div id="rank">
        
        
  

    </div>
    <br><br><br>
<hr class="clear_line">
  </main>

</body>
</html>

<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->


