package com.jeecg.controller.baizhimanager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeecg.entity.baizhimanager.BUserEntity;
import com.jeecg.entity.baizhimanager.OrderEntity;
import com.jeecg.service.baizhimanager.BUserServiceI;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
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

import com.jeecg.entity.baizhimanager.FileEntity;
import com.jeecg.service.baizhimanager.FileServiceI;

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
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

/**   
 * @Title: Controller
 * @Description: 文件表
 * @author zhangdaihao
 * @date 2018-02-01 18:27:25
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/fileController")
public class FileController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(FileController.class);

	@Autowired
	private FileServiceI fileService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private BUserServiceI bUserService;
	


	/**
	 * 文件表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/baizhimanager/fileList");
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
	public void datagrid(FileEntity file,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
			CriteriaQuery cq = new CriteriaQuery(FileEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, file, request.getParameterMap());
		this.fileService.getDataGridReturn(cq, true);
		List results = dataGrid.getResults();
	
		//防止jeecg查询过后在重新更改数据
		systemService.getSession().clear();
		
		for (Object result : results) {
			FileEntity fileEntity = (FileEntity)result;
			BUserEntity entity = bUserService.getEntity(BUserEntity.class, fileEntity.getUserid());
			fileEntity.setUserid(entity.getUsername());
		}
		TagUtil.datagrid(response, dataGrid);
	
	}

	/**
	 * 删除文件表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(FileEntity file, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		file = systemService.getEntity(FileEntity.class, file.getId());
		message = "文件表删除成功";
		fileService.delete(file);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加文件表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(FileEntity file, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(file.getId())) {
			message = "文件表更新成功";
			FileEntity t = fileService.get(FileEntity.class, file.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(file, t);
				fileService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "文件表更新失败";
			}
		} else {
			message = "文件表添加成功";
			fileService.save(file);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 文件表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(FileEntity file, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(file.getId())) {
			file = fileService.getEntity(FileEntity.class, file.getId());
			req.setAttribute("filePage", file);
		}
		return new ModelAndView("com/jeecg/baizhimanager/file");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<FileEntity> list() {
		List<FileEntity> listFiles=fileService.getList(FileEntity.class);
		return listFiles;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		FileEntity task = fileService.get(FileEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody FileEntity file, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<FileEntity>> failures = validator.validate(file);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		fileService.save(file);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = file.getId();
		URI uri = uriBuilder.path("/rest/fileController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody FileEntity file) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<FileEntity>> failures = validator.validate(file);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		fileService.saveOrUpdate(file);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		fileService.deleteEntityById(FileEntity.class, id);
	}

	@RequestMapping(params = "download")
public void download(String fileurl, String filename, HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String realPath = request.getSession().getServletContext().getRealPath("/");
//		File file = new File(realPath);
//		File parentFile = file.getParentFile();
//		String absolutePath = parentFile.getAbsolutePath();
//		String s = absolutePath + "/ROOT/file";
//		String extension = FilenameUtils.getExtension(fileurl);
//		String newUrl = s + fileurl;
//		String s1 = filename + "." + extension;
	File file1 = new File(fileurl);
	response.setContentType("text/xml");
	String newName = new String(filename.getBytes("utf-8"), "iso8859-1");
	response.setHeader("Content-Disposition", "attachment;filename=" + newName);
	ServletOutputStream outputStream = response.getOutputStream();
	outputStream.write(FileUtils.readFileToByteArray(file1));
}
}
