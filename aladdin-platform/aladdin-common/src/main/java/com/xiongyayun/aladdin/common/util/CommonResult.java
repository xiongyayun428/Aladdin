package com.xiongyayun.aladdin.common.util;

import com.xiongyayun.aladdin.common.constant.CommonConstants;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @author: <a href="mailto:xiongyayun428@163.com">Yayun.Xiong</a>
 * @date: 2020/6/18
 */
@Data
@Accessors(chain = true)
public class CommonResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;
    private String msg;
    private T data;

    public static <T> CommonResult<T> success() {
        return restResult(null, CommonConstants.SUCCESS, null);
    }

    public static <T> CommonResult<T> success(T data) {
        return restResult(data, CommonConstants.SUCCESS, null);
    }

    public static <T> CommonResult<T> success(T data, String msg) {
        return restResult(data, CommonConstants.SUCCESS, msg);
    }

    public static <T> CommonResult<T> failed() {
        return restResult(null, CommonConstants.FAIL, null);
    }

    public static <T> CommonResult<T> failed(String msg) {
        return restResult(null, CommonConstants.FAIL, msg);
    }

    public static <T> CommonResult<T> failed(T data) {
        return restResult(data, CommonConstants.FAIL, null);
    }

    public static <T> CommonResult<T> failed(T data, String msg) {
        return restResult(data, CommonConstants.FAIL, msg);
    }

    private static <T> CommonResult<T> restResult(T data, String code, String msg) {
        CommonResult<T> apiResult = new CommonResult<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
}
