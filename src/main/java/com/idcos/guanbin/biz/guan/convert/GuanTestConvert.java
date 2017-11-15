/**
 * 杭州云霁科技有限公司
 * http://www.idcos.com
 * Copyright (c) 2015-2017 All Rights Reserved.
 */
 
package com.idcos.guanbin.biz.guan.convert;

import com.idcos.gaunbin.dal.auto.dataobject.guan.GuanTestDO;
import com.idcos.guanbin.biz.common.template.ConvertFunction;
import org.springframework.stereotype.Service;
import com.idcos.guanbin.biz.guan.vo.GuanTestVO;


/**
 * GuanTestConvert对象转化类 , 第一次只是生成一个默认的convert
 * <p>第一次由自动生成代码工具初始化，后续可以编辑，再次生成的时候不会进行覆盖</p>
 * <p>这个类是泛型，需要你确定转化的target是什么，ConvertFunction中 Object 需要指定的是待转化为VO的对象class type，这里默认是Object</p>
 * @author GuanBin
 * @version GuanTestConvert.java,v 1.1 2017-09-12 15:53:09 GuanBin Exp $
 */
@Service
public class GuanTestConvert extends ConvertFunction<GuanTestDO,GuanTestVO> {

}