<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>����֧��ҳ��</title>
    
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
    ���Ķ������Ϊ:${sessionScope.forder.fid} Ҫ֧���ļ۸���${sessionScope.forder.ftotal}
	<br /> ��ѡ��Ҫ֧�������У�
	<br />
	<form action="/shopping/PaySer" method="post"></form>
	<table border="1">
		<tr>

			<c:forEach items="${applicationScope.fileNames}" var="fileName"
				varStatus="num">
				<td><input type="radio" value="${fn:substring(fileName,0,fn:indexOf(fileName,'.'))}" name="pd_FrpId" /> <img
					src="/shopping/image/bank/${fileName}" /></td>
				<c:if test="${num.count%5==0}">
		</tr>
		<tr>
			</c:if>
			</c:forEach>
		</tr>
	</table>
	<input type="hidden" value="${sessionScope.forder.fid}" name="p2_Order"/>
	<input type="hidden" value="${sessionScope.forder.ftotal}" name="p3_Amt"/>
	<input type="submit" value="ȷ��֧��" />
	<input type="hidden" value="pay" name="status"/>
	</form>
    </center>
  </body>
</html>
