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
                        <th>专业</th>
                        <th>操作</th>
                        <th>租赁信息</th>
                    </tr>
                </thead>
                <tbody>
                
                	 <c:forEach items="${allVip}" var="vip">
       					 <tr>
				            <td>${vip.no}</td>
				            <td>${vip.name}</td> 
                			<td>${vip.age}</td>
                			<td>${vip.sex}</td>
                			<td>${vip.telephone}</td>
                			<td>${vip.major}</td>   
                			<td>
                				<a class="btn" href="/cdmanagement/vip/toEditVipPage?originalVipNo=${vip.no}">编辑</a>
                				<a class="btn" href="/cdmanagement/vip/deleteVipByNo?vipNo=${vip.no}">删除</a>
                			</td>  	
                			<td>
                				<a class="btn" href="/cdmanagement/admin/findVipBorrowCdByNo?vipNo=${vip.no}">查看</a>
                			</td>			
               			</tr>
           			 </c:forEach>
           			 
                </tbody>
            </table>
            
        </div>
        
    </div>
</body>
</html>