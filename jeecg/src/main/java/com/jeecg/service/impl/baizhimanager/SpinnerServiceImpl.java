package com.jeecg.service.impl.baizhimanager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.service.baizhimanager.SpinnerServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("spinnerService")
@Transactional
public class SpinnerServiceImpl extends CommonServiceImpl implements SpinnerServiceI {
	
}