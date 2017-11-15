/**
 * yunjikeji Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.idcos.guanbin.biz.common.template;


/**
 * 业务处理回调默认的适配器
 * @author yanlv
 * @version $Id: BusinessProcessCallbackAdator.java, v 0.1 2015年3月22日 下午3:50:46 yanlv Exp $
 */
public abstract class BusinessProcessCallbackAdator<T> implements BusinessProcessCallback<T> {

    @Override
    public void checkParam(BusinessProcessContext context) {
    }

    @Override
    public void checkBusinessInfo(BusinessProcessContext context) {
    }

    @Override
    public abstract T doBusiness(BusinessProcessContext context);

    @Override
    public void exceptionProcess(CommonBizException exception, BusinessProcessContext context) {

    }

}
