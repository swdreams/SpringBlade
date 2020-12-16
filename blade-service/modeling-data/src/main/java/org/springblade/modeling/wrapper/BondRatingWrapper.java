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

import lombok.AllArgsConstructor;
import org.springblade.core.mp.support.BaseEntityWrapper;
import org.springblade.core.tool.utils.BeanUtil;
import org.springblade.core.tool.utils.Func;
import org.springblade.modeling.entity.BondRating;
import org.springblade.modeling.vo.BondRatingVO;

import java.util.HashMap;

/**
 * 债券评级信息
包装类,返回视图层所需的字段
 *
 * @author Blade
 * @since 2020-12-10
 */
public class BondRatingWrapper extends BaseEntityWrapper<BondRating, BondRatingVO>  {

	public static HashMap<Integer, String> ratingTypes = new HashMap<>();

	static {
		ratingTypes.put(1, "债项外部评级");
		ratingTypes.put(2, "发行人评级");
		ratingTypes.put(3, "债项隐含评级");
	}

    public static BondRatingWrapper build() {
        return new BondRatingWrapper();
    }

	@Override
	public BondRatingVO entityVO(BondRating bondRating) {
		BondRatingVO bondRatingVO = BeanUtil.copy(bondRating, BondRatingVO.class);
		bondRatingVO.setRateTypeName(ratingTypes.get(Func.toInt(bondRatingVO.getRateType())));
		return bondRatingVO;
	}

}
