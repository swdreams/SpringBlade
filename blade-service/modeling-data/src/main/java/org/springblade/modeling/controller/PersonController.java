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
import org.springblade.modeling.entity.Person;
import org.springblade.modeling.vo.PersonVO;
import org.springblade.modeling.wrapper.PersonWrapper;
import org.springblade.modeling.service.IPersonService;
import org.springblade.core.boot.ctrl.BladeController;
import java.util.List;

/**
 * 基础信息
 控制器
 *
 * @author Blade
 * @since 2020-12-15
 */
@RestController
@AllArgsConstructor
@RequestMapping("/person")
@Api(value = "基础信息", tags = "基础信息接口")
public class PersonController extends BladeController {

	private IPersonService personService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
    @ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入person")
	public R<PersonVO> detail(PersonVO person) {
		//Person detail = personService.getOne(Condition.getQueryWrapper(person));
		// return R.data(PersonWrapper.build().entityVO(detail));

		PersonVO personVO = personService.selectPersonDetail(person);
		return R.data(personVO);
	}

	/**
	* 分页 基础信息

	*/
	@GetMapping("/list")
    @ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入person")
	public R<IPage<PersonVO>> list(PersonVO person, Query query) {
		//IPage<Person> pages = personService.page(Condition.getPage(query), Condition.getQueryWrapper(person));
		// return R.data(PersonWrapper.build().pageVO(pages));
		IPage<PersonVO> pages = personService.selectPersonPage(Condition.getPage(query), person);
		return R.data(pages);
	}

	@GetMapping("/listInOrg")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入person")
	public R<IPage<PersonVO>> listInOrg(PersonVO person, Query query) {
		IPage<PersonVO> pages = personService.selectPersonInOrgPage(Condition.getPage(query), person.getOrgId());
		return R.data(pages);
	}

	/**
	* 自定义分页 基础信息

	*/
	@GetMapping("/page")
    @ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入person")
	public R<IPage<PersonVO>> page(PersonVO person, Query query) {
		IPage<PersonVO> pages = personService.selectPersonPage(Condition.getPage(query), person);
		return R.data(pages);
	}

	/**
	* 新增 基础信息

	*/
	@PostMapping("/save")
    @ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入person")
	public R save(@Valid @RequestBody Person person) {
		return R.status(personService.save(person));
	}

	/**
	* 修改 基础信息

	*/
	@PostMapping("/update")
    @ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入person")
	public R update(@Valid @RequestBody Person person) {
		return R.status(personService.updateById(person));
	}

	/**
	* 新增或修改 基础信息

	*/
	@PostMapping("/submit")
    @ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入person")
	public R submit(@Valid @RequestBody Person person) {
		return R.status(personService.saveOrUpdate(person));
	}

	
	/**
	* 删除 基础信息

	*/
	@PostMapping("/remove")
    @ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(personService.deleteLogic(Func.toLongList(ids)));
	}

	
}
