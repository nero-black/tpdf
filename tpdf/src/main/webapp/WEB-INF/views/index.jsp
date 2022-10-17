<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "include/header.jsp" %> <!-- 헤더 삽입 -->
<%@ page import = "com.tpdf.shoot.vo.VideoVo" %>  
<%@ page import="java.util.*" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<% List<VideoVo> videoList = (List)request.getAttribute("videoList"); %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css">
<style>
* {text-decoration:none;}
#more{display:inline-block; margin-left:330px; font-weight:bold;}
#font{font-weight:900; margin-bottom:10px;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
/* alert("test"); */ 
var v= "";
var y= "";
$(document).ready(function () {	
	 $.ajax({
	    url:"${pageContext.request.contextPath}/index_data.do",
	    type : "get",
	    dataType: "json",
	    success: function(data) { 
	         /* alert("성공");   */
				
		       $.each(data.matches, function(index){
		    	   
		    		   var x = this.homeTeam.crest;
		    		   var y = this.awayTeam.crest;
		    	 
		    		   
		    			  if(this.competition.code == "CL"||this.competition.code == "PL"||
		    					  this.competition.code == "PD"||
		    					  this.competition.code == "BL1"||
		    					  this.competition.code == "SA"){
		    	v1 ="<tr><td>"
		    	   +this.utcDate.substr(11,5)+"</td><td align='right'>"
				   +this.homeTeam.name+"&nbsp;"
				   +"<img src='"+x+"'height=20 width=20>"+"</td><td align='center' class='result_id'>";
				
				 //console.log(this.score.fullTime.home);  
				   
				if(this.score.fullTime.home != null){   
					v1 += this.score.fullTime.home+"&nbsp;"+":"+"&nbsp;"
				   		+this.score.fullTime.away;
				}else{
					v1 += "vs"
					
				}  	
				  v1 +="</td><td align='left'>"
				   +"<img src='"+y+"'height=20 width=20>"+"&nbsp;"
				   +this.awayTeam.name+"</td></tr>"
		   
				   ;
				   
		    		
		    	v= v+v1;
		    	
		    			  };
		       });
		       
	    
		       $("#rank_tbl").html("<table>"
		  				 +"<thead><tr>"
		   				 +"<th class='time' scope='col' width='10%' align='center'>시간</th>"
		   				 +"<th scope='col' width='30%'' align='right'><!-- HOME --></th>"
		   				 +"<th scope='col' width='5%'' align='center'>경기</th>"
		   				 +"<th scope='col' width='30%'' align='left'><!-- AWAY --></th></tr>"
		   			     +"</thead>"
		  				 +v+"</table>");
		  		 
		  		 
		  		 $(".table_id").each(function(){
			       		var rows =$(".table_id:contains('"+$(this).text()+"')");
			       		if(rows.length > 1){
			       			rows.eq(0).attr("rowspan", rows.length);
			       			rows.not(":eq(0)").remove(0);
			       		}
			       	});
		  		
		  		
		       },
		  
		        
	      error:function(request,status,error){        
	    	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    }
	    
	}); 
	 
	 $.ajax({
		    url:"${pageContext.request.contextPath}/PL_data.do",
		    type : "get",
		    dataType: "json",
		    success: function(data) { 
		    	/* alert("성공"); */
		       
			      
			       $.each(data.standings, function(index){
			    	 
			     	
			    	if(this.type == "TOTAL"){ //타입이 토탈인 것들의 갯수 
			    	  $.each(data.standings[index].table, function(tindex){		
			     		 if(this.position <= "10"){
							 var x = this.team.crest;
						
			     		  y1 = "<tr><td align='center'>"+this.position+"</td><td>"
			     		  +"<img src='"+x+"'height=20 width=20>"+"&nbsp;"+this.team.name+"</td><td>"
			     		  +this.playedGames+"</td><td>"
			     		  +this.points+"</td><td>"
			     		  +this.won+"</td><td>"
			     		  +this.draw+"</td><td>"
			     		  +this.lost+"</td><td>"
			     		  +this.goalsFor+"</td><td>"
			     		  +this.goalsAgainst+"</td><td>"
			     		  +this.goalDifference+"</td></tr>";
			     		  
			     		  y = y+y1;
			     		  
			     		 }
			     	 	});
			    	  }   
			       });
			      
			    	  $("#schedule_tbl").html("<table width=100%  border-collapse: collapse; >"
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
			    			  		
			    			  				+y+"</table>"); 

			        
		     
		    },
		      error:function(request,status,error){        
		    	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		    }
		    
		});   
	 
}); 
//프리미어리그 
 $(function (){
$("#PL_league").click(function () {
	$("#schedule_tbl").html("");
	var v = "";
	$.ajax({
	    url:"${pageContext.request.contextPath}/data.do",
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
		    		  if(this.position <= "10"){
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
		    		  };
		     	     	 
		     	 	});
		    	  }   
		       });
		      
		    	  $("#schedule_tbl").html("<table border='6' width=100%  border-collapse: collapse; >"
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
	
 }); 
//라리가

 $(function (){
$("#PD_league").click(function () {
	$("#schedule_tbl").html("");
	var v = "";
	$.ajax({
	    url:"${pageContext.request.contextPath}/data3.do",
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
		    		  if(this.position <= "10"){
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
		    		  };
		     	     	 
		     	 	});
		    	  }   
		       });
		      
		    	  $("#schedule_tbl").html("<table border='6' width=100%  border-collapse: collapse; >"
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
	
 }); 
//분데스
 $(function (){
$("#BL1_league").click(function () {
	$("#schedule_tbl").html("");
	var v = "";
	$.ajax({
	    url:"${pageContext.request.contextPath}/data4.do",
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
		    		  if(this.position <= "10"){
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
		    		  };
		     	     	 
		     	 	});
		    	  }   
		       });
		      
		    	  $("#schedule_tbl").html("<table border='6' width=100%  border-collapse: collapse; >"
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
	
 }); 

