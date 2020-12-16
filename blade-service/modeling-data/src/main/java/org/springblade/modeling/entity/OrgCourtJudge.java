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
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 实体类
 *
 * @author Blade
 * @since 2020-12-16
 */
@Data
@TableName("TB_ORG_COURT_JUDGE")
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "OrgCourtJudge对象", description = "OrgCourtJudge对象")
public class OrgCourtJudge implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 机构主ID
	 */
	@ApiModelProperty(value = "机构主ID")
	@TableField("ORG_ID")
	private BigDecimal orgId;
	/**
	 * 日期
	 */
	@ApiModelProperty(value = "日期")
	@TableField("JUDGE_DATE")
	private String judgeDate;
	/**
	 * 案件名称
	 */
	@ApiModelProperty(value = "案件名称")
	@TableField("CASE_NAME")
	private String caseName;
	/**
	 * 案由
	 */
	@ApiModelProperty(value = "案由")
	@TableField("CASE_REASON")
	private String caseReason;
	/**
	 * 案件身份
	 */
	@ApiModelProperty(value = "案件身份")
	@TableField("CASE_STATUS")
	private String caseStatus;
	/**
	 * 案号
	 */
	@ApiModelProperty(value = "案号")
	@TableField("CASE_NO")
	private String caseNo;
	/**
	 * 原文地址
	 */
	@ApiModelProperty(value = "原文地址")
	@TableField("CASE_URL")
	private String caseUrl;
	@TableId("ID")
	private BigDecimal id;


}
