<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030" />
<title>无标题文档</title>
<link type="text/css" href="style/jquery-ui-1.8.7.custom.css" />
<link type="text/css" href="style/jquery.ui.theme.css" />
<script type="text/javascript" src="script/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="script/jquery-ui-1.8.7.custom.min.js"></script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE2 {
	color: #43860c;
	font-size: 12px;
}

a:link {
	font-size: 12px;
	text-decoration: none;
	color: #43860c;
}

a:visited {
	font-size: 12px;
	text-decoration: none;
	color: #43860c;
}

a:hover {
	font-size: 12px;
	text-decoration: none;
	color: #FF0000;
}
-->
</style>
<script type="text/JavaScript">
$(document).ready(function() {
		$("#accordion").accordion({
			animated: "slide",
			autoHeight: true,
			clearStyle: false,
			collapsible: false,
			event: "click",
			fillSpace: false,
			header : "h3"
		});
	});
</script>
</head>

<body>
	<div id="accordion">
		<c:forEach items="${modules}" var="m">
			<c:if test="${empty m.parent}">
				<div>
					<h3>
						<a href="#">${m.name}</a>
					</h3>
					<div>
						<c:if test="${!empty m.children}">
							<c:forEach items="${m.children}" var="s">
								<div>
									<a href="${s.url}" target="I1">${s.name}</a>
								</div>
							</c:forEach>
						</c:if>
					</div>
				</div>
			</c:if>
		</c:forEach>
	</div>
</body>
</html>
