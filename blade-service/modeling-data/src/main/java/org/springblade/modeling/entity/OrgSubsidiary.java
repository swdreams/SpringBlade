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
@TableName("TB_ORG_SUBSIDIARY")
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "OrgSubsidiary对象", description = "OrgSubsidiary对象")
public class OrgSubsidiary implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 机构主ID
	 */
	@ApiModelProperty(value = "机构主ID")
	@TableField("ORG_ID")
	private BigDecimal orgId;
	/**
	 * 机构名称
	 */
	@ApiModelProperty(value = "机构名称")
	@TableField("ORG_NAME")
	private String orgName;
	/**
	 * 负责人
	 */
	@ApiModelProperty(value = "负责人")
	@TableField("CHIEF_NAME")
	private String chiefName;
	/**
	 * 成立日期
	 */
	@ApiModelProperty(value = "成立日期")
	@TableField("ESTABLISH_DATE")
	private String establishDate;
	/**
	 * 状态
	 */
	@ApiModelProperty(value = "状态")
	@TableField("SUBSIDIARY_STATUS")
	private String subsidiaryStatus;
	/**
	 * 主ID
	 */
	@ApiModelProperty(value = "主ID")
	@TableId("ID")
	private BigDecimal id;


}
