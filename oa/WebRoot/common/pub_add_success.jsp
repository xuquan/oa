<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<link href="style/oa.css" rel="stylesheet" type="text/css">
		<link href="style/win.css" rel="stylesheet" type="text/css">
		<script language="javascript">
			function closewindow(){
				if(window.opener){
					window.opener.location.reload(true);
					window.close();
				}
			}
			
			function clock(){
				i=i-1;
				if(document.getElementById("info")){
					document.getElementById("info").innerHTML="本窗口将在"+i+"秒后自动关闭";
				}
				if(i>0){
					setTimeout("clock();",1000);
				}else{
					closewindow();
				}
			}
			
			var i=4;
			clock();
		
		</script>
		<title>添加记录成功</title>
	</head>

	<body>
		<center>
			<font color="red" size="5">添加成功</font>
			<br />
			<div id="info">本窗口将在3秒后自动关闭</div>
			<input type="button" value="关闭窗口" onclick="window.close();">
		</center>
	</body>
</html>
