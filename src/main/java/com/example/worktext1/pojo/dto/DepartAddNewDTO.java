package com.example.worktext1.pojo.dto;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
@Data
public class DepartAddNewDTO implements Serializable {
    /**
     * 父级部门ID，0为顶级部门
     */
    @ApiModelProperty(value = "父级部门id",example = "0",required = true)
    @NotNull(message = "必须提交父级部门id！")
    private Long pid;
    /**
     * 部门编码
     */
    private String code;
    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称",example = "橘子部",required = true)
    @NotNull(message = "必须提交部门名称！")
    private String name;
    /**
     * 排序：越大越往前排
     */
    private Integer sort;


}
