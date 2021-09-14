package com.faircloud.platform.common.exception;

/**
 * 业务异常处理
 * @author Fair Cheng
 */
public class BusinessException extends RuntimeException {

    public int code;

    public BusinessException(){}

    public BusinessException(String message){
        super(message);
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code=code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
