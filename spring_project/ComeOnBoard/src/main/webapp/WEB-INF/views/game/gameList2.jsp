<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ComeOnBoard</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script> 
<%@ include file="/WEB-INF/views/frame/metaheader.jsp" %>
</head>
<style>
    * {
        margin: 0;
        padding: 0;
    }

    .main_body{
        background-color: #f7f7f7;
    }

    ul {
        list-style: none;
    }

    .listbar{
        
        height: 20px;
        width: 100%;
        max-width: 980px;
        padding: 12px 5px;
        color: white;
        background-color:rgb(251, 188, 006);
        margin: 30px auto;
        border: 2px solid #000;
       
 
    }
    
    .listbar>select{

        width: 80px;
        float: left; 
        display: inline;
    }

    .listbarv>ul{
        
        display: inline;

    }
    .listbar>ul>li{
        float: right; 
        
        margin-right: 10px;
    }
    
    .listbar>ul>li>a:hover{
    color: rgb(66, 133, 244);
    }

    .game_list{
        
        width: 100%;
        max-width: 980px;
        height: auto;
        margin: 15px auto 0px auto;
        padding: 12px 5px;
        min-height: 130px;
        
        border: 2px solid #000;
    }
   
    
    

    .game_img{
        
        width: 100px;
        height: 100px;
        /* border : 2px solid #000; */
        padding: 5px 15px;
        margin : 5px 10px; 
        border-right: 2px solid rgb(251, 188, 006);
        float:left; 
        
    }

    
    .game_list>div>ul{
        float : left; 
    }

    .game_list>div>div{

        width: 100px;
        height: 100px;
        background-color: rgb(66, 133, 244);
        text-align: center;
        line-height: 100px;
        font-size: 20px;
        float: right ;
        /* margin: 5px 15px; */
        margin-right: 15px;
        margin-top: 5px;
    }

.game_item{
    display: block;
    clear: both;
    border-bottom: 2px solid #000;
    /* padding-top: 10px; */
    height: 130px;
    margin-top: 15px;
}

.game_item>ul>li>h3>a:hover{
    color: rgb(66, 133, 244);
}

.paging{
    margin: 0px auto;
    width: 100%;
    max-width: 980px;
    height: 40px;
    /* margin-bottom: 20px; */
   
    
    /* border: 2px solid #000; */
    
}

.paging>h4{
    /* text-align: center; */
    margin: 0px auto;
    display: inline;
}

.paging_number{
    width: 420px;
    
}
.game_reg{
    width: 560px;
    float: right;
}
.reg_btn{
    float: right;
    width: 80px;
    margin: 2px 0px;
    border-radius: 7px;
    visibility:hidden;
}

.reg_btn:hover{ 
        background-color: rgb(251, 188, 006); 
        cursor: pointer;
    }

a{
    text-decoration: none;
    color: black;
}

#etc{
	display :none
}
#btn_order{
	background-color: rgb(251, 188, 006); 
	border : none;
	font-size : 15px;
	
}
#btn_order:hover{
	color: rgb(66, 133, 244); 
}
</style>
<script>

