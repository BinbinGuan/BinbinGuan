/**
 * 杭州云霁科技有限公司
 * http://www.idcos.com
 * Copyright (c) 2015-2017 All Rights Reserved.
 */

package com.idcos.guanbin.biz.guan.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idcos.cloud.biz.common.check.CommonParamtersChecker;
import com.idcos.cloud.core.common.biz.CommonResult;
import com.idcos.gaunbin.dal.auto.dao.guan.GuanTestDAO;
import com.idcos.gaunbin.dal.auto.dataobject.guan.GuanTestDO;
import com.idcos.guanbin.biz.common.template.BusinessQueryCallBack;
import com.idcos.guanbin.biz.common.template.BusinessQueryTemplate;
import com.idcos.guanbin.biz.guan.convert.GuanTestConvert;
import com.idcos.guanbin.biz.guan.manager.auto.GuanTestQueryManager;


/**
 * Manager实现类
 * <p>第一次由自动生成代码工具初始化，后续可以编辑，再次生成的时候不会进行覆盖</p>
 *
 * @author GuanBin
 * @version v 1.1 2017-09-12 15:53:09 GuanBin Exp $
 */
@Service
public class GuanTestQueryManagerImpl implements GuanTestQueryManager {

    @Autowired
    private BusinessQueryTemplate businessQueryTemplate;

    @Autowired
    private GuanTestDAO guanTestDAO;

    @Autowired
    private GuanTestConvert guanTestConvert;

    @Override
    public CommonResult<?> getAll() {
        return businessQueryTemplate.process(new BusinessQueryCallBack<Object>() {

            @Override
            public Object doQuery() {

                return "测试123456";
            }

            @Override
            public void checkParam() {

            }
        });
    }

    @Override
    public CommonResult<?> doError() {
        return null;
    }

    @Override
    public CommonResult<?> queryById(final String id) {

        return businessQueryTemplate.process(new BusinessQueryCallBack<Object>() {

            @Override
            public Object doQuery() {
                GuanTestDO guanTestDO = guanTestDAO.findOne(id);
                return guanTestConvert.apply(guanTestDO);
            }

            @Override
            public void checkParam() {
                CommonParamtersChecker.checkNotBlank(id);
            }
        });

    }



}