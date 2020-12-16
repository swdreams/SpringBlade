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
import org.springblade.modeling.entity.OrgAffiliate;
import org.springblade.modeling.vo.OrgAffiliateVO;
import org.springblade.modeling.wrapper.OrgAffiliateWrapper;
import org.springblade.modeling.service.IOrgAffiliateService;
import org.springblade.core.boot.ctrl.BladeController;
import java.util.List;

/**
 * 相关机构关联表
 控制器
 *
 * @author Blade
 * @since 2020-12-16
 */
@RestController
@AllArgsConstructor
@RequestMapping("/orgAffiliate")
@Api(value = "相关机构关联表", tags = "相关机构关联表接口")
public class OrgAffiliateController extends BladeController {

	private IOrgAffiliateService orgAffiliateService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
    @ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入orgAffiliate")
	public R<OrgAffiliateVO> detail(OrgAffiliate orgAffiliate) {
		OrgAffiliate detail = orgAffiliateService.getOne(Condition.getQueryWrapper(orgAffiliate));
		return R.data(OrgAffiliateWrapper.build().entityVO(detail));
	}

	/**
	* 分页 相关机构关联表

	*/
	@GetMapping("/list")
    @ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入orgAffiliate")
	public R<IPage<OrgAffiliateVO>> list(OrgAffiliate orgAffiliate, Query query) {
		IPage<OrgAffiliate> pages = orgAffiliateService.page(Condition.getPage(query), Condition.getQueryWrapper(orgAffiliate));
		return R.data(OrgAffiliateWrapper.build().pageVO(pages));
	}

	/**
	* 自定义分页 相关机构关联表

	*/
	@GetMapping("/page")
    @ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入orgAffiliate")
	public R<IPage<OrgAffiliateVO>> page(OrgAffiliateVO orgAffiliate, Query query) {
		IPage<OrgAffiliateVO> pages = orgAffiliateService.selectOrgAffiliatePage(Condition.getPage(query), orgAffiliate);
		return R.data(pages);
	}

	/**
	* 新增 相关机构关联表

	*/
	@PostMapping("/save")
    @ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入orgAffiliate")
	public R save(@Valid @RequestBody OrgAffiliate orgAffiliate) {
		return R.status(orgAffiliateService.save(orgAffiliate));
	}

	/**
	* 修改 相关机构关联表

	*/
	@PostMapping("/update")
    @ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入orgAffiliate")
	public R update(@Valid @RequestBody OrgAffiliate orgAffiliate) {
		return R.status(orgAffiliateService.updateById(orgAffiliate));
	}

	/**
	* 新增或修改 相关机构关联表

	*/
	@PostMapping("/submit")
    @ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入orgAffiliate")
	public R submit(@Valid @RequestBody OrgAffiliate orgAffiliate) {
		return R.status(orgAffiliateService.saveOrUpdate(orgAffiliate));
	}

	
	/**
	* 删除 相关机构关联表

	*/
	@PostMapping("/remove")
    @ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(orgAffiliateService.deleteLogic(Func.toLongList(ids)));
	}

	
}
