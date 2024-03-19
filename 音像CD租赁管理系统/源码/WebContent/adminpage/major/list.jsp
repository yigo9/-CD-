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
                        <th>职业编号</th>
                        <th>职业名称</th>
                        <th>拥有权限</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                
                	 <c:forEach items="${allMajor}" var="major">
       					 <tr>
				            <td>${major.no}</td>
				            <td>${major.name}</td> 
                			<td>${major.department}</td>

               				<td>
                            	<a class="btn" href="/cdmanagement/major/toEditMajorPage?originalMajorNo=${major.no}">编辑</a>
                            	<a class="btn" href="/cdmanagement/major/deleteMajorByNo?majorNo=${major.no}">删除</a>
                        	</td>
               			</tr>
           			 </c:forEach>
           			 
                </tbody>
            </table>
            
        </div>
       
        
    </div>
</body>
</html>