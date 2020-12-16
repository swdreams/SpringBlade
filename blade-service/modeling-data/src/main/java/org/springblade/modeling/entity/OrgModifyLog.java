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
 * 变更信息
实体类
 *
 * @author Blade
 * @since 2020-12-16
 */
@Data
@TableName("TB_ORG_MODIFY_LOG")
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "OrgModifyLog对象", description = "变更信息")
public class OrgModifyLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 变更信息
     */
    @ApiModelProperty(value = "变更信息")
    @TableField("ORG_ID")
  private BigDecimal orgId;
    /**
     * 变更日期
     */
    @ApiModelProperty(value = "变更日期")
    @TableField("MODIFY_DATE")
  private String modifyDate;
    /**
     * 变更项目
     */
    @ApiModelProperty(value = "变更项目")
    @TableField("SUBJECT")
  private String subject;
    /**
     * 变更前
     */
    @ApiModelProperty(value = "变更前")
    @TableField("MOD_BEFORE")
  private String modBefore;
    /**
     * 变更前
     */
    @ApiModelProperty(value = "变更前")
    @TableField("MOD_AFTER")
  private String modAfter;
  @TableField("ID")
  private BigDecimal id;


}
