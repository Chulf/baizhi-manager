package com.jeecg.controller.baizhimanager;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeecg.entity.baizhimanager.BUserEntity;
import com.jeecg.service.baizhimanager.BUserServiceI;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.jeecg.entity.baizhimanager.OrderEntity;
import com.jeecg.service.baizhimanager.OrderServiceI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;

import java.util.Map;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

/**   
 * @Title: Controller
 * @Description: 订单
 * @author zhangdaihao
 * @date 2018-02-01 18:27:51
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/orderController")
public class OrderController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(OrderController.class);

	@Autowired
	private OrderServiceI orderService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private BUserServiceI bUserService;


	/**
	 * 订单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/baizhimanager/orderList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(OrderEntity order,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(OrderEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, order, request.getParameterMap());
		this.orderService.getDataGridReturn(cq, true);
		List results = dataGrid.getResults();

		//防止查询过后在更新数据库数据
		systemService.getSession().clear();
		for (Object result : results) {
			OrderEntity oe = (OrderEntity)result;
			if(oe.getType().equals("0")){oe.setType("WEB");}
			if(oe.getType().equals("1")){oe.setType("APP");}
			if(oe.getType().equals("2")){oe.setType("其他软件");}
			BUserEntity entity = bUserService.getEntity(BUserEntity.class, oe.getUserid());
			oe.setUserid(entity.getUsername());
		}
		//dataGrid.setResults(results);
		TagUtil.datagrid(response, dataGrid);

	}

	/**
	 * 删除订单
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(OrderEntity order, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		order = systemService.getEntity(OrderEntity.class, order.getId());
		message = "订单删除成功";
		orderService.delete(order);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加订单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(OrderEntity order, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(order.getId())) {
			message = "订单更新成功";
			OrderEntity t = orderService.get(OrderEntity.class, order.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(order, t);
				orderService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "订单更新失败";
			}
		} else {
			message = "订单添加成功";
			orderService.save(order);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 订单列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(OrderEntity order, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(order.getId())) {
			order = orderService.getEntity(OrderEntity.class, order.getId());
			req.setAttribute("orderPage", order);
		}
		return new ModelAndView("com/jeecg/baizhimanager/order");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<OrderEntity> list() {
		List<OrderEntity> listOrders=orderService.getList(OrderEntity.class);
		return listOrders;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		OrderEntity task = orderService.get(OrderEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody OrderEntity order, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<OrderEntity>> failures = validator.validate(order);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		orderService.save(order);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = order.getId();
		URI uri = uriBuilder.path("/rest/orderController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody OrderEntity order) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<OrderEntity>> failures = validator.validate(order);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		orderService.saveOrUpdate(order);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		orderService.deleteEntityById(OrderEntity.class, id);
	}
}
