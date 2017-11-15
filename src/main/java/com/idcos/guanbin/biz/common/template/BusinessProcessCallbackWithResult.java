/**
 * 杭州云霁科技有限公司
 * http://www.idcos.com
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.idcos.guanbin.biz.common.template;

import com.idcos.guanbin.biz.common.template.BusinessProcessContext;

import com.idcos.cloud.core.common.biz.CommonResult;
import com.idcos.guanbin.biz.common.template.BusinessProcessContext;
import com.idcos.guanbin.biz.common.template.CommonBizException;

/**
 * 把外部的result参数传递过来，方便对result返回结果进行自定义,特殊情况下使用
 * @author yanlv
 * @version $Id: BusinessProcessCallbackWithResult.java, v 0.1 2015年6月5日 下午1:06:46 yanlv Exp $
 */
public interface BusinessProcessCallbackWithResult<T> {

    /**
     * 检查参数信息，如果失败，抛出<code>CommonBizException</code>异常
     */
    public void checkParam(BusinessProcessContext context, CommonResult<T> result);

    /**
     * 检查参数信息，如果失败，抛出<code>CommonBizException</code>异常
     */
    public void checkBusinessInfo(BusinessProcessContext context, CommonResult<T> result);

    /**
     * 做相关的业务处理，提供事务相关的支持,如果失败，抛出<code>CommonBizException</code>异常
     */
    public T doBusiness(BusinessProcessContext context, CommonResult<T> result);

    /**
     * 发生异常的时候处理方式
     * @param exception 异常信息
     * @param context 上下文信息
     */
    public void exceptionProcess(CommonBizException exception, BusinessProcessContext context,
                                 CommonResult<T> result);

}
