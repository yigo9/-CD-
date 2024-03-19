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
        
            <table class="table">
            
                <thead>
                    <tr>
                        <th>会员号</th>
                        <th>姓名</th>
                        <th>年龄</th>
                        <th>性别</th>
                        <th>手机号</th>
                        <th>职业</th>
                        <th>所欠金额</th>
                        <th>操作</th>
                    </tr>
                </thead>
                
                <tbody>
                
                	 <c:forEach items="${allFineInfo}" var="fineInfo">
       					 <tr>
				            <td>${fineInfo.vipNo}</td>
				            <td>${fineInfo.vipName}</td> 
                			<td>${fineInfo.vipAge}</td>
                			<td>${fineInfo.vipSex}</td>
                			<td>${fineInfo.vipTelephone}</td>
                			<td>${fineInfo.vipMajor}</td>   
                			<td>${fineInfo.fineMoney}</td>   
		                	<td><a class="btn" href="/cdmanagement/admin/urgeOneUserPayback?vipNo=${fineInfo.vipNo}">催促</a></td>
               			</tr>
           			 </c:forEach>
           			 
                </tbody>
                
            </table>
            
        </div>
        
    </div>
</body>
</html>