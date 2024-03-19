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
	            <form action="/cdmanagement/cd/insertCd" class="form" method="post">
	
	                <div>
	                	CD名
	                    <input type="text"  class="form-input" name="no" required="required" placeholder="xxx"/>
	                </div>
	                <div>
	                	CD号
	                    <input type="text" class="form-input" name="name" required="required"  placeholder="xxx"/>
	                </div>
	                <div>
	                	作者
	                    <input type="text" class="form-input" name="author" required="required"  placeholder="xxx"/>
	                </div>
	               <div>
	               		价格
	                    <input type="text" class="form-input" name="price" required="required"  placeholder="xxx"/>
	                </div>
	                <div>
	                	数量
	                    <input type="text" class="form-input" name="num" required="required"  placeholder="xxx"/>
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
	                    <input type="text" class="form-input" required="required"  name="remark" placeholder="xxx"/>
	                </div>
	                <div>
	                    <input type="submit" class="btn" value="确定">
	                </div>
	 
	            </form>

            
        </div>
        
    </div>
</body>
</html>