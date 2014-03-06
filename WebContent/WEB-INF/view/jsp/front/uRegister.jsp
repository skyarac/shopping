<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户登录页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<center>
	用户注册界面
		<form action="/shopping/user/UserSer" method="post">
    	登录名:<input type="text" name="ulogin" id="ulogin"/><br/>
    	密码:<input type="password" name="upass" /><br />
    	真实姓名:<input type="text" name="uname"/><br />
    	性别:<input type="text" name="usex"/><br />
    	电话:<input type="text" name="uphone"/><br />
    	邮编:<input type="text" name="upost"/><br />
    	邮箱:<input type="text" name="uemail"/><br />
    	地址:<input type="text" name="uaddress"/><br />
    	${error}<br/>
    	<input type="submit" value="提交" />
    	<input type="hidden" name="status" value="register"/> 
    </form>
	</center>
</body>
</html>
