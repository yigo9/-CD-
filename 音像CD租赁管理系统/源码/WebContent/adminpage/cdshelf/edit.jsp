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

        	    <a class="btn-add" href="/cdmanagement/cdshelf/toAddCdshelfPage">添加</a>
	            <form action="/cdmanagement/cdshelf/updateCdshelf" class="form" method="post">
	            
	            	<div>
	                    <input type="hidden"  class="form-input" name="originalCdshelfNo" value="${originalCdshelfNo}"/>
	                </div>
	            
	                <div>
	                	CD架编号
	                    <input type="text"  class="form-input" name="no" value="${cdshelf.no}"/>
	                </div>
	                <div>
						占地面积
	                    <input type="text" class="form-input" name="area" value="${cdshelf.area}"/>
	                </div>
	                <div>
	                	CD架位置
	                    <input type="text" class="form-input" name="location" value="${cdshelf.location}"/>
	                </div>
	               <div>
	               		CD架分类
	                    <input type="text" class="form-input" name="type" value="${cdshelf.type}"/>
	                </div>
	                <div>
	                	CD架简介
	                    <input type="text" class="form-input" name="remark" value="${cdshelf.remark}"/>
	                </div>
	                 
	                <div>
	                    <input type="submit" class="btn" value="修改">
	                </div>
	 
	            </form>
	            

            
        </div>
        
    </div>
</body>
</html>