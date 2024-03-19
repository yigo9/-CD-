<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="../static/css/base.css">
    <link rel="stylesheet" href="../static/css/inner.css">
    <link rel="stylesheet" href="../static/fonts/iconfont.css">
    <link rel="shortcut icon" href="../static/img/bitbug_favicon.ico">
</head>
<body>
	
	<%@ include file="/common-bars/topbar.jsp" %>
	
    <div class="main">
    
    	<%@ include file="/common-bars/adminsidebar.jsp" %>

        <div class="right bg">
        
         	<p>亲爱的管理员，欢迎来到CD管理系统管理界面</p>
         	<p>在这里您可以对会员，CD，CD架，会员职业，会员所拥有的权限进行相应的增删查改操作</p>
         	<p>您可以点击罚账单来查询所有用户的罚款情况</p>
         	<p>若对某个会员迟迟不还歀而困扰，您可以点击催促按钮来给他发送一封催款邮件</p>
         	<p>您可以下达通知，下达的通知有字数限制，在255字之内，所有会员的邮箱都会接收到此通知</p>
         	<p>您可以点击会员反馈来查看该系统所有会员的反馈信息</p>

        </div>
    </div>
</body>
</html>