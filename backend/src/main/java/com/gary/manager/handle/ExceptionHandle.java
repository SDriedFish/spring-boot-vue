package com.gary.manager.handle;

import com.gary.manager.bean.Result;
import com.gary.manager.enums.ResultEnum;
import com.gary.manager.exception.PersonException;
import com.gary.manager.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * Date: 2018/4/23
 * Time: 23:07
 */
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof PersonException) {
            PersonException girlException = (PersonException) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        } else {
            return ResultUtil.error(ResultEnum.UNKONW_ERROR.getCode(), ResultEnum.UNKONW_ERROR.getMsg());
        }
    }
}