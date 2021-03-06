package com.power.doc.controller;

import com.alibaba.fastjson.JSON;
import com.power.common.model.CommonResult;
import com.power.doc.model.BaseReq;
import com.power.doc.model.Leader;
import com.power.doc.model.SubUser;
import com.power.doc.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 *
 * 关于Validator使用测试
 *
 * @author yu 2018/06/28.
 */

@RestController
@RequestMapping("validator")
public class ValidatorTestController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidatorTestController.class);

    /**
     * validate验证测试
     *
     * @param leader
     * @return
     */
    @PostMapping("/test")
    public CommonResult testSimpleValidate(@Valid @RequestBody Leader leader) {
        LOGGER.debug("ReqParams:{}", JSON.toJSONString(leader));
        return CommonResult.ok();
    }


    /**
     * 验证通用参数
     * @param param
     * @return
     */
    @PostMapping("valid")
    public CommonResult testValid(@Valid @RequestBody BaseReq<SubUser> param){
        LOGGER.debug("ReqParams:{}", JSON.toJSONString(param));
        return CommonResult.ok();
    }

}
