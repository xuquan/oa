<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
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
				<label>机构名称：</label>
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
			<li><a class="add" target="dialog" href="org.do?method=addInput&parentId=${orgForm.parentId}"><span>添加</span></a></li>
			<li><a class="edit" href="demo_page4.html?uid={sid_user}" target="navTab" warn="请选择一个用户"><span>修改</span></a></li>
			<li><a class="delete" title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" href="demo/common/ajaxDone.html"><span>批量删除</span></a></li>
			<li><a href="org.do?parentId=${ppid}">返回</a></li>
		</ul>
	</div>
	<table class="table" width="80%" layoutH="138">
		<thead>
			<tr>
			<th width="8%"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
            <th width="8%" height="18">序号</th>
            <th width="30%" height="18">机构名称</th>
            <th width="14%" height="18">机构编号</th>
           	<th width="30%" height="18">父机构名称</th>
            <th width="10%" height="18">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${!empty pm.datas}">
				<c:forEach items="${pm.datas}" var="org">
					<tr>
			            <td>
			              <input name="selectFlag" type="checkbox" value="${org.id}" />
			            </td>
			            <td>${org.id}</td>
			            <td><a href="org.do?parentId=${org.id }">${org.name}</a></td>
			            <td>${org.sn}</td>
			            <td>${org.parent.name}</td>
			            <td>
							<a title="删除" target="ajaxTodo" class="btnDel" onclick="del('org.do?method=del&id=${org.id }');">删除</a>
							<a title="编辑" target="dialog" class="btnEdit" href="org.do?method=updateInput&id=${org.id}">编辑</a>
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
		<pg:pager url="org.do" items="${pm.total}" export="currentPageNumber=pageNumber">
		<pg:param name="parentId"/>
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
