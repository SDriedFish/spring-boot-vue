package com.gary.manager.exception;

import com.gary.manager.enums.ResultEnum;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * Date: 2018/4/23
 * Time: 23:05
 */
public class PersonException extends RuntimeException {

    private Integer code;

    public PersonException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}