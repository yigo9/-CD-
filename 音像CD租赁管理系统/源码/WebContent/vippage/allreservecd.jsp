<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="../static/css/base.css">
    <link rel="stylesheet" href="../static/css/inner.css">
    <link rel="stylesheet" href="../static/fonts/iconfont.css">
    <link rel="shortcut icon" href="../static/img/bitbug_favicon.ico">
</head>

<body>

	<%@ include file="/common-bars/topbar.jsp" %>
	
    <div class="main">
    
   		<%@ include file="/common-bars/vipsidebar.jsp" %>
   	
        <div class="right">
        
            <table class="table">
            
                <thead>
                    <tr>
                        <th>CD编号</th>
                        <th>CD名称</th>
                        <th>作者</th>
                        <th>价格</th>
                        <th>剩余数量</th>
                        <th>类型</th>
                        <th>CD位置</th>
                        <th>操作</th>
                    </tr>
                </thead>
                
                <tbody>

                
                	 <c:forEach items="${allReserveCd}" var="cd">
       					 <tr>
				            <td>${cd.cdNo}</td>
				            <td>${cd.cdName}</td> 
                			<td>${cd.cdAuthor}</td>
                			<td>${cd.cdPrice}</td>
                			<td>${cd.cdNum}</td>
                			<td>${cd.cdType}</td>
               				<td>${cd.cdLocation}</td>

               				<td>
                    
               					<a class="btn" href="/cdmanagement/cd/findAllCd?admin=false&startIndex=0">租赁</a>          
               					<a class="btn" href="/cdmanagement/log/cancelReserveCd?cdNo=${cd.cdNo}">取消</a>                           	
                        	</td>
                        	
               			</tr>
           			 </c:forEach>
                </tbody>
                
            </table>
            
        </div>
        
    </div>
</body>
</html>