<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
	   <div class="left">
            <div class="title">M A I N</div>
            <ul>
                <li><a href="/cdmanagement/vippage/welcome.jsp" class="icon-1"><span>首页</span></a></li>
                <li><a href="/cdmanagement/cd/findAllCd?admin=false&startIndex=0" class="icon-2"><span>查询CD</span></a></li>
                <li><a href="/cdmanagement/cd/findCanReserveCd" class="icon-3"><span>预约CD</span></a></li>
                <li><a href="/cdmanagement/log/findAllBorrowCd" class="icon-4"><span>查已租赁</span></a></li>
                <li><a href="/cdmanagement/log/findFine" class="icon-5"><span>罚款记录</span></a></li>
                <li><a href="/cdmanagement/log/findAllReserveCd" class="icon-6"><span>查已预约</span></a></li>
                <li><a href="/cdmanagement/log/toSendLetterPage" class="icon-7"><span>发邮件</span></a></li>
                <li><a href="/cdmanagement/log/findAllMessage" class="icon-8"><span>收件箱</span></a></li>
                <li><a href="/cdmanagement/log/toSystemFeedbackPage" class="icon-9"><span>系统反馈</span></a></li>
                <li><a href="/cdmanagement/log/toEditPasswordPage" class="icon-10"><span>设置</span></a></li>
            </ul>
        </div>
</body>
</html>