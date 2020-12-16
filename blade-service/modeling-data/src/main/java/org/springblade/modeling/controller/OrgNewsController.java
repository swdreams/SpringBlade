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
import org.springblade.modeling.entity.OrgNews;
import org.springblade.modeling.vo.OrgNewsVO;
import org.springblade.modeling.wrapper.OrgNewsWrapper;
import org.springblade.modeling.service.IOrgNewsService;
import org.springblade.core.boot.ctrl.BladeController;
import java.util.List;

/**
 * 新闻资讯
 控制器
 *
 * @author Blade
 * @since 2020-12-16
 */
@RestController
@AllArgsConstructor
@RequestMapping("/orgNews")
@Api(value = "新闻资讯", tags = "新闻资讯接口")
public class OrgNewsController extends BladeController {

	private IOrgNewsService orgNewsService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
    @ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入orgNews")
	public R<OrgNewsVO> detail(OrgNews orgNews) {
		OrgNews detail = orgNewsService.getOne(Condition.getQueryWrapper(orgNews));
		return R.data(OrgNewsWrapper.build().entityVO(detail));
	}

	/**
	* 分页 新闻资讯

	*/
	@GetMapping("/list")
    @ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入orgNews")
	public R<IPage<OrgNewsVO>> list(OrgNews orgNews, Query query) {
		IPage<OrgNews> pages = orgNewsService.page(Condition.getPage(query), Condition.getQueryWrapper(orgNews));
		return R.data(OrgNewsWrapper.build().pageVO(pages));
	}

	/**
	* 自定义分页 新闻资讯

	*/
	@GetMapping("/page")
    @ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入orgNews")
	public R<IPage<OrgNewsVO>> page(OrgNewsVO orgNews, Query query) {
		IPage<OrgNewsVO> pages = orgNewsService.selectOrgNewsPage(Condition.getPage(query), orgNews);
		return R.data(pages);
	}

	/**
	* 新增 新闻资讯

	*/
	@PostMapping("/save")
    @ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入orgNews")
	public R save(@Valid @RequestBody OrgNews orgNews) {
		return R.status(orgNewsService.save(orgNews));
	}

	/**
	* 修改 新闻资讯

	*/
	@PostMapping("/update")
    @ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入orgNews")
	public R update(@Valid @RequestBody OrgNews orgNews) {
		return R.status(orgNewsService.updateById(orgNews));
	}

	/**
	* 新增或修改 新闻资讯

	*/
	@PostMapping("/submit")
    @ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入orgNews")
	public R submit(@Valid @RequestBody OrgNews orgNews) {
		return R.status(orgNewsService.saveOrUpdate(orgNews));
	}

	
	/**
	* 删除 新闻资讯

	*/
	@PostMapping("/remove")
    @ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(orgNewsService.deleteLogic(Func.toLongList(ids)));
	}

	
}
