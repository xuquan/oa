<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form action="workflow.do" method="post" enctype="multipart/form-data" target="dialog" onsubmit="return iframeCallback(this,dialogAjaxDone)">
<input type="hidden" name="method" value="add">
<input type="hidden" name="userId" value="${login.id}">

<div class="pageFormContent" layouth="56" style="height: 205px; overflow: auto;">
	<p>
		<label>添加或重新上传流程定义文件和图片</label>
	</p>
	<p>
	<p>
		<label>请选择上传的流程定义文件：</label>
		<input type="file" name="processDefinition">
	</p>
	<p>
	<p>
		<label>请选择上传的流程定义图片：</label>
		<input type="file" name="processImage">
	</p>
</div>
<div class="formBar">
	<ul>
		<li>
			<div class="buttonActive">
				<div class="buttonContent">
					<button type="submit">上传</button>
				</div>
			</div>
		</li>
		<li>
			<div class="button">
				<div class="buttonContent">
					<button class="close" type="button">关闭</button>
				</div>
			</div>
		</li>
	</ul>
</div>
</form>
