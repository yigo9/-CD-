<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="/cdmanagement/static/css/base.css">
    <link rel="stylesheet" href="/cdmanagement/static/css/inner.css">
    <link rel="stylesheet" href="/cdmanagement/static/fonts/iconfont.css">
    <link rel="shortcut icon" href="/cdmanagement/static/img/bitbug_favicon.ico">
    
</head>

<body>

	<%@ include file="/common-bars/topbar.jsp" %>
	
    <div class="main">
    
   		<%@ include file="/common-bars/adminsidebar.jsp" %>
   	
        <div class="right" style="width: 1211px;">
        
            <table class="table">
                <thead>
                    <tr>
                        <th>CD编号</th>
                        <th>CD名称</th>
                        <th>作者</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>所属CD架</th>
                        <th>简介</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                
                	 <c:forEach items="${allCd}" var="cd">
       					 <tr>
				            <td>${cd.no}</td>
				            <td>${cd.name}</td> 
                			<td>${cd.author}</td>
                			<td>${cd.price}</td>
                			<td>${cd.num}</td>
                			<td>${cd.shelf}</td>
               				<td>${cd.remark}</td>
               				<td>
                            	<a class="btn" href="/cdmanagement/cd/toEditCdPage?originalCdNo=${cd.no}">编辑</a>
                            	<a class="btn" href="/cdmanagement/cd/deleteCdByNo?cdNo=${cd.no}">删除</a>
                        	</td>
               			</tr>
           			 </c:forEach>
           			 
                </tbody>
            </table>
            
        </div>
        
         <div class="cut">
            <ul>
                <li><a href="/cdmanagement/cd/findAllCd?admin=true&startIndex=0">1</a></li>
                <li><a href="/cdmanagement/cd/findAllCd?admin=true&startIndex=9">2</a></li>
                <li><a href="/cdmanagement/cd/findAllCd?admin=true&startIndex=18">3</a></li>
                <li><a href="/cdmanagement/cd/findAllCd?admin=true&startIndex=27">4</a></li>
                <li><a href="/cdmanagement/cd/findAllCd?admin=true&startIndex=36">5</a></li>
        	</ul>
    	</div>
        
    </div>
</body>
</html>
