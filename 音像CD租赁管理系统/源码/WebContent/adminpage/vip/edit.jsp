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

        	    <a class="btn-add" href="/cdmanagement/vip/toAddVipPage">添加</a>
	            <form action="/cdmanagement/vip/updateVip" class="form" method="post">
	
		            <div>
	                    <input type="hidden"  class="form-input" name="originalVipNo" value="${originalVipNo}"/>
	                </div>
	                
	                <div>
	                	会员号
	                    <input type="number"  class="form-input" name="no" value="${vip.no}"/>
	                </div>
	                <div>
	                	姓名
	                    <input type="text" class="form-input" name="name" value="${vip.name}"/>
	                </div>
	                <div>
	                	年龄
	                    <input type="text" class="form-input" name="age" value="${vip.age}"/>
	                </div>
	               <div>
	               		性别
	                    <input type="text" class="form-input" name="sex" value="${vip.sex}"/>
	                </div>
	                <div>
	                	电话
	                    <input type="text" class="form-input" name="tel" value="${vip.telephone}"/>
	                </div>
	                 <div>
	                  	职业
	                  	<select name="major" class="form-input">
	                    	<c:forEach items="${allMajor}" var="major">
	                        	<option value="${major.name}" ${major.name == vip.major ?  "selected" :""}>${major.name}</option>
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