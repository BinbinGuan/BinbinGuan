package com.idcos.guanbin.biz.common.template;


/**
 * 业务处理上下文信息
 * @author yanlv
 * @version $Id: BusinessProcessContext.java, v 0.1 2015年3月22日 下午3:42:02 yanlv Exp $
 */
public interface BusinessQueryCallBack<T> {

    /**
     * 检查参数信息，是否满足查询条件
     */
    public void checkParam();

    /**
     * 进行查询相关的业务处理
     */
    public T doQuery();
}
