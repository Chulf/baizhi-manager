<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>用户</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="bUserController.do?save">
		<input id="id" name="id" type="hidden" value="${bUserPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">用户名:</label>
		      <input class="inputxt" id="username" name="username" ignore="ignore"   value="${bUserPage.username}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">密码:</label>
		      <input class="inputxt" id="password" name="password" ignore="ignore"   value="${bUserPage.password}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">邮箱:</label>
		      <input class="inputxt" id="mail" name="mail" ignore="ignore"   value="${bUserPage.mail}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">手机号:</label>
		      <input class="inputxt" id="phone" name="phone" ignore="ignore"   value="${bUserPage.phone}" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>