package com.jeecg.service.impl.baizhimanager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.service.baizhimanager.FileServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("fileService")
@Transactional
public class FileServiceImpl extends CommonServiceImpl implements FileServiceI {
	
}