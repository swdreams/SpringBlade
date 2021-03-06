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
 * 履历信息
 * 实体类
 *
 * @author Blade
 * @since 2020-12-15
 */
@Data
@TableName("TB_PERSON_HISTORY")
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "PersonHistory对象", description = "履历信息")
public class PersonHistory implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 人物主ID
	 */
	@ApiModelProperty(value = "人物主ID")
	@TableField("PERSON_ID")
	private BigDecimal personId;
	/**
	 * 时间
	 */
	@ApiModelProperty(value = "时间")
	@TableField("PER_DATE")
	private String perDate;
	/**
	 * 任职单位
	 */
	@ApiModelProperty(value = "任职单位")
	@TableField("ORG_UNIT")
	private String orgUnit;
	/**
	 * 任职部门
	 */
	@ApiModelProperty(value = "任职部门")
	@TableField("ORG_DEPARTMENT")
	private String orgDepartment;
	/**
	 * 职务
	 */
	@ApiModelProperty(value = "职务")
	@TableField("POSITION")
	private String position;
	/**
	 * PK
	 */
	@ApiModelProperty(value = "PK")
	@TableField("ID")
	private BigDecimal id;


}
