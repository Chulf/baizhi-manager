package com.jeecg.service.impl.baizhimanager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.service.baizhimanager.BUserServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("bUserService")
@Transactional
public class BUserServiceImpl extends CommonServiceImpl implements BUserServiceI {
	
}