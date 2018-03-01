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
		      <label class="Validform_label">用户外键:</label>
		      <input class="inputxt" id="userid" name="userid" ignore="ignore"   value="${orderPage.userid}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">产品类型:</label>
		      <input class="inputxt" id="type" name="type" ignore="ignore"   value="${orderPage.type}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">需求书:</label>
		      <input class="inputxt" id="demand" name="demand" ignore="ignore"   value="${orderPage.demand}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">页面数:</label>
		      <input class="inputxt" id="number" name="number" ignore="ignore"   value="${orderPage.number}" />
		      <span class="Validform_checktip"></span>
		    </div>
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
		      <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="time" name="time" ignore="ignore"     value="<fmt:formatDate value='${orderPage.time}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">关于项目的简单描述:</label>
		      <input class="inputxt" id="description" name="description" ignore="ignore"   value="${orderPage.description}" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>