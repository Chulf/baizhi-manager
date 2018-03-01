package com.jeecg.service.impl.baizhimanager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.service.baizhimanager.PageServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("pageService")
@Transactional
public class PageServiceImpl extends CommonServiceImpl implements PageServiceI {
	
}