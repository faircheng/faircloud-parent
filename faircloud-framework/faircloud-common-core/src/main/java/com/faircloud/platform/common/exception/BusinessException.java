package com.faircloud.platform.common.exception;

import com.faircloud.platform.common.enums.StatusCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 统一异常处理 业务异常处理
 *
 * @author Felix Cheng
 */
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends RuntimeException {

    @Getter
    @Setter
    public StatusCode code;

    public BusinessException(StatusCode code) {
        super(code.getMsg());
        this.code = code;
    }

    public BusinessException(StatusCode code, Throwable cause) {
        super(code.getMsg(), cause);
    }
}
