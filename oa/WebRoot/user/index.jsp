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
			<li><a class="edit" href="demo_page4.html?uid={sid_user}" target="navTab" warn="请选择一个用户"><span>修改</span></a></li>
			<li><a class="delete" title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" href="demo/common/ajaxDone.html"><span>批量删除</span></a></li>
		</ul>
	</div>
	<table class="table" width="80%" layoutH="138">
		<thead>
			<tr>
			<th width="5%"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
            <th width="5%" height="18">序号</th>
            <th width="8%" height="18">姓名</th>
            <th width="5%" height="18">性别</th>
           	<th width="20%" height="18">所属机构</th>
           	<th width="6%" height="18">登录账号</th>
            <th width="8%" height="18">失效时间</th>
           	<th width="8%" height="18">绑定邮箱</th>
           	<th width="8%" height="18">分配账号</th>
           	<th width="8%" height="18">删除账号</th>
            <th width="8%" height="18">修改账号</th>
           	<th width="8%" height="18">分配角色</th>
            <th width="8%" height="18">用户授权</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${!empty pm.datas}">
				<c:forEach items="${pm.datas}" var="person">
					<tr>
			            <td>
			              <input name="selectFlag" type="checkbox" value="${person.id}" />
			            </td>
			            <td>${person.id}</td>
			            <td>${person.name}</td>
			            <td>${person.sex}</td>
			            <td>${person.org.name}</td>
			            <td>${person.user.username}</td>
			            <td><fmt:formatDate value="${person.user.expireTime}" pattern="yyyy-MM-dd"/></td>
			            <td><a href="user.do?method=bindingInput&id=${person.user.id}" title="编辑" target="dialog" class="btnEdit">绑定邮箱</a></td>
			            <td><a href="user.do?method=addInput&personId=${person.id}" title="编辑" target="dialog" class="btnEdit">分配账号</td>
			            <td><a onclick="del('user.do?method=delUser&id=${person.user.id}');" title="删除" target="ajaxTodo" class="btnDel">删除账号</td>
			            <td><a href="user.do?method=updateInput&id=${person.user.id}" title="编辑" target="dialog" class="btnEdit">修改账号</td>
			            <td><a href="user.do?method=userRoleList&id=${person.user.id}" title="编辑" target="dialog" class="btnEdit">分配角色</td>
			            <td><a href="acl.do?principalType=User&principalSn=${person.user.id}" title="编辑" target="dialog" class="btnEdit">用户授权</td>
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
		<pg:pager url="person.do" items="${pm.total}" export="currentPageNumber=pageNumber">
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
