<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>订单</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="orderController.do?save">
		<input id="id" name="id" type="hidden" value="${orderPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">价格:</label>
		      <input class="inputxt" id="price" name="price" ignore="ignore"   value="${orderPage.price}" datatype="d" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">订单状态:</label>
		      <input class="inputxt" id="state" name="state" ignore="ignore"   value="${orderPage.state}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">下单时间:</label>
		      <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="time" name="time" ignore="ignore"  value="<fmt:formatDate value='${orderPage.time}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">关于项目的简单描述:</label>
		      <textarea name="description" style="width: 100% ;background-color:#f4f4f4" rows="6" >${orderPage.description}</textarea>
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>