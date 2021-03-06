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
import org.springblade.modeling.entity.PersonHistory;
import org.springblade.modeling.vo.PersonHistoryVO;
import org.springblade.modeling.wrapper.PersonHistoryWrapper;
import org.springblade.modeling.service.IPersonHistoryService;
import org.springblade.core.boot.ctrl.BladeController;

import java.util.List;

/**
 * 履历信息
 * 控制器
 *
 * @author Blade
 * @since 2020-12-15
 */
@RestController
@AllArgsConstructor
@RequestMapping("/personHistory")
@Api(value = "履历信息", tags = "履历信息接口")
public class PersonHistoryController extends BladeController {

	private IPersonHistoryService personHistoryService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入personHistory")
	public R<PersonHistoryVO> detail(PersonHistory personHistory) {
		PersonHistory detail = personHistoryService.getOne(Condition.getQueryWrapper(personHistory));
		return R.data(PersonHistoryWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 履历信息
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入personHistory")
	public R<IPage<PersonHistoryVO>> list(PersonHistory personHistory, Query query) {
		IPage<PersonHistory> pages = personHistoryService.page(Condition.getPage(query), Condition.getQueryWrapper(personHistory));
		return R.data(PersonHistoryWrapper.build().pageVO(pages));
	}

	@GetMapping("/listAll")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入personHistory")
	public R<List<PersonHistoryVO>> listAll(PersonHistory personHistory, Query query) {
		List<PersonHistory> list = personHistoryService.list(Condition.getQueryWrapper(personHistory));
		return R.data(PersonHistoryWrapper.build().listVO(list));
	}

	/**
	 * 自定义分页 履历信息
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入personHistory")
	public R<IPage<PersonHistoryVO>> page(PersonHistoryVO personHistory, Query query) {
		IPage<PersonHistoryVO> pages = personHistoryService.selectPersonHistoryPage(Condition.getPage(query), personHistory);
		return R.data(pages);
	}

	/**
	 * 新增 履历信息
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入personHistory")
	public R save(@Valid @RequestBody PersonHistory personHistory) {
		return R.status(personHistoryService.save(personHistory));
	}

	/**
	 * 修改 履历信息
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入personHistory")
	public R update(@Valid @RequestBody PersonHistory personHistory) {
		return R.status(personHistoryService.updateById(personHistory));
	}

	/**
	 * 新增或修改 履历信息
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入personHistory")
	public R submit(@Valid @RequestBody PersonHistory personHistory) {
		return R.status(personHistoryService.saveOrUpdate(personHistory));
	}


	/**
	 * 删除 履历信息
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(personHistoryService.deleteLogic(Func.toLongList(ids)));
	}


}
