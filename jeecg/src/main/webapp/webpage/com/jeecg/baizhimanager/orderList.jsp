<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
    function detail2(title,url, id,width,height) {
	
	var rowsData = $('#'+id).datagrid('getSelections');
	
//	if (rowData.id == '') {
//		tip('请选择查看项目');
//		return;
//	}
	
	if (!rowsData || rowsData.length == 0) {
		tip('请选择查看项目');
		return;
	}
	if (rowsData.length > 1) {
		tip('请选择一条记录再查看');
		return;
	}

    url += '&load=detail&username='+rowsData[0].userid;
	createdetailwindow(title,url,width,height);
}
</script>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="orderList" title="订单" actionUrl="orderController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="用户外键" field="userid"   width="120" url="bUserController.do?addorupdate"  funname="detail2('查看','bUserController.do?addorupdate','orderList')"></t:dgCol>
   <t:dgCol title="产品类型" field="type"   width="120"></t:dgCol>
   <t:dgCol title="需求书" field="demand"   width="120"></t:dgCol>
   <t:dgCol title="页面数" field="number"   width="120"></t:dgCol>
   <t:dgCol title="价格" field="price"   width="120"></t:dgCol>
   <t:dgCol title="订单状态" field="state"   width="120"></t:dgCol>
   <t:dgCol title="下单时间" field="time" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="关于项目的简单描述" field="description"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>

   <t:dgDelOpt title="删除" url="orderController.do?del&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="orderController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="orderController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="orderController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>

 