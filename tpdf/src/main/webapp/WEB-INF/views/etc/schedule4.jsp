<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.*, java.io.*"%>
<%@ page import="org.json.simple.*"%>
<%@ page import="org.json.simple.parser.JSONParser"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/schedule.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/schedule.js"></script>

<script>
/* alert("test"); */
var v= "";
$(document).ready(function () {
	 $.ajax({
	    url:"${pageContext.request.contextPath}/schedule_data4.do",
	    type : "get",
	    dataType: "json",
	    success: function(data) { 
	       

		       $.each(data.matches, function(index){
		    	
		    		   var x = this.homeTeam.crest;
		    		   var y = this.awayTeam.crest;
		    		   if(this.utcDate.substr(5,2) == "08"){
		    	v1 ="<tr><td class='table_id' align='center'>"+this.utcDate.substr(5,5)+"</td><td>"
		    	   +this.utcDate.substr(11,5)+"</td><td align='right'>"
				   +this.homeTeam.name+"&nbsp;"
				   +"<img src='"+x+"'height=20 width=20>"+"</td><td align='center' class='result_id'>"
				   if(this.score.fullTime.home != null){   
						v1 += this.score.fullTime.home+"&nbsp;"+":"+"&nbsp;"
					   		+this.score.fullTime.away;
					}else{
						v1 += "vs"
						
					}  v1+="</td><td align='left'>"
				   +"<img src='"+y+"'height=20 width=20>"+"&nbsp;"
				   +this.awayTeam.name+"</td></tr>"
				   
				   
				   
				   
				   ;
				   
		    		
		    	v= v+v1;
		     
		    		   };
		       });
	    
		       $("#schedule_tbl").html("<table>"
		  				 +"<thead><tr><th class='date' scope='col' width='12%'>날짜</th>"
		   				 +"<th class='time' scope='col' width='10%' align='left'>시간</th>"
		   				 +"<th scope='col' width='30%'' align='right'>HOME</th>"
		   				 +"<th scope='col' width='5%'' align='center'>경기</th>"
		   				 +"<th scope='col' width='30%'' align='left'>AWAY</th></tr>"
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
		      
	
});

$(function(){
	$(".BL1_one").click(function () {
		$("#schedule_tbl").html("");
		var v = "";
		 $.ajax({
		    url:"${pageContext.request.contextPath}/schedule_data4.do",
		    type : "get",
		    dataType: "json",
		    success: function(data) { 
		         

			       $.each(data.matches, function(index){
			    	   
			    		   var x = this.homeTeam.crest;
			    		   var y = this.awayTeam.crest;
			    	   if(this.utcDate.substr(5,2) == "08"){
			    	v1 ="<tr><td class='table_id' align='center'>"+this.utcDate.substr(5,5)+"</td><td>"
			    	   +this.utcDate.substr(11,5)+"</td><td align='right'>"
					   +this.homeTeam.name+"&nbsp;"
					   +"<img src='"+x+"'height=20 width=20>"+"</td><td align='center' class='result_id'>"
					   if(this.score.fullTime.home != null){   
							v1 += this.score.fullTime.home+"&nbsp;"+":"+"&nbsp;"
						   		+this.score.fullTime.away;
						}else{
							v1 += "vs"
							
						}  v1+="</td><td align='left'>"
					   +"<img src='"+y+"'height=20 width=20>"+"&nbsp;"
					   +this.awayTeam.name+"</td></tr>"
					   
					   
					   
					   
					   ;
					   
			    		
			    	v= v+v1;
			    	   };
			     
			    	  
			       });
		    
			       $("#schedule_tbl").html("<table>"
	 		  				 +"<thead><tr><th class='date' scope='col' width='12%'>날짜</th>"
	 		   				 +"<th class='time' scope='col' width='10%' align='left'>시간</th>"
	 		   				 +"<th scope='col' width='30%'' align='right'>HOME</th>"
	 		   				 +"<th scope='col' width='5%'' align='center'>경기</th>"
	 		   				 +"<th scope='col' width='30%'' align='left'>AWAY</th></tr>"
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
			      
		
	});
	});
	
$(function(){
	$(".BL1_two").click(function () {
		$("#schedule_tbl").html("");
		var v = "";
		 $.ajax({
		    url:"${pageContext.request.contextPath}/schedule_data4.do",
		    type : "get",
		    dataType: "json",
		    success: function(data) { 
		         

			       $.each(data.matches, function(index){
			    	   
			    		   var x = this.homeTeam.crest;
			    		   var y = this.awayTeam.crest;
			    	   if(this.utcDate.substr(5,2) == "09"){
			    	v1 ="<tr><td class='table_id' align='center'>"+this.utcDate.substr(5,5)+"</td><td>"
			    	   +this.utcDate.substr(11,5)+"</td><td align='right'>"
					   +this.homeTeam.name+"&nbsp;"
					   +"<img src='"+x+"'height=20 width=20>"+"</td><td align='center' class='result_id'>"
					   if(this.score.fullTime.home != null){   
							v1 += this.score.fullTime.home+"&nbsp;"+":"+"&nbsp;"
						   		+this.score.fullTime.away;
						}else{
							v1 += "vs"
							
						}  v1+="</td><td align='left'>"
					   +"<img src='"+y+"'height=20 width=20>"+"&nbsp;"
					   +this.awayTeam.name+"</td></tr>"
					   
					   
					   
					   
					   ;
					   
			    		
			    	v= v+v1;
			    	   };
			     
			    	  
			       });
		    
			       $("#schedule_tbl").html("<table>"
	 		  				 +"<thead><tr><th class='date' scope='col' width='12%'>날짜</th>"
	 		   				 +"<th class='time' scope='col' width='10%' align='left'>시간</th>"
	 		   				 +"<th scope='col' width='30%'' align='right'>HOME</th>"
	 		   				 +"<th scope='col' width='5%'' align='center'>경기</th>"
	 		   				 +"<th scope='col' width='30%'' align='left'>AWAY</th></tr>"
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
			      
		
	});
	});
	
$(function(){
	$(".BL1_three").click(function () {
		$("#schedule_tbl").html("");
		var v = "";
		 $.ajax({
		    url:"${pageContext.request.contextPath}/schedule_data4.do",
		    type : "get",
		    dataType: "json",
		    success: function(data) { 
		         

			       $.each(data.matches, function(index){
			    	   
			    		   var x = this.homeTeam.crest;
			    		   var y = this.awayTeam.crest;
			    	   if(this.utcDate.substr(5,2) == "10"){
			    	v1 ="<tr><td class='table_id' align='center'>"+this.utcDate.substr(5,5)+"</td><td>"
			    	   +this.utcDate.substr(11,5)+"</td><td align='right'>"
					   +this.homeTeam.name+"&nbsp;"
					   +"<img src='"+x+"'height=20 width=20>"+"</td><td align='center' class='result_id'>"
					   if(this.score.fullTime.home != null){   
							v1 += this.score.fullTime.home+"&nbsp;"+":"+"&nbsp;"
						   		+this.score.fullTime.away;
						}else{
							v1 += "vs"
							
						}  v1+="</td><td align='left'>"
					   +"<img src='"+y+"'height=20 width=20>"+"&nbsp;"
					   +this.awayTeam.name+"</td></tr>"
					   
					   
					   
					   
					   ;
					   
			    		
			    	v= v+v1;
			    	   };
			     
			    	  
			       });
		    
			       $("#schedule_tbl").html("<table>"
	 		  				 +"<thead><tr><th class='date' scope='col' width='12%'>날짜</th>"
	 		   				 +"<th class='time' scope='col' width='10%' align='left'>시간</th>"
	 		   				 +"<th scope='col' width='30%'' align='right'>HOME</th>"
	 		   				 +"<th scope='col' width='5%'' align='center'>경기</th>"
	 		   				 +"<th scope='col' width='30%'' align='left'>AWAY</th></tr>"
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
			      
		
	});
	});
	
$(function(){
	$(".BL1_four").click(function () {
		$("#schedule_tbl").html("");
		var v = "";
		 $.ajax({
		    url:"${pageContext.request.contextPath}/schedule_data4.do",
		    type : "get",
		    dataType: "json",
		    success: function(data) { 
		         

			       $.each(data.matches, function(index){
			    	   
			    		   var x = this.homeTeam.crest;
			    		   var y = this.awayTeam.crest;
			    	   if(this.utcDate.substr(5,2) == "11"){
			    	v1 ="<tr><td class='table_id' align='center'>"+this.utcDate.substr(5,5)+"</td><td>"
			    	   +this.utcDate.substr(11,5)+"</td><td align='right'>"
					   +this.homeTeam.name+"&nbsp;"
					   +"<img src='"+x+"'height=20 width=20>"+"</td><td align='center' class='result_id'>"
					   if(this.score.fullTime.home != null){   
							v1 += this.score.fullTime.home+"&nbsp;"+":"+"&nbsp;"
						   		+this.score.fullTime.away;
						}else{
							v1 += "vs"
							
						}  v1+="</td><td align='left'>"
					   +"<img src='"+y+"'height=20 width=20>"+"&nbsp;"
					   +this.awayTeam.name+"</td></tr>"
					   
					   
					   
					   
					   ;
					   
			    		
			    	v= v+v1;
			    	   };
			     
			    	  
			       });
		    
			       $("#schedule_tbl").html("<table>"
	 		  				 +"<thead><tr><th class='date' scope='col' width='12%'>날짜</th>"
	 		   				 +"<th class='time' scope='col' width='10%' align='left'>시간</th>"
	 		   				 +"<th scope='col' width='30%'' align='right'>HOME</th>"
	 		   				 +"<th scope='col' width='5%'' align='center'>경기</th>"
	 		   				 +"<th scope='col' width='30%'' align='left'>AWAY</th></tr>"
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
			      
		
	});
	});
	
$(function(){
	$(".BL1_five").click(function () {
		$("#schedule_tbl").html("");
		var v = "";
		 $.ajax({
		    url:"${pageContext.request.contextPath}/schedule_data4.do",
		    type : "get",
		    dataType: "json",
		    success: function(data) { 
		         

			       $.each(data.matches, function(index){
			    	   
			    		   var x = this.homeTeam.crest;
			    		   var y = this.awayTeam.crest;
			    	   if(this.utcDate.substr(5,2) == "12"){
			    	v1 ="<tr><td class='table_id' align='center'>"+this.utcDate.substr(5,5)+"</td><td>"
			    	   +this.utcDate.substr(11,5)+"</td><td align='right'>"
					   +this.homeTeam.name+"&nbsp;"
					   +"<img src='"+x+"'height=20 width=20>"+"</td><td align='center' class='result_id'>"
					   if(this.score.fullTime.home != null){   
							v1 += this.score.fullTime.home+"&nbsp;"+":"+"&nbsp;"
						   		+this.score.fullTime.away;
						}else{
							v1 += "vs"
							
						}  v1+="</td><td align='left'>"
					   +"<img src='"+y+"'height=20 width=20>"+"&nbsp;"
					   +this.awayTeam.name+"</td></tr>"
					   
					   
					   
					   
					   ;
					   
			    		
			    	v= v+v1;
			    	   };
			     
			    	  
			       });
		    
			       $("#schedule_tbl").html("<table>"
	 		  				 +"<thead><tr><th class='date' scope='col' width='12%'>날짜</th>"
	 		   				 +"<th class='time' scope='col' width='10%' align='left'>시간</th>"
	 		   				 +"<th scope='col' width='30%'' align='right'>HOME</th>"
	 		   				 +"<th scope='col' width='5%'' align='center'>경기</th>"
	 		   				 +"<th scope='col' width='30%'' align='left'>AWAY</th></tr>"
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
			      
		
	});
	});

</script>
<style>
 #schedule_tbl  table {
    width: 100%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
  }
  
#league_menu a {

	 color:#fff;
  	 text-decoration: none;
  	 background-color: #afafaf;
     color: white;
     padding:15px 70px 15px 70px;
     margin: 0 5px 0;
     text-align: center;
     text-decoration: none;
     display: inline-block;
     cursor: pointer;
  }
  #league_menu_d {font-weight:bold;}
  .schedule_month .list a {
    position: relative;
    display: block;
    color: #3e3e3e;
    font-size: 20px;
    text-decoration: none;
    min-width: 47px;
    text-align: center;
    line-height: 39px;
}
	.schedule_month ul {text-align:center;}
	.schedule_month ul li{display:inline-block; list-style-type: none; border-collapse: collapse; width:auto;
						padding:0px 60px 0px 60px; font-weight: bold; }
	.result_id, .table_id{font-weight:900; font-size:20px;}
	#league_menu ul {text-align:center;}
    #league_menu ul li {display:inline-block; }
  </style>
<body>
  <main>
  	<div id="sub_menu">
  		<a href="${pageContext.request.contextPath}/rank.do">순위표</a> |
  		<a href="${pageContext.request.contextPath}/schedule.do">경기 일정</a> |
		<a href="${pageContext.request.contextPath}/live_video.do">실시간 방송</a>
  	</div>
  	<div id="league_menu">
	  	<ul>
	  		<li>
	  			<a id="league_menu_a" href="${pageContext.request.contextPath}/schedule.do">프리미어리그</a> 
	  		</li>
	  		<li>
	  			<a id="league_menu_b" href="${pageContext.request.contextPath}/schedule2.do">챔피언스리그</a>
	  		 </li>
	  		<li>
	  			<a id="league_menu_c" href="${pageContext.request.contextPath}/schedule3.do">라리가</a>
	  		</li>
	  		<li>
	  			<a id="league_menu_d" href="${pageContext.request.contextPath}/schedule4.do">분데스리가</a>
	  		</li>
	  		<li>
	  			<a id="league_menu_e" href="${pageContext.request.contextPath}/schedule5.do">세리에</a>
	  		</li>
	  	</ul>	
  	</div>
  	<br><br>
  	<h2>2022/23 시즌 일정</h2>
  	<br>
  		<div class="schedule_month">
   			<ul class="list">
   				<li>
   				<a style="cursor:pointer" class="BL1_one">
					<span class="year">2022년</span>
										<span class="month">8월</span>
				</a>
   				</li>
   				<li>
   				<a style="cursor:pointer" class="BL1_two">
					<span class="year">2022년</span>
										<span class="month">9월</span>
				</a>
   				</li>
   				<li>
   				<a style="cursor:pointer" class="BL1_three">
					<span class="year">2022년</span>
										<span class="month">10월</span>
				</a>
   				</li>
   				<li>
   				<a style="cursor:pointer" class="BL1_four">
					<span class="year">2022년</span>
										<span class="month">11월</span>
				</a>
   				</li>
   				<li>
   				<a style="cursor:pointer" class="BL1_five">
					<span class="year">2022년</span>
										<span class="month">12월</span>
				</a>
   				</li>
   			</ul>
   			</div>
   	<div id="schedule_tbl">
   		
	 </div>
    <br><br><br>
<hr class="clear_line">
  </main>
  	

</body>

</html>

<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->