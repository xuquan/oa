<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>公文审批历史</title>
</head>
<body>
<logic:empty name="historys">
<font color="red" size="15">没有审批历史记录！</font>
</logic:empty>
<logic:notEmpty name="historys">
<logic:iterate id="history" name="historys">
<hr>
<font color="red" size="5">&nbsp;&nbsp;审批人：<c:out value="${history.approver.person.name }"/></font><br>
<font color="red" size="5">审批时间：<fmt:formatDate value="${history.approveTime}" pattern="yyyy年MM月dd日  HH:mm:ss"/></font><br>
<font color="red" size="5">审批意见：<c:out value="${history.comment }"/></font><br>
<br>
</logic:iterate>
</logic:notEmpty>
</body>
</html>