<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>微调</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="spinnerController.do?save">
		<input id="id" name="id" type="hidden" value="${spinnerPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">source:</label>
		      <input class="inputxt" id="source" name="source" ignore="ignore"   value="${spinnerPage.source}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">options:</label>
		      <input class="inputxt" id="options" name="options" ignore="ignore"   value="${spinnerPage.options}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">price:</label>
		      <input class="inputxt" id="price" name="price" ignore="ignore"   value="${spinnerPage.price}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">sequence:</label>
		      <input class="inputxt" id="sequence" name="sequence" ignore="ignore"   value="${spinnerPage.sequence}" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>