package com.example.worktext1.controller;

import com.example.worktext1.pojo.dto.DepartAddNewDTO;
import com.example.worktext1.pojo.dto.DepartUpdateDTO;
import com.example.worktext1.pojo.vo.DepartStandardVO;
import com.example.worktext1.service.DepartService;
import com.example.worktext1.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
@Api(tags = "01.部门管理模块")
@Slf4j
@RestController
@RequestMapping("/department")
public class DepartController {
    public DepartController(){
        log.debug("创建控制器：DepartController");
    }

    @Autowired
    DepartService departService;

    //http://localhost:8888/departs/add
    @ApiOperation("添加部门")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add")
    public JsonResult<Void> add(@Validated DepartAddNewDTO departAddNewDTO) throws UnknownHostException {
        log.debug("接收到【添加部门】的请求，开始处理请求：{}",departAddNewDTO);
        departService.addNew(departAddNewDTO);
        return JsonResult.ok();
    }

    @ApiOperation("删除部门")
    @ApiOperationSupport(order = 200)
    @PostMapping("/delete/{id:[0-9]+}")
    public JsonResult<Void> delete(@PathVariable Long id){
        log.debug("接收到【删除部门】的请求，开始处理删除id为{}的部门的请求：",id);
        departService.deleteById(id);
        return JsonResult.ok();
    }

    @ApiOperation("修改部门")
    @ApiOperationSupport(order = 300)
    @PostMapping("/update")
    public JsonResult<Void> update(@Validated DepartUpdateDTO departUpdateDTO) throws UnknownHostException {
        log.debug("接收到【修改部门】的请求，开始处理请求：{}",departUpdateDTO);
        departService.update(departUpdateDTO);
        return JsonResult.ok();
    }

    @ApiOperation("根据id查询部门")
    @ApiOperationSupport(order = 400)
    @PostMapping("/info/{id:[0-9]+}")
    public JsonResult<DepartStandardVO> info(@PathVariable Long id){
        log.debug("接收到【根据id查询部门】的请求，查询id为【{}】的部门：",id);
        DepartStandardVO depart = departService.getInfoById(id);
        return JsonResult.ok(depart);
    }


}
