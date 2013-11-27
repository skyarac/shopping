<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单详细页面</title>
    
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
     此次购物订单信息如下:
		<table>
			<tr>
				<td>
					商品编号
				</td>
				<td>
					商品名称
				</td>
				<td>
					商品价格
				</td>
				<td>
					商品数量
				</td>
			</tr>
			<c:forEach items="${sessionScope.forder.sorders}" var="sorder">
				<tr>
					<td>
						${sorder.goods.gid}
					</td>
					<td>
						${sorder.sname}
					</td>
					<td>
						${sorder.sprice}
					</td>
					<td>
						${sorder.snumber}
					</td>
				</tr>
			</c:forEach>
		</table>
		<div>
			总价:${sessionScope.forder.ftotal}
		</div><br/>
		---------------------------------------------------------------------------<br/>
		配送信息填写:<br/>
		<form action="/shopping/ForderSer" method="post">
			收货人姓名:<input type="text" name="fname" value="${sessionScope.users.uname}" /><br/>
			电话:<input type="text" name="fphone" value="${sessionScope.users.uphone}" /><br/>
			邮件:<input type="text" name="femail" value="${sessionScope.users.uemail}" /><br/>
			邮编:<input type="text" name="fpost" value="${sessionScope.users.upost}" /><br/>
			送货地址:<input type="text" name="faddress" value="${sessionScope.users.uaddress }"><br/>
			留言:<input type="text" name="fremark" /><br/>
			<input type="submit" value="确认提交" /><br/>
			<input type="hidden" name="status" value="saveForder" />
		</form>
   </center>
  </body>
</html>
