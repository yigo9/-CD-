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
    
   		<%@ include file="/common-bars/vipsidebar.jsp" %>
   				
        <div class="right bg">
        
         	<p>亲爱的会员${sessionScope.vipName}，欢迎来到音像CD管理系统</p>
         	<p>您的个人信息&nbsp;&nbsp;&nbsp;&nbsp;会员号 : ${sessionScope.vipNo} &nbsp;&nbsp;&nbsp;&nbsp; 职业: ${sessionScope.vipMajor}</p>
         	<p>在这里您可以点击侧边栏进行相应的查询，预约CD等相关操作</p>
         	<p>如果您预约了CD，CD的数量不为0的时刻我们会通知您，但不会自动帮你抢，需要你自行前往租赁</p>
         	<p>您可以发送信息到我店指定的会员账号绑定的用户，前提是他在本系统中已经注册过账户</p>
         	<p>如果您因为过期未还CD而欠款，可点击罚款记录进行查询</p>
         	<p>如果您因为没有还款而点击了刷新按钮，后台账户没有得到核实，会对您进行惩罚</p>
         	<p>如果对系统有什么意见或者见解，欢迎进行系统反馈</p>
         	<p>您可以在设置一栏中修改自己的密码</p>
         	
        </div>
    </div>
    
</body>
</html>
