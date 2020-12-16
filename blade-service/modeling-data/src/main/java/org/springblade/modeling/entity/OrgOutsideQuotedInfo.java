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
 * 机构外部引用信息
实体类
 *
 * @author Blade
 * @since 2020-12-16
 */
@Data
@TableName("TB_ORG_OUTSIDE_QUOTED_INFO")
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "OrgOutsideQuotedInfo对象", description = "机构外部引用信息")
public class OrgOutsideQuotedInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 机构主ID
     */
    @ApiModelProperty(value = "机构主ID")
    @TableField("ORG_ID")
  private BigDecimal orgId;
    /**
     * 引用类型
     */
    @ApiModelProperty(value = "引用类型")
    @TableField("QUOTED_TYPE")
  private BigDecimal quotedType;
    /**
     * 引用地址
     */
    @ApiModelProperty(value = "引用地址")
    @TableField("QUOTED_URL")
  private String quotedUrl;
    /**
     * 引用来源
     */
    @ApiModelProperty(value = "引用来源")
    @TableField("QUOTED_SOURCE")
  private String quotedSource;
  @TableField("ID")
  private BigDecimal id;


}
