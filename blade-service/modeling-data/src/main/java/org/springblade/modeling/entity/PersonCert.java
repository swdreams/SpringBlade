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
 * 证书信息
 * 实体类
 *
 * @author Blade
 * @since 2020-12-15
 */
@Data
@TableName("TB_PERSON_CERT")
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "PersonCert对象", description = "证书信息")
public class PersonCert implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 人物主ID
	 */
	@ApiModelProperty(value = "人物主ID")
	@TableField("PERSON_ID")
	private BigDecimal personId;
	/**
	 * 证书编号
	 */
	@ApiModelProperty(value = "证书编号")
	@TableField("CERT_NUMBER")
	private String certNumber;
	/**
	 * 证书状态
	 */
	@ApiModelProperty(value = "证书状态")
	@TableField("CERT_STATUS")
	private String certStatus;
	/**
	 * 证书状态
	 */
	@ApiModelProperty(value = "证书类别")
	@TableField("CERT_TYPE")
	private String certType;
	/**
	 * 证书取得日期
	 */
	@ApiModelProperty(value = "证书取得日期")
	@TableField("CERT_DATE")
	private String certDate;
	/**
	 * 变更日期
	 */
	@ApiModelProperty(value = "变更日期")
	@TableField("CER_MODIFIED_DATE")
	private String cerModifiedDate;
	@TableId("ID")
	private BigDecimal id;


}
