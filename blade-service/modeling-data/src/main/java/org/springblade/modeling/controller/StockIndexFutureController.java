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
import org.springblade.modeling.vo.BondVO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.modeling.entity.StockIndexFuture;
import org.springblade.modeling.vo.StockIndexFutureVO;
import org.springblade.modeling.wrapper.StockIndexFutureWrapper;
import org.springblade.modeling.service.IStockIndexFutureService;
import org.springblade.core.boot.ctrl.BladeController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

/**
 * 股指期货基货信息表
 控制器
 *
 * @author Blade
 * @since 2020-12-10
 */
@RestController
@AllArgsConstructor
@RequestMapping("/stockIndexFuture")
@Api(value = "股指期货基货信息表", tags = "股指期货基货信息表接口")
public class StockIndexFutureController extends BladeController {

	private IStockIndexFutureService stockIndexFutureService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
    @ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入stockIndexFuture")
	public R<StockIndexFutureVO> detail(StockIndexFuture stockIndexFuture) {
		StockIndexFuture detail = stockIndexFutureService.getOne(Condition.getQueryWrapper(stockIndexFuture));
		return R.data(StockIndexFutureWrapper.build().entityVO(detail));
	}

	/**
	* 分页 股指期货基货信息表

	*/
	@GetMapping("/list")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "finanInstrucode", value = "查询名称", paramType = "query", dataType = "string"),
		@ApiImplicitParam(name = "contractname", value = "合约名称", paramType = "query", dataType = "string")
	})
    @ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入stockIndexFuture")
	public R<IPage<StockIndexFutureVO>> list(@ApiIgnore @RequestParam Map<String, Object> stockIndexFuture, Query query) {
	//public R<IPage<StockIndexFutureVO>> list(StockIndexFuture stockIndexFuture, Query query) {
		IPage<StockIndexFuture> pages = stockIndexFutureService.page(Condition.getPage(query), Condition.getQueryWrapper(stockIndexFuture, StockIndexFuture.class));
		return R.data(StockIndexFutureWrapper.build().pageVO(pages));
	}

	/**
	* 自定义分页 股指期货基货信息表

	*/
	/*@GetMapping("/page")
    @ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入stockIndexFuture")
	public R<IPage<StockIndexFutureVO>> page(StockIndexFutureVO stockIndexFuture, Query query) {
		IPage<StockIndexFutureVO> pages = stockIndexFutureService.selectStockIndexFuturePage(Condition.getPage(query), stockIndexFuture);
		return R.data(pages);
	}*/

	/**
	* 新增 股指期货基货信息表

	*/
	@PostMapping("/save")
    @ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入stockIndexFuture")
	public R save(@Valid @RequestBody StockIndexFuture stockIndexFuture) {
		return R.status(stockIndexFutureService.save(stockIndexFuture));
	}

	/**
	* 修改 股指期货基货信息表

	*/
	@PostMapping("/update")
    @ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入stockIndexFuture")
	public R update(@Valid @RequestBody StockIndexFuture stockIndexFuture) {
		return R.status(stockIndexFutureService.updateById(stockIndexFuture));
	}

	/**
	* 新增或修改 股指期货基货信息表

	*/
	@PostMapping("/submit")
    @ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入stockIndexFuture")
	public R submit(@Valid @RequestBody StockIndexFuture stockIndexFuture) {
		return R.status(stockIndexFutureService.saveOrUpdate(stockIndexFuture));
	}

	
	/**
	* 删除 股指期货基货信息表

	*/
	@PostMapping("/remove")
    @ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(stockIndexFutureService.deleteLogic(Func.toLongList(ids)));
	}

	
}
