/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.modeling.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springblade.core.mp.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 机构基础信息实体类
 *
 * @author Blade
 * @since 2020-12-05
 */
@Data
@TableName("TB_ORG_BASIC_INFO")
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "OrgBasicInfo对象", description = "机构基础信息")
public class OrgBasicInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 机构主ID
	 */
	@ApiModelProperty(value = "机构主ID")
	@TableId(value = "ORG_MAIN_ID", type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long orgMainId;
	/**
	 * 机构名称
	 */
	@ApiModelProperty(value = "机构名称")
	@TableField("ORG_NAME")
	private String orgName;
	/**
	 * 机构中文全称
	 */
	@ApiModelProperty(value = "机构中文全称")
	@TableField("ORG_NAME_CH_ALL")
	private String orgNameChAll;
	/**
	 * 机构英文全称
	 */
	@ApiModelProperty(value = "机构英文全称")
	@TableField("ORG_NAME_ENG_ALL")
	private String orgNameEngAll;
	/**
	 * 企业性质
	 */
	@ApiModelProperty(value = "企业性质")
	@TableField("ORG_NATURE")
	private String orgNature;
	/**
	 * 成立日期
	 */
	@ApiModelProperty(value = "成立日期")
	@TableField("ORG_INCORP_DATE")
	private String orgIncorpDate;
	/**
	 * 注册地址
	 */
	@ApiModelProperty(value = "注册地址")
	@TableField("ORG_REGISTER_ADDR")
	private String orgRegisterAddr;
	/**
	 * 注册资本(万元/人民币)
	 */
	@ApiModelProperty(value = "注册资本(万元/人民币)")
	@TableField("ORG_REGISTER_CAPITAL")
	private Double orgRegisterCapital;
	/**
	 * 实缴资本(万元/人民币)
	 */
	@ApiModelProperty(value = "实缴资本(万元/人民币)")
	@TableField("ORG_PAIDIN_CAPITAL")
	private Double orgPaidinCapital;
	/**
	 * 组织机构代码
	 */
	@ApiModelProperty(value = "组织机构代码")
	@TableField("ORG_ORG_CODE")
	private String orgOrgCode;
	/**
	 * 统一社会信用代码
	 */
	@ApiModelProperty(value = "统一社会信用代码")
	@TableField("ORG_UNIFIED_SOCIAL_CREDITCODE")
	private String orgUnifiedSocialCreditcode;
	/**
	 * 曾用名
	 */
	@ApiModelProperty(value = "曾用名")
	@TableField("ORG_NAME_BEFORE")
	private String orgNameBefore;
	/**
	 * 法人代表
	 */
	@ApiModelProperty(value = "法人代表")
	@TableField("ORG_LEGAL_PERSON")
	private String orgLegalPerson;
	/**
	 * 实际控制人
	 */
	@ApiModelProperty(value = "实际控制人")
	@TableField("ORG_REAL_CONTROLLER")
	private String orgRealController;
	/**
	 * 机构官网
	 */
	@ApiModelProperty(value = "机构官网")
	@TableField("ORG_OFFICAL_SITE_ADDR")
	private String orgOfficalSiteAddr;
	/**
	 * 联系电话
	 */
	@ApiModelProperty(value = "联系电话")
	@TableField("ORG_CONTACT_PHONE")
	private String orgContactPhone;
	/**
	 * 邮箱
	 */
	@ApiModelProperty(value = "邮箱")
	@TableField("ORG_CONTACT_MAIL")
	private String orgContactMail;
	/**
	 * 传真
	 */
	@ApiModelProperty(value = "传真")
	@TableField("ORG_CONTACT_FAX")
	private String orgContactFax;
	/**
	 * 机构状态
	 */
	@ApiModelProperty(value = "机构状态")
	@TableField("ORG_STATUS")
	private String orgStatus;
	/**
	 * 机构logo
	 */
	@ApiModelProperty(value = "机构logo")
	@TableField("ORG_LOGO_PATH")
	private String orgLogoPath;
	/**
	 * 机构logo
	 */
	@ApiModelProperty(value = "是否投顾资质")
	@TableField("ORG_INVEST_ENABLE")
	private String orgInvestEnable;
	/**
	 * 中基协登记编号
	 */
	@ApiModelProperty(value = "中基协登记编号")
	@TableField("ORG_CFA_REGNO")
	private String orgCfaRegno;
	/**
	 * 中基协登记日期
	 */
	@ApiModelProperty(value = "中基协登记日期")
	@TableField("ORG_CFA_REGDATE")
	private String orgCfaRegdate;
	/**
	 * 是否中基协会员
	 */
	@ApiModelProperty(value = "是否中基协会员")
	@TableField("ORG_CFA_MEMBERFLAG")
	private String orgCfaMemberflag;
	/**
	 * 中基协入会时间
	 */
	@ApiModelProperty(value = "中基协入会时间")
	@TableField("ORG_CFA_MEMBERDATE")
	private String orgCfaMemberdate;
	/**
	 * 中基协会员类型
	 */
	@ApiModelProperty(value = "中基协会员类型")
	@TableField("ORG_CFA_MEMBERTYPE")
	private String orgCfaMembertype;
	/**
	 * 中基协会员类型
	 */
	@ApiModelProperty(value = "中基协会员类型")
	@TableField("ORG_CFA_MEMBERLEGAL")
	private String orgCfaMemberlegal;

	/**
	 * 是否已删除
	 */
	@TableLogic
	@ApiModelProperty(value = "是否已删除")
	private Integer isDeleted;


}
