<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>页面</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="pageController.do?save">
		<input id="id" name="id" type="hidden" value="${pagePage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">页面名称:</label>
		      <input class="inputxt" id="pagename" name="pagename" ignore="ignore"   value='${pagePage.pagename}' />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">英语字段:</label>
		      <input class="inputxt" id="english" name="english" ignore="ignore"   value='${pagePage.english}' />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">中文字段:</label>
		      <input class="inputxt" id="chinese" name="chinese" ignore="ignore"   value='${pagePage.chinese}' />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">german:</label>
		      <input class="inputxt" id="german" name="german" ignore="ignore"   value='${pagePage.german}' />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">状态码:</label>
		      <input class="inputxt" id="status" name="status" ignore="ignore"   value="${pagePage.status}" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>