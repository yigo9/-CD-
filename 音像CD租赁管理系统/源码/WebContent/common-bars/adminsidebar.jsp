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
                <li><a href="/cdmanagement/adminpage/welcome.jsp" class="icon-1"><span>首页</span></a></li>
                <li><a href="/cdmanagement/vip/findAllVip" class="icon-2"><span>会员管理</span></a></li>
                <li><a href="/cdmanagement/cd/findAllCd?admin=true&startIndex=0" class="icon-3"><span>CD管理</span></a></li>
                <li><a href="/cdmanagement/cdshelf/findAllCdshelf" class="icon-4"><span>CD架管理</span></a></li>
                <li><a href="/cdmanagement/major/findAllMajor" class="icon-5"><span>职业管理</span></a></li>
                <li><a href="/cdmanagement/department/findAllDepartment" class="icon-6"><span>权限管理</span></a></li>
                <li><a href="/cdmanagement/admin/findAllVipFineInfo" class="icon-7"><span>会员罚款账单</span></a></li>
                <li><a href="/cdmanagement/adminpage/givenotice.jsp"  class="icon-8"><span>下达通知</span></a></li>
                <li><a href="/cdmanagement/admin/toUserFeedbackPage" class="icon-9"><span>用户反馈</span></a></li>
                <li><a href="#" class="icon-10"><span>设置</span></a></li>
            </ul>
        </div>
</body>
</html>