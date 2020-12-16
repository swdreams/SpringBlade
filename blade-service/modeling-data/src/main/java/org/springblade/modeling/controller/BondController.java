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

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.*;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import lombok.AllArgsConstructor;
import javax.validation.Valid;

import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.constant.BladeConstant;
import org.springblade.core.tool.utils.Func;
import org.springblade.modeling.entity.BondRating;
import org.springblade.modeling.service.IBondRatingService;
import org.springblade.modeling.vo.BondRatingVO;
import org.springblade.modeling.wrapper.BondRatingWrapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.modeling.entity.Bond;
import org.springblade.modeling.vo.BondVO;
import org.springblade.modeling.wrapper.BondWrapper;
import org.springblade.modeling.service.IBondService;
import org.springblade.core.boot.ctrl.BladeController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

/**
 * 债券基础信息

 控制器
 *
 * @author Blade
 * @since 2020-12-09
 */
@RestController
@AllArgsConstructor
@RequestMapping("/bond")
@Api(value = "债券基础信息", tags = "债券基础信息接口")
public class BondController extends BladeController {

	private IBondService bondService;
	private IBondRatingService bondRatingService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
    @ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入bond")
	public R<BondVO> detail(Bond bond) {
		Bond detail = bondService.getOne(Condition.getQueryWrapper(bond));

		BondVO tmp = BondWrapper.build().entityVO(detail);
		tmp.setBondRatingList(bondRatingService.selectBondRatingList(detail.getBondCode()));
		return R.data(tmp);
	}

	/**
	* 分页 债券基础信息

	*/
	@GetMapping("/list")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "bondCode", value = "债券代码", paramType = "query", dataType = "string"),
		@ApiImplicitParam(name = "secName", value = "债券名称", paramType = "query", dataType = "string")
	})
    @ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入bond")
	public R<IPage<BondVO>> list(@ApiIgnore @RequestParam Map<String, Object> bond, Query query) {
		IPage<Bond> pages = bondService.page(Condition.getPage(query), Condition.getQueryWrapper(bond, Bond.class));
		return R.data(BondWrapper.build().pageVO(pages));
	}



	/**
	* 自定义分页 债券基础信息

	*/
	/*@GetMapping("/page")
    @ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入bond")
	public R<IPage<BondVO>> page(BondVO bond, Query query) {
		IPage<BondVO> pages = bondService.selectBondPage(Condition.getPage(query), bond);
		return R.data(pages);
	}*/

	/**
	* 新增 债券基础信息


	*/
	@PostMapping("/save")
    @ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入bond")
	public R save(@Valid @RequestBody Bond bond) {
		return R.status(bondService.save(bond));
	}

	/**
	* 修改 债券基础信息


	*/
	@PostMapping("/update")
    @ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入bond")
	public R update(@Valid @RequestBody Bond bond) {
		return R.status(bondService.updateById(bond));
	}

	/**
	* 新增或修改 债券基础信息


	*/
	@PostMapping("/submit")
    @ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入bond")
	public R submit(@Valid @RequestBody Bond bond) {
		return R.status(bondService.saveOrUpdate(bond));
	}

	
	/**
	* 删除 债券基础信息


	*/
	@PostMapping("/remove")
    @ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(bondService.deleteLogic(Func.toLongList(ids)));
	}

	
}
