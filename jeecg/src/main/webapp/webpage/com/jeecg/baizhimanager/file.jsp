<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>文件表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="fileController.do?save">
		<input id="id" name="id" type="hidden" value="${filePage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">文件名称:</label>
		      <input class="inputxt" id="filename" name="filename" ignore="ignore"   value="${filePage.filename}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">上传时间:</label>
		      <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="uploadtime" name="uploadtime" ignore="ignore"     value="<fmt:formatDate value='${filePage.uploadtime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">文件描述:</label>
		      <input class="inputxt" id="text" name="text" ignore="ignore"   value="${filePage.text}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">用户外键:</label>
		      <input class="inputxt" id="userid" name="userid" ignore="ignore"   value="${filePage.userid}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">文件保存地址:</label>
		      <input class="inputxt" id="fileurl" name="fileurl" ignore="ignore"   value="${filePage.fileurl}" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>