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
import org.springblade.modeling.entity.OrgCourtFinal;
import org.springblade.modeling.vo.OrgCourtFinalVO;
import org.springblade.modeling.wrapper.OrgCourtFinalWrapper;
import org.springblade.modeling.service.IOrgCourtFinalService;
import org.springblade.core.boot.ctrl.BladeController;
import java.util.List;

/**
 * 终本案件
 控制器
 *
 * @author Blade
 * @since 2020-12-16
 */
@RestController
@AllArgsConstructor
@RequestMapping("/orgCourtFinal")
@Api(value = "终本案件", tags = "终本案件接口")
public class OrgCourtFinalController extends BladeController {

	private IOrgCourtFinalService orgCourtFinalService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
    @ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入orgCourtFinal")
	public R<OrgCourtFinalVO> detail(OrgCourtFinal orgCourtFinal) {
		OrgCourtFinal detail = orgCourtFinalService.getOne(Condition.getQueryWrapper(orgCourtFinal));
		return R.data(OrgCourtFinalWrapper.build().entityVO(detail));
	}

	/**
	* 分页 终本案件

	*/
	@GetMapping("/list")
    @ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入orgCourtFinal")
	public R<IPage<OrgCourtFinalVO>> list(OrgCourtFinal orgCourtFinal, Query query) {
		IPage<OrgCourtFinal> pages = orgCourtFinalService.page(Condition.getPage(query), Condition.getQueryWrapper(orgCourtFinal));
		return R.data(OrgCourtFinalWrapper.build().pageVO(pages));
	}

	/**
	* 自定义分页 终本案件

	*/
	@GetMapping("/page")
    @ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入orgCourtFinal")
	public R<IPage<OrgCourtFinalVO>> page(OrgCourtFinalVO orgCourtFinal, Query query) {
		IPage<OrgCourtFinalVO> pages = orgCourtFinalService.selectOrgCourtFinalPage(Condition.getPage(query), orgCourtFinal);
		return R.data(pages);
	}

	/**
	* 新增 终本案件

	*/
	@PostMapping("/save")
    @ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入orgCourtFinal")
	public R save(@Valid @RequestBody OrgCourtFinal orgCourtFinal) {
		return R.status(orgCourtFinalService.save(orgCourtFinal));
	}

	/**
	* 修改 终本案件

	*/
	@PostMapping("/update")
    @ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入orgCourtFinal")
	public R update(@Valid @RequestBody OrgCourtFinal orgCourtFinal) {
		return R.status(orgCourtFinalService.updateById(orgCourtFinal));
	}

	/**
	* 新增或修改 终本案件

	*/
	@PostMapping("/submit")
    @ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入orgCourtFinal")
	public R submit(@Valid @RequestBody OrgCourtFinal orgCourtFinal) {
		return R.status(orgCourtFinalService.saveOrUpdate(orgCourtFinal));
	}

	
	/**
	* 删除 终本案件

	*/
	@PostMapping("/remove")
    @ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(orgCourtFinalService.deleteLogic(Func.toLongList(ids)));
	}

	
}
