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
 * 基础信息
 * 实体类
 *
 * @author Blade
 * @since 2020-12-15
 */
@Data
@TableName("TB_PERSON")
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Person对象", description = "基础信息")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 人物主ID
	 */
	@ApiModelProperty(value = "人物主ID")
	@TableId("ID")
	private BigDecimal id;
	/**
	 * 姓名
	 */
	@ApiModelProperty(value = "姓名")
	@TableField("NAME")
	private String name;
	/**
	 * 姓名
	 */
	@ApiModelProperty(value = "姓名")
	@TableField("SEX")
	private BigDecimal sex;
	/**
	 * 从业日期
	 */
	@ApiModelProperty(value = "从业日期")
	@TableField("START_DATE")
	private String startDate;
	/**
	 * 现任机构主ID
	 */
	@ApiModelProperty(value = "现任机构主ID")
	@TableField("ORG_ID")
	private BigDecimal orgId;
	/**
	 * 当前职位
	 */
	@ApiModelProperty(value = "当前职位")
	@TableField("POSITION")
	private String position;
	/**
	 * 职业背景
	 */
	@ApiModelProperty(value = "职业背景")
	@TableField("PRO_BACKGROUND")
	private String proBackground;
	/**
	 * 毕业院校
	 */
	@ApiModelProperty(value = "毕业院校")
	@TableField("GRAD_SCHOOL")
	private String gradSchool;
	/**
	 * 最高学历
	 */
	@ApiModelProperty(value = "最高学历")
	@TableField("MAX_EDUCATION")
	private String maxEducation;
	/**
	 * 人物介绍
	 */
	@ApiModelProperty(value = "人物介绍")
	@TableField("PROFILE")
	private String profile;
	/**
	 * 个人荣誉
	 */
	@ApiModelProperty(value = "个人荣誉")
	@TableField("PERSONAL_HONOR")
	private String personalHonor;

	/**
	 * 头像
	 */
	@ApiModelProperty(value = "头像")
	@TableField("AVATAR_URL")
	private String avatarUrl;

}