//세리에A
 $(function (){
$("#SA_league").click(function () {
	$("#schedule_tbl").html("");
	var v = "";
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
		    		  if(this.position <= "10"){
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
		    		  };
		     	     	 
		     	 	});
		    	  }   
		       });
		      
		    	  $("#schedule_tbl").html("<table border='6' width=100%  border-collapse: collapse; >"
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
	
 }); 

</script>
<body>
  <main>
      <a id="hot_video" href="#">
        <span>핫비디오 제목입니다</span>
        <img src="${pageContext.request.contextPath}/resources/img/hot_video.png" alt="하이라이트 영상"  class="main_video">
      </a>
      <a class="issue_video" href="#">
        <img src="${pageContext.request.contextPath}/resources/img/video.png" alt="영상" class="sub_video">
        <span>영상 제목입니다. </span>
        <p>출처</p>
      </a>
      <a class="issue_video" href="#">
        <img src="${pageContext.request.contextPath}/resources/img/video.png" alt="영상" class="sub_video">
        <span>영상 제목입니다.</span>
        <p>출처</p>
      </a>
      <a class="issue_video" href="#">
        <img src="${pageContext.request.contextPath}/resources/img/video.png" alt="영상" class="sub_video">
        <span>영상 제목입니다.</span>
        <p>출처</p>
      </a>
            
    <hr class="clear_line">
    <hr class="mid_line">
    
    <div id="notice">
      <a href="${pageContext.request.contextPath}/notice/notice_list"><span>새로운 소식</span></a>
      <table>
						<tr><th>번호</th><th>제목</th><th>작성자</th><th>등록일</th></tr>
						
						<c:forEach items="${list}" var = "list">
							<tr>
								<td><c:out value="${list.board_idx}" /></td>
								<td><c:out value="${list.title}" /></td>
								<td><c:out value="${list.writer}" /></td>
								<td><fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd"/></td>
							</tr>
						</c:forEach>
						
					</table>
    </div>
    <div id="board">
      <a href="${pageContext.request.contextPath}/board/board_list""><span>자유 게시판</span></a>
      <table>
        <tr>
          <td><a href="#">자유 게시글 제목1</a></td>
        </tr>
        <tr>
          <td><a href="#">자유 게시글 제목2</a></td>
        </tr>
        <tr>
          <td><a href="#">자유 게시글 제목3</a></td>
        </tr>
        <tr>
          <td><a href="#">자유 게시글 제목4</a></td>
        </tr>
        <tr>
          <td><a href="#">자유 게시글 제목5</a></td>
        </tr>
        <tr>
          <td><a href="#">자유 게시글 제목6</a></td> 
        </tr>
        <tr>
          <td><a href="#">자유 게시글 제목7</a></td> 
        </tr>
        <tr>
          <td><a href="#">자유 게시글 제목8</a></td> 
        </tr>
        <tr>
          <td><a href="#">자유 게시글 제목9</a></td> 
        </tr>
        <tr>
          <td><a href="#">자유 게시글 제목10</a></td> 
        </tr>
      </table>
    </div> 
       
    <hr class="clear_line">
    
    <div id="mid_banner">
    <a href="https://www.eveonline.com/" target="_blank"><img src="${pageContext.request.contextPath}/resources/img/banner00.png" alt="배너" id="banner00" /></a>
    </div>
    
    <hr class="clear_line">
	<div id="video">
    <a href="${pageContext.request.contextPath}/video_list.do""><span>영상 게시판</span></a>
    <hr>
    <div id="video_list">
		<div class="video">
			<% for (VideoVo videoVo : videoList ) {	%>
			<a href="<%=request.getContextPath() %>/video_view.do?video_idx=<%=videoVo.getVideo_idx()%>">
			<table>
				<tr> <td><img src="https://img.youtube.com/vi/<%=videoVo.getFile()%>/hqdefault.jpg" alt="${pageContext.request.contextPath}/resources/img/video.png" /></td> </tr>
				
				<% 
				String title = videoVo.getTitle();
				int title_l = title.length();
				if (title_l >= 16) {
					title = title.substring(0,15);
					title = title + "...";
					// System.out.println("제목 (잘림): "+title);		
				}else {
				// System.out.println("제목: "+title);		
				}
				%>
				<tr> <th><%= title %></th> </tr>
			</table> </a>
			<% } %>
			</div>
		</div>
	</div>
    <hr class="clear_line">

   <div id="rank">
      <a id="font" href="${pageContext.request.contextPath}/rank.do">오늘의  경기일정</a>
      <!-- <a id="more" href="${pageContext.request.contextPath}/rank.do">더보기</a> -->
      <div id="rank_tbl">
      
      </div>
    </div>

    <div id="schedule">
      <a id="font"  href="${pageContext.request.contextPath}/schedule.do">리그 순위표</a>
      <!-- <a id="more" href="${pageContext.request.contextPath}/schedule.do">더보기</a> -->
      <br>
      <div>
      <!-- <a href="#" id="PL_league"  onclick="return false;" >프리미어리그</a>
      <a href="#" id="PD_league"  onclick="return false;">라리가</a>
      <a href="#" id="BL1_league" onclick="return false;">분데스리가</a>
      <a href="#" id="SA_league"  onclick="return false;">세리에 A</a>  -->
      </div>
      
      <div id="schedule_tbl">
      </div>
      
    </div>
    <br><br><br>
<hr class="clear_line">
  </main>

</body>
</html>

<%@ include file = "include/footer.jsp" %> <!-- 풋터 삽입 -->