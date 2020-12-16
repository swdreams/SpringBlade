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

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springblade.modeling.entity.StockIndexFuture;
import org.springblade.modeling.vo.StockIndexFutureVO;
import org.springblade.modeling.mapper.StockIndexFutureMapper;
import org.springblade.modeling.service.IStockIndexFutureService;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 股指期货基货信息表
 服务实现类
 *
 * @author Blade
 * @since 2020-12-10
 */
@Service
public class StockIndexFutureServiceImpl extends ServiceImpl<StockIndexFutureMapper, StockIndexFuture> implements IStockIndexFutureService {

	@Override
	public IPage<StockIndexFutureVO> selectStockIndexFuturePage(IPage<StockIndexFutureVO> page, StockIndexFutureVO stockIndexFuture) {
		return page.setRecords(baseMapper.selectStockIndexFuturePage(page, stockIndexFuture));
	}

	@Override
	public boolean deleteLogic(@NotEmpty List<Long> ids) {
		return false;
	}
}
