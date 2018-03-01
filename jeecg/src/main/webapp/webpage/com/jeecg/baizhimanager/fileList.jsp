<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="fileList" title="文件表" actionUrl="fileController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="文件名称" field="filename"   width="120"></t:dgCol>
   <t:dgCol title="上传时间" field="uploadtime" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="用户外键" field="userid"   width="120"></t:dgCol>
   <t:dgCol title="文件保存地址" field="fileurl"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="150"></t:dgCol>
   <t:dgDelOpt title="删除" url="fileController.do?del&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgDefOpt title="下载" url="fileController.do?download&fileurl={fileurl}&filename={filename}" urlclass="ace_button" />
   <t:dgToolBar title="录入" icon="icon-add" url="fileController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="fileController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="fileController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
<script>

</script>