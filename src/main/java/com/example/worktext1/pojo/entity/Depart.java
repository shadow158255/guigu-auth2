package com.example.worktext1.pojo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@Data
public class Depart implements Serializable {
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
     * 创建时间
     */
    private LocalDateTime addTime;
    /**
     * 创建IP
     */
    private String addIp;
    /**
     * 创建人
     */
    private Long addUserId;
    /**
     * 最后更新时间
     */
    private LocalDateTime lastEditTime;
    /**
     * 最后更新IP
     */
    private String lastEditIp;
    /**
     * 最后更新人
     */
    private Long lastEditBy;
    /**
     * 是否删除：0正常 1已删除
     */
    @JsonProperty("isDel")
    private Boolean isDel;
}
