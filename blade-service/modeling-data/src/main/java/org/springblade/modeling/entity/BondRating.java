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
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springblade.core.mp.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 债券评级信息
 * 实体类
 *
 * @author Blade
 * @since 2020-12-10
 */
@Data
@TableName("TB_BOND_RATING")
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "BondRating对象", description = "债券评级信息")
public class BondRating implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 债券代码
	 */
	@ApiModelProperty(value = "债券代码")
	@TableField("BOND_CODE")
	private String bondCode;
	/**
	 * 资产类型
	 */
	@ApiModelProperty(value = "资产类型")
	@TableField("ASSET_TYPE")
	private String assetType;
	/**
	 * 市场类型
	 */
	@ApiModelProperty(value = "市场类型")
	@TableField("MARKET_TYPE")
	private String marketType;
	/**
	 * 评级类型
	 */
	@ApiModelProperty(value = "评级类型")
	@TableField("RATE_TYPE")
	private Integer rateType;
	/**
	 * 评级日期
	 */
	@ApiModelProperty(value = "评级日期")
	@TableField("RATE_DATE")
	private String rateDate;
	/**
	 * 评级
	 */
	@ApiModelProperty(value = "评级")
	@TableField("LEVEL_VALUE")
	private String levelValue;
	/**
	 * 评级机构名称
	 */
	@ApiModelProperty(value = "评级机构名称")
	@TableField("RATE_ORG_NAME")
	private String rateOrgName;

	@TableField("ID")
	@JsonSerialize(using = ToStringSerializer.class)
	private BigDecimal id;

}
