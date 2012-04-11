<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='style/reset.css' />
	<link rel='stylesheet' type='text/css' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/start/jquery-ui.css' />
	<link rel='stylesheet' type='text/css' href='style/jquery.weekcalendar.css' />
	<link rel='stylesheet' type='text/css' href='style/demo.css' />
	
	<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js'></script>
	<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/jquery-ui.min.js'></script>
	<script type='text/javascript' src='script/jquery.weekcalendar.js'></script>
	<script type='text/javascript' src='script/demo.js'></script>

</head>
<body> 
	<center>
	<h1><font color="red">我的工作日程</font></h1>
	</center>
	<div id='calendar'></div>
	<div id="event_edit_container">
		<form>
			<input type="hidden" />
			<ul>
				<li>
					<span>日期: </span><span class="date_holder"></span> 
				</li>
				<li>
					<label for="start">开始时间: </label><select name="start"><option value="">选择开始时间</option></select>
				</li>
				<li>
					<label for="end">结束时间: </label><select name="end"><option value="">选择结束时间</option></select>
				</li>
				<li>
					<label for="title">标题: </label><input type="text" name="title" />
				</li>
				<li>
					<label for="body">内容: </label><textarea name="body"></textarea>
				</li>
			</ul>
		</form>
	</div>
</body>
</html>
