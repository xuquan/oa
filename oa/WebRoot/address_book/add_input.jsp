<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form action="addresslist.do" method="post" target="dialog">

<input type="hidden" name="method" value="add">
<input type="hidden" name="userId" value="${login.id}">

<div class="pageFormContent" layouth="56" style="height: 205px; overflow: auto;">
	<p>
		<label>姓名</label>
		<input type="hidden" name="UseFreq" value="">
		<input class="required valid" size="28" type="text" name="name">
	</p>
	<p>
		<label>电子邮件</label>
		<input type="hidden" name="USEREMAILNAME" value="">
		<input class="required valid" size="28" type="text" name="email">
	</p>
	<p>
		<label>手机号码</label>
		<input type="text" size="28" name="mobilePhone">
	</p>
	<p>
		<label>固定电话</label>
		<input type="text" size="28" name="phs">
	</p>
	<p>
		<label>别名</label>
		<input type="text" size="28" name="nickName">
	</p>
	<p>
		<label>生日</label>
		<input type="text" class="date" size="28" name="birthday"><a class="inputDateButton" href="javascript:;">选择</a>
	</p>
	<p>
		<label>家庭住址</label>
		<input type="text" size="28" name="street">
	</p>
	<p>
		<label>公司名称</label>
		<input type="text" size="28" name="company">
	</p>
	<p>
		<label>备注</label>
		<input type="text" size="28" name="notes">
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
