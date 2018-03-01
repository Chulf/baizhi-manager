package com.jeecg.service.impl.baizhimanager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.service.baizhimanager.ResourceServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("resourceService")
@Transactional
public class ResourceServiceImpl extends CommonServiceImpl implements ResourceServiceI {
	
}