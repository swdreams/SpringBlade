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
import org.springblade.modeling.entity.OrgCourtExecute;
import org.springblade.modeling.vo.OrgCourtExecuteVO;
import org.springblade.modeling.wrapper.OrgCourtExecuteWrapper;
import org.springblade.modeling.service.IOrgCourtExecuteService;
import org.springblade.core.boot.ctrl.BladeController;
import java.util.List;

/**
 * 被执行人 控制器
 *
 * @author Blade
 * @since 2020-12-16
 */
@RestController
@AllArgsConstructor
@RequestMapping("/orgCourtExecute")
@Api(value = "被执行人", tags = "被执行人接口")
public class OrgCourtExecuteController extends BladeController {

	private IOrgCourtExecuteService orgCourtExecuteService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
    @ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入orgCourtExecute")
	public R<OrgCourtExecuteVO> detail(OrgCourtExecute orgCourtExecute) {
		OrgCourtExecute detail = orgCourtExecuteService.getOne(Condition.getQueryWrapper(orgCourtExecute));
		return R.data(OrgCourtExecuteWrapper.build().entityVO(detail));
	}

	/**
	* 分页 被执行人
	*/
	@GetMapping("/list")
    @ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入orgCourtExecute")
	public R<IPage<OrgCourtExecuteVO>> list(OrgCourtExecute orgCourtExecute, Query query) {
		IPage<OrgCourtExecute> pages = orgCourtExecuteService.page(Condition.getPage(query), Condition.getQueryWrapper(orgCourtExecute));
		return R.data(OrgCourtExecuteWrapper.build().pageVO(pages));
	}

	/**
	* 自定义分页 被执行人
	*/
	@GetMapping("/page")
    @ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入orgCourtExecute")
	public R<IPage<OrgCourtExecuteVO>> page(OrgCourtExecuteVO orgCourtExecute, Query query) {
		IPage<OrgCourtExecuteVO> pages = orgCourtExecuteService.selectOrgCourtExecutePage(Condition.getPage(query), orgCourtExecute);
		return R.data(pages);
	}

	/**
	* 新增 被执行人
	*/
	@PostMapping("/save")
    @ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入orgCourtExecute")
	public R save(@Valid @RequestBody OrgCourtExecute orgCourtExecute) {
		return R.status(orgCourtExecuteService.save(orgCourtExecute));
	}

	/**
	* 修改 被执行人
	*/
	@PostMapping("/update")
    @ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入orgCourtExecute")
	public R update(@Valid @RequestBody OrgCourtExecute orgCourtExecute) {
		return R.status(orgCourtExecuteService.updateById(orgCourtExecute));
	}

	/**
	* 新增或修改 被执行人
	*/
	@PostMapping("/submit")
    @ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入orgCourtExecute")
	public R submit(@Valid @RequestBody OrgCourtExecute orgCourtExecute) {
		return R.status(orgCourtExecuteService.saveOrUpdate(orgCourtExecute));
	}

	
	/**
	* 删除 被执行人
	*/
	@PostMapping("/remove")
    @ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(orgCourtExecuteService.deleteLogic(Func.toLongList(ids)));
	}

	
}
