package com.gary.manager.utils;

import com.gary.manager.bean.Result;
import com.gary.manager.enums.ResultEnum;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * Date: 2018/4/23
 * Time: 22:52
 */
public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }


    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}