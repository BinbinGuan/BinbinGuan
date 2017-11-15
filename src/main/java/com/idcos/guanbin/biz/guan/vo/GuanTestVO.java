/**
 * 杭州云霁科技有限公司
 * http://www.idcos.com
 * Copyright (c) 2015-2017 All Rights Reserved.
 */

package com.idcos.guanbin.biz.guan.vo;

// auto generated imports
import com.idcos.cloud.core.common.BaseVO;

import java.util.Date;

/**
 * 返回结果对象 GuanTestVO
 * <p>第一次由自动生成代码工具初始化，后续可以编辑，再次生成的时候不会进行覆盖</p>
 * @author GuanBin
 * @version GuanTestVO.java,v 1.1 2017-09-12 15:53:09 GuanBin Exp $
 */

public class GuanTestVO extends BaseVO {

    private static final long serialVersionUID = 1L;

    private String            id;

    private String            projectId;

    private String            projectName;

    private String            resId;

    private String            totalPrice;

    private Date              gmtCreate;

    private Date              gmtModified;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
}