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
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="dialog" href="info.do?method=addInput" title="发布信息"><span>发布信息</span></a></li>
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" href="demo/common/ajaxDone.html" class="delete"><span>批量删除</span></a></li>
		</ul>
	</div>
	<table class="table" width="70%" layoutH="138">
		<thead>
			<tr>
			<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
            <th width="45%" height="18">标题</th>
            <th width="24%" height="18">发布时间</th>
            <th width="20%" height="18">发布人</th>
            <th width="10%" height="18">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${!empty pm.datas}">
				<c:forEach items="${pm.datas}" var="info">
					<tr>
			            <td>
			              <input name="selectFlag" type="checkbox" value="${info.id}" />
			            </td>
			            <td><a target="dialog" href="info.do?method=show&id=${info.id}">${info.title}</a></td>
			            <td><fmt:formatDate value="${info.time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td>${info.publisher.person.name}</td>
			            <td>
							<a title="删除" target="ajaxTodo" class="btnDel" href="info.do?method=del&id=${info.id }">删除</a>
							<a title="编辑" target="dialog" class="btnEdit" href="info.do?method=updateInput&id=${info.id}">编辑</a>
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