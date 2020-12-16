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

import com.baomidou.mybatisplus.annotation.TableName;
import org.springblade.core.mp.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 立案信息
 * 实体类
 *
 * @author Blade
 * @since 2020-12-16
 */
@Data
@TableName("TB_ORG_COURT_FILLING")
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "OrgCourtFilling对象", description = "立案信息")
public class OrgCourtFilling implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 机构主ID
	 */
	@ApiModelProperty(value = "机构主ID")
	@TableField("ORG_ID")
	private BigDecimal orgId;
	/**
	 * 立案日期
	 */
	@ApiModelProperty(value = "立案日期")
	@TableField("FILING_DATE")
	private String filingDate;
	/**
	 * 案号
	 */
	@ApiModelProperty(value = "案号")
	@TableField("CASE_NO")
	private String caseNo;
	/**
	 * 原告
	 */
	@ApiModelProperty(value = "原告")
	@TableField("PLAINTIFF")
	private String plaintiff;
	/**
	 * 被告
	 */
	@ApiModelProperty(value = "被告")
	@TableField("DEFENDANT")
	private String defendant;
	/**
	 * 受理法院
	 */
	@ApiModelProperty(value = "受理法院")
	@TableField("ACCEPT_COURT")
	private String acceptCourt;
	/**
	 * 开庭日期
	 */
	@ApiModelProperty(value = "开庭日期")
	@TableField("OPEN_DATE")
	private String openDate;
	/**
	 * 结束日期
	 */
	@ApiModelProperty(value = "结束日期")
	@TableField("END_DATE")
	private String endDate;
	/**
	 * 承办法官
	 */
	@ApiModelProperty(value = "承办法官")
	@TableField("ACCEPT_STAFF")
	private String acceptStaff;
	/**
	 * 助理法官
	 */
	@ApiModelProperty(value = "助理法官")
	@TableField("ASSISTANT")
	private String assistant;
	@TableField("ID")
	private BigDecimal id;


}
