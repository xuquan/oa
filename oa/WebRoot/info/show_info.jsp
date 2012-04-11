<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<title>公共信息</title>
</head>
<body>
<center>
<form action="info.do" method="post">
<p>
<p>
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<td>
			<!-- 主输入域开始 -->
			<table height="400" width="100%" border="0" cellspacing="0" cellpadding="20" class="settingtable">
				<h1 style="color: red">${info.title}</h1>
				<hr size="1" color="blue"/>
				<p></p>
				<tr>
					发布人：${info.publisher.person.name}&nbsp;&nbsp;&nbsp;
					日期：<fmt:formatDate value="${info.time}" pattern="yyyy年MM月dd日 HH:mm:ss"/>	
				</tr>
				<hr/>
				<p>
				<tr class="normal black" align="left">
					&nbsp;&nbsp;&nbsp;&nbsp;<font style="color: green;size: 40">${info.content}</front>
				</tr>
			</table>
			<!-- 主输入域结束 -->
			</td>
		</TR>
	</TBODY>
</TABLE>
</form>
</center>
</body>
</html>