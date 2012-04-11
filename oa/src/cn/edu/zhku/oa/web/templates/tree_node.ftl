<div dojoType="TreeNode"  title="${org.name}" objectId="${org.id}">
	<#list org.children as org>
		<#include "tree_node.ftl">
	</#list>
</div>