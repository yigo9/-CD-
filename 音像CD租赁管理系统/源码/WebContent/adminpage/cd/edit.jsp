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

        	    <a class="btn-add" href="/cdmanagement/cd/toAddCdPage">添加</a>
	            <form action="/cdmanagement/cd/updateCd" class="form" method="post">
	            	            
	            	<div>
	                    <input type="hidden"  class="form-input" name="originalCdNo" value="${originalCdNo}"/>
	                </div>
	
	                <div>
	                	CD名
	                    <input type="text"  class="form-input" name="no" value="${cd.no}"/>
	                </div>
	                <div>
	                	CD号
	                    <input type="text" class="form-input" name="name" value="${cd.name}"/>
	                </div>
	                <div>
	                	作者
	                    <input type="text" class="form-input" name="author" value="${cd.author}"/>
	                </div>
	               <div>
	               		价格
	                    <input type="text" class="form-input" name="price" value="${cd.price}"/>
	                </div>
	                <div>
	                	数量
	                    <input type="text" class="form-input" name="num" value="${cd.num}"/>
	                </div>
	                 <div>
	                  	CD架
	                  	<select name="shelf" class="form-input">
	                    	<c:forEach items="${allCdshelf}" var="cdshelf">
	                        	<option value="${cdshelf.no}" ${cd.shelf == cdshelf.no ?  "selected" :""}>${cdshelf.no}</option>
	                        </c:forEach>
	                    </select>
	                </div>
	               <div>
	                	简介
	                    <input type="text" class="form-input" name="remark" value="${cd.remark}"/>
	                </div>
	                <div>
	                    <input type="submit" class="btn" value="修改">
	                </div>
	 
	            </form>

            
        </div>
        
    </div>
</body>
</html>
