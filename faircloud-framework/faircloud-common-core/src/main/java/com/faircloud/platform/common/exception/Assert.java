package com.faircloud.platform.common.exception;

import com.faircloud.platform.common.enums.StatusCode;
import com.faircloud.platform.common.enums.StatusCodeEnum;

import lombok.extern.slf4j.Slf4j;

/**
 * custom assert
 *
 * @author Felix Cheng
 */
@Slf4j
public abstract class Assert {

    public static void notNull(Object obj) {
        if (obj == null) {
            throw new BusinessException(StatusCodeEnum.A0400);
        }
    }

    public static void notNull(Object obj, StatusCode code) {
        if (obj == null) {
            throw new BusinessException(code);
        }
    }
}
