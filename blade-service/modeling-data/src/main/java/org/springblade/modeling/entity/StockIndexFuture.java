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
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 股指期货基货信息表
实体类
 *
 * @author Blade
 * @since 2020-12-10
 */
@Data
@TableName("TB_STOCK_INDEX_FUTURE")
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "StockIndexFuture对象", description = "股指期货基货信息表")
public class StockIndexFuture implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 金融工具代码
     */
    @ApiModelProperty(value = "金融工具代码")
    @TableField("FINAN_INSTRUCODE")
  private String finanInstrucode;
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
     * 合约名称
     */
    @ApiModelProperty(value = "合约名称")
    @TableField("CONTRACTNAME")
  private String contractname;


}
