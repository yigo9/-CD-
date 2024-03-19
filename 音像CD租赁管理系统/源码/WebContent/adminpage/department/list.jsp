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
                        <th>超级会员编号</th>
                        <th>超级会员名称</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                
                	 <c:forEach items="${allDepartment}" var="department">
       					 <tr>
				            <td>${department.no}</td>
				            <td>${department.name}</td> 
               				<td>
                            	<a class="btn" href="/cdmanagement/department/toEditDepartmentPage?originalDepartmentNo=${department.no}">编辑</a>
                            	<a class="btn" href="/cdmanagement/department/deleteDepartmentByNo?departmentNo=${department.no}">删除</a>
                        	</td>
               			</tr>
           			 </c:forEach>
           			 
                </tbody>
            </table>
            
        </div>
       
        
    </div>
</body>
</html>