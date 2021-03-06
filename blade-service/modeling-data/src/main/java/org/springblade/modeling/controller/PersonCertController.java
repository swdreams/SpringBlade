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
import org.springblade.modeling.entity.PersonCert;
import org.springblade.modeling.vo.PersonCertVO;
import org.springblade.modeling.wrapper.PersonCertWrapper;
import org.springblade.modeling.service.IPersonCertService;
import org.springblade.core.boot.ctrl.BladeController;
import java.util.List;

/**
 * 证书信息
 控制器
 *
 * @author Blade
 * @since 2020-12-15
 */
@RestController
@AllArgsConstructor
@RequestMapping("/personCert")
@Api(value = "证书信息", tags = "证书信息接口")
public class PersonCertController extends BladeController {

	private IPersonCertService personCertService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
    @ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入personCert")
	public R<PersonCertVO> detail(PersonCert personCert) {
		PersonCert detail = personCertService.getOne(Condition.getQueryWrapper(personCert));
		return R.data(PersonCertWrapper.build().entityVO(detail));
	}

	/**
	* 分页 证书信息

	*/
	@GetMapping("/list")
    @ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入personCert")
	public R<IPage<PersonCertVO>> liPst(PersonCert personCert, Query query) {
		IPage<PersonCert> pages = personCertService.page(Condition.getPage(query), Condition.getQueryWrapper(personCert));
		return R.data(PersonCertWrapper.build().pageVO(pages));
	}

	/**
	* 自定义分页 证书信息

	*/
	@GetMapping("/page")
    @ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入personCert")
	public R<IPage<PersonCertVO>> page(PersonCertVO personCert, Query query) {
		IPage<PersonCertVO> pages = personCertService.selectPersonCertPage(Condition.getPage(query), personCert);
		return R.data(pages);
	}

	/**
	* 新增 证书信息

	*/
	@PostMapping("/save")
    @ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入personCert")
	public R save(@Valid @RequestBody PersonCert personCert) {
		return R.status(personCertService.save(personCert));
	}

	/**
	* 修改 证书信息

	*/
	@PostMapping("/update")
    @ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入personCert")
	public R update(@Valid @RequestBody PersonCert personCert) {
		return R.status(personCertService.updateById(personCert));
	}

	/**
	* 新增或修改 证书信息

	*/
	@PostMapping("/submit")
    @ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入personCert")
	public R submit(@Valid @RequestBody PersonCert personCert) {
		return R.status(personCertService.saveOrUpdate(personCert));
	}

	
	/**
	* 删除 证书信息

	*/
	@PostMapping("/remove")
    @ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(personCertService.deleteLogic(Func.toLongList(ids)));
	}

	
}
