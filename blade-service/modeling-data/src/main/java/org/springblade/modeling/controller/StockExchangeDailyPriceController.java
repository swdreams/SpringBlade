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
package org.springblade.modeling.controller;

import io.swagger.annotations.*;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import lombok.AllArgsConstructor;
import javax.validation.Valid;

import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.modeling.entity.StockExchangeDailyPrice;
import org.springblade.modeling.vo.StockExchangeDailyPriceVO;
import org.springblade.modeling.wrapper.StockExchangeDailyPriceWrapper;
import org.springblade.modeling.service.IStockExchangeDailyPriceService;
import org.springblade.core.boot.ctrl.BladeController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

/**
 * 交易所证券日行情表
 控制器
 *
 * @author Blade
 * @since 2020-12-14
 */
@RestController
@AllArgsConstructor
@RequestMapping("/stock-history")
@Api(value = "交易所证券日行情表", tags = "交易所证券日行情表接口")
public class StockExchangeDailyPriceController extends BladeController {

	private IStockExchangeDailyPriceService stockExchangeDailyPriceService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
    @ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入stockExchangeDailyPrice")
	public R<StockExchangeDailyPriceVO> detail(StockExchangeDailyPrice stockExchangeDailyPrice) {
		StockExchangeDailyPrice detail = stockExchangeDailyPriceService.getOne(Condition.getQueryWrapper(stockExchangeDailyPrice));
		return R.data(StockExchangeDailyPriceWrapper.build().entityVO(detail));
	}

	/**
	* 分页 交易所证券日行情表

	*/
	@GetMapping("/list")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "finanInstrucode", value = "查询名称", paramType = "query", dataType = "string"),
		@ApiImplicitParam(name = "stockName", value = "股票名称", paramType = "query", dataType = "string"),
		@ApiImplicitParam(name = "excDate", value = "行情日期", paramType = "query", dataType = "string")
	})
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入stockExchangeDailyPrice")
	public R<IPage<StockExchangeDailyPriceVO>> list(@ApiIgnore @RequestParam Map<String, Object> stockExchangeDailyPrice, Query query) {
		IPage<StockExchangeDailyPrice> pages = stockExchangeDailyPriceService.page(Condition.getPage(query), Condition.getQueryWrapper(stockExchangeDailyPrice, StockExchangeDailyPrice.class));
		return R.data(StockExchangeDailyPriceWrapper.build().pageVO(pages));
	}

	/**
	* 自定义分页 交易所证券日行情表

	*/
	@GetMapping("/page")
    @ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入stockExchangeDailyPrice")
	public R<IPage<StockExchangeDailyPriceVO>> page(StockExchangeDailyPriceVO stockExchangeDailyPrice, Query query) {
		IPage<StockExchangeDailyPriceVO> pages = stockExchangeDailyPriceService.selectStockExchangeDailyPricePage(Condition.getPage(query), stockExchangeDailyPrice);
		return R.data(pages);
	}

	/**
	* 新增 交易所证券日行情表

	*/
	@PostMapping("/save")
    @ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入stockExchangeDailyPrice")
	public R save(@Valid @RequestBody StockExchangeDailyPrice stockExchangeDailyPrice) {
		return R.status(stockExchangeDailyPriceService.save(stockExchangeDailyPrice));
	}

	/**
	* 修改 交易所证券日行情表

	*/
	@PostMapping("/update")
    @ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入stockExchangeDailyPrice")
	public R update(@Valid @RequestBody StockExchangeDailyPrice stockExchangeDailyPrice) {
		return R.status(stockExchangeDailyPriceService.updateById(stockExchangeDailyPrice));
	}

	/**
	* 新增或修改 交易所证券日行情表

	*/
	@PostMapping("/submit")
    @ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入stockExchangeDailyPrice")
	public R submit(@Valid @RequestBody StockExchangeDailyPrice stockExchangeDailyPrice) {
		return R.status(stockExchangeDailyPriceService.saveOrUpdate(stockExchangeDailyPrice));
	}

	
	/**
	* 删除 交易所证券日行情表

	*/
	@PostMapping("/remove")
    @ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(stockExchangeDailyPriceService.deleteLogic(Func.toLongList(ids)));
	}

	
}
