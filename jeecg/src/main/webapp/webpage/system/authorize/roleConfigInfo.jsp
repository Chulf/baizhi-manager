<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>二级权限组管理添加更新</title>
<t:base type="jquery,easyui,tools"></t:base>

<style>
.table-form {
    width: 99.6%;
    font-size: 12px;
    margin: 2px auto;
}
table {
    border-spacing: 0;
    border-collapse: collapse;
}
.table-form tr th {
    width: 20%;
    height: 32px;
    background: #FBFBFF;
    color: #282831;
    padding: 0px 5px;
    text-align: right;
    border: 1px solid #EBECEF;
    font-weight: normal;
}
td, th {
    display: table-cell;
    vertical-align: inherit;
}
.table-form td {
    font-weight: normal;
    padding: 5px 5px;
    border: 1px solid #EBECEF;
}
td input {
	width : 156px !important;
}
</style>
<script>
//提交form重置zTree,校验部门,部门一对一授权组
function saveObj1() {
	var deptId = $("#deptId").val();
	var curId = $("#id").val();
	if(deptId == null && deptId == "") {
		tip("请选择部门");
		return false;	
	}
	$.ajax({
		url : "functionGroupController.do?checkDept",
		data : {
			"deptId":deptId,
			"curId":curId
		},
		type : "POST",
		success:function(data){
			var d = $.parseJSON(data);
			if(d.success) {
				$('#formobj').form('submit', {
					url : "functionGroupController.do?save",
					success : function(r) {
						$("#formobj", parent.loadTree());
						$("#formobj").find(":input").val("");
						$("#pid").val("${id}");
						$("#selectId").val("${id}");
						$("#pGroupName").val("${pGroupName}");
					}
				});
			}else {
				tip(d.msg);
			}
		},
		error:function(data) {
			var d = $.parseJSON(data);
			tip(d.msg);
		}
	});
}
</script>
</head>
<body style="overflow: hidden;" scroll="no">
<t:formvalid formid="formobj" layout="table" dialog="true" >
<c:set var="parentId" value="${functionGroup.pid}"></c:set>
<div class="datagrid-toolbar" <c:if test="${parentId eq '0'}">style="display:none"</c:if>>
	<a class="easyui-linkbutton l-btn l-btn-plain" onclick="saveObj1()">
		<i class="fa fa-plus"></i><span class="bigger-110 no-text-shadow"> 保  存</span>
	</a>
</div>
<input type="hidden" id="id" name="id" value="${functionGroup.id}"/>
<input type="hidden" id="selectId" name="selectId" value="${id}"/>
<input type="hidden" id="pid" name="pid" value="${functionGroup.pid}"/>
<input type="hidden" id="level" name="level" value="${functionGroup.level}"/>
	<table class="table-form" cellspacing="0">
		<tbody>
			<c:set var="curId" value="${functionGroup.id}"></c:set> 
			<tr <c:if test="${parentId eq '0'}"></c:if>>								
				<th style="width:350px;"><span>权限组名称:</span></th>
				<td class="ng-binding">
					<input type="text" name="groupName" id="groupName" value="${functionGroup.groupName }" <c:if test="${parentId eq '0'}"> readonly="readonly"</c:if> />
				</td>
			</tr>
			
			<tr <c:if test="${parentId ne '0'}"> style="display:none"</c:if>>
				<th><span>部门名称:</span></th>
				<td class="ng-binding">
					<input id="deptId" name="deptId" type="hidden" value="${functionGroup.deptId}">
					<input id="deptName" name="deptName" type="text" <c:if test="${parentId eq '0'}">onclick="javascript:void(0)" readonly="readonly"</c:if> value="${functionGroup.deptName}" onclick="openDepartmentSelect()">
				</td>
			</tr>
			<tr <c:if test="${parentId ne '0'}"> style="display:none"</c:if>>
				<th><span>部门编码:</span></th>
				<td class="ng-binding">
					<input type="text" name="deptCode" id="deptCode" value="${functionGroup.deptCode }" readonly="readonly"/>
				</td>
			</tr>
		</tbody>
	</table>
</t:formvalid>
</body>
</html>
