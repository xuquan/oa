<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<title>������Ա��Ϣ</title>
</head>
<body>
<center>
<form action="person.do" method="post">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- ���������ӡ��༭����ı��� -->
			<td align="center" class="tdEditTitle">������Ա��Ϣ</TD>
		</TR>
		<TR>
			<td>
			<!-- ��������ʼ -->

<input type="hidden" name="method" value="add">
<table class="tableEdit" style="width:580px;" cellspacing="0" border="0" cellpadding="0">
	<tr>
		<td class="tdEditLabel" >��������</td>			
		<td class="tdEditContent"><input type="text" 
		id="orgNameId" disabled="disabled">
		<input type="hidden" name="orgId" id="orgIdId">
		<input type="button" value="ѡ��" 
		onclick="openWin('org.do?select=true','selectOrgs',800,600,1);">
		</td>
		<td class="tdEditLabel" >����</td>			
		<td class="tdEditContent"><input type="text" name="name"></td>
	</tr>
	<tr>
		<td class="tdEditLabel" >�Ա�</td>			
		<td class="tdEditContent"><input type="text" name="sex">
		</td>
		<td class="tdEditLabel" >�绰</td>			
		<td class="tdEditContent"><input type="text" name="phone">
		</td>
	</tr>
	<tr>
		<td class="tdEditLabel" >��ַ</td>			
		<td class="tdEditContent"><input type="text" name="address"></td>
		<td class="tdEditLabel" >����</td>			
		<td class="tdEditContent" colspan="3"><input type="text" name="description">
		</td>
	</tr>
</table>

			<!-- ����������� -->
			</td>
		</TR>
	</TBODY>
</TABLE>

<TABLE>
		<TR align="center">
			<TD colspan="3" bgcolor="#EFF3F7">
			<input type="submit" name="saveButton"
				class="MyButton" value="������Ա��Ϣ"> 
			<input type="button" class="MyButton"
				value="�رմ���" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>