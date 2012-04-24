<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<link href="style/oa.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="script/public.js"></script>
		<title>添加角色信息</title>
	</head>
	<body>
		<center>
			<form action="role.do" method="post">
				<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0"
					style="width: 580px;">
					<TBODY>
						<form action="workflow.do" method="post" enctype="multipart/form-data">
							<input type="hidden" name="method" value="add">
							<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
							  <tr>
							    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
							      <tr>
							        <td width="15" height="30"><img src="images/tab_03.gif" width="15" height="30" /></td>
							        <td width="1101" background="images/tab_05.gif"><img src="images/311.gif" width="16" height="16" /> <span class="STYLE4">添加或重新上传流程定义文件和图片</span></td>
							        <td width="14"><img src="images/tab_07.gif" width="14" height="30" /></td>
							      </tr>
							    </table></td>
							  </tr>
							  <tr>
							    <td>
							    <table width="100%" border="0" cellspacing="0" cellpadding="0">
							      <tr>
							        <td width="9" background="images/main_38.gif" rowspan="1"></td>
							        <td bgcolor="#f3ffe3">
							          <tr height="26" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">请选择上传的流程定义文件：<input type="file" name="processDefinition"></div></tr>
							          <tr height="26" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">请选择上传的流程定义图片：<input type="file" name="processImage"></div></tr>
							          <tr height="26" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1"><input type="submit" name="submit1" value="上传"></div></tr>
							        </td>
							    </table>
							    </td>
							  </tr>
							</table>
						</form>
					</TBODY>
				</TABLE>

				<TABLE>
					<TR align="center">
						<TD colspan="3" bgcolor="#EFF3F7">
							<input type="submit" name="saveButton" class="MyButton"
								value="保存角色信息">
							<input type="button" class="MyButton" value="关闭窗口" onclick="window.close();">
						</TD>
					</TR>
				</TABLE>
			</form>
		</center>
	</body>
</html>