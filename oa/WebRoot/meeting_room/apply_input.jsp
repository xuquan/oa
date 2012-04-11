<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<title>申请会议室</title>
</head>
<body>
<center>
<form action="meetingRoom.do" method="post">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- 这里是添加、编辑界面的标题 -->
			<td align="center" class="tdEditTitle">申请会议室</TD>
		</TR>
		<TR>
			<td>
			<!-- 主输入域开始 -->

<input type="hidden" name="method" value="save">
<input type="hidden" name="applyId" value="${meetingRoomForm.applyId }">
<table class="tableEdit" style="width:580px;" cellspacing="0" border="0" cellpadding="0">
	<tr>
		<td class="tdEditLabel" >会议室编号</td>			
		<td class="tdEditContent"><input type="text" name="sn" value="${meetingRoomForm.sn }">
		</td>
		<td class="tdEditLabel" >申请原因</td>			
		<td class="tdEditContent"><input type="text" name="applyReason" value="${meetingRoomForm.applyReason }"></td>
	</tr>
	<tr>
		<td class="tdEditLabel" >起始时间</td>			
		<td class="tdEditContent">
		<input type="text" name="beginDate" value="<fmt:formatDate value="${meetingRoomForm.beginDate }" pattern="yyyy-M-d" />">
		<input type="text" style="width:20px" name="beginTime" value="${meetingRoomForm.beginTime }">
		</td>
		<td class="tdEditLabel" >结束时间</td>			
		<td class="tdEditContent">
		<input type="text" name="endDate" value="<fmt:formatDate value="${meetingRoomForm.endDate }" pattern="yyyy-M-d" />">
		<input type="text" style="width:20px" name="endTime" value="${meetingRoomForm.endTime }">
		</td>
	</tr>
	<tr>
		<td class="tdEditLabel" >申请状态</td>			
		<td class="tdEditContent">
		<select name="status">
			<option value="A" <c:if test="${meetingRoomForm.status eq 'A' }">selected</c:if>>申请</option>
			<option value="O" <c:if test="${meetingRoomForm.status eq 'O' }">selected</c:if>>占用</option>
		</select>
		</td>
		<td class="tdEditLabel" ></td>			
		<td class="tdEditContent">
		
		</td>
	</tr>
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
				class="MyButton" value="保存"> 
			<input type="button" class="MyButton"
				value="关闭窗口" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>