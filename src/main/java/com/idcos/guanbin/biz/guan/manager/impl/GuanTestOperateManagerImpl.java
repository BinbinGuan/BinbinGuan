/**
 * 杭州云霁科技有限公司
 * http://www.idcos.com
 * Copyright (c) 2015-2017 All Rights Reserved.
 */
 
package com.idcos.guanbin.biz.guan.manager.impl;

import com.idcos.guanbin.biz.common.template.BusinessProcessCallbackAdator;
import com.idcos.guanbin.biz.common.template.BusinessProcessContext;
import com.idcos.guanbin.biz.common.template.BusinessProcessTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import com.idcos.cloud.core.common.biz.CommonResult;
import com.idcos.guanbin.biz.guan.manager.auto.GuanTestOperateManager;
import org.springframework.stereotype.Service;


/**
 * Manager实现类
 * <p>第一次由自动生成代码工具初始化，后续可以编辑，再次生成的时候不会进行覆盖</p>
 * @author GuanBin
 * @version v 1.1 2017-09-12 15:53:09 GuanBin Exp $
 */
@Service
public class GuanTestOperateManagerImpl implements GuanTestOperateManager {

    @Autowired
    private BusinessProcessTemplate businessProcessTemplate;
    
	@Override
	public CommonResult<?> delete( final String id){
	
		return businessProcessTemplate.process(new BusinessProcessCallbackAdator<Object>() {

            @Override
            public void checkParam(BusinessProcessContext context) {
            }

            @Override
            public void checkBusinessInfo(BusinessProcessContext context) {
            }

            @Override
            public Object doBusiness(BusinessProcessContext context) {
                return null;
            }
        });
        
	}
}
