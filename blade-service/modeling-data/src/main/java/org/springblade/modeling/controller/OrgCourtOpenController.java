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
import org.springblade.modeling.entity.OrgCourtOpen;
import org.springblade.modeling.vo.OrgCourtOpenVO;
import org.springblade.modeling.wrapper.OrgCourtOpenWrapper;
import org.springblade.modeling.service.IOrgCourtOpenService;
import org.springblade.core.boot.ctrl.BladeController;
import java.util.List;

/**
 * 开庭公告
 控制器
 *
 * @author Blade
 * @since 2020-12-16
 */
@RestController
@AllArgsConstructor
@RequestMapping("/orgCourtOpen")
@Api(value = "开庭公告", tags = "开庭公告接口")
public class OrgCourtOpenController extends BladeController {

	private IOrgCourtOpenService orgCourtOpenService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
    @ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入orgCourtOpen")
	public R<OrgCourtOpenVO> detail(OrgCourtOpen orgCourtOpen) {
		OrgCourtOpen detail = orgCourtOpenService.getOne(Condition.getQueryWrapper(orgCourtOpen));
		return R.data(OrgCourtOpenWrapper.build().entityVO(detail));
	}

	/**
	* 分页 开庭公告

	*/
	@GetMapping("/list")
    @ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入orgCourtOpen")
	public R<IPage<OrgCourtOpenVO>> list(OrgCourtOpen orgCourtOpen, Query query) {
		IPage<OrgCourtOpen> pages = orgCourtOpenService.page(Condition.getPage(query), Condition.getQueryWrapper(orgCourtOpen));
		return R.data(OrgCourtOpenWrapper.build().pageVO(pages));
	}

	/**
	* 自定义分页 开庭公告

	*/
	@GetMapping("/page")
    @ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入orgCourtOpen")
	public R<IPage<OrgCourtOpenVO>> page(OrgCourtOpenVO orgCourtOpen, Query query) {
		IPage<OrgCourtOpenVO> pages = orgCourtOpenService.selectOrgCourtOpenPage(Condition.getPage(query), orgCourtOpen);
		return R.data(pages);
	}

	/**
	* 新增 开庭公告

	*/
	@PostMapping("/save")
    @ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入orgCourtOpen")
	public R save(@Valid @RequestBody OrgCourtOpen orgCourtOpen) {
		return R.status(orgCourtOpenService.save(orgCourtOpen));
	}

	/**
	* 修改 开庭公告

	*/
	@PostMapping("/update")
    @ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入orgCourtOpen")
	public R update(@Valid @RequestBody OrgCourtOpen orgCourtOpen) {
		return R.status(orgCourtOpenService.updateById(orgCourtOpen));
	}

	/**
	* 新增或修改 开庭公告

	*/
	@PostMapping("/submit")
    @ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入orgCourtOpen")
	public R submit(@Valid @RequestBody OrgCourtOpen orgCourtOpen) {
		return R.status(orgCourtOpenService.saveOrUpdate(orgCourtOpen));
	}

	
	/**
	* 删除 开庭公告

	*/
	@PostMapping("/remove")
    @ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(orgCourtOpenService.deleteLogic(Func.toLongList(ids)));
	}

	
}
