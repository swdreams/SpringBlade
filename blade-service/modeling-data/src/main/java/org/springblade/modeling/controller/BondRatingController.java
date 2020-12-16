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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import javax.validation.Valid;

import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.modeling.entity.BondRating;
import org.springblade.modeling.vo.BondRatingVO;
import org.springblade.modeling.wrapper.BondRatingWrapper;
import org.springblade.modeling.service.IBondRatingService;
import org.springblade.core.boot.ctrl.BladeController;
import java.util.List;

/**
 * 债券评级信息
 控制器
 *
 * @author Blade
 * @since 2020-12-10
 */
@RestController
@AllArgsConstructor
@RequestMapping("/bondRating")
@Api(value = "债券评级信息", tags = "债券评级信息接口")
public class BondRatingController extends BladeController {

	private IBondRatingService bondRatingService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
    @ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入bondRating")
	public R<BondRatingVO> detail(BondRating bondRating) {
		BondRating detail = bondRatingService.getOne(Condition.getQueryWrapper(bondRating));
		return R.data(BondRatingWrapper.build().entityVO(detail));
	}

	/**
	* 分页 债券评级信息

	*/
	@GetMapping("/list")
    @ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入bondRating")
	public R<IPage<BondRatingVO>> list(BondRating bondRating, Query query) {
		IPage<BondRating> pages = bondRatingService.page(Condition.getPage(query), Condition.getQueryWrapper(bondRating));
		return R.data(BondRatingWrapper.build().pageVO(pages));
	}

	/**
	* 自定义分页 债券评级信息

	*/
	@GetMapping("/page")
    @ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入bondRating")
	public R<IPage<BondRatingVO>> page(BondRatingVO bondRating, Query query) {
		IPage<BondRatingVO> pages = bondRatingService.selectBondRatingPage(Condition.getPage(query), bondRating);
		return R.data(pages);
	}

	/**
	* 新增 债券评级信息

	*/
	@PostMapping("/save")
    @ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入bondRating")
	public R save(@Valid @RequestBody BondRating bondRating) {
		return R.status(bondRatingService.save(bondRating));
	}

	/**
	* 修改 债券评级信息

	*/
	@PostMapping("/update")
    @ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入bondRating")
	public R update(@Valid @RequestBody BondRating bondRating) {
		return R.status(bondRatingService.updateById(bondRating));
	}

	/**
	* 新增或修改 债券评级信息

	*/
	@PostMapping("/submit")
    @ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入bondRating")
	public R submit(@Valid @RequestBody BondRating bondRating) {
		return R.status(bondRatingService.saveOrUpdate(bondRating));
	}

	
	/**
	* 删除 债券评级信息

	*/
	@PostMapping("/remove")
    @ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(bondRatingService.deleteLogic(Func.toLongList(ids)));
	}

	
}
