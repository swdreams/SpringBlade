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

import com.baomidou.mybatisplus.annotation.TableName;
import org.springblade.core.mp.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 债券基础信息
 * <p>
 * 实体类
 *
 * @author Blade
 * @since 2020-12-09
 */
@Data
@TableName("TB_BOND")
@ApiModel(value = "Bond对象", description = "债券基础信息")
public class Bond implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 债券代码
	 */
	@ApiModelProperty(value = "债券代码")
	@TableId("BOND_CODE")
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
	 * 上海交易所代码
	 */
	@ApiModelProperty(value = "上海交易所代码")
	@TableField("SHANGHAI_CODE")
	private String shanghaiCode;
	/**
	 * 深圳交易所代码
	 */
	@ApiModelProperty(value = "深圳交易所代码")
	@TableField("SHENZEN_CODE")
	private String shenzenCode;
	/**
	 * 银行间市场代码
	 */
	@ApiModelProperty(value = "银行间市场代码")
	@TableField("BANK_CODE")
	private String bankCode;
	/**
	 * 托管场所
	 */
	@ApiModelProperty(value = "托管场所")
	@TableField("TRUSTEESHIP")
	private String trusteeship;
	/**
	 * 币种
	 */
	@ApiModelProperty(value = "币种")
	@TableField("MONEY_TYPE")
	private String moneyType;
	/**
	 * 债券名称
	 */
	@ApiModelProperty(value = "债券名称")
	@TableField("SEC_NAME")
	private String secName;
	/**
	 * 债券面值
	 */
	@ApiModelProperty(value = "债券面值")
	@TableField("FACE_VALUE")
	private Integer faceValue;
	/**
	 * 发行价格
	 */
	@ApiModelProperty(value = "发行价格")
	@TableField("PRICE")
	private Integer price;
	/**
	 * 发行日期
	 */
	@ApiModelProperty(value = "发行日期")
	@TableField("ISSUE_DATE")
	private String issueDate;
	/**
	 * 起息日期
	 */
	@ApiModelProperty(value = "起息日期")
	@TableField("DUE_DATE")
	private String dueDate;
	/**
	 * 到期日期
	 */
	@ApiModelProperty(value = "到期日期")
	@TableField("EXPIRE_DATE")
	private String expireDate;
	/**
	 * 息票类型
	 */
	@ApiModelProperty(value = "息票类型")
	@TableField("COUPON_TYPE")
	private String couponType;
	/**
	 * 发行机构
	 */
	@ApiModelProperty(value = "发行机构")
	@TableField("ISSUE_ORG")
	private String issueOrg;
	/**
	 * 债券类型
	 */
	@ApiModelProperty(value = "债券类型")
	@TableField("BOND_TYPE")
	private String bondType;
	/**
	 * 期限
	 */
	@ApiModelProperty(value = "期限")
	@TableField("TERMLIMIT")
	private Integer termlimit;


}
