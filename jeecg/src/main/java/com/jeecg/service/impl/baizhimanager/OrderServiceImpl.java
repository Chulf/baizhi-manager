package com.jeecg.service.impl.baizhimanager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.service.baizhimanager.OrderServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("orderService")
@Transactional
public class OrderServiceImpl extends CommonServiceImpl implements OrderServiceI {
	
}