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
package org.springblade.modeling.wrapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import org.springblade.core.mp.support.BaseEntityWrapper;
import org.springblade.core.tool.node.ForestNodeMerger;
import org.springblade.core.tool.node.INode;
import org.springblade.core.tool.utils.BeanUtil;
import org.springblade.modeling.entity.Bond;
import org.springblade.modeling.vo.BondVO;



/**
 * 债券基础信息

包装类,返回视图层所需的字段
 *
 * @author Blade
 * @since 2020-12-09
 */
public class BondWrapper extends BaseEntityWrapper<Bond, BondVO>  {

    public static BondWrapper build() {
        return new BondWrapper();
    }

    @Override
	public BondVO entityVO(Bond bond) {
		BondVO bondVO = BeanUtil.copy(bond, BondVO.class);

		return bondVO;
	}

}
