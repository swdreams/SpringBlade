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
 * 被执行人实体类
 *
 * @author Blade
 * @since 2020-12-16
 */
@Data
@TableName("TB_ORG_COURT_EXECUTE")
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "OrgCourtExecute对象", description = "被执行人")
public class OrgCourtExecute implements Serializable {

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
    @TableField("FILLING_DATE")
  private String fillingDate;
    /**
     * 案号
     */
    @ApiModelProperty(value = "案号")
    @TableField("CASE_NO")
  private String caseNo;
    /**
     * 执行标的
     */
    @ApiModelProperty(value = "执行标的")
    @TableField("SUBJECT")
  private String subject;
    /**
     * 执行法院
     */
    @ApiModelProperty(value = "执行法院")
    @TableField("COURT")
  private String court;
    /**
     * 身份证号/组织机构代码
     */
    @ApiModelProperty(value = "身份证号/组织机构代码")
    @TableField("ORG_CODE")
  private String orgCode;
  @TableField("ID")
  private BigDecimal id;


}
