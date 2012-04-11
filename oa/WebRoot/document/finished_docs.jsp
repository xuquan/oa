<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>公文管理</title>
<link href="style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE4 {
	font-size: 12px;
	color: #1F4A65;
	font-weight: bold;
}

a:link {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;

}
a:visited {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;
}
a:hover {
	font-size: 12px;
	color: #FF0000;
	text-decoration: underline;
}
a:active {
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.STYLE7 {font-size: 12}

-->
</style>

<script>
var  highlightcolor='#eafcd5';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(){
	source=event.srcElement;
	if(source.tagName=="TR"||source.tagName=="TABLE")
		return;
	while(source.tagName!="TD")
		source=source.parentElement;
	source=source.parentElement;
	cs  =  source.children;
	//alert(cs.length);
	if(cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
	for(i=0;i<cs.length;i++){
		cs[i].style.backgroundColor=highlightcolor;
	}
}

function  changeback(){
if(event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
	return;
if(event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
	for(i=0;i<cs.length;i++){
		cs[i].style.backgroundColor="";
	}
}

function  clickto(){
	source=event.srcElement;
	if(source.tagName=="TR"||source.tagName=="TABLE")
		return;
	while(source.tagName!="TD")
		source=source.parentElement;
	source=source.parentElement;
	cs  =  source.children;
//alert(cs.length);
	if(cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
		for(i=0;i<cs.length;i++){
			cs[i].style.backgroundColor=clickcolor;
		}
	else
		for(i=0;i<cs.length;i++){
			cs[i].style.backgroundColor="";
		}
}
</script>
</head>

<body>
<form id="orgForm">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="images/tab_03.gif" width="15" height="30" /></td>
        <td width="800" background="images/tab_05.gif"><img src="images/311.gif" width="16" height="16" /> <span class="STYLE4">公文管理->归档处理</span></td>
        <td width="400" background="images/tab_05.gif"><table border="0" align="right" cellpadding="0" cellspacing="0">
        </table></td>
        <td width="14"><img src="images/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="images/tab_12.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3"><table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#c0de98" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td width="6%" height="26" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">公文名称</div></td>
            <td width="8%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">公文描述</div></td>
            <td width="16%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">创建时间</div></td>
            <td width="14%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">公文状态</div></td>
            <td width="14%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">流程名称</div></td>
           	<td width="10%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">附件</div></td>
            <td width="14%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">审批历史</div></td>
          </tr>
          <c:if test="${!empty pm.datas}">
          <c:forEach items="${pm.datas}" var="document">
          <tr>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${document.title}</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${document.description}</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${document.createTime}</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${document.status}</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${document.workflow.name}</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">
           	<c:if test="${!empty document.content }">
          		<a href="document.do?method=download&id=${document.id}">下载</a>
        	</c:if></div>
	        </td>
	        <td height="18" bgcolor="#FFFFFF"><div align="center"><img src="images/037.gif" width="9" height="9" /><span class="STYLE1"> [</span><a href="#" onclick="openWin('document.do?method=approvedHistory&id=${document.id}','show',500,300)">查看</a><span class="STYLE1">]</span></div></td>
	        
	        <c:if test="${document.status eq 'new' }">
	        </c:if>
          </tr>
          </c:forEach>
          </c:if>
           <!-- 在列表数据为空的时候，要显示的提示信息 -->
		   <c:if test="${empty pm.datas}">
		   <tr>
		   	<td height="18" bgcolor="#FFFFFF" colspan="10"><div align="center" class="STYLE2 STYLE1">没有找到相应的记录</div></td>
		   </tr>
		   </c:if>
        </table></td>
        <td width="9" background="images/tab_16.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="29"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="images/tab_20.gif" width="15" height="29" /></td>
        <td background="images/tab_21.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
          	<pg:pager url="document.do" items="${pm.total}" export="currentPageNumber=pageNumber">
            <td width="25%" height="29" nowrap="nowrap">
            	<span class="STYLE1">
            		共${pm.total}条纪录，当前第
            		<pg:pages>
            			<c:choose>
            				<c:when test="${currentPageNumber eq pageNumber}">
            					<font color="red">${pageNumber}</font>
            				</c:when>
            			</c:choose>
            		</pg:pages>
            		页，每页10条纪录
            	</span>
            </td>
            <td width="75%" valign="top" class="STYLE1"><div align="right">
              <table width="352" height="20" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="62" height="22" valign="middle">
                  	<div align="right">
                  		<pg:first>
            				<a href="${pageUrl}"><img src="images/first.gif" width="37" height="15" /></a>
            			</pg:first>
                  	</div>
                  </td>
                  <td width="50" height="22" valign="middle">
                  	<div align="right">
                  		<pg:prev>
            				<a href="${pageUrl}"><img src="images/back.gif" width="43" height="15" /></a>
            			</pg:prev>
                  	</div>
                  </td>
                  <td width="54" height="22" valign="middle">
                  	<div align="right">
                  		<pg:next>
            				<a href="${pageUrl}"><img src="images/next.gif" width="43" height="15" /></a>
            			</pg:next>
                  	</div>
                  </td>
                  <td width="49" height="22" valign="middle">
                  	<div align="right">
                  		<pg:last>
            				<a href="${pageUrl}"><img src="images/last.gif" width="37" height="15" /></a>
            			</pg:last>
                  	</div>
                  </td>
                </tr>
              </table>
            </div>
            </td>
            </pg:pager>
          </tr>
        </table></td>
        <td width="14"><img src="images/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</html>
