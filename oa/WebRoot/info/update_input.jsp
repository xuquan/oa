<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form action="info.do" method="post" enctype="multipart/form-data" onsubmit="return iframeCallback(this,dialogAjaxDone);">

<input type="hidden" name="method" value="update">
<input type="hidden" name="id" value="${info.id }">
<input type="hidden" name="userId" value="${login.id}">

<div class="pageFormContent" layouth="56" style="height: 205px; overflow: auto;">
	<p>
		<label>标题</label>
		<input type="hidden" name="UseFreq" value="">
		<input class="required valid" size="28" type="text" name="title" value="${info.title}">
	</p>
	<p>
		<label>内容</label>
		<textarea class="textInput" style="width:95%;height:150px;vertical-align: right;overflow:true; float: right;" name="content">
		${info.content}
		</textarea>
	</p>
</div>
<div class="formBar">
	<ul>
		<li>
			<div class="buttonActive">
				<div class="buttonContent">
					<button type="submit">提交</button>
				</div>
			</div>
		</li>
		<li>
			<div class="button">
				<div class="buttonContent">
					<button class="close" type="button">取消</button>
				</div>
			</div>
		</li>
	</ul>
</div>
</form>