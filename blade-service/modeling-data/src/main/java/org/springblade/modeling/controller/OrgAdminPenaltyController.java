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
import org.springblade.modeling.entity.OrgAdminPenalty;
import org.springblade.modeling.vo.OrgAdminPenaltyVO;
import org.springblade.modeling.wrapper.OrgAdminPenaltyWrapper;
import org.springblade.modeling.service.IOrgAdminPenaltyService;
import org.springblade.core.boot.ctrl.BladeController;
import java.util.List;

/**
 * 行政处罚
 控制器
 *
 * @author Blade
 * @since 2020-12-16
 */
@RestController
@AllArgsConstructor
@RequestMapping("/orgAdminPenalty")
@Api(value = "行政处罚", tags = "行政处罚接口")
public class OrgAdminPenaltyController extends BladeController {

	private IOrgAdminPenaltyService orgAdminPenaltyService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
    @ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入orgAdminPenalty")
	public R<OrgAdminPenaltyVO> detail(OrgAdminPenalty orgAdminPenalty) {
		OrgAdminPenalty detail = orgAdminPenaltyService.getOne(Condition.getQueryWrapper(orgAdminPenalty));
		return R.data(OrgAdminPenaltyWrapper.build().entityVO(detail));
	}

	/**
	* 分页 行政处罚

	*/
	@GetMapping("/list")
    @ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入orgAdminPenalty")
	public R<IPage<OrgAdminPenaltyVO>> list(OrgAdminPenalty orgAdminPenalty, Query query) {
		IPage<OrgAdminPenalty> pages = orgAdminPenaltyService.page(Condition.getPage(query), Condition.getQueryWrapper(orgAdminPenalty));
		return R.data(OrgAdminPenaltyWrapper.build().pageVO(pages));
	}

	/**
	* 自定义分页 行政处罚

	*/
	@GetMapping("/page")
    @ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入orgAdminPenalty")
	public R<IPage<OrgAdminPenaltyVO>> page(OrgAdminPenaltyVO orgAdminPenalty, Query query) {
		IPage<OrgAdminPenaltyVO> pages = orgAdminPenaltyService.selectOrgAdminPenaltyPage(Condition.getPage(query), orgAdminPenalty);
		return R.data(pages);
	}

	/**
	* 新增 行政处罚

	*/
	@PostMapping("/save")
    @ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入orgAdminPenalty")
	public R save(@Valid @RequestBody OrgAdminPenalty orgAdminPenalty) {
		return R.status(orgAdminPenaltyService.save(orgAdminPenalty));
	}

	/**
	* 修改 行政处罚

	*/
	@PostMapping("/update")
    @ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入orgAdminPenalty")
	public R update(@Valid @RequestBody OrgAdminPenalty orgAdminPenalty) {
		return R.status(orgAdminPenaltyService.updateById(orgAdminPenalty));
	}

	/**
	* 新增或修改 行政处罚

	*/
	@PostMapping("/submit")
    @ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入orgAdminPenalty")
	public R submit(@Valid @RequestBody OrgAdminPenalty orgAdminPenalty) {
		return R.status(orgAdminPenaltyService.saveOrUpdate(orgAdminPenalty));
	}

	
	/**
	* 删除 行政处罚

	*/
	@PostMapping("/remove")
    @ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(orgAdminPenaltyService.deleteLogic(Func.toLongList(ids)));
	}

	
}
