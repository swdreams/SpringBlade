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
import org.springblade.modeling.entity.OrgBasicInfo;
import org.springblade.modeling.vo.OrgBasicInfoVO;
import org.springblade.modeling.wrapper.OrgBasicInfoWrapper;
import org.springblade.modeling.service.IOrgBasicInfoService;
import org.springblade.core.boot.ctrl.BladeController;
import java.util.List;

/**
 * 机构基础信息 控制器
 *
 * @author Blade
 * @since 2020-12-05
 */
@RestController
@AllArgsConstructor
@RequestMapping("/org")
@Api(value = "机构基础信息", tags = "机构基础信息接口")
public class OrgBasicInfoController extends BladeController {

	private IOrgBasicInfoService orgBasicInfoService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
    @ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入orgBasicInfo")
	public R<OrgBasicInfoVO> detail(OrgBasicInfo orgBasicInfo) {
		OrgBasicInfo detail = orgBasicInfoService.getOne(Condition.getQueryWrapper(orgBasicInfo));
		return R.data(OrgBasicInfoWrapper.build().entityVO(detail));
	}

	/**
	* 分页 机构基础信息
	*/
	@GetMapping("/list")
    @ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入orgBasicInfo")
	public R<IPage<OrgBasicInfoVO>> list(OrgBasicInfoVO orgBasicInfo, Query query) {
		//IPage<OrgBasicInfo> pages = orgBasicInfoService.page(Condition.getPage(query), Condition.getQueryWrapper(orgBasicInfo));
		//return R.data(OrgBasicInfoWrapper.build().pageVO(pages));
		IPage<OrgBasicInfoVO> pagesVO= orgBasicInfoService.selectOrgBasicInfoPage(Condition.getPage(query), orgBasicInfo);
		return R.data(pagesVO);
	}

	/**
	* 自定义分页 机构基础信息
	*/
	@GetMapping("/page")
    @ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入orgBasicInfo")
	public R<IPage<OrgBasicInfoVO>> page(OrgBasicInfoVO orgBasicInfo, Query query) {
		IPage<OrgBasicInfoVO> pages = orgBasicInfoService.selectOrgBasicInfoPage(Condition.getPage(query), orgBasicInfo);
		return R.data(pages);
	}

	/**
	* 新增 机构基础信息
	*/
	@PostMapping("/save")
    @ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入orgBasicInfo")
	public R save(@Valid @RequestBody OrgBasicInfo orgBasicInfo) {
		return R.status(orgBasicInfoService.save(orgBasicInfo));
	}

	/**
	* 修改 机构基础信息
	*/
	@PostMapping("/update")
    @ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入orgBasicInfo")
	public R update(@Valid @RequestBody OrgBasicInfo orgBasicInfo) {
		return R.status(orgBasicInfoService.updateById(orgBasicInfo));
	}

	/**
	* 新增或修改 机构基础信息
	*/
	@PostMapping("/submit")
    @ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入orgBasicInfo")
	public R submit(@Valid @RequestBody OrgBasicInfo orgBasicInfo) {
		return R.status(orgBasicInfoService.saveOrUpdate(orgBasicInfo));
	}

	
	/**
	* 删除 机构基础信息
	*/
	@PostMapping("/remove")
    @ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(orgBasicInfoService.deleteLogic(Func.toLongList(ids)));
	}

	
}