$(function(){
	
	
	if('${loginInfo.memAuth}' == 'manager'){
		$('#reg_btn').css('visibility','visible');
	}
	
});


 
</script>
<script>
$(function(){
	$('#sortForm').change(function(){
		
	function sortlist(sort){
		$.ajax({
			url :'<c:url value="/game/gamelist"/>',
			type : 'post',
			data : {
				sortType : $('#sortForm')
			},
			success : function(data){
				$('#sortForm').val().submit();	
			},
			error : function(){
				alert('?????????????????????');
			},
			complete : function(){}
		});
		
	}
		
	});
	
});
</script>
<body>

    <%@ include file="/WEB-INF/views/frame/header.jsp" %>
	<%@ include file="/WEB-INF/views/gameFrame/searchbar.jsp"%>
	
	<form method="post">
		<div class="listbar">
			
				<select  name="sortKeyword" id="sortForm" onchange="changeSort()">
					<option selected> ???????????? </option>
					<option value="1" >??????</option>
					<option value="2" >??????</option>
					<option value="3" >????????????</option>
					<option value="4" >??????</option>
					<option value="5" >?????????</option>
					<option value="6" >??????</option>
					<option value="7" >??????</option>
					<option value="8" >?????????</option>
				</select>
				<script>
					function changeSort() {
						var select = $('#sortForm').val();
						
						$.ajax({
							
							type : 'get',
							url : '<c:url value="/game/gamelist"/>',
							data : {
									sortType : select
								},
							success : function(){
								location.href = "gamelist?sortType="+select;
							},
							error:function(request,status,error){   //????????? ??????????????? ???????????? ?????? ????????? ??????
								//alert('??????');
								alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
								
							},
							complete : function(){	
									 
							}							
						})
							
					}				
				</script>
	        	<form  method="post">
			        <ul>
			        	<li><button type="submit" id="btn_order" name="orderType" value="1">?????????</button></li>
			        	<li><button type="submit" id="btn_order" name="orderType" value="0">?????????</button></li>
			        	<li><button type="submit" id="btn_order" name="orderType" value="2">?????????</button></li>
			        </ul>
		        </form>
	        
	    </div>
	</form>
	
    <div class="game_list">

        <c:forEach items="${listView.gameList}" var="gameMain" >
        <div class="game_item">
            
            
            <a href="<c:url value ='/game/gamepage/'/>${gameMain.gameIdx}">
            <img src="<c:url value="/uploadfile/uploadgamefile"/>/${gameMain.gamePhoto}" class="game_img"/>
            </a>
            
            
            
            <ul>
                <li><h3><a href="<c:url value ='/game/gamepage/'/>${gameMain.gameIdx}" >${gameMain.gameName}</a></h3></li>
                <li><h3>?????? : ${gameMain.gameSort}</h3></li>
                <li><h3>???????????? : ${gameMain.gamePerson}</h3></li>
                <li><h3>??????????????? : ${gameMain.gameTime}</h3></li>
                <li><h3>???????????? : ${gameMain.gameLmtAge}</h3></li>
            </ul>
            
            <div>
                <h1>${gameMain.avg }</h1>
            </div>

          
        </div> 

	</c:forEach>
    </div>
   	
	
	
	    <div class="paging">

        <div class="game_reg">
            <input type="button" value="??????" class="reg_btn" id="reg_btn"
            onclick="document.location.href='<c:url value ='/game/gameReg'/>'" >

        <div class="paging_number">
	        <c:if test ="${listView.pageTotalCount>0 }">
	        	<div  class="paging">
	        	<c:if test="${listView.startPage != 1 }">
				<a href="gamelist?page=${listView.startPage-1}&keyword=${searchType.keyword}&sortType=${searchType.sortType}&orderType=${searchType.orderType}">&lt;</a>
				</c:if>
				<c:forEach begin="${listView.startPage }" end="${listView.endPage }" var="p">
					<c:choose>
						<c:when test="${p == listView.currentPageNumber }">
							<b>${p }</b>
						</c:when>
						<c:when test="${p != listView.currentPageNumber }">
							<a href="gamelist?page=${p}&keyword=${searchType.keyword}&sortType=${searchType.sortType}&orderType=${searchType.orderType}">${p }</a>
						</c:when>
					</c:choose>
				</c:forEach>	        	
	        	<c:if test="${listView.endPage != listView.pageTotalCount}">
					<a href="gamelist?page=${listView.endPage+1}&keyword=${searchType.keyword}&sortType=${searchType.sortType}&orderType=${searchType.orderType}">&gt;</a>
				</c:if> 
		       
		        <%-- 	<c:forEach begin="1" end="${listView.pageTotalCount }" var="num">
        		
		        		<span>[<a href="gamelist?page=${num}&keyword=${searchType.keyword}">${num}</a>]</span>
		        
		        	</c:forEach> --%>
		        	
	        	</div>
	        </c:if>          
        </div>


        </div>
          
    </div>

</body>
</html>