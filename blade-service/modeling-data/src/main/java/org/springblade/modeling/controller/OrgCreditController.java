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
import org.springblade.modeling.entity.OrgCredit;
import org.springblade.modeling.vo.OrgCreditVO;
import org.springblade.modeling.wrapper.OrgCreditWrapper;
import org.springblade.modeling.service.IOrgCreditService;
import org.springblade.core.boot.ctrl.BladeController;
import java.util.List;

/**
 * 诚信信息
 控制器
 *
 * @author Blade
 * @since 2020-12-16
 */
@RestController
@AllArgsConstructor
@RequestMapping("/orgCredit")
@Api(value = "诚信信息", tags = "诚信信息接口")
public class OrgCreditController extends BladeController {

	private IOrgCreditService orgCreditService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
    @ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入orgCredit")
	public R<OrgCreditVO> detail(OrgCredit orgCredit) {
		OrgCredit detail = orgCreditService.getOne(Condition.getQueryWrapper(orgCredit));
		return R.data(OrgCreditWrapper.build().entityVO(detail));
	}

	/**
	* 分页 诚信信息

	*/
	@GetMapping("/list")
    @ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入orgCredit")
	public R<IPage<OrgCreditVO>> list(OrgCredit orgCredit, Query query) {
		IPage<OrgCredit> pages = orgCreditService.page(Condition.getPage(query), Condition.getQueryWrapper(orgCredit));
		return R.data(OrgCreditWrapper.build().pageVO(pages));
	}

	/**
	* 自定义分页 诚信信息

	*/
	@GetMapping("/page")
    @ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入orgCredit")
	public R<IPage<OrgCreditVO>> page(OrgCreditVO orgCredit, Query query) {
		IPage<OrgCreditVO> pages = orgCreditService.selectOrgCreditPage(Condition.getPage(query), orgCredit);
		return R.data(pages);
	}

	/**
	* 新增 诚信信息

	*/
	@PostMapping("/save")
    @ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入orgCredit")
	public R save(@Valid @RequestBody OrgCredit orgCredit) {
		return R.status(orgCreditService.save(orgCredit));
	}

	/**
	* 修改 诚信信息

	*/
	@PostMapping("/update")
    @ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入orgCredit")
	public R update(@Valid @RequestBody OrgCredit orgCredit) {
		return R.status(orgCreditService.updateById(orgCredit));
	}

	/**
	* 新增或修改 诚信信息

	*/
	@PostMapping("/submit")
    @ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入orgCredit")
	public R submit(@Valid @RequestBody OrgCredit orgCredit) {
		return R.status(orgCreditService.saveOrUpdate(orgCredit));
	}

	
	/**
	* 删除 诚信信息

	*/
	@PostMapping("/remove")
    @ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(orgCreditService.deleteLogic(Func.toLongList(ids)));
	}

	
}
