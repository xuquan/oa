<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<link rel='stylesheet' type='text/css' href='style/reset.css' />
	<link rel='stylesheet' type='text/css' href='style/jquery.weekcalendar.css' />
	<link rel='stylesheet' type='text/css' href='style/demo.css' />
	<script type='text/javascript' src='script/jquery.weekcalendar.js'></script>
	<script type='text/javascript' src='script/demo.js'></script>
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
