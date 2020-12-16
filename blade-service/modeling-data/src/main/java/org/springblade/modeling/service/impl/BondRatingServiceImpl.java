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
package org.springblade.modeling.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springblade.modeling.entity.Bond;
import org.springblade.modeling.entity.BondRating;
import org.springblade.modeling.vo.BondRatingVO;
import org.springblade.modeling.mapper.BondRatingMapper;
import org.springblade.modeling.service.IBondRatingService;
import org.springblade.modeling.wrapper.BondRatingWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 债券评级信息
 服务实现类
 *
 * @author Blade
 * @since 2020-12-10
 */
@Service
public class BondRatingServiceImpl extends ServiceImpl<BondRatingMapper, BondRating> implements IBondRatingService {

	@Override
	public IPage<BondRatingVO> selectBondRatingPage(IPage<BondRatingVO> page, BondRatingVO bondRating) {
		return page.setRecords(baseMapper.selectBondRatingPage(page, bondRating));
	}

	@Override
	public boolean deleteLogic(@NotEmpty List<Long> ids) {
		return false;
	}

	public List<BondRatingVO> selectBondRatingList(String bondCode)
	{
		return BondRatingWrapper.build().listVO(baseMapper.selectList(Wrappers.<BondRating>query().lambda().eq(BondRating::getBondCode, bondCode)));
	}
}
