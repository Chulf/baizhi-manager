<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>源</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="resourceController.do?save">
		<input id="id" name="id" type="hidden" value="${resourcePage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">手机号:</label>
		      <input class="inputxt" id="phone" name="phone" ignore="ignore"   value="${resourcePage.phone}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">邮箱:</label>
		      <input class="inputxt" id="email" name="email" ignore="ignore"   value="${resourcePage.email}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">地址:</label>
		      <input class="inputxt" id="address" name="address" ignore="ignore"   value="${resourcePage.address}" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>