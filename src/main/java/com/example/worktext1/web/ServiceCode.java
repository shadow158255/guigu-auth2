package com.example.worktext1.web;

/**
 * 业务状态码
 */
public interface ServiceCode {

    /**
     * 成功
     */
    Integer OK = 20000;

    /**
     *数据冲突，例如尝试添加不允许重复的数据
     */
    Integer ERR_CONFLICT = 40900;

    /**
     * 相关资源或数据不存在
     */
    Integer ERR_NOT_FOUND = 40400;

    /**
     * 插入数据时的错误
     */
    Integer ERR_INSERT = 50001;

    /**
     * 删除数据时的错误
     */
    Integer ERR_DELETE = 50002;
}
