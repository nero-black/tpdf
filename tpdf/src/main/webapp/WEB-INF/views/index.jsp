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
		       
	    
		       $("#rank_tbl").html("<table id='todaymatch'>"
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
	    	alert("잠시 후 새로고침 뒤 다시 시도해주시기바랍니다");
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
			      
			    	  $("#schedule_tbl").html("<table>"
			    			  		+"<th>순위</th>"
			    			  		+"<th>팀</th>"
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
		      
		    	  $("#schedule_tbl").html("<table>"
		    			  		+"<th>순위</th>"
		    			  		+"<th>팀</th>"
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
		      
		    	  $("#schedule_tbl").html("<table >"
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
		      
		    	  $("#schedule_tbl").html("<table  >"
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
		      
		    	  $("#schedule_tbl").html("<table >"
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
	  
	    
	});  
		      
	
	});
	
 }); 

</script>
<body>
  <main>
    <div id="main_banner">
    <a href="https://baltimoresportsandlife.com/english-premier-league-2022-2023-preview/" target="_blank"><img src="${pageContext.request.contextPath}/resources/img/main.jpeg" alt="메인 배너" /></a>
    </div>
    
    <hr class="clear_line">
    <hr class="mid_line">
    
    <div id="notice">
      <a href="${pageContext.request.contextPath}/notice/notice_list"><span>새로운 소식</span></a>
      <table>
						<tr></tr>
						
						<c:forEach items="${list2}" var = "list2">
							<tr>
								<td width="10%" id="notice_title">소식</td>
								<td width="60%">
								<a href="/notice/notice_readView?notice_idx=${list2.notice_idx}&
																		page=${scri.page}&
																		perPageNum=${scri.perPageNum}&
																		searchType=${scri.searchType}&
																		keyword=${scri.keyword}">
																		<c:out value="${list2.title}" /></a>&nbsp&nbsp<span id="notice_d">[<c:out value="${list2.hit}"/>]</span>
																		</td>
								</tr>
						</c:forEach>
						
					</table>
    </div>
    <div id="board">
      <a href="${pageContext.request.contextPath}/board/board_list""><span>자유 게시판</span></a>
      <table>
						<tr></tr>
						
						<c:forEach items="${blist}" var = "blist">
							<tr>
								<td width="10%" id="board_title" colspan='2'>자유</td>
								<td width="60%" nowrap>
								<a href="/board/board_readView?board_idx=${blist.board_idx}&
																		page=${scri.page}&
																		perPageNum=${scri.perPageNum}&
																		searchType=${scri.searchType}&
																		keyword=${scri.keyword}">
																		<c:out value="${blist.title}" /></a>&nbsp&nbsp<span id="board_d">[<c:out value="${blist.hit}"/>]</span>
																		</td>
							
								</tr>
						</c:forEach>
						
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
	<div id="soccer_line">
	   <div id="rank">
	      <a id="font" href="${pageContext.request.contextPath}/rank.do">오늘의  경기일정</a>
	      <div id="rank_tbl">
	      </div>
	    </div>
	
	    <div id="schedule">
	      <a id="font"  href="${pageContext.request.contextPath}/schedule.do">리그 순위표</a>
	      <br>
	      <div id="schedule_icon">
		      <a href="#" id="PL_league"  onclick="return false;" >프리미어리그</a>
		      <a href="#" id="PD_league"  onclick="return false;">라리가</a>
		      <a href="#" id="BL1_league" onclick="return false;">분데스리가</a>
		      <a href="#" id="SA_league"  onclick="return false;">세리에 A</a> 
	      </div>
	      
	      <div id="schedule_tbl">
	      </div>
	      
	    </div>
	    <br><br><br>
	    </div>
<hr class="clear_line">
  </main>

</body>
</html>

<%@ include file = "include/footer.jsp" %> <!-- 풋터 삽입 -->