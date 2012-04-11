<div dojoType="TreeBasicController" widgetId="treeController"></div>
<div dojoType="TreeSelector" widgetId="treeSelector" eventNames="select:nodeSelected" ></div>
<div dojoType="Tree" selector="treeSelector">
<#list orgs as org>
	
	<#include "tree_node.ftl">
	
</#list>
</div>