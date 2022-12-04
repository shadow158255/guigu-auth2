package com.example.worktext1.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class DepartUpdateDTO implements Serializable {
    /**
     * 需要修改的部门id
     */
    @ApiModelProperty(value = "父级部门id",example = "20",required = true)
    private Long departId;
    /**
     * 父级部门ID，0为顶级部门
     */
    @ApiModelProperty(value = "父级部门id",example = "20",required = true)
    private Long pid;
    /**
     * 部门编码
     */
    @ApiModelProperty(value = "父级部门编码",example = "1234456",required = true)
    private String code;
    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称",example = "苹果",required = true)
    private String name;
    /**
     * 排序：越大越往前排
     */
    @ApiModelProperty(value = "部门排序",example = "25",required = true)
    private Integer sort;
}
