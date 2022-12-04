package com.example.worktext1.pojo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
public class DepartStandardVO implements Serializable {
    /**
     * PK
     */
    private Long departId;
    /**
     * 父级部门ID，0为顶级部门
     */
    private Long pid;
    /**
     * 部门编码
     */
    private String code;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 排序：越大越往前排
     */
    private Integer sort;
    /**
     * 是否删除：0正常 1已删除
     */
    @JsonProperty("isDel")
    private Boolean isDel;
}
