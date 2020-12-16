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
import org.springblade.modeling.entity.OrgCourtNotice;
import org.springblade.modeling.vo.OrgCourtNoticeVO;
import org.springblade.modeling.wrapper.OrgCourtNoticeWrapper;
import org.springblade.modeling.service.IOrgCourtNoticeService;
import org.springblade.core.boot.ctrl.BladeController;
import java.util.List;

/**
 * 法院公告
 控制器
 *
 * @author Blade
 * @since 2020-12-16
 */
@RestController
@AllArgsConstructor
@RequestMapping("/orgCourtNotice")
@Api(value = "法院公告", tags = "法院公告接口")
public class OrgCourtNoticeController extends BladeController {

	private IOrgCourtNoticeService orgCourtNoticeService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
    @ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入orgCourtNotice")
	public R<OrgCourtNoticeVO> detail(OrgCourtNotice orgCourtNotice) {
		OrgCourtNotice detail = orgCourtNoticeService.getOne(Condition.getQueryWrapper(orgCourtNotice));
		return R.data(OrgCourtNoticeWrapper.build().entityVO(detail));
	}

	/**
	* 分页 法院公告

	*/
	@GetMapping("/list")
    @ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入orgCourtNotice")
	public R<IPage<OrgCourtNoticeVO>> list(OrgCourtNotice orgCourtNotice, Query query) {
		IPage<OrgCourtNotice> pages = orgCourtNoticeService.page(Condition.getPage(query), Condition.getQueryWrapper(orgCourtNotice));
		return R.data(OrgCourtNoticeWrapper.build().pageVO(pages));
	}

	/**
	* 自定义分页 法院公告

	*/
	@GetMapping("/page")
    @ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入orgCourtNotice")
	public R<IPage<OrgCourtNoticeVO>> page(OrgCourtNoticeVO orgCourtNotice, Query query) {
		IPage<OrgCourtNoticeVO> pages = orgCourtNoticeService.selectOrgCourtNoticePage(Condition.getPage(query), orgCourtNotice);
		return R.data(pages);
	}

	/**
	* 新增 法院公告

	*/
	@PostMapping("/save")
    @ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入orgCourtNotice")
	public R save(@Valid @RequestBody OrgCourtNotice orgCourtNotice) {
		return R.status(orgCourtNoticeService.save(orgCourtNotice));
	}

	/**
	* 修改 法院公告

	*/
	@PostMapping("/update")
    @ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入orgCourtNotice")
	public R update(@Valid @RequestBody OrgCourtNotice orgCourtNotice) {
		return R.status(orgCourtNoticeService.updateById(orgCourtNotice));
	}

	/**
	* 新增或修改 法院公告

	*/
	@PostMapping("/submit")
    @ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入orgCourtNotice")
	public R submit(@Valid @RequestBody OrgCourtNotice orgCourtNotice) {
		return R.status(orgCourtNoticeService.saveOrUpdate(orgCourtNotice));
	}

	
	/**
	* 删除 法院公告

	*/
	@PostMapping("/remove")
    @ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(orgCourtNoticeService.deleteLogic(Func.toLongList(ids)));
	}

	
}
