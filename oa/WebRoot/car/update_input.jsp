<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<title>修改车辆信息</title>
</head>
<body>
<center>
<form action="car.do" method="post">
<input type="hidden" name="method" value="update">
<input type="hidden" name="id" value="${car.id }">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- 这里是添加、编辑界面的标题 -->
			<td align="center" class="tdEditTitle">修改车辆</TD>
		</TR>
		<TR>
			<td>
			<!-- 主输入域开始 -->
			<table width="100%" border="0" cellspacing="0" cellpadding="4"
			class="settingtable">
			<tbody>
				<tr class="normal black">
					<td width="120" style="text-align: right;">
						车辆名称：
						<input type="hidden" name="UseFreq" value="">
					</td>
					<td align="left">
						<input type="text"  class="txt" size="28"
							name="name" value="${car.name}" />
						&nbsp;
						<font color="#FF0000">(*必填)</font>
					</td>
				</tr>
				<tr class="normal black">
					<td align="right">
						车牌号码：
					</td>
					<td align="left">
						<input type="text"  name="carNumber"
							class="txt noime" size="28" value="${car.carNumber}" />
						&nbsp;
						<font color="#FF0000">(*必填)</font>
						<input type="hidden" name="USEREMAILNAME" value="">
					</td>
				</tr>

			</tbody>

			<tbody id="extendInfo">
				<tr class="normal black">
					<td align="right">
						载客数量：
					</td>
					<td align="left">
						<input type="text"  name="carLoad"
							class="txt noime" size="28" value="${car.carLoad}" />
					</td>
				</tr>
			</tbody>
		</table>
			<!-- 主输入域结束 -->
			</td>
		</TR>
	</TBODY>
</TABLE>

<TABLE>
		<TR align="center">
			<TD colspan="3" bgcolor="#EFF3F7">
			<input type="submit" name="saveButton"
				class="MyButton" value="更新"> 
			<input type="button" class="MyButton"
				value="关闭窗口" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>