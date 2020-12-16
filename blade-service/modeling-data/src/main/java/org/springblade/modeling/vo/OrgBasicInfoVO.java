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
package org.springblade.modeling.vo;

import org.springblade.modeling.entity.OrgBasicInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 机构基础信息视图实体类
 *
 * @author Blade
 * @since 2020-12-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "OrgBasicInfoVO对象", description = "机构基础信息")
public class OrgBasicInfoVO extends OrgBasicInfo {
	private static final long serialVersionUID = 1L;

}
