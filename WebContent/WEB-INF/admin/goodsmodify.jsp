<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品编辑页面</title>
    
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
  
            商品编号：${param.gid}<br/>
   <form action="/shopping/AccountSer" method="post">
                   <input type="hidden" name="gid" value="${param.gid}"/><br/>
		              商品名称:<input type="text" name="gname" value="${param.gname}"/><br/>
		              商品图片:<input type="text" name="gpic" value="${param.gpic}"/><br/>
		               商品价格:<input type="text" name="gprice" value="${param.gprice}"/><br/>
		                商品描述:<input type="text" name="gremark" value="${param.gremark}"/><br/>
		                 详细描述:<input type="text" name="gxremark" value="${param.gxremark}"/><br/>
		                是否推荐:<input type="text" name="giscommend" value="${param.giscommend}"/><br/>
		                是否有效:<input type="text" name="gisopen" value="${param.gisopen}"/><br/>
		              类别编号:<input type="text" name="cid" value="${param.cid}"/><br/>
	                               提交:<input type="submit" value="提交"/><br/>
           <input type="hidden" name="status" value="goodsModify"><br/>
   </form>
   </center>
  </body>
</html>
