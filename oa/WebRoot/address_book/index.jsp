<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>

<form id="pagerForm" method="post" action="#rel#">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="w_removeSelected.html" method="post">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>姓名：</label>
				<input type="text" name="keywords" value=""/>
			</li>
		</ul>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="dialog" href="addresslist.do?method=addInput" title="添加通讯录"><span>添加</span></a></li>
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" href="demo/common/ajaxDone.html" class="delete"><span>批量删除</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
			<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
            <th width="8%" height="18">姓名</th>
            <th width="14%" height="18">电子邮件</th>
            <th width="10%" height="18">手机号码</th>
           	<th width="12%" height="18">固定电话</th>
            <th width="8%" height="18">别名</th>
            <th width="7%" height="18">生日</th>
            <th width="13%" height="18">家庭住址</th>
            <th width="9%" height="18">公司名称</th>
            <th width="7%" height="18">备注</th>
            <th width="6%" height="18">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${!empty pm.datas}">
				<c:forEach items="${pm.datas}" var="addressBook">
					<tr>
			            <td>
			              <input name="selectFlag" type="checkbox" value="${addressBook.id}" />
			            </td>
			            <td>${addressBook.name}</td>
			            <td>${addressBook.email}</td>
			            <td>${addressBook.mobilePhone}</td>
			            <td>${addressBook.phs}</td>
						<td>${addressBook.nickName}</td>
						<td><fmt:formatDate value="${addressBook.birthday}" pattern="yyyy-MM-dd"/></td>
						<td>${addressBook.street}</td>
						<td>${addressBook.company}</td>           
			            <td>${addressBook.notes}</td>
			            <td>
							<a title="删除" target="ajaxTodo" class="btnDel" href="addresslist.do?method=del&id=${addressBook.id }">删除</a>
							<a title="编辑" target="dialog" class="btnEdit" href="addresslist.do?method=updateInput&id=${addressBook.id}">编辑</a>
						</td>
          			</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty pm.datas}">
			   <tr>
			   	<td height="18" bgcolor="#FFFFFF" colspan="13">没有找到相应的记录</td>
			   </tr>
			</c:if>
		</tbody>
	</table>
	<div class="panelBar">
		<pg:pager url="addresslist.do" items="${pm.total}" export="currentPageNumber=pageNumber">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="20">20</option>
				<option value="50">50</option>
				<option value="100">100</option>
				<option value="200">200</option>
			</select>
			<span>条，共${pm.total}条</span>
		</div>
		<div class="pagination" targetType="navTab" totalCount="200" numPerPage="20" pageNumShown="10" currentPage="${currentPageNumber}"></div>
		</pg:pager>
	</div>
</div>
