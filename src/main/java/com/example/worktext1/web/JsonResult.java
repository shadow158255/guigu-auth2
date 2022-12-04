package com.example.worktext1.web;

import com.example.worktext1.ex.ServiceException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
public class JsonResult<T> implements Serializable {
    /**
     *业务状态码：本质上是一个数值，由服务器端和客户端共同约定每个数值的意义
     */
    private Integer state;

    /**
     * 消息:业务执行出错时的描述文本
     */
    private String message;

    /**
     * 数据：当处理请求成功时，可能需要响应某些数据到客户端（通常是客户端发起GET请求，当然，某些POST请求可能也需要响应数据）
     */
    private T data;

    public static JsonResult ok(){
        return ok(null);
    }
    public static<T> JsonResult<T> ok(T data){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setState(ServiceCode.OK);
        jsonResult.setData(data);
        return jsonResult;
    }
    public static JsonResult<Void> fail(ServiceException e){
        return fail(e.getState(),e.getMessage());
    }

    public static JsonResult<Void> fail(Integer state,String message){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setState(state);
        jsonResult.setMessage(message);
        return jsonResult;
    }

}
