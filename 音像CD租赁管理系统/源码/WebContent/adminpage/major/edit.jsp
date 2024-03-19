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

        <div class="right">
        	    <a class="btn-add" href="/cdmanagement/major/toAddMajorPage">添加</a>
	            <form action="/cdmanagement/major/updateMajor" class="form" method="post">
	            	<div>
	                    <input type="hidden"  class="form-input" name="originalMajorNo" value="${originalMajorNo}"/>
	                </div>
	            
	                <div>
	                	职业编号
	                    <input type="text"  class="form-input" name="no" value="${major.no}"/>
	                </div>
	                <div>
						职业名称
	                    <input type="text" class="form-input" name="name" value="${major.name}"/>
	                </div>
	                 <div>
	                  	拥有权限
	                  	<select name="department" class="form-input">
	                    	<c:forEach items="${allDepartment}" var="department">
	                        	<option value="${department.name}" ${department.name == major.department ?  "selected" :""}>${department.name}</option>
	                        </c:forEach>
	                    </select>
	                </div>
	   
	                 
	                <div>
	                    <input type="submit" class="btn" value="修改">
	                </div>
	 
	            </form>
	            

            
        </div>
        
    </div>
</body>
</html>